package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.dao.ClassDAO;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.CourseDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.StudentCourseDAO;
import edu.yctc.genesis.dao.TeacherLessonDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.TeacherLessonDO;
import edu.yctc.genesis.service.TimetableIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("timetableService")
public class TimetableServiceImpl implements TimetableIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    @Resource
    LessonDAO lessonDAO;//课时

    @Resource
    CourseDAO courseDAO;//课程安排

    @Resource
    ClassroomDAO classroomDAO;//教室

    @Resource
    UserDAO userDAO;//用户

    @Resource
    TeacherLessonDAO teacherLessonDAO;//老师课时

    @Resource
    StudentCourseDAO studentCourseDAO;//学生课时

    @Resource
    ClassDAO classDAO;//班级

    //通过userid查询课程集
    @Override
    public ResultDO<List<LessonDO>> getLessonDOListByUserId4Student(long userId) {
        if (userId <= 0) {
            LOG.error("get lessonDO by userId fail, parameter invalid, userId={}", userId);
            return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 课程号集
            List<Long> courseIdList = studentCourseDAO.getCourseIdsByUserId(userId);
            for (long id : courseIdList) {
                if (id <= 0) {
                    LOG.error("get lessonDO by userId fail, courseId <= 0, courseId={}, userId={}", id, userId);
                    return new ResultDO<List<LessonDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            // 得到lessonDO集
            List<LessonDO> list = new ArrayList<>();
            for (long courseId : courseIdList) {
                List<LessonDO> lessonDOList = lessonDAO.getLessonDOByCourseId(courseId);
                for (LessonDO lessonDO : lessonDOList) {
                    // 还未上的课
                    if (lessonDO.getBegin().after(new Date()))
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

    //通过id查询课程courseDO
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

    //通过id查询教室
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

    //通过课程id查询老师
    @Override
    public ResultDO<String> getTeacherNameByLessonId(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("get teacherName by lessonId fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            TeacherLessonDO teacherLessonDO = teacherLessonDAO.getTeacherLessonDOByLessonId(lessonId);
            if (teacherLessonDO == null) {
                LOG.error("get teacher name by lessonId fail, teacherLessonDO is null, lessonId={}, teacherLessonDO={}",
                    lessonId, teacherLessonDO);
                return new ResultDO<String>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
            long userId = teacherLessonDO.getUserId();
            if (userId <= 0) {
                LOG.error("get teacher name by lessonId fail, userId <= 0, lessonId={}, teacherLessonDO={}, userId={}",
                    lessonId, teacherLessonDO, userId);
                return new ResultDO<String>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
            String teacherName = userDAO.getUserDOById(userId).getName();
            if (StringUtils.isBlank(teacherName)) {
                LOG.error(
                    "get teacher name by lessonId fail, userId <= 0, lessonId={}, teacherLessonDO={}, userId={}, teacherName={}",
                    lessonId, teacherLessonDO, userId, teacherName);
                return new ResultDO<String>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
            LOG.info("get teacher name by lessonId success, lessonId={}", lessonId);
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, teacherName);
        } catch (Exception e) {
            LOG.error("get teacher name by lessonId error, lessonId={}", lessonId, e);
            return new ResultDO<String>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

    //通过教师id返回课时安排
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

    //通过classid查询课程
    @Override
    public ResultDO<ClassDO> getClassDOById(long classId) {
        if (classId <= 0) {
            LOG.error("get classDO by id fail, parameter invalid, classId={}", classId);
            return new ResultDO<ClassDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            ClassDO classDO = classDAO.getClassDOById(classId);
            LOG.info("get classDO by id success, classId={}, classDO={}", classId, classDO);
            return new ResultDO<ClassDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, classDO);
        } catch (Exception e) {
            LOG.error("get classDO by id error, parameter invalid, classId={}", classId, e);
            return new ResultDO<ClassDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }
}
