package edu.yctc.genesis.service;

import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ResultDO;

public interface ClassScoreIService {

    /**
     * 插入一条课堂评分信息
     *
     * @param attendanceDO
     */
    public ResultDO<Void> insert(ClassScoreDO classScoreDO);
}
