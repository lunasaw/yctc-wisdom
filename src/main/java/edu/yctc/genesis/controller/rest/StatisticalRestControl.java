package edu.yctc.genesis.controller.rest;

import java.util.Map;

public interface StatisticalRestControl {

    /**
     * 获得教室占用状况
     * 
     * @return
     */
    public Map<String, Integer> getClassroomUsingState();
}
