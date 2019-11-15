package edu.yctc.genesis.service;

import java.util.Map;

public interface StatisticalIService {

    /**
     * 获得教室占用状况
     * 
     * @return
     */
    Map<String, Integer> getClassroomUsingState();

    public void  insert();

}
