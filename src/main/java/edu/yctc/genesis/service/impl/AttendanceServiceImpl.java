package edu.yctc.genesis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.attendance.AttendState;
import edu.yctc.genesis.dao.AttendanceDAO;
import edu.yctc.genesis.entity.AttendanceDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.AttendanceIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Autowired
    private AttendanceDAO attendanceDAO;

    @Override
    public ResultDO<Void> insert(AttendanceDO attendanceDO) {
        // 0. 参数校验
        if (attendanceDO.getUserId() <= 0 || attendanceDO.getLessonId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (AttendState.isLegal(attendanceDO.getAttendState()) == false) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        try {
            attendanceDAO.insert(attendanceDO);
        } catch (Exception e) {
            LOG.error("insert AttendanceDO exception, attendanceDO=" + attendanceDO, e);
        }

        LOG.info("insert AttendanceDO success, attendanceDO={}", attendanceDO);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }
}
