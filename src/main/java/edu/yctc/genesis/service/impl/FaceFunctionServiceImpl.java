package edu.yctc.genesis.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.dao.AttendanceDAO;
import edu.yctc.genesis.dao.BuildingFloorDAO;
import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.EquipmentDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.dao.StudentStateDAO;
import edu.yctc.genesis.dao.TeacherLessonDAO;
import edu.yctc.genesis.entity.AttendanceDO;
import edu.yctc.genesis.entity.BuildingFloorDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.EquipmentDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;
import edu.yctc.genesis.entity.TeacherLessonDO;
import edu.yctc.genesis.face.function.impl.FaceFunctionImpl;
import edu.yctc.genesis.face.util.CheckKnowledgeThread;
import edu.yctc.genesis.face.util.CheckStudentStateThread;
import edu.yctc.genesis.service.FaceFunctionIService;
import edu.yctc.genesis.util.FloorComparatorUtil;

/**
 * 算法业务层接口实现
 * 
 * @author 15272
 */
@ComponentScan({"edu.yctc.genesis.dao"})
@Service("faceFunctionService")
public class FaceFunctionServiceImpl implements FaceFunctionIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Resource
    TeacherLessonDAO teacherLessonDAO;

    @Resource
    LessonDAO lessonDAO;

    @Resource
    AttendanceDAO attendanceDAO;

    @Resource
    StudentStateDAO studentStateDAO;

    @Resource
    BuildingFloorDAO buildingFloorDAO;

    @Resource
    ClassroomDAO classroomDAO;

    @Resource
    EquipmentDAO equipmentDAO;

    @Override
    public ResultDO<List<AttendanceDO>> checkAttendanceByTeacherId(long teacherId) {
        if (teacherId <= 0) {
            LOG.error("check by teacherId fail, parameter invalid, teacherId={}", teacherId);
            return new ResultDO<List<AttendanceDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        // 获取所有授课记录
        List<TeacherLessonDO> teacherLessonDOList = teacherLessonDAO.getTeacherLessonDOByUserId(teacherId);
        if (teacherLessonDOList.isEmpty()) {
            LOG.error("get teacherLessonDO by teacherId fail, no teacherLessonDO, teacherId={}", teacherId);
            return new ResultDO<List<AttendanceDO>>(false, ResultCode.NO_TEACHER_LESSON_FOUND,
                ResultCode.MSG_NO_TEACHER_LESSON_FOUND, null);
        }
        // 参数验证
        for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
            if (teacherLessonDO.getId() <= 0 || teacherLessonDO.getLessonId() <= 0
                || teacherLessonDO.getUserId() <= 0) {
                LOG.error("get teacherLessonDO by teacherId fail, parameter invalid, teacherId={}", teacherId);
                return new ResultDO<List<AttendanceDO>>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
            // 存在性验证
            LessonDO lessonDO = lessonDAO.getLessonDOById(teacherLessonDO.getLessonId());
            if (lessonDO == null) {
                LOG.error("get lessonDO by id fail, no such lessonDO, lessonId={}, teacherId={}",
                    teacherLessonDO.getLessonId(), teacherId);
                return new ResultDO<List<AttendanceDO>>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR, null);
            }
        }
        // 获取正在上的课
        LessonDO lessonDO = null;
        for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
            LessonDO checkLessonDO = lessonDAO.getLessonDOById(teacherLessonDO.getLessonId());
            // 找到正在上的课
            if (checkLessonDO.getBegin().before(new Date()) && checkLessonDO.getEnd().after(new Date())) {
                lessonDO = checkLessonDO;
                break;
            }
            // 不是正在上的课，跳过
            else {
                continue;
            }
        }
        // 无正在上的课程
        if (lessonDO == null) {
            LOG.error("get current teacherLessonDO by teacherId fail, no lesson found, teacherId={}", teacherId);
            return new ResultDO<List<AttendanceDO>>(false, ResultCode.NO_TEACHING_LESSON,
                ResultCode.MSG_NO_TEACHING_LESSON, null);
        }
        // 点名
        FaceFunctionImpl faceFunctionImpl = new FaceFunctionImpl();
        faceFunctionImpl.checkByLessonId(Long.toString(lessonDO.getId()));
        // 返回点名情况
        List<AttendanceDO> list = attendanceDAO.getAttendanceDOsByLessonId(lessonDO.getId());
        LOG.info("check attendance by teacherId success, teacherId={}, list={}", teacherId, list);
        return new ResultDO<List<AttendanceDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @Override
    public ResultDO<Void> checkStateByTeacherId(long teacherId) {
        if (teacherId <= 0) {
            LOG.error("check state by teacherId fail, parameter invalid, teacherId={}", teacherId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            List<TeacherLessonDO> teacherLessonDOList = teacherLessonDAO.getTeacherLessonDOByUserId(teacherId);
            if (teacherLessonDOList.isEmpty()) {
                LOG.error("get teacherLessonDO by teacherId fail, no teacherLessonDO, teacherId={}", teacherId);
                return new ResultDO<Void>(false, ResultCode.NO_TEACHER_LESSON_FOUND,
                    ResultCode.MSG_NO_TEACHER_LESSON_FOUND);
            }
            // 参数验证
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                if (teacherLessonDO.getId() <= 0 || teacherLessonDO.getLessonId() <= 0
                    || teacherLessonDO.getUserId() <= 0) {
                    LOG.error("get teacherLessonDO by teacherId fail, parameter invalid, teacherId={}", teacherId);
                    return new ResultDO<Void>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
                }
                // 存在性验证
                LessonDO lessonDO = lessonDAO.getLessonDOById(teacherLessonDO.getLessonId());
                if (lessonDO == null) {
                    LOG.error("get lessonDO by id fail, no such lessonDO, lessonId={}, teacherId={}",
                        teacherLessonDO.getLessonId(), teacherId);
                    return new ResultDO<Void>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
                }
            }
            // 获取正在上的课
            LessonDO lessonDO = null;
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                LessonDO checkLessonDO = lessonDAO.getCurrentLessonDOByLessonId(teacherLessonDO.getLessonId());
                // 不是正在上的课，跳过
                if (checkLessonDO == null)
                    continue;
                // 找到正在上的课
                else {
                    lessonDO = checkLessonDO;
                    break;
                }
            }
            // 无正在上的课程
            if (lessonDO == null) {
                LOG.error("get current teacherLessonDO by teacherId fail, no lesson found, teacherId={}", teacherId);
                return new ResultDO<Void>(false, ResultCode.NO_TEACHING_LESSON, ResultCode.MSG_NO_TEACHING_LESSON);
            }
            // 开始进行状态检测
            // 判断是否已经在检测
            if (CheckStudentStateThread.isChecking(lessonDO.getId())) {
                LOG.error("check state by lessonId fail, still checking, lessonId={}", lessonDO.getId());
                return new ResultDO<Void>(false, ResultCode.STILL_CHECKING, ResultCode.MSG_STILL_CHECKING);
            }
            // 线程池开启
            CheckStudentStateThread.checkStateByLessonId(lessonDO.getId());
            LOG.info("check state by teacherId start, teacherId={}", teacherId);
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("check state by teacherId error, teacherId={}", teacherId, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Map<Long, List<StudentStateDO>>> getStateByTeacherId(long teacherId) {
        if (teacherId <= 0) {
            LOG.error("get state by teacherId fail, parameter invalid, teacherId={}", teacherId);
            return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            List<TeacherLessonDO> teacherLessonDOList = teacherLessonDAO.getTeacherLessonDOByUserId(teacherId);
            if (teacherLessonDOList.isEmpty()) {
                LOG.error("get teacherLessonDO by teacherId fail, no teacherLessonDO, teacherId={}", teacherId);
                return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.NO_TEACHER_LESSON_FOUND,
                    ResultCode.MSG_NO_TEACHER_LESSON_FOUND, null);
            }
            // 参数验证
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                if (teacherLessonDO.getId() <= 0 || teacherLessonDO.getLessonId() <= 0
                    || teacherLessonDO.getUserId() <= 0) {
                    LOG.error("get teacherLessonDO by teacherId fail, parameter invalid, teacherId={}", teacherId);
                    return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.DB_ERROR,
                        ResultCode.MSG_DB_ERROR, null);
                }
                // 存在性验证
                LessonDO lessonDO = lessonDAO.getLessonDOById(teacherLessonDO.getLessonId());
                if (lessonDO == null) {
                    LOG.error("get lessonDO by id fail, no such lessonDO, lessonId={}, teacherId={}",
                        teacherLessonDO.getLessonId(), teacherId);
                    return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.DB_ERROR,
                        ResultCode.MSG_DB_ERROR, null);
                }
            }
            // 获取正在上的课
            LessonDO lessonDO = null;
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                LessonDO checkLessonDO = lessonDAO.getCurrentLessonDOByLessonId(teacherLessonDO.getLessonId());
                // 不是正在上的课，跳过
                if (checkLessonDO == null)
                    continue;
                // 找到正在上的课
                else {
                    lessonDO = checkLessonDO;
                    break;
                }
            }
            // 无正在上的课程
            if (lessonDO == null) {
                LOG.error("get current teacherLessonDO by teacherId fail, no lesson found, teacherId={}", teacherId);
                return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.NO_TEACHING_LESSON,
                    ResultCode.MSG_NO_TEACHING_LESSON, null);
            }
            // 返回学生检测到的状态记录
            // 获取所有被检测的学生的userId
            List<Long> userIdList = studentStateDAO.getUserIdsByLessonId(lessonDO.getId());
            for (long id : userIdList) {
                if (id <= 0) {
                    LOG.error("get userIds by lessonId fail, userId <= 0, userId={}", id);
                    return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.DB_ERROR,
                        ResultCode.MSG_DB_ERROR, null);
                }
            }
            Map<Long, List<StudentStateDO>> map = new HashMap<>();
            for (long id : userIdList) {
                List<StudentStateDO> list = studentStateDAO.getStudentStateDOByUserIdAndLessonId(id, lessonDO.getId());
                map.put(id, list);
            }
            LOG.info("get state by teacherId success, teacherId={}, lessonId={}, map={}", teacherId, lessonDO.getId(),
                map);
            return new ResultDO<Map<Long, List<StudentStateDO>>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, map);
        } catch (Exception e) {
            LOG.error("get state by teacherId error, teacherId={}", teacherId, e);
            return new ResultDO<Map<Long, List<StudentStateDO>>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<Void> controlCamera(String command) {
        if (StringUtils.isBlank(command)) {
            LOG.error("control camera fail, parameter invalid, command={}", command);
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            FaceFunctionImpl faceFunctionImpl = new FaceFunctionImpl();
            faceFunctionImpl.cameraControl(command);
            LOG.info("control camera success, command={}", command);
            return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("control camera error, command={}", command, e);
            return new ResultDO<>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

    @Override
    public ResultDO<Void> checkKnowledgeByTeacherId(long teacherId) {
        if (teacherId <= 0) {
            LOG.error("check knowledge by teacherId fail, parameter invalid, teacherId={}", teacherId);
            return new ResultDO<Void>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            List<TeacherLessonDO> teacherLessonDOList = teacherLessonDAO.getTeacherLessonDOByUserId(teacherId);
            if (teacherLessonDOList.isEmpty()) {
                LOG.error("get teacherLessonDO by teacherId fail, no teacherLessonDO, teacherId={}", teacherId);
                return new ResultDO<Void>(false, ResultCode.NO_TEACHER_LESSON_FOUND,
                    ResultCode.MSG_NO_TEACHER_LESSON_FOUND);
            }
            // 参数验证
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                if (teacherLessonDO.getId() <= 0 || teacherLessonDO.getLessonId() <= 0
                    || teacherLessonDO.getUserId() <= 0) {
                    LOG.error("get teacherLessonDO by teacherId fail, parameter invalid, teacherId={}", teacherId);
                    return new ResultDO<Void>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
                }
                // 存在性验证
                LessonDO lessonDO = lessonDAO.getLessonDOById(teacherLessonDO.getLessonId());
                if (lessonDO == null) {
                    LOG.error("get lessonDO by id fail, no such lessonDO, lessonId={}, teacherId={}",
                        teacherLessonDO.getLessonId(), teacherId);
                    return new ResultDO<Void>(false, ResultCode.DB_ERROR, ResultCode.MSG_DB_ERROR);
                }
            }
            // 获取正在上的课
            LessonDO lessonDO = null;
            for (TeacherLessonDO teacherLessonDO : teacherLessonDOList) {
                LessonDO checkLessonDO = lessonDAO.getCurrentLessonDOByLessonId(teacherLessonDO.getLessonId());
                // 不是正在上的课，跳过
                if (checkLessonDO == null)
                    continue;
                // 找到正在上的课
                else {
                    lessonDO = checkLessonDO;
                    break;
                }
            }
            // 无正在上的课程
            if (lessonDO == null) {
                LOG.error("get current teacherLessonDO by teacherId fail, no lesson found, teacherId={}", teacherId);
                return new ResultDO<Void>(false, ResultCode.NO_TEACHING_LESSON, ResultCode.MSG_NO_TEACHING_LESSON);
            }
            // 开始检测
            // 判断是否已经在检测
            if (CheckKnowledgeThread.isChecking(lessonDO.getId())) {
                LOG.error("check knowledge by lessonId fail, still checking, lessonId={}", lessonDO.getId());
                return new ResultDO<Void>(false, ResultCode.STILL_CHECKING, ResultCode.MSG_STILL_CHECKING);
            }
            // 线程池开启
            CheckKnowledgeThread checkKnowledgeThread = new CheckKnowledgeThread();
            checkKnowledgeThread.checkKnowledgeByLessonId(lessonDO.getId());
            LOG.info("check knowledge by teacherId start, teacherId={}", teacherId);
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            LOG.error("check knowledge by teacherId error, teacherId={}", teacherId, e);
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }

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

    @Override
    public ResultDO<List<EquipmentDO>> getEquipmentDOsByClassroomNumber(String number) {
        if (StringUtils.isBlank(number)) {
            LOG.error("get equipmentDOs by classroom number fail, parameter invalid, number={}", number);
            return new ResultDO<List<EquipmentDO>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            String idListJson = classroomDAO.getEquipmentIdsByClassroomNumber(number);
            List<Long> idList = JSON.parseArray(idListJson, Long.class);
            List<EquipmentDO> list = new ArrayList<>();
            for (long id : idList) {
                EquipmentDO equipmentDO = equipmentDAO.getEquipmentDOById(id);
                if (equipmentDO == null) {
                    continue;
                }
                list.add(equipmentDO);
            }
            LOG.info("get equipmentDOs by classroom number success, number={}, list={}", number, list);
            return new ResultDO<List<EquipmentDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
        } catch (Exception e) {
            LOG.error("get equipmentDOs by classroom number fail, number={}", number, e);
            return new ResultDO<List<EquipmentDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<String> getVideoByEquipmentNumber(String number) {
        if (StringUtils.isBlank(number)) {
            LOG.error("get video by equipment number fail, parameter invalid, number={}", number);
            return new ResultDO<String>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            String video = equipmentDAO.getEquipmentDOByNumber(number).getVideo();
            LOG.info("get video by equipment number success, number={}, video={}", number, video);
            return new ResultDO<String>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, video);
        } catch (Exception e) {
            LOG.error("get video by equipment number error, number={}", number, e);
            return new ResultDO<String>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION,
                null);
        }
    }

}
