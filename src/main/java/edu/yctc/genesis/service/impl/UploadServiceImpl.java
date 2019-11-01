package edu.yctc.genesis.service.impl;

import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.user.UserType;
import edu.yctc.genesis.dao.AcademyDAO;
import edu.yctc.genesis.dao.ClassDAO;
import edu.yctc.genesis.dao.ProfessionDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.AcademyDO;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ProfessionDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.UploadIService;
import edu.yctc.genesis.util.ExcelUtil;
import edu.yctc.genesis.util.SHA256Util;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("uploadService")
public class UploadServiceImpl implements UploadIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    private final static String EXCEL_XLS = "xls"; // Excel 2003

    private final static String EXCEL_XLSX = "xlsx"; // Excel 2007/2010

    private final static int FIRST_SHEET = 0;

    private final static String DEFAULT_PASSWORD = "123456";

    private final static String DEFAULT_ACADEMY = "信息工程学院";

    @Resource
    private UserDAO userDAO;//用户

    @Resource
    private ProfessionDAO professionDAO;//专业

    @Resource
    private ClassDAO classDAO;//班级

    @Resource
    private AcademyDAO academyDAO;//学院

    @Override
    public ResultDO<Void> uploadStudents(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            LOG.error("upload students fail, file is empty, multipartFile={}", multipartFile);
            return new ResultDO<>(false, ResultCode.FILE_EMPTY, ResultCode.MSG_FILE_EMPTY);
        }
        try {
            // 解析excel
            String fileName = multipartFile.getOriginalFilename();// 获取文件名
            InputStream inputStream = multipartFile.getInputStream();// 输入流
            Workbook workbook = null;
            // excel 2003
            if (fileName.endsWith(EXCEL_XLS)) {
                workbook = new HSSFWorkbook(inputStream);
            }
            // excel 2007/2010
            else if (fileName.endsWith(EXCEL_XLSX)) {
                workbook = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(FIRST_SHEET);
            int rowsSummary = sheet.getLastRowNum();// 获得总行数,返回的是总行数-1
            // 遍历excel表
            for (int i = 1; i < rowsSummary + 1; i++) {
                Row row = sheet.getRow(i);
                UserDO userDO = new UserDO();
                if (row != null) {
                    // 学号
                    String number = ExcelUtil.getCellValue(row.getCell(0)).toString();
                    // 如果重复则跳过
                    if (userDAO.getUserDOByNumber(number) != null) {
                        continue;
                    }
                    userDO.setNumber(number);
                    // 姓名
                    String name = ExcelUtil.getCellValue(row.getCell(1)).toString();
                    userDO.setName(name);
                    // 专业
                    String profession = ExcelUtil.getCellValue(row.getCell(2)).toString();
                    ProfessionDO professionDO = professionDAO.getProfessionDOByProfession(profession);
                    if (professionDO == null) { // 数据库中没有记录，新增
                        professionDO = new ProfessionDO();
                        professionDO.setProfession(profession);
                        professionDAO.insert(professionDO);
                    }
                    // 班级
                    String studentClass = ExcelUtil.getCellValue(row.getCell(3)).toString();
                    ClassDO classDO = classDAO.getClassDOByNumber(studentClass);
                    if (classDO == null) {
                        classDO = new ClassDO();
                        classDO.setNumber(studentClass);
                        classDO.setProfessionId(professionDO.getId());
                        AcademyDO academyDO = academyDAO.getAcademyDOByAcademy(DEFAULT_ACADEMY);// TODO 缺少专业表头，暂时写死
                        if (academyDO == null) {
                            academyDO = new AcademyDO();
                            academyDO.setAcademy("信息工程学院");
                            academyDAO.insert(academyDO);
                        }
                        classDO.setAcademyId(academyDO.getId());
                        classDAO.insert(classDO);
                        userDO.setAcademyId(academyDO.getId());
                    }
                    userDO.setClassId(classDO.getId());
                    // 性别
                    String sex = ExcelUtil.getCellValue(row.getCell(4)).toString();
                    userDO.setSex(sex);
                    // 手机号
                    String phone = ExcelUtil.getCellValue(row.getCell(6)).toString();
                    userDO.setPhone(phone);
                    // 邮箱
                    String mail = ExcelUtil.getCellValue(row.getCell(8)).toString();
                    userDO.setMail(mail);
                    // 权限类型
                    int type = UserType.STUDENT;
                    userDO.setType(type);
                    // TODO excel缺少身份证，待添加
                    // 默认密码为身份证后八位，暂全为123456
                    userDO.setPassword(SHA256Util.SHA256(DEFAULT_PASSWORD));
                }
                userDAO.insert(userDO);
            }
            LOG.info("upload students success");
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("upload students error, multipartFile={}", multipartFile, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

}
