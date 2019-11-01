package edu.yctc.genesis.controller.rest;

import java.util.List;

import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.AcademyAndClassesVO;
import edu.yctc.genesis.vo.CourseAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.CourseDOAndUrlVO;
import edu.yctc.genesis.vo.LessonDOAndUrlVO;
import edu.yctc.genesis.vo.LessonDetailsVO;
import edu.yctc.genesis.vo.ModifyAttendanceStateVO;
import edu.yctc.genesis.vo.StudentAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.StudentAndAttendanceStateAndScoreVO;
import edu.yctc.genesis.vo.StudentDOAndUrlVO;
import edu.yctc.genesis.vo.UserIdAndYearAndTermVO;

public interface DetailsRestController {

    /**
     * 通过userId(学生)和学年和学期获得课程集
     * 
     * @param userIdAndYearAndTermVO
     * @return
     */
    public ResultDO<List<CourseDOAndUrlVO>>
        getCourseDOByYearAndTermAndUserId(UserIdAndYearAndTermVO userIdAndYearAndTermVO);

    /**
     * 通过teacherId获得课程集
     * 
     * @param teacherId
     * @return
     */
    public ResultDO<List<String>> getCourseDOByTeacherId(long teacherId);

    /**
     * 通过courseName获得lessondo集
     * 
     * @param courseName
     * @return
     */
    public ResultDO<List<LessonDOAndUrlVO>> getLessonDOByCourseName(String courseName);

    /**
     * 通过学院和班级返回学生
     * 
     * @param academyAndClassesVO
     * @return
     */
    public ResultDO<List<StudentDOAndUrlVO>> getStudentDOByAcademyAndClassesVO(AcademyAndClassesVO academyAndClassesVO);

    /**
     * 通过studentId获得该堂课的CourseAndAttendanceRateAndScoreDO集
     * 
     * @param studentId
     * @return
     */
    public ResultDO<List<CourseAndAttendanceRateAndScoreVO>>
        getCourseAndAttendanceRateAndScoreVOByStudentId(long studentId);

    /**
     * 通过courseId获得该门课的CourseAndAttendanceRateAndScoreDO
     * 
     * @param courseId
     * @return
     */
    public ResultDO<CourseAndAttendanceRateAndScoreVO> getCourseAndAttendanceRateAndScoreVOByCourseId(long courseId);

    /**
     * 通过courseId获得该门课的每个学生的StudentAndAttendanceRateAndScoreVO集
     * 
     * @param courseId
     * @return
     */
    public ResultDO<List<StudentAndAttendanceRateAndScoreVO>> getEveryStudentAttendanceDetailByCourseId(long courseId);

    /**
     * 通过lessonId获得该堂课的LessonDetailsVO
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<LessonDetailsVO> getLessonDetailsVOByLessonId(long lessonId);

    /**
     * 通过lessonId获得该堂课的每个学生的LessonDetailsVO集
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<StudentAndAttendanceStateAndScoreVO>> getEveryStudentAttendanceDetailByLessonId(long lessonId);

    /**
     * 修改学生出勤状态并返回修改后的状态
     * 
     * @param modifyAttendanceStateVO
     * @return
     */
    public ResultDO<String> modifyAttendanceState(ModifyAttendanceStateVO modifyAttendanceStateVO);

}
