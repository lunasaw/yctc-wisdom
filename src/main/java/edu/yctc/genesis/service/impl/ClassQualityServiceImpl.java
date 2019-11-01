package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.dao.ClassScoreDAO;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.CourseDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.StudentCourseDAO;
import edu.yctc.genesis.dao.StudentStateDAO;
import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;
import edu.yctc.genesis.service.ClassQualityIService;
import edu.yctc.genesis.util.ClassScoreUtil;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("classQualityService")
public class ClassQualityServiceImpl implements ClassQualityIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    StudentCourseDAO studentCourseDAO;//学生选课

    @Resource
    LessonDAO lessonDAO;//课时

    @Resource
    CourseDAO courseDAO;//课程

    @Resource
    ClassroomDAO classroomDAO;//教室

    @Resource
    StudentStateDAO studentStateDAO;//学生状态

    @Resource
    ClassScoreDAO classScoreDAO;//课程评分

    @Override
    public ResultDO<List<LessonDO>> getLessonDOList4StudentByUserId(long userId) {
        if (userId <= 0) {
            LOG.error("get lessonDO list by userId fail, parameter invalid, userId={}", userId);
            return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 课程号集
            List<Long> courseIdList = studentCourseDAO.getCourseIdsByUserId(userId);
            for (long id : courseIdList) {
                if (id <= 0) {
                    LOG.error("get lessonDO list by userId fail, courseId <= 0, courseId={}, userId={}", id, userId);
                    return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            // 得到lessonDO集
            List<LessonDO> list = new ArrayList<>();
            for (long courseId : courseIdList) {
                List<LessonDO> lessonDOList = lessonDAO.getLessonDOByCourseId(courseId);
                for (LessonDO lessonDO : lessonDOList) {
                    // 已经上的课(才有评分)
                    // TODO 注释去掉 if (lessonDO.getEnd().before(new Date()))
                    list.add(lessonDO);
                }
            }
            LOG.info("get lessonDO list by userId success, userId={}, list={}", userId, list);
            return new ResultDO<List<LessonDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get lessonDO list by userId error, userId={}", userId, e);
            return new ResultDO<List<LessonDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

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

    @Override
    public ResultDO<ClassScoreDO> getClassScoreDOByUserIdAndLessonId(long userId, long lessonId) {
        if (userId <= 0 || lessonId <= 0) {
            LOG.error("get classScoreDO by userId and lessonId fail, parameter invalid, userId={}, lessonId={}", userId,
                lessonId);
            return new ResultDO<ClassScoreDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            List<StudentStateDO> list = studentStateDAO.getStudentStateDOByUserIdAndLessonId(userId, lessonId);
            if (list.isEmpty()) {
                LOG.error("get studentStateDO by userId and lessonId fail, userId={}, lessonId={}", userId, lessonId);
                return new ResultDO<ClassScoreDO>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
            // 参数验证
            for (StudentStateDO stateDO : list) {
                if (stateDO == null || stateDO.getId() <= 0 || stateDO.getLessonId() <= 0 || stateDO.getUserId() <= 0
                    || stateDO.getId() <= 0 || StringUtils.isBlank(stateDO.getFaceToken())) {
                    LOG.error(
                        "get studentStateDO by userId and lessonId fail, parameter invalid, userId={}, lessonId={}, stateDO={}",
                        userId, lessonId, stateDO);
                    return new ResultDO<ClassScoreDO>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            // 计算评分
            ResultDO<Double> calculateScoreByStateResultDO = ClassScoreUtil.calculateScoreByState(list);
            if (calculateScoreByStateResultDO.isSuccess() == false) {
                LOG.error("calculate score by state fail, userId={}, lessonId={}, list={}", userId, lessonId, list);
                return new ResultDO<ClassScoreDO>(false, calculateScoreByStateResultDO.getCode(),
                    calculateScoreByStateResultDO.getMsg(), null);
            }
            // 已有评分则跟新，没有评分则新增
            ClassScoreDO classScoreDO = classScoreDAO.getClassScoreDOByUserIdAndLessonId(userId, lessonId);
            if (classScoreDO != null) {
                classScoreDO.setScore(calculateScoreByStateResultDO.getModule().doubleValue());
                classScoreDAO.update(classScoreDO);
                LOG.info(
                    "get classScoreDO by userId and lessonId success, update classScoreDO success, userId={}, lessonId={}, classScoreDO={}",
                    userId, lessonId, classScoreDO);
                return new ResultDO<ClassScoreDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classScoreDO);
            } else {
                ClassScoreDO newClassScoreDO = new ClassScoreDO();
                newClassScoreDO.setLessonId(lessonId);
                newClassScoreDO.setUserId(userId);
                newClassScoreDO.setScore(calculateScoreByStateResultDO.getModule().doubleValue());
                classScoreDAO.insert(newClassScoreDO);
                LOG.info(
                    "get classScoreDO by userId and lessonId success, insert classScoreDO success, userId={}, lessonId={}, classScoreDO={}",
                    userId, lessonId, newClassScoreDO);
                return new ResultDO<ClassScoreDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, newClassScoreDO);
            }
        } catch (Exception e) {
            LOG.error("get classScoreDO by userId and lessonId error, userId={}, lessonId={}", userId, lessonId);
            return new ResultDO<ClassScoreDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<Void> calculateScoresByLessonId(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("calculate scores by lessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            // 获取本堂课所有学生
            long courseId = lessonDAO.getCourseIdById(lessonId);
            if (courseId <= 0) {
                LOG.error("get courseId by lessonId fail, courseId <= 0, lessonId={}, courseId={}", lessonId, courseId);
                return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
            }
            // 得到选课学生id集
            List<Long> userIdList = studentCourseDAO.getUserIdsByCourseId(courseId);
            // 得到studentStateDO用于计算评分
            for (long userId : userIdList) {
                List<StudentStateDO> studentStateDOs = studentStateDAO.getStudentStateDOByUserIdAndLessonId(userId,
                    lessonId);
                if (studentStateDOs.isEmpty()) {
                    LOG.error("no such stateDO, userId={}, lessonId={}", userId, lessonId);
                    continue;
                }
                ResultDO<Double> resultDO = ClassScoreUtil.calculateScoreByState(studentStateDOs);
                if (resultDO.isSuccess() == false) {
                    LOG.error("calculate score by state fail, userId={}, lessonId={}, stateDOs={}, resultDO={}", userId,
                        lessonId, studentStateDOs, resultDO.toString());
                    continue;
                }
                // 存入数据库，有则更新，无则增加
                ClassScoreDO classScoreDO = classScoreDAO.getClassScoreDOByUserIdAndLessonId(userId, lessonId);
                if (classScoreDO != null) {
                    classScoreDO.setScore(resultDO.getModule().doubleValue());
                    classScoreDAO.update(classScoreDO);
                    LOG.info("calculate score success, update success, userId={}, lessonId={}, classScoreDO={}", userId,
                        lessonId, classScoreDO);
                } else {
                    ClassScoreDO newClassScoreDO = new ClassScoreDO();
                    newClassScoreDO.setLessonId(lessonId);
                    newClassScoreDO.setUserId(userId);
                    newClassScoreDO.setScore(resultDO.getModule().doubleValue());
                    classScoreDAO.insert(newClassScoreDO);
                    LOG.info("calculate score success, insert success, userId={}, lessonId={}, classScoreDO={}", userId,
                        lessonId, newClassScoreDO);
                }
            }
            LOG.info("calculate score by lessonId success, lessonId={}, userIds={}", lessonId, userIdList);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("calculate scores by lessonId error, lessonId={}", lessonId, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }
}
