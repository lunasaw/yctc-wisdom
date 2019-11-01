package edu.yctc.genesis.controller.rest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.attendance.AttendState;
import edu.yctc.genesis.controller.rest.FaceFunctionRestController;
import edu.yctc.genesis.controller.session.SessionContentHolder;
import edu.yctc.genesis.dao.ClassDAO;
import edu.yctc.genesis.dao.UserDAO;
import edu.yctc.genesis.entity.AttendanceDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.service.FaceFunctionIService;
import edu.yctc.genesis.vo.AttendanceVO;
import edu.yctc.genesis.vo.StudentStateVO;

@RestController
@ComponentScan({"edu.yctc.genesis.service"})
@RequestMapping("/restfacefunction")
public class FaceFunctionRestControllerImpl implements FaceFunctionRestController {

    @Autowired
    FaceFunctionIService faceFunctionService;

    @Resource
    UserDAO userDAO;

    @Resource
    ClassDAO classDAO;

    @Override
    @PostMapping("check-attendance")
    public ResultDO<List<AttendanceVO>> checkAttendance(HttpSession httpSession) {
        long teacherId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (StringUtils.isBlank(httpSession.getId()) || teacherId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        try {
            ResultDO<List<AttendanceDO>> checkAttendanceResultDO =
                faceFunctionService.checkAttendanceByTeacherId(teacherId);
            if (checkAttendanceResultDO.isSuccess() == false) {
                return new ResultDO<List<AttendanceVO>>(false, checkAttendanceResultDO.getCode(),
                    checkAttendanceResultDO.getMsg(), null);
            }
            // 构建VO
            List<AttendanceDO> attendanceDOlist = checkAttendanceResultDO.getModule();
            // 参数验证
            for (AttendanceDO attendanceDO : attendanceDOlist) {
                if (AttendState.isLegal(attendanceDO.getAttendState()) == false || attendanceDO.getId() <= 0
                    || attendanceDO.getLessonId() <= 0 || attendanceDO.getUserId() <= 0)
                    return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
            }
            List<AttendanceVO> attendanceVOList = new ArrayList<>();
            for (AttendanceDO attendanceDO : attendanceDOlist) {
                AttendanceVO attendanceVO = new AttendanceVO();
                UserDO userDO = userDAO.getUserDOById(attendanceDO.getUserId());
                attendanceVO.setUserId(attendanceDO.getUserId());
                attendanceVO.setName(userDO.getName());
                attendanceVO.setAttendance(attendanceDO.getAttendState());
                attendanceVO.setStudentClass(classDAO.getClassDOById(userDO.getClassId()).getNumber());
                attendanceVOList.add(attendanceVO);
            }

            return new ResultDO<List<AttendanceVO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, attendanceVOList);
        } catch (Exception e) {
            return new ResultDO<List<AttendanceVO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    @PostMapping("check-state")
    public ResultDO<Void> checkState(HttpSession httpSession) {
        long teacherId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (StringUtils.isBlank(httpSession.getId()) || teacherId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return faceFunctionService.checkStateByTeacherId(teacherId);
    }

    @Override
    @PostMapping("get-student-state-vo")
    public ResultDO<Map<Long, List<StudentStateVO>>> getStudentState(HttpSession httpSession) {
        long teacherId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (StringUtils.isBlank(httpSession.getId()) || teacherId <= 0) {
            return new ResultDO<Map<Long, List<StudentStateVO>>>(false, ResultCode.PARAMETER_INVALID,
                ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            ResultDO<Map<Long, List<StudentStateDO>>> resultDO = faceFunctionService.getStateByTeacherId(teacherId);
            if (resultDO.isSuccess() == false) {
                return new ResultDO<Map<Long, List<StudentStateVO>>>(false, resultDO.getCode(), resultDO.getMsg(),
                    null);
            }
            // 参数验证
            Iterator<Entry<Long, List<StudentStateDO>>> iterator = resultDO.getModule().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, List<StudentStateDO>> entry = (Map.Entry<Long, List<StudentStateDO>>)iterator.next();
                long userId = entry.getKey();
                UserDO userDO = userDAO.getUserDOById(userId);
                if (userId <= 0 || userDO == null) {
                    return new ResultDO<Map<Long, List<StudentStateVO>>>(false, ResultCode.DB_ERROR,
                        ResultCode.MSG_DB_ERROR, null);
                }
                List<StudentStateDO> list = entry.getValue();
                for (StudentStateDO stateDO : list) {
                    if (stateDO == null || stateDO.getId() <= 0 || stateDO.getLessonId() <= 0 || stateDO.getState() <= 0
                        || stateDO.getUserId() <= 0 || StringUtils.isBlank(stateDO.getFaceToken())
                        || stateDO.getScanStartTime() == null || stateDO.getScanEndTime() == null) {
                        return new ResultDO<Map<Long, List<StudentStateVO>>>(false, ResultCode.DB_ERROR,
                            ResultCode.MSG_DB_ERROR, null);
                    }
                }
            }
            // 构建VO
            Map<Long, List<StudentStateVO>> map = new HashMap<>();
            Iterator<Entry<Long, List<StudentStateDO>>> iterator4BuildVO = resultDO.getModule().entrySet().iterator();
            while (iterator4BuildVO.hasNext()) {
                Map.Entry<Long, List<StudentStateDO>> entry =
                    (Map.Entry<Long, List<StudentStateDO>>)iterator4BuildVO.next();
                long userId = entry.getKey();
                String name = userDAO.getUserDOById(userId).getName();
                // 该学生上课状态检测集
                List<StudentStateDO> studentStateDOList = entry.getValue();
                // VO集
                List<StudentStateVO> list = new ArrayList<>();
                for (StudentStateDO stateDO : studentStateDOList) {
                    StudentStateVO studentStateVO = new StudentStateVO();
                    studentStateVO.setName(name);
                    studentStateVO.setStudentStateDO(stateDO);
                    studentStateVO.setNumber(userDAO.getUserDOById(stateDO.getUserId()).getNumber());
                    list.add(studentStateVO);
                }
                // 添加到map中
                map.put(userId, list);
            }
            return new ResultDO<Map<Long, List<StudentStateVO>>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, map);
        } catch (Exception e) {
            return new ResultDO<Map<Long, List<StudentStateVO>>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION,
                ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    @PostMapping("check-knowledge")
    public ResultDO<Void> checkKnowledge(HttpSession httpSession) {
        long teacherId = SessionContentHolder.getSignInUserIdBySessionId(httpSession.getId());
        if (StringUtils.isBlank(httpSession.getId()) || teacherId <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        return faceFunctionService.checkKnowledgeByTeacherId(teacherId);
    }

}
