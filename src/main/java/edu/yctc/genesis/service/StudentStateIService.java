package edu.yctc.genesis.service;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;

public interface StudentStateIService {

    /**
     * 插入一条考勤信息
     *
     * @param attendanceDO
     */
    public ResultDO<Void> insert(StudentStateDO studentStateDO);
}
