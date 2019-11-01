package edu.yctc.genesis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.constant.ResultCode;
import edu.yctc.genesis.dao.ClassScoreDAO;
import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.service.ClassScoreIService;

@ComponentScan({"edu.yctc.genesis.dao"})
@Service("classScoreService")
public class ClassScoreServiceImpl implements ClassScoreIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLogger");

    @Autowired
    private ClassScoreDAO classScoreDAO;

    //插入一条课程评分情况
    @Override
    public ResultDO<Void> insert(ClassScoreDO classScoreDO) {
        // 0. 参数校验
        if (classScoreDO.getUserId() <= 0 || classScoreDO.getLessonId() <= 0 || classScoreDO.getScore() < 0) {
            return new ResultDO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }

        try {
            classScoreDAO.insert(classScoreDO);
        } catch (Exception e) {
            LOG.error("insert ClassScoreDO exception, classScoreDO=" + classScoreDO, e);
        }

        LOG.info("insert ClassScoreDO success, classScoreDO={}", classScoreDO);
        return new ResultDO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
    }
}
