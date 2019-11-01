package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.floor.Floor;
import edu.yctc.genesis.constant.entity.term.Term;
import edu.yctc.genesis.constant.entity.year.Year;
import edu.yctc.genesis.dao.AcademyDAO;
import edu.yctc.genesis.dao.AttendanceDAO;
import edu.yctc.genesis.dao.BuildingFloorDAO;
import edu.yctc.genesis.dao.ClassDAO;
import edu.yctc.genesis.dao.ClassScoreDAO;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.ClassroomStateDAO;
import edu.yctc.genesis.dao.CourseDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.ProfessionDAO;
import edu.yctc.genesis.dao.StudentCourseDAO;
import edu.yctc.genesis.dao.TeacherLessonDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.AcademyDO;
import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ProfessionDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;
import edu.yctc.genesis.service.MetaDataIService;
import edu.yctc.genesis.util.FloorComparatorUtil;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;
import edu.yctc.genesis.vo.CourseDTOAndClassesVO;
import edu.yctc.genesis.vo.ModifyBuildingFloorVO;
import edu.yctc.genesis.vo.ModifyClassDOVO;
import edu.yctc.genesis.vo.ModifyClassroomVO;
import edu.yctc.genesis.vo.ModifyCourseVO;
import edu.yctc.genesis.vo.ModifyStudentVO;
import edu.yctc.genesis.vo.ModifyTeacherVO;
import edu.yctc.genesis.vo.StudentDOAndAcademyAndClassesVO;
import edu.yctc.genesis.vo.TeacherDOAndAcademyVO;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("metaDataService")
public class MetaDataServiceImpl implements MetaDataIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    ClassroomDAO classroomDAO;//教室

    @Resource
    CourseDAO courseDAO;//课程

    @Resource
    UserDAO userDAO;//用户

    @Resource
    LessonDAO lessonDAO;//课时

    @Resource
    BuildingFloorDAO buildingFloorDAO;//楼号

    @Resource
    StudentCourseDAO studentCourseDAO;//选课

    @Resource
    ClassDAO classDAO;//班级

    @Resource
    AcademyDAO academyDAO;//学院

    @Resource
    ClassroomStateDAO classroomStateDAO;//教室使用

    @Resource
    TeacherLessonDAO teacherLessonDAO;//老师授课

    @Resource
    AttendanceDAO attendanceDAO;//考勤

    @Resource
    ClassScoreDAO classScoreDAO;//课堂评分

    @Resource
    ProfessionDAO professionDAO;//专业

    //通过楼号获取楼层号
    @Override
    public ResultDO<List<String>> getFloorsByBuilding(String building) {
        if (StringUtils.isBlank(building) == true) {
            LOG.error("get floors by building fail, building is blank, building={}", building);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<String> list = buildingFloorDAO.getFloorsByBuilding(building);
            // 给楼层排序
            Collections.sort(list, new Comparator<String>() {

                @Override
                public int compare(String firstBuilding, String secondeBuilding) {
                    int firstBuildingNumber = FloorComparatorUtil.getNumber(firstBuilding.split("楼")[0]);
                    int secondeBuildingNumber = FloorComparatorUtil.getNumber(secondeBuilding.split("楼")[0]);
                    return firstBuildingNumber - secondeBuildingNumber;
                }
            });
            LOG.info("get floors by building success, building={}", building);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get floors by building error, building={}", building, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过楼号楼层号获取所有教室
    @Override
    public ResultDO<List<ClassroomDO>> getClassroomDOByBuildingAndFloor(String building, String floor) {
        if (StringUtils.isBlank(building) || StringUtils.isBlank(floor)) {
            LOG.error("get classroomDO by building and floor fail, parameter invalid, building={}, floor={}", building,
                floor);
            return new ResultDO<List<ClassroomDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 获取楼层楼号在库中对应的id
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOByBuildingAndFloor(building, floor);
            long buildingFloorId = buildingFloorDO.getId();
            List<ClassroomDO> list = classroomDAO.getClassroomDOByBuildingFloorId(buildingFloorId);
            LOG.info("get classroomDO by building and floor success, building={}, floor={}", building, floor);
            return new ResultDO<List<ClassroomDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get classroomDO by building and floor error, building={}, floor={}", building, floor, e);
            return new ResultDO<List<ClassroomDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //删除教室
    @Override
    public ResultDO<Void> deleteClassroom(long id) {
        if (id <= 0) {
            LOG.error("delete classroom fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 验证外键约束
            if (lessonDAO.checkByclassroomId(id) != null || classroomStateDAO.checkByclassroomId(id) != null) {
                LOG.error("delete classroom fail, foreign key constraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            classroomDAO.deleteById(id);
            LOG.info("delete classroom success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete classroom error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //修改教室信息
    @Override
    public ResultDO<Void> modifyClassroom(ModifyClassroomVO modifyClassroomVO) {
        if (modifyClassroomVO == null || StringUtils.isBlank(modifyClassroomVO.getBuilding())
            || StringUtils.isBlank(modifyClassroomVO.getFloor()) || StringUtils.isBlank(modifyClassroomVO.getNumber())
            || StringUtils.isBlank(modifyClassroomVO.getEquipmentId()) || modifyClassroomVO.getId() <= 0) {
            LOG.error("modify classroom fail, parameter invalid, modifyClassroomVO={}", modifyClassroomVO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            ClassroomDO classroomDO = classroomDAO.getClassroomDOById(modifyClassroomVO.getId());
            // 更新
            classroomDO.setEquipmentId(modifyClassroomVO.getEquipmentId());
            classroomDO.setNumber(modifyClassroomVO.getNumber());
            // 更改buildingFloorId
            long buildingFloorId =
                buildingFloorDAO.getBuildingFloorDOByBuildingAndFloor(modifyClassroomVO.getBuilding(),
                    modifyClassroomVO.getFloor()).getId();
            classroomDO.setBuildingFloorId(buildingFloorId);
            classroomDAO.update(classroomDO);
            LOG.info("modify classroom success, classroomDO={}, modifyClassroomVO={}", classroomDO, modifyClassroomVO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify classroom error, modifyClassroomVO={}", modifyClassroomVO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //获取楼号
    @Override
    public ResultDO<List<String>> getBuildings() {
        try {
            List<String> list = buildingFloorDAO.getBuildings();
            LOG.info("get buildings success, list={}", list);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get buildings error, list={}", buildingFloorDAO.getBuildings(), e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //返回库中学年集
    @Override
    public ResultDO<List<String>> getYears() {
        try {
            List<String> list = courseDAO.getYears();
            LOG.info("get year success, list={}", list);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get year error, list={}", courseDAO.getYears(), e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过学年和学期返回课程集
    @Override
    public ResultDO<List<CourseDO>> getCourseDOByYearAndTerm(String year, int term) {
        if (StringUtils.isBlank(year) || (term != Term.FIRSTSEMESTER && term != Term.SECONDSEMESTER)) {
            LOG.error("get courseDO by year and term fail, parameter invalid, year={}, term={}", year, term);
            return new ResultDO<List<CourseDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<CourseDO> list = courseDAO.getCourseDOByYearAndTerm(year, term);
            LOG.info("get courseDO by year and term success, year={}, term={}, list={}", year, term, list);
            return new ResultDO<List<CourseDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get courseDO by year and term error, year={}, term={}", year, term, e);
            return new ResultDO<List<CourseDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //验证是否存在课程id
    @Override
    public ResultDO<Void> deleteCourse(long id) {
        if (id <= 0) {
            LOG.error("delete course fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 验证外键约束
            if (lessonDAO.checkByCourseId(id) != null || studentCourseDAO.checkByCourseId(id) != null) {
                LOG.error("delete course fail, foreign key constraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            courseDAO.deleteById(id);
            LOG.info("delete course success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete course error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //修改课程信息
    @Override
    public ResultDO<Void> modifyCourse(ModifyCourseVO modifyCourseVO) {
        if (StringUtils.isBlank(modifyCourseVO.getClassId()) || StringUtils.isBlank(modifyCourseVO.getName())
            || StringUtils.isBlank(modifyCourseVO.getNumber()) || StringUtils.isBlank(modifyCourseVO.getProfession())
            || StringUtils.isBlank(modifyCourseVO.getYear()) || modifyCourseVO.getId() <= 0
            || modifyCourseVO.getLessonSum() <= 0
            || (modifyCourseVO.getTerm() != Term.FIRSTSEMESTER && modifyCourseVO.getTerm() != Term.SECONDSEMESTER)) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 转化为courseDO
            CourseDO courseDO = new CourseDO(modifyCourseVO);
            // 解析前端选择的专业为专业id
            long professionId = professionDAO.getProfessionDOByProfession(modifyCourseVO.getProfession()).getId();
            if (professionId <= 0) {
                LOG.error("get professionDO by profession fail, professionId <= 0, modifyCourseVO={}, professionId={}",
                    modifyCourseVO, professionId);
                return new ResultDO<>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
            }
            courseDO.setProfessionId(professionId);
            // 解析前端输入的班级
            String[] classNumberList = courseDO.getClassId().split(",");
            List<Long> classIdList = new ArrayList<>();
            for (String number : classNumberList) {
                ClassDO classDO = classDAO.getClassDOByNumber(number);
                classIdList.add(classDO.getId());
            }
            // 转换为json
            String classIdListJson = JSON.toJSONString(classIdList);
            courseDO.setClassId(classIdListJson);
            courseDAO.update(courseDO);
            LOG.info("modify course success, courseDO={}", courseDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify course error, modifyCourseVO={}", modifyCourseVO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //返回库中学院id集
    @Override
    public ResultDO<List<String>> getAcademies() {
        try {
            List<String> list = academyDAO.getAcademies();
            LOG.info("get academies success, list={}", list);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get academies error, list={}", userDAO.getAcademies(), e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过学院名称返回AcademyDO,通过学院返回教师集
    @Override
    public ResultDO<List<UserDO>> getTeacherDOByAcademy(String academy) {
        if (StringUtils.isBlank(academy)) {
            LOG.error("get teacher by academy fail, parameter invalid, academy={}", academy);
            return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 获取学院对应id
            long academyId = academyDAO.getAcademyDOByAcademy(academy).getId();
            List<UserDO> list = userDAO.getTeacherDOByAcademyId(academyId);
            LOG.info("get teacher by academy success, academy={}", academy);
            return new ResultDO<List<UserDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get teacher by academy error, academy={}", academy, e);
            return new ResultDO<List<UserDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //判断是否有userId对应的教师 如果有 id删除用户
    @Override
    public ResultDO<Void> deleteTeacher(long id) {
        if (id <= 0) {
            LOG.error("delete teacher fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 验证外键约束
            if (teacherLessonDAO.checkByTeacherId(id) != null) {
                LOG.error("delete teacher fail, foreign key constraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            userDAO.deleteById(id);
            LOG.info("delete teacher success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete teacher error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过修改老师的id返回用户 更新用户信息
    @Override
    public ResultDO<Void> modifyTeacher(ModifyTeacherVO modifyTeacherVO) {
        if (modifyTeacherVO == null || StringUtils.isBlank(modifyTeacherVO.getAcademy())
            || StringUtils.isBlank(modifyTeacherVO.getNumber()) || StringUtils.isBlank(modifyTeacherVO.getSex())
            || StringUtils.isBlank(modifyTeacherVO.getIdCardNumber()) || StringUtils.isBlank(modifyTeacherVO.getPhone())
            || StringUtils.isBlank(modifyTeacherVO.getMail()) || StringUtils.isBlank(modifyTeacherVO.getFaceToken())
            || StringUtils.isBlank(modifyTeacherVO.getName()) || modifyTeacherVO.getId() <= 0) {
            LOG.error("modify teacher fail, parameter invalid, modifyTeacherVO={}", modifyTeacherVO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            UserDO teacherDO = userDAO.getUserDOById(modifyTeacherVO.getId());
            // 更新数据
            teacherDO.setAcademyId(academyDAO.getAcademyDOByAcademy(modifyTeacherVO.getAcademy()).getId());
            teacherDO.setNumber(modifyTeacherVO.getNumber());
            teacherDO.setName(modifyTeacherVO.getName());
            teacherDO.setSex(modifyTeacherVO.getSex());
            teacherDO.setIdCardNumber(modifyTeacherVO.getIdCardNumber());
            teacherDO.setPhone(modifyTeacherVO.getPhone());
            teacherDO.setMail(modifyTeacherVO.getMail());
            teacherDO.setFaceToken(modifyTeacherVO.getFaceToken());

            userDAO.update(teacherDO);

            LOG.info("modify teacher success, teacherDO={}", teacherDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify teacher error, modifyTeacherVO={}", modifyTeacherVO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过学院名称返回AcademyDO 获取id 通过学院id返回ClassDO集
    @Override
    public ResultDO<List<String>> getClassesByAcademy(String academy) {
        if (StringUtils.isBlank(academy) == true) {
            LOG.error("get classes by academy fail, academy is blank, academy={}", academy);
            return new ResultDO<List<String>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 获取学院id
            long academyId = academyDAO.getAcademyDOByAcademy(academy).getId();
            LOG.info("get academyDO by academy success, academy={}", academy);
            List<ClassDO> classDOList = classDAO.getClassDOsByAcademyId(academyId);
            LOG.info("get classDOs by academyId success, academyId={}", academyId);
            List<String> classesList = new ArrayList<>();
            for (int i = 0; i < classDOList.size(); i++) {
                classesList.add(classDOList.get(i).getNumber());
            }
            LOG.info("get classes by academy success, academy={}", academy);
            return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classesList);
        } catch (Exception e) {
            LOG.error("get classes by academy error, academy={}", academy, e);
            return new ResultDO<List<String>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过教室和学院返回两者id 查询用户
    @Override
    public ResultDO<List<UserDO>> getStudentDOByAcademyAndClasses(String academy, String classes) {
        if (StringUtils.isBlank(academy) || StringUtils.isBlank(classes)) {
            LOG.error("get studentDO by academy and classes fail, parameter invalid, academy={}, classes={}", academy,
                classes);
            return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            long academyId = academyDAO.getAcademyDOByAcademy(academy).getId();
            long classId = classDAO.getClassDOByNumber(classes).getId();
            List<UserDO> studentDOList = new LinkedList<UserDO>();
            studentDOList = userDAO.getStudentDOByAcademyIdAndClassId(academyId, classId);
            LOG.info("get studentDO by academy and classes success, academy={}, classes={}", academy, classes);
            return new ResultDO<List<UserDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, studentDOList);
        } catch (Exception e) {
            LOG.error("get studentDO by academy and classes error, academy={}, classes={}", academy, classes, e);
            return new ResultDO<List<UserDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过id 删除学生
    @Override
    public ResultDO<Void> deleteStudent(long id) {
        if (id <= 0) {
            LOG.error("delete student fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 验证外键约束
            if (studentCourseDAO.checkByStudentId(id) != null || classScoreDAO.checkByStudentId(id) != null
                || attendanceDAO.checkByStudentId(id) != null) {
                LOG.error("delete student fail, foreign key constraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            userDAO.deleteById(id);
            LOG.info("delete student success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete student error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //更新用户信息
    @Override
    public ResultDO<Void> modifyStudent(ModifyStudentVO modifyStudentVO) {
        if (modifyStudentVO == null || StringUtils.isBlank(modifyStudentVO.getAcademy())
            || StringUtils.isBlank(modifyStudentVO.getClasses()) || StringUtils.isBlank(modifyStudentVO.getNumber())
            || StringUtils.isBlank(modifyStudentVO.getSex()) || StringUtils.isBlank(modifyStudentVO.getIdCardNumber())
            || StringUtils.isBlank(modifyStudentVO.getPhone()) || StringUtils.isBlank(modifyStudentVO.getMail())
            || StringUtils.isBlank(modifyStudentVO.getFaceToken()) || StringUtils.isBlank(modifyStudentVO.getName())
            || modifyStudentVO.getId() <= 0) {
            LOG.error("modify student fail, parameter invalid, modifyStudentVO={}", modifyStudentVO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            UserDO studentDO = userDAO.getUserDOById(modifyStudentVO.getId());
            // 更新数据
            studentDO.setAcademyId(academyDAO.getAcademyDOByAcademy(modifyStudentVO.getAcademy()).getId());
            studentDO.setClassId(classDAO.getClassDOByNumber(modifyStudentVO.getClasses()).getId());
            studentDO.setNumber(modifyStudentVO.getNumber());
            studentDO.setName(modifyStudentVO.getName());
            studentDO.setSex(modifyStudentVO.getSex());
            studentDO.setIdCardNumber(modifyStudentVO.getIdCardNumber());
            studentDO.setPhone(modifyStudentVO.getPhone());
            studentDO.setMail(modifyStudentVO.getMail());
            studentDO.setFaceToken(modifyStudentVO.getFaceToken());

            // 更新数据库
            userDAO.update(studentDO);
            LOG.info("modify student success, studentDO={}", studentDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify student error, modifyStudentVO={}", modifyStudentVO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过教室id返回教室
    @Override
    public ResultDO<ClassroomDO> getClassroomDOById(long id) {
        if (id <= 0) {
            LOG.error("get classroomDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<ClassroomDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            ClassroomDO classroomDO = classroomDAO.getClassroomDOById(id);
            LOG.info("get classroomDO by id success, id={}, classroomDO={}", id, classroomDO);
            return new ResultDO<ClassroomDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classroomDO);
        } catch (Exception e) {
            LOG.error("get classroomDO by id error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }

    }

    //id获取课程信息 查询班级id集合 再通过id集查询班级集
    @Override
    public ResultDO<CourseDTOAndClassesVO> getCourseDTOAndClassesVOById(long id) {
        if (id <= 0) {
            LOG.error("get courseDTOAndClassesVO by id, parameter invalid, id={}", id);
            return new ResultDO<CourseDTOAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            CourseDO courseDO = courseDAO.getCourseDOById(id);
            CourseDTO courseDTO = new CourseDTO(courseDO);
            // 获取班级id集
            List<Long> classIdList = courseDTO.getClassId();
            // 参数验证
            for (long classId : classIdList) {
                if (classId <= 0) {
                    LOG.error("get courseDTOAndClassesVO by id fail, classId <= 0, id={}, classId={}", id, classId);
                    return new ResultDO<CourseDTOAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            // 班级集
            List<ClassDO> classDOList = new ArrayList<>();
            for (long classId : classIdList) {
                ClassDO classDO = classDAO.getClassDOById(classId);
                classDOList.add(classDO);
            }
            // 构建VO
            CourseDTOAndClassesVO courseDTOAndClassesVO = new CourseDTOAndClassesVO();
            courseDTOAndClassesVO.setCourseDTO(courseDTO);
            courseDTOAndClassesVO.setClassDOList(classDOList);
            courseDTOAndClassesVO
                .setProfession(professionDAO.getProfessionById(courseDTOAndClassesVO.getCourseDTO().getProfessionId()));
            LOG.info("get courseDTOAndClassesVO by id success, id={}", id);
            return new ResultDO<CourseDTOAndClassesVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                courseDTOAndClassesVO);
        } catch (Exception e) {
            LOG.error("get courseDTOAndClassesVO by id error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //id得到用户 用户得到学院id  通过id返回AcademyDO
    @Override
    public ResultDO<TeacherDOAndAcademyVO> getTeacherDOAndAcademyVOById(long id) {
        if (id <= 0) {
            LOG.error("get teacherDO and academy vo by id fail, parameter invalid, id={}", id);
            return new ResultDO<TeacherDOAndAcademyVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 得到teacherDO
            UserDO teacherDO = userDAO.getUserDOById(id);
            // 获得academyId
            long academyId = teacherDO.getAcademyId();
            if (academyId <= 0) {
                LOG.error("get teacherDO and academy vo by id fail, parameter invalid, id={}, academyId={}", id,
                    academyId);
                return new ResultDO<TeacherDOAndAcademyVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 获得AcademyDO
            AcademyDO academyDO = new AcademyDO();
            academyDO = academyDAO.getAcademyDOById(academyId);
            LOG.info("get academyDO by academyId success, academyId={}", academyId);
            // 构建VO
            TeacherDOAndAcademyVO teacherDOAndAcademyVO = new TeacherDOAndAcademyVO();
            teacherDOAndAcademyVO.setTeacherDO(teacherDO);
            teacherDOAndAcademyVO.setAcademy(academyDO.getAcademy());
            LOG.info("get teacherDO and academy vo by id success, id={}, VO={}", id, teacherDOAndAcademyVO);
            return new ResultDO<TeacherDOAndAcademyVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                teacherDOAndAcademyVO);
        } catch (Exception e) {
            LOG.error("get teacherDO and academy vo by id error, id={}", id);
            return new ResultDO<TeacherDOAndAcademyVO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //id得到用户 用户查询所在学院id和班级id 返回用户学院和班级集合
    @Override
    public ResultDO<StudentDOAndAcademyAndClassesVO> getStudentDOAndAcademyAndClassesVOById(long id) {
        if (id <= 0) {
            LOG.error("get studentDO and academy and classes vo by id fail, parameter invalid, id={}", id);
            return new ResultDO<StudentDOAndAcademyAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 得到studentDO
            UserDO studentDO = userDAO.getUserDOById(id);
            // 获得academyId
            long academyId = studentDO.getAcademyId();
            // 获得classesId
            long classesId = studentDO.getClassId();
            if (academyId <= 0 || classesId <= 0) {
                LOG.error(
                    "get studentDO and academy and classes vo by id fail, parameter invalid, id={}, academyId={}, classesId={}",
                    id, academyId, classesId);
                return new ResultDO<StudentDOAndAcademyAndClassesVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 获得AcademyDO
            AcademyDO academyDO = new AcademyDO();
            academyDO = academyDAO.getAcademyDOById(academyId);
            LOG.info("get academyDO by academyId success, academyId={}", academyId);
            // 获得ClassDO
            ClassDO classDO = classDAO.getClassDOById(classesId);
            LOG.info("get classDO by classesId success, classesId={}", classesId);
            // 构建VO
            StudentDOAndAcademyAndClassesVO studentDOAndAcademyAndClassesVO = new StudentDOAndAcademyAndClassesVO();
            studentDOAndAcademyAndClassesVO.setStudentDO(studentDO);
            studentDOAndAcademyAndClassesVO.setAcademy(academyDO.getAcademy());
            studentDOAndAcademyAndClassesVO.setClasses(classDO.getNumber());
            LOG.info("get studentDO and academy and classes vo by id success, id={}, VO={}", id,
                studentDOAndAcademyAndClassesVO);
            return new ResultDO<StudentDOAndAcademyAndClassesVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                studentDOAndAcademyAndClassesVO);
        } catch (Exception e) {
            LOG.error("get studentDO and academy and classes vo by id error, id={}", id);
            return new ResultDO<StudentDOAndAcademyAndClassesVO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过userId查询,获得courseId集,通过courseId获取该用户课堂集
    @Override
    public ResultDO<List<LessonDO>> getLessonDOByUserId(long userId) {
        if (userId <= 0) {
            LOG.error("get lessonDO by userId fail, parameter invalid, userId={}", userId);
            return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<Long> courseIdList = studentCourseDAO.getCourseIdsByUserId(userId);
            for (long id : courseIdList) {
                if (id <= 0) {
                    LOG.error("get lessonDO by userId fail, courseId <= 0, courseId={}, userId={}", id, userId);
                    return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            List<LessonDO> list = new ArrayList<>();
            for (long courseId : courseIdList) {
                List<LessonDO> lessonDOList = lessonDAO.getLessonDOByCourseId(courseId);
                for (LessonDO lessonDO : lessonDOList) {
                    list.add(lessonDO);
                }
            }
            LOG.info("get lessonDO by userId success, userId={}, list={}", userId, list);
            return new ResultDO<List<LessonDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get lessonDO by userId error, userId={}", userId, e);
            return new ResultDO<List<LessonDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //id查询课时
    @Override
    public ResultDO<LessonDO> getLessonDOById(long id) {
        if (id <= 0) {
            LOG.error("get lessonDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<LessonDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            LessonDO lessonDO = lessonDAO.getLessonDOById(id);
            LOG.info("get lessonDO by id success, id={}, lessonDO={}", id, lessonDO);
            return new ResultDO<LessonDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, lessonDO);
        } catch (Exception e) {
            LOG.error("get lessonDO by id error, id={}", id, e);
            return new ResultDO<LessonDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //根据楼号和楼层返回BuildingFloorDO
    @Override
    public ResultDO<BuildingFloorDO> getBuildingFloorDOByBuildingAndFloor(String building, String floor) {
        if (StringUtils.isBlank(building) || StringUtils.isBlank(floor)) {
            LOG.error("get buildingFloorDO by building and floor fail, parameter invalid, building={}, floor={}",
                building, floor);
            return new ResultDO<BuildingFloorDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOByBuildingAndFloor(building, floor);
            LOG.info("get buildingFloorDO by building and floor success, building={}, floor={}, buildingFloorDO={}",
                building, floor, buildingFloorDO);
            return new ResultDO<BuildingFloorDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, buildingFloorDO);
        } catch (Exception e) {
            LOG.error("get buildingFloorDO by building and floor error, building={}, floor={}", building, floor);
            return new ResultDO<BuildingFloorDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //用户id 构建教室Do 楼号楼层号 ClassroomDOAndBuildingAndFloorVO
    @Override
    public ResultDO<ClassroomDOAndBuildingAndFloorVO> getClassroomDOAndbuildingAndFloorVOById(long id) {
        if (id <= 0) {
            LOG.error("get classroomDO and building and floor vo by id fail, parameter invalid, id={}", id);
            return new ResultDO<ClassroomDOAndBuildingAndFloorVO>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            // 得到ClassroomDO
            ClassroomDO classroomDO = classroomDAO.getClassroomDOById(id);
            // 获得buildingFloorId
            long buildFloorId = classroomDO.getBuildingFloorId();
            if (buildFloorId <= 0) {
                LOG.error(
                    "get classroomDO and building and floor vo by id fail, parameter invalid, id={}, buildingFloorId={}",
                    id, buildFloorId);
                return new ResultDO<ClassroomDOAndBuildingAndFloorVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 获得buildingFloorDO
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(buildFloorId);
            // 构建VO
            ClassroomDOAndBuildingAndFloorVO classroomDOAndBuildingAndFloorVO = new ClassroomDOAndBuildingAndFloorVO();
            classroomDOAndBuildingAndFloorVO.setClassroomDO(classroomDO);
            classroomDOAndBuildingAndFloorVO.setBuilding(buildingFloorDO.getBuilding());
            classroomDOAndBuildingAndFloorVO.setFloor(buildingFloorDO.getFloor());
            LOG.info("get classroomDO and building and floor vo by id success, id={}, VO={}", id,
                classroomDOAndBuildingAndFloorVO);
            return new ResultDO<ClassroomDOAndBuildingAndFloorVO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                classroomDOAndBuildingAndFloorVO);
        } catch (Exception e) {
            LOG.error("get classroomDO and building and floor vo by id error, id={}", id);
            return new ResultDO<ClassroomDOAndBuildingAndFloorVO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过id返回ClassDO
    @Override
    public ResultDO<ClassDO> getClassDOById(long id) {
        if (id <= 0) {
            LOG.error("get classDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<ClassDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            ClassDO classDO = classDAO.getClassDOById(id);
            LOG.info("get classDO by Id success, id={}, classDO={}", id, classDO);
            return new ResultDO<ClassDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classDO);
        } catch (Exception e) {
            LOG.error("get classDO by id error, id={}", id);
            return new ResultDO<ClassDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过楼号返回BuildingFloorDO
    @Override
    public ResultDO<List<BuildingFloorDO>> getBuildingFloorDOsByBuilding(String building) {
        if (StringUtils.isBlank(building)) {
            LOG.error("get buildingFloorDOs by building fail, parameter invalid, building={}", building);
            return new ResultDO<List<BuildingFloorDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            List<BuildingFloorDO> list = buildingFloorDAO.getBuildingFloorDOsByBuilding(building);
            // 给楼层排序
            Collections.sort(list, new Comparator<BuildingFloorDO>() {

                @Override
                public int compare(BuildingFloorDO firstBuildingFloor, BuildingFloorDO secondeBuildingFloor) {
                    int firstFloorNumber = FloorComparatorUtil.getNumber(firstBuildingFloor.getFloor().split("楼")[0]);
                    int secondeFloorNumber =
                        FloorComparatorUtil.getNumber(secondeBuildingFloor.getFloor().split("楼")[0]);
                    return firstFloorNumber - secondeFloorNumber;
                }
            });
            LOG.info("get buildingFloorDOs by building success, building={}, list={}", building, list);
            return new ResultDO<List<BuildingFloorDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get buildingFloorDOs by building error, building={}", building, e);
            return new ResultDO<List<BuildingFloorDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
    }

    //根据id返回BuildingFloorDO
    @Override
    public ResultDO<BuildingFloorDO> getBuildingFloorDOById(long id) {
        if (id <= 0) {
            LOG.error("get buildingFloorDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<BuildingFloorDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(id);
            LOG.info("get buildingFloorDO by id success, id={}, buildingFloorDO={}", id, buildingFloorDO);
            return new ResultDO<BuildingFloorDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, buildingFloorDO);
        } catch (Exception e) {
            LOG.error("get buildingFloorDO by id error, id={}", id);
            return new ResultDO<BuildingFloorDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //id判断是否存在buildingFloorId 存在就删除
    @Override
    public ResultDO<Void> deleteBuildingFloorById(long id) {
        if (id <= 0) {
            LOG.error("delete buildingfloor by id fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 外键约束
            if (classroomDAO.checkByBuildingFloorId(id) != null) {
                LOG.error("delete building floor fail, foreign key constraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            buildingFloorDAO.deleteById(id);
            LOG.info("delete buildingfloor by id success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete buildingfloor by id error, id={}", id);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //根据modifyBuildingFloorVO.getId()返回BuildingFloorDO  然后修改
    @Override
    public ResultDO<Void> modifyBuildingFloor(ModifyBuildingFloorVO modifyBuildingFloorVO) {
        if (modifyBuildingFloorVO.getId() <= 0 || StringUtils.isBlank(modifyBuildingFloorVO.getBuilding())
            || StringUtils.isBlank(modifyBuildingFloorVO.getFloor())) {
            LOG.error("modify building floor fail, parameter invalid, modifyBuildingFloorVO={}", modifyBuildingFloorVO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(modifyBuildingFloorVO.getId());
            buildingFloorDO.setBuilding(modifyBuildingFloorVO.getBuilding());
            buildingFloorDO.setFloor(modifyBuildingFloorVO.getFloor());
            // 判断是否已经存在 根据楼号和楼层返回BuildingFloorDO
            BuildingFloorDO check =
                buildingFloorDAO.getBuildingFloorDOByBuildingAndFloor(modifyBuildingFloorVO.getBuilding(),
                    modifyBuildingFloorVO.getFloor());
            if (check != null) {
                LOG.error(
                    "modify buildingFloor fail, already exist buildingFloorDO in DB, modifyBuildingFloorVO={}, existBuildingFloorDO={}",
                    modifyBuildingFloorVO, check);
                return new ResultDO<>(false, ResultCode.ALREADY_EXIST_BUILDINGFLOORDO,
                    ResultCode.MSG_ALREADY_EXIST_BUILDINGFLOORDO);
            }
            buildingFloorDAO.update(buildingFloorDO);
            LOG.info("modify building floor success, modifyBuildingFloorVO={}", modifyBuildingFloorVO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify building floor error, modifyBuildingFloorVO={}", modifyBuildingFloorVO);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //学院获取id 通过学院id返回班级集
    @Override
    public ResultDO<List<ClassDO>> getClassDOsByAcademy(String academy) {
        if (StringUtils.isBlank(academy)) {
            LOG.error("get classDOs by academy fail, parameter invalid, academy={}", academy);
            return new ResultDO<List<ClassDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        // 获取学院id
        long academyId = academyDAO.getAcademyDOByAcademy(academy).getId();
        if (academyId <= 0) {
            LOG.error("get classDOs by academy fail, academyId <= 0, academy={}, academyId={}", academy, academyId);
            return new ResultDO<List<ClassDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<ClassDO> list = classDAO.getClassDOsByAcademyId(academyId);
            LOG.info("get classDOs by academy success, academy={}, list={}", academy, list);
            return new ResultDO<List<ClassDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);

        } catch (Exception e) {
            LOG.error("get classDOs by academy error, academy={}", academy);
            return new ResultDO<List<ClassDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过id返回AcademyDO
    @Override
    public ResultDO<AcademyDO> getAcademyDOById(long id) {
        if (id <= 0) {
            LOG.error("get academy by id fail, parameter invalid, id={}", id);
            return new ResultDO<AcademyDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            AcademyDO academyDO = academyDAO.getAcademyDOById(id);
            LOG.info("get academyDO by id, id={}", id);
            return new ResultDO<AcademyDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, academyDO);
        } catch (Exception e) {
            LOG.error("get academyDO by id error, id={}", id, e);
            return new ResultDO<AcademyDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过id删除ClassDO
    @Override
    public ResultDO<Void> deleteClassDOById(long id) {
        if (id <= 0) {
            LOG.error("delete classDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 验证外键约束
            if (!courseDAO.checkByClassId(id).isEmpty() || userDAO.checkByClassId(id) != null) {
                LOG.error("delete classDO by id fail, foreign key contraint, id={}", id);
                return new ResultDO<>(false, ResultCode.FOREIGN_KEY_CONSTRAINT, ResultCode.MSG_FOREIGN_KEY_CONSTRAINT);
            }
            classDAO.deleteById(id);
            LOG.info("delete classDO by id success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete classDO by id error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //通过学院名称返回AcademyDO 然后得到id  过学院id和班级号返回ClassDO 修改
    @Override
    public ResultDO<Void> modifyClass(ModifyClassDOVO modifyClassDOVO) {
        if (modifyClassDOVO.getId() <= 0 || StringUtils.isBlank(modifyClassDOVO.getAcademy())
            || StringUtils.isBlank(modifyClassDOVO.getNumber())
            || StringUtils.isBlank(modifyClassDOVO.getProfession())) {
            LOG.error("modify class fail, parameter invalid, modifyClassDOVO=#{}", modifyClassDOVO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            long id = modifyClassDOVO.getId();
            long academyId = academyDAO.getAcademyDOByAcademy(modifyClassDOVO.getAcademy()).getId();
            // 判断是否已存在要修改成的班级
            ClassDO check = classDAO.getClassDOByAcademyIdAndNumber(academyId, modifyClassDOVO.getNumber());
            if (check != null && check.getId() != modifyClassDOVO.getId()) {
                LOG.error("modify class fail, already exist classDO, modifyClassDOVO={}, existClassDO={}",
                    modifyClassDOVO, check);
                return new ResultDO<>(false, ResultCode.ALREADY_EXIST_CLASSDO, ResultCode.MSG_ALREADY_EXIST_CLASSDO);
            }
            long professionId = professionDAO.getProfessionDOByProfession(modifyClassDOVO.getProfession()).getId();
            ClassDO classDO = classDAO.getClassDOById(id);
            classDO.setAcademyId(academyId);
            classDO.setNumber(modifyClassDOVO.getNumber());
            classDO.setProfessionId(professionId);
            classDAO.update(classDO);
            LOG.info("modify class success, modifyClassDOVO=#{}", modifyClassDOVO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify class error, modifyClassDOVO=#{}", modifyClassDOVO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }


    @Override
    public ResultDO<List<String>> getEnumFloors() {
        List<String> list = Floor.ALL_FLOOR;
        LOG.info("get enum floors success");
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }


    @Override
    public ResultDO<List<String>> getEnumYears() {
        List<String> list = Year.ALL_YEAR;
        LOG.info("get enum years success");
        return new ResultDO<List<String>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    //通过id返回ProfessionDO
    @Override
    public ResultDO<ProfessionDO> getProfessionDOById(long id) {
        if (id <= 0) {
            LOG.error("get professionDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<ProfessionDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            ProfessionDO professionDO = professionDAO.getProfessionDOById(id);
            LOG.info("get professionDO by id success, id={}, professionDO={}", id, professionDO);
            return new ResultDO<ProfessionDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, professionDO);
        } catch (Exception e) {
            LOG.error("get professionDO by id error, id={}", id);
            return new ResultDO<ProfessionDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //获取库中所有专业
    @Override
    public ResultDO<List<ProfessionDO>> getProfessionDOs() {
        try {
            List<ProfessionDO> list = professionDAO.getProfessionDOs();
            LOG.info("get professionDOs success, list={}", list);
            return new ResultDO<List<ProfessionDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get professionDOs error", e);
            return new ResultDO<List<ProfessionDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

}
