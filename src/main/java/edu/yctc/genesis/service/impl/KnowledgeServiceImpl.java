package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import edu.yctc.genesis.dao.*;
import edu.yctc.genesis.entity.*;
import edu.yctc.genesis.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.service.KnowledgeIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("knowledgeService")
/**
 * 知识点检测业务层实现
 * 
 * @author 15272
 */
public class KnowledgeServiceImpl implements KnowledgeIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    /** 匹配中文正则表达式 */
    private final static String PATTERN = "[\\u4e00-\\u9fa5]+";

    @Resource
    private LessonDAO lessonDAO;

    @Resource
    private TeacherLessonDAO teacherLessonDAO;

    @Resource
    private CourseDAO courseDAO;

    @Resource
    private ClassroomDAO classroomDAO;

    @Resource
    private KnowledgeLessonDAO knowledgeLessonDAO;

    @Resource
    private KnowledgeDAO knowledgeDAO;

    @Resource
    private KnowledgeStudentStateDAO knowledgeStudentStateDAO;

    @Resource
    private PictureKnowledgeDAO pictureKnowledgeDAO;

    //判断待匹配字符串中是否存在知识点
    @Override
    public ResultDO<Boolean> checkKnowledge(String knowledge, String toMatch) {
        if (StringUtils.isBlank(knowledge) || StringUtils.isBlank(toMatch)) {
            LOG.error("check knowledge fail, parameter invalid, knowledge={}, toMatch={}", knowledge, toMatch);
            return new ResultDO<Boolean>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, false);
        }
        Pattern pattern = Pattern.compile(PATTERN);
        // OCR识别出的文字用换行符分隔
        String[] split = toMatch.split("\n");
        for (String str : split) {
            if (pattern.matcher(str).find()) { // 匹配到中文
                // 判断是否是知识点
                if (str.replaceAll(" ", "").contains(knowledge.replaceAll(" ", ""))) {
                    LOG.info("check knowledge success, knowledge={}, toMatch={}", knowledge, toMatch);
                    return new ResultDO<Boolean>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, true);
                }
            }
        }
        LOG.error("check knowledge fail, no such knowledge, knowledge={}, toMatch={}", knowledge, toMatch);
        return new ResultDO<Boolean>(false, ResultCode.NO_SUCH_KNOWLEDGE, ResultCode.MSG_NO_SUCH_KNOWLEDGE, false);
    }

    //通过userId返回TeacherLessonDO 获得lessonId集  id查询课时
    @Override
    public ResultDO<List<LessonDO>> getLessonDOListByUserId4Teacher(long userId) {
        if (userId <= 0) {
            LOG.error("get lessonDO list by userId fail, parameter invalid, userId={}", userId);
            return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 获得lessonId集
            List<TeacherLessonDO> teacherLessonDOList = teacherLessonDAO.getTeacherLessonDOByUserId(userId);
            // 参数验证
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                if (teacherLessonDO == null || teacherLessonDO.getId() <= 0 || teacherLessonDO.getLessonId() <= 0
                    || teacherLessonDO.getUserId() <= 0) {
                    LOG.error("get lessonDO list by userId fail, parameter invalid, teacherLessonDO={}, userId={}",
                        teacherLessonDO, userId);
                    return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            List<LessonDO> list = new ArrayList<>();
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                long lessonId = teacherLessonDO.getLessonId();
                LessonDO lessonDO = lessonDAO.getLessonDOById(lessonId);
                // 还未上的课
                if (lessonDO.getBegin().after(new Date()))
                    list.add(lessonDO);
            }
            LOG.info("get lessonDO list by userId success, userId={}, list={}", userId, list);
            return new ResultDO<List<LessonDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get lessonDO list by userId error, userId={}", userId, e);
            return new ResultDO<List<LessonDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //id查询课程
    @Override
    public ResultDO<CourseDO> getCourseDOById(long id) {
        if (id <= 0) {
            LOG.error("get courseDO by id fail, parameter invalid, id={}", id);
            return new ResultDO<CourseDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            CourseDO courseDO = courseDAO.getCourseDOById(id);
            LOG.info("get courseDO by id success, id={}", id);
            return new ResultDO<CourseDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseDO);
        } catch (Exception e) {
            LOG.error("get courseDO by id error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //用户id查询教室
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

    //通过lessonId得到knowledgeLessonDO集
    @Override
    public ResultDO<List<KnowledgeDO>> getKnowledgeDOsByLessonId(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("get knowledgeDOs by lessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<List<KnowledgeDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            List<KnowledgeDO> knowledgeDOs = new ArrayList<>();
            List<KnowledgeLessonDO> knowledgeLessonDOs = knowledgeLessonDAO.getKnowledgeLessonDOsByLessonId(lessonId);
            for (KnowledgeLessonDO knowledgeLessonDO : knowledgeLessonDOs) {
                knowledgeDOs.add(knowledgeDAO.getKnowledgeDOById(knowledgeLessonDO.getKnowledgeId()));
            }
            LOG.info("get knowledgeDOs by lessonId success, lessonId={}", lessonId);
            return new ResultDO<List<KnowledgeDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, knowledgeDOs);
        } catch (Exception e) {
            LOG.error("get knowledgeDOs by lessonId error, lessonId={}", lessonId, e);
            return new ResultDO<List<KnowledgeDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过课程id 返回知识点集合
    public ResultDO<List<OneKnowledgeDetailsVO>> getKnowledgesDetailsVOByLessonId(long lessonId) {

        if (lessonId <= 0) {
            LOG.error("get knowledgesDetailsVO By LessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<List<OneKnowledgeDetailsVO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<OneKnowledgeDetailsVO> oneKnowledgeDetailsVOList = new LinkedList<OneKnowledgeDetailsVO>();
        try {
            // 1.根据lessonId获得知识点id的list
            List<KnowledgeLessonDO> knowledgeDOList = knowledgeLessonDAO.getKnowledgeLessonDOsByLessonId(lessonId);
            LOG.info("get knowledgeLessonDOs by lessonId By LessonId success, knowledgeDOList={}, lessonId={}",
                knowledgeDOList, lessonId);
            // 2.遍历,传参
            for (int i = 0; i < knowledgeDOList.size(); i++) {
                OneKnowledgeDetailsVO oneKnowledgeDetailsVO = new OneKnowledgeDetailsVO();
                Long knowledgeId = knowledgeDOList.get(i).getKnowledgeId();
                KnowledgeDO knowledgeDO = knowledgeDAO.getKnowledgeDOById(knowledgeId);
//                System.out.println("==--------------"+knowledgeDO);
                oneKnowledgeDetailsVO.setKnowledgeId(knowledgeId);
                oneKnowledgeDetailsVO.setContent(knowledgeDO.getContent());
                oneKnowledgeDetailsVO.setLength(knowledgeDO.getLength());
                oneKnowledgeDetailsVO.setSum(knowledgeStudentStateDAO.getSumByLessonId(lessonId, knowledgeId));
                oneKnowledgeDetailsVO
                    .setSumForCareful(knowledgeStudentStateDAO.getSumOfCarefulByLessonId(lessonId, knowledgeId));
                List<KnowledgeStudentStateDO> KnowledgeStudentStateDOList =
                    knowledgeStudentStateDAO.getKnowledgeStudentStateDOListByKnowledgeId(knowledgeId);
//                System.out.println("--------------------"+knowledgeDOList);
                if (KnowledgeStudentStateDOList.size() == 0) {
                    continue;
                }
//                oneKnowledgeDetailsVO
//                    .setScanStartTime(knowledgeStudentStateDAO.getScanStartTimeByKnowledgeId(knowledgeId));
//                oneKnowledgeDetailsVO.setScanEndTime(knowledgeStudentStateDAO.getScanEndTimeByKnowledgeId(knowledgeId));

                oneKnowledgeDetailsVOList.add(oneKnowledgeDetailsVO);
//                System.out.println(oneKnowledgeDetailsVOList.toString());
            }
            LOG.info("get knowledgesDetailsVO By LessonId success, lessonId={}", lessonId);
            return new ResultDO<List<OneKnowledgeDetailsVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                oneKnowledgeDetailsVOList);

        } catch (Exception e) {
            LOG.error("get knowledgesDetailsVO By LessonId error, lessonId={}", lessonId, e);
            return new ResultDO<List<OneKnowledgeDetailsVO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //通过知识点id 返回图片集合
    @Override
    public ResultDO<List<KnowledgePictureDO>> getKnowledgePictureDOsByKnowledgeId(long knowledgeId){
        System.out.println("正在通过知识点查找图片");
        if (knowledgeId <= 0) {
            LOG.error("get GetPictureVO By knowledgeId fail, parameter invalid, lessonId={}", knowledgeId);
            return new ResultDO<List<KnowledgePictureDO>>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        List<KnowledgePictureDO> knowledgePictureDOS = new LinkedList<KnowledgePictureDO>();
        try {
            System.out.println("根据knowledgeId获得图片的list");
            // 1.根据knowledgeId获得图片的list
            knowledgePictureDOS=pictureKnowledgeDAO.PictureByKnowledgeId(knowledgeId);
            LOG.info("get knowledgePictureDOS by knowledgeId success, knowledgeId={}",
                     knowledgeId);
            System.out.println(knowledgePictureDOS.toString());
            // 2.遍历,传参
            GetPictureVO getPictureVO=new GetPictureVO();
            for (int i = 0; i < knowledgePictureDOS.size(); i++){
                getPictureVO.setPicture(knowledgePictureDOS);
            }
            LOG.info("get knowledgePictureDOS By knowledgeId success, getPictureVOS={} getContent={}", knowledgePictureDOS,knowledgeDAO.getKnowledgeDOById(knowledgeId).getContent());
            return new ResultDO<List<KnowledgePictureDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
                    knowledgePictureDOS);
        } catch (Exception e) {
            LOG.error("get knowledgePictureDOS By knowledgeId error, knowledgeId={}", knowledgeId, e);
            return new ResultDO<List<KnowledgePictureDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                    ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    //插入知识点对应的图片
    public  ResultDO<Void> insertPictureByKnowledgeId (String picture,long knowledgeId) {
        KnowledgePictureDO knowledgePictureDO =new KnowledgePictureDO();
        knowledgePictureDO.setKnowledgeid(knowledgeId);
        knowledgePictureDO.setPicture(picture);
        try {
            pictureKnowledgeDAO.insert(knowledgePictureDO);
            LOG.info("insert knowledge success, knowledgePictureDO={}", knowledgePictureDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert knowledge error, knowledgePictureDO={}", knowledgePictureDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //修改知识点
    @Override
    public ResultDO<Void> modifyKnowledge(KnowledgeDO knowledgeDO) {
        if (knowledgeDO.getId() <= 0 || StringUtils.isBlank(knowledgeDO.getContent()) || knowledgeDO.getLength() <= 0) {
            LOG.error("modify knowledge fail, parameter invalid, knowledgeDO={}", knowledgeDO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            knowledgeDAO.update(knowledgeDO);
            LOG.info("modify knowledge success, knowledgeDO={}", knowledgeDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("modify knowledge error, knowledgeDO={}", knowledgeDO, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //删除知识点
    @Override
    public ResultDO<Void> deleteKnowledgeById(long id) {
        if (id <= 0) {
            LOG.error("delete knowledge by id fail, parameter invalid, id={}", id);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            knowledgeDAO.deleteById(id);
            knowledgeLessonDAO.deleteKnowledgeLessonDOByKnowledgeId(id);
            LOG.info("delete knowledge by id success, id={}", id);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("delete knowledge by id error, id={}", id, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //插入知识点
    @Override
    public ResultDO<Void> insertKnowledge(long lessonId, String content, double length) {
        if (lessonId <= 0 || StringUtils.isBlank(content) || length <= 0) {
            LOG.error("insert knowledge fail, parameter invalid, lessonId={}, content={}, length={}", lessonId, content,
                length);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            KnowledgeDO knowledgeDO = new KnowledgeDO();
            knowledgeDO.setContent(content);
            knowledgeDO.setLength(length);
            knowledgeDAO.insert(knowledgeDO);
            KnowledgeLessonDO knowledgeLessonDO = new KnowledgeLessonDO();
            knowledgeLessonDO.setKnowledgeId(knowledgeDO.getId());
            knowledgeLessonDO.setLessonId(lessonId);
            knowledgeLessonDAO.insert(knowledgeLessonDO);
            LOG.info("insert knowledge success, lessonId={}, knowledDO={}", lessonId, knowledgeDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert knowledge error, lessonId={}, content={}, length={}", lessonId, content, length);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //插入一个状态信息
    @Override
    public ResultDO<Void> insertKnowledgeAndStudentStateDO(KnowledgeStudentStateDO knowledgeStudentStateDO) {
        if (knowledgeStudentStateDO.getKnowledgeId() <= 0
            || knowledgeStudentStateDO.getLessonId() <= 0 || knowledgeStudentStateDO.getState() <= 0
            || knowledgeStudentStateDO.getUserId() <= 0) {
            LOG.error("insert knowledge and studentStateDO fail, parameter invalid, knowledgeStudentStateD={}",
                knowledgeStudentStateDO);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            knowledgeStudentStateDAO.insert(knowledgeStudentStateDO);
            LOG.info("insert knowledge and studentStateDO success, knowledgeStudentStateD={}", knowledgeStudentStateDO);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("insert knowledge and studentStateDO error, knowledgeStudentStateD={}", knowledgeStudentStateDO);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    //获取学生状态集合
    @Override
    public ResultDO<StudentsLessonStateVO> getStudentsLessonStateVO(long lessonId,long knowledgeId){
        System.out.println("正在通过课程id查询状态集合");
        if (knowledgeId <= 0&&lessonId<0) {
            LOG.error("get GetPictureVO By knowledgeId fail, parameter invalid, lessonId={},knowledgeId={}",lessonId, knowledgeId);
            return new ResultDO<StudentsLessonStateVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        StudentsLessonStateVO  studentsLessonStateVO=new StudentsLessonStateVO();
        try {
            List<StateLessonDO> lessonStateVO = knowledgeStudentStateDAO.getKnowledgeStudentStateLessonStateVO(lessonId, knowledgeId);
            System.out.println("正在通过课程id查询状态集合"+lessonStateVO);
            int LISTENING=0;  /** 认真听课 1*/
            int PLAY_MOBILE_PHONE=0;/** 玩手机 2*/
            int DAZE=0;/** 发呆 3*/
            int SLEEP=0;/** 睡觉 4*/

            for (int i=0;i<lessonStateVO.size();i++){
                if (lessonStateVO.get(i).getState()==1){
                    LISTENING++;
                }if (lessonStateVO.get(i).getState()==2){
                    PLAY_MOBILE_PHONE++;
                }if (lessonStateVO.get(i).getState()==3){
                    DAZE++;
                }if (lessonStateVO.get(i).getState()==4){
                    SLEEP++;
                }
            }
            studentsLessonStateVO.setLISTENING(LISTENING);
            studentsLessonStateVO.setPLAY_MOBILE_PHONE(PLAY_MOBILE_PHONE);
            studentsLessonStateVO.setDAZE(DAZE);
            studentsLessonStateVO.setSLEEP(SLEEP);

        } catch (Exception e) {
            LOG.error("get studentsLessonStateVO By knowledgeId fail, parameter invalid, lessonId={},knowledgeId={}",lessonId, knowledgeId,e);
        }
        return new ResultDO<StudentsLessonStateVO>(true, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, studentsLessonStateVO);
    }

    @Override
    public ResultDO<GetBooleanByPictureVO> GetBooleanByPictureid(long pictureId){
        System.out.println("正在通过图片id查询是否被识别到集合");
        if (pictureId <= 0) {
            LOG.error("get GetBooleanBy ByPictureVO  fail, parameter invalid, pictureId={}",pictureId);
            return new ResultDO<GetBooleanByPictureVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        GetPictureBooleanLastVO GetPictureBooleanLastVO=null;
        GetBooleanByPictureVO getBooleanByPictureVO=new GetBooleanByPictureVO();
        try {
            GetPictureBooleanLastVO = pictureKnowledgeDAO.GetBooleanByPictureid(pictureId);
            System.out.println(GetPictureBooleanLastVO);
            getBooleanByPictureVO.setPrictureId(GetPictureBooleanLastVO.getPictureid());
            getBooleanByPictureVO.setId(GetPictureBooleanLastVO.getId());
            getBooleanByPictureVO.setKnowledgeid(GetPictureBooleanLastVO.getKnowledgeid());
            KnowledgeDO knowledgeDO = knowledgeDAO.getKnowledgeDOById(GetPictureBooleanLastVO.getKnowledgeid());
            getBooleanByPictureVO.setKnowledge(knowledgeDO.getContent());
            if (GetPictureBooleanLastVO.getPictureBoolean()==1){
                getBooleanByPictureVO.setCheck(true);
            }else {
                getBooleanByPictureVO.setCheck(false);
            }
        System.out.println("正在通过图片id查询是否被识别到集合---------------");
        } catch (Exception e) {
            LOG.error("get GetBooleanByPictureVO By byPictureVOS fail, parameter invalid, pictureId={}",pictureId,e);
            return new ResultDO<GetBooleanByPictureVO>(false, ResultCode.PARAMETER_INVALID,
                    ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return new ResultDO<GetBooleanByPictureVO>(true, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, getBooleanByPictureVO);
    }

}
