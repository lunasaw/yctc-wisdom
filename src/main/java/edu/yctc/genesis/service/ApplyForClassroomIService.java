package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.ApplyClassroomVO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;

public interface
ApplyForClassroomIService {

    /**
     * 返回库中学年集
     * 
     * @return
     */
    public ResultDO<List<String>> getYears();

    /**
     * 通过学年返回学期集
     * 
     * @param year
     * @return
     */
    public ResultDO<List<String>> getTermByYear(String year);

    /**
     * 通过学年和学期返回课程集
     * 
     * @param year
     * @param term
     * @return
     */
    public ResultDO<List<String>> getCourseByYearAndTerm(String year, int term);

    /**
     * 用过学年、学期和课程返回课程集
     *
     * @param year
     * @param term
     * @param courseName
     * @return
     */
    public ResultDO<CourseDO> getCourseDOByYearAndTermAndCourse(String year, int term, String courseName);

    /**
     * 通过课程时间返回空闲教室及其楼号层号VO
     * 
     * @param lessonTime
     * @return
     */
    public ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>
        getFreeClassroomDOAndBuildingAndFloorVOByLessonTime(String lessonTime);

    /**
     * 申请教室
     * 
     * @param applyClassroomVO
     * @return
     */
    public ResultDO<Void> applyClassroom(ApplyClassroomVO applyClassroomVO);

}
