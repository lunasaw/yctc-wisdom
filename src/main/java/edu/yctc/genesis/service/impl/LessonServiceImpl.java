package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.EquipmentDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.StudentCourseDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.LessonIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("lessonService")
/**
 * lessonService接口实现
 * 
 * @author 15272
 */
public class LessonServiceImpl implements LessonIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Resource
    LessonDAO lessonDAO;

    @Resource
    ClassroomDAO classroomDAO;

    @Resource
    EquipmentDAO equipmentDAO;

    @Resource
    StudentCourseDAO studentCourseDAO;

    @Resource
    UserDAO userDAO;

    // @Override
    // public ResultDO<String> getVideoUrlByLessonId(long lessonId) {
    // if (lessonId <= 0) {
    // LOG.error("get video url by lessonId fail, parameter invalid, lessonId={}", lessonId);
    // return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
    // }
    // try {
    // // 获取教室id
    // long classroomId = lessonDAO.getClassroomIdById(lessonId);
    // if (classroomId <= 0) {
    // LOG.error("get classroomId by lessonId fail, classroomId <= 0, lessonId={}, classroomId={}", lessonId,
    // classroomId);
    // return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
    // null);
    // }
    // // 获取设备id
    // long equipmentId = classroomDAO.getClassroomDOById(classroomId).getEquipmentId();
    // if (equipmentId <= 0) {
    // LOG.error("get equipmentId fail, equipmentId <= 0, lessonId={}, classroomId={}, equipmentId={}",
    // lessonId, classroomId, equipmentId);
    // return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
    // null);
    // }
    // // 获取url
    // String url = equipmentDAO.getEquipmentDOById(equipmentId).getVideo();
    // if (StringUtils.isBlank(url)) {
    // LOG.error("get url fail, lessonId={}, classroomId={}, equipmentId={}, url={}", lessonId, classroomId,
    // equipmentId, url);
    // return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
    // null);
    // }
    // LOG.info("get video url by lessonId success, lessonId={}, url={}", lessonId, url);
    // return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, url);
    // } catch (Exception e) {
    // LOG.error("get video url by lessonId error, lessonId={}", lessonId, e);
    // return new ResultDO<String>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
    // null);
    // }
    // }

    //通过课程id返回CourseId 得到选课学生id集 查询用户
    @Override
    public ResultDO<List<UserDO>> getAllStudentsAtLesson(long lessonId) {
        if (lessonId <= 0) {
            LOG.error("get all students at lesson fail, parameter invalid, lessonId={}", lessonId);
            return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                null);
        }
        try {
            // 获取课程id
            long courseId = lessonDAO.getCourseIdById(lessonId);
            if (courseId <= 0) {
                LOG.error("get courseId by lessonId fail, courseId <= 0, lessonId={}, courseId={}", lessonId, courseId);
                return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID,
                    null);
            }
            // 得到选课学生id集
            List<Long> userIdList = studentCourseDAO.getUserIdsByCourseId(courseId);
            for (long userId : userIdList) {
                if (userId <= 0) {
                    LOG.error("get userIds by courseId fail, userId <= 0, lessonId={}, courseId={}, userId={}",
                        lessonId, courseId, userId);
                    return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
                UserDO userDO = userDAO.getUserDOById(userId);
                if (userDO == null) {
                    LOG.error("get userDO by id fail, userDO is null, lessonId={}, courseId={}, userId={}, userDO={}",
                        lessonId, courseId, userId, userDO);
                    return new ResultDO<List<UserDO>>(false, ResultCode.PARAMETER_INVALID,
                        ResultCode.MSG_PARAMETER_INVALID, null);
                }
            }
            // 获取userDO
            List<UserDO> userDOList = new ArrayList<>();
            for (long userId : userIdList) {
                UserDO userDO = userDAO.getUserDOById(userId);
                userDOList.add(userDO);
            }
            LOG.info("get all students at lesson success, lessonId={}, courseId={}, list={}", lessonId, courseId,
                userDOList);
            return new ResultDO<List<UserDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, userDOList);
        } catch (Exception e) {
            LOG.error("get all students at lesson error, lessonId={}", lessonId, e);
            return new ResultDO<List<UserDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

}
