package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.vo.CourseAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.LessonDetailsVO;
import edu.yctc.genesis.vo.StudentAndAttendanceRateAndScoreVO;
import edu.yctc.genesis.vo.StudentAndAttendanceStateAndScoreVO;

public interface DetailsIService {

    /**
     * 通过userId和学年和学期获得课程
     * 
     * @param userId
     * @param year
     * @param term
     * @return
     */
    public ResultDO<List<CourseDO>> getCourseDOByUserIdAndYearAndTerm(long userId, String year, int term);

    /**
     * 通过teacherId获得课程集
     * 
     * @param teacherId
     * @return
     */
    public ResultDO<List<String>> getCoursesByTeacherId(long teacherId);

    /**
     * 通过courseName获得lessonDO集
     * 
     * @param courseName
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOByCourseName(String courseName);

    /**
     * 通过lessonId返回classroomDO
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<ClassroomDO> getClassroomDOByLessonId(long lessonId);

    /**
     * 通过学院和班级返回学生集
     * 
     * @param academy
     * @param classes
     * @return
     */
    public ResultDO<List<UserDO>> getStudentDOByAcademyAndClasses(String academy, String classes);

    /**
     * 通过studentId返回CourseAndAttendanceRateAndScoreDO
     * 
     * @param studentId
     * @return
     */
    public ResultDO<List<CourseAndAttendanceRateAndScoreVO>>
        getCourseAndAttendanceRateAndScoreVOByStudentId(long studentId);

    /**
     * 通过courseId获得参加本堂课的CourseAndAttendanceRateAndScoreVO
     * 
     * @param courseId
     * @return
     */
    public ResultDO<CourseAndAttendanceRateAndScoreVO> getCourseAndAttendanceRateAndScoreVOByCourseId(long courseId);

    /**
     * 通过studentId返回StudentAndAttendanceRateAndScoreVO集
     * 
     * @param studentId
     * @return
     */
    public ResultDO<List<StudentAndAttendanceRateAndScoreVO>>
        getStudentAndAttendanceRateAndScoreVOByCourseId(long courseId);

    /**
     * 通过lessonId获得参加本堂课的LessonDetailsVO
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<LessonDetailsVO> getLessonDetailsVOByLessonId(long lessonId);

    /**
     * 通过lessonId返回LessonDetailsVO集
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<StudentAndAttendanceStateAndScoreVO>> getEveryStudentAttendanceDetailByLessonId(long lessonId);

    /**
     * 修改学生出勤状态并返回修改后的状态
     * 
     * @param userId
     * @param lessonId
     * @param attendState
     * @return
     */
    public ResultDO<String> modifyAttendanceState(long userId, long lessonId, String attendState);

}
