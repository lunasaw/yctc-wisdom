package edu.yctc.genesis.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.constant.entity.studentstate.StudentState;
import edu.yctc.genesis.dao.StudentStateDAO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;
import edu.yctc.genesis.service.StudentStateIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("studentStateService")
public class StudentStateServiceImpl implements StudentStateIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Autowired
    private StudentStateDAO studentStateDAO;

    //插入一条学生状态
    @Override
    public ResultDO<Void> insert(StudentStateDO studentStateDO) {
        // 0. 参数校验
        if (studentStateDO.getUserId() <= 0 || studentStateDO.getLessonId() <= 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (StudentState.isLegal(studentStateDO.getState()) == false) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (studentStateDO.getScanStartTime() != null) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
        if (StringUtils.isEmpty(studentStateDO.getFaceToken())) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        try {
            StudentStateDO studentStateDOCheck = studentStateDAO.getStudentStateDOById(studentStateDO.getId());
            if (studentStateDOCheck == null)
                studentStateDAO.insert(studentStateDO);
            else
                studentStateDAO.update(studentStateDO);
        } catch (Exception e) {
            LOG.error("insert StudentStateDO exception, studentStateDO=" + studentStateDO, e);
        }

        LOG.info("insert StudentStateDO success, studentStateDO={}", studentStateDO);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }
}
