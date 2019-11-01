package edu.yctc.genesis.controller.rest;

import java.text.ParseException;
import java.util.List;

import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.ApplyClassroomVO;
import edu.yctc.genesis.vo.ClassroomDOAndBuildingAndFloorVO;
import edu.yctc.genesis.vo.YearAndTermAndCourseVO;
import edu.yctc.genesis.vo.YearAndTermVO;

public interface ApplyForClassroomRestController {

    /**
     * 返回库中学年集
     * 
     * @return
     */
    public ResultDO<List<String>> getYears();

    /**
     * 通过学年返回学期
     * 
     * @param year
     * @return
     */
    public ResultDO<List<String>> getTermByYear(String year);

    /**
     * 通过学年和学期返回课程
     * 
     * @param yearAndTermVO
     * @return
     */
    public ResultDO<List<String>> getCourseByYearAndTermVO(YearAndTermVO yearAndTermVO);

    /**
     * 通过学年、学期和课程返回课程集
     * 
     * @param yearAndTermAndCourseVO
     * @return
     */
    public ResultDO<CourseDO> getCourseDOByYearAndTermAndCourseVO(YearAndTermAndCourseVO yearAndTermAndCourseVO);

    /**
     * 通过上课时间返回空闲教室集
     * 
     * @param lessonTime
     * @return
     */
    public ResultDO<List<ClassroomDOAndBuildingAndFloorVO>>
        getClassroomDOAndBuildingAndFloorVOByLessonTime(String lessonTime);

    /**
     * applyClassroom的rest方法
     *
     * @param userDO
     * @return
     * @throws ParseException
     */
    ResultDO<Void> applyClassroom(ApplyClassroomVO applyClassroomVO);
}
