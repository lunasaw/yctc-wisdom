package edu.yctc.genesis.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.TeachingScheduleVO;
import edu.yctc.genesis.vo.TimetableVO;

public interface TimetableRestController {

    /**
     * 通过用户Id返回课程安排
     *
     * @param httpSession
     * @return
     */
    public ResultDO<List<TimetableVO>> getTimetable4Student(HttpSession httpSession);

    /**
     * 通过用户id返回教师课表
     *
     * @param httpSession
     * @return
     */
    public ResultDO<List<TeachingScheduleVO>> getTimetable4Teacher(HttpSession httpSession);
}
