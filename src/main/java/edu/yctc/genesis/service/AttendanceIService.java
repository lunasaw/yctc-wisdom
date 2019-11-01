package edu.yctc.genesis.service;

import edu.yctc.genesis.entity.AttendanceDO;
import edu.yctc.genesis.entity.ResultDO;

public interface AttendanceIService {

    /**
     * 插入一条考勤信息
     *
     * @param attendanceDO
     */
    public ResultDO<Void> insert(AttendanceDO attendanceDO);
}
