package edu.yctc.genesis.controller.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.AttendanceVO;
import edu.yctc.genesis.vo.StudentStateVO;

public interface FaceFunctionRestController {

    /**
     * 上课考勤
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<List<AttendanceVO>> checkAttendance(HttpSession httpSession);

    /**
     * 学生状态检测
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<Void> checkState(HttpSession httpSession);

    /**
     * 返回学生检测状态
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<Map<Long, List<StudentStateVO>>> getStudentState(HttpSession httpSession);

    /**
     * 知识点状态检测
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<Void> checkKnowledge(HttpSession httpSession);
}
