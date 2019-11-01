package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.ClassScoreDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;

public interface ClassQualityIService {

    /**
     * 通过userId返回已上的课程集
     * 
     * @param id
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOList4StudentByUserId(long userId);

    /**
     * 通过id返回courseDO
     * 
     * @param id
     * @return
     */
    public ResultDO<CourseDO> getCourseDOById(long id);

    /**
     * 通过id返回classroomDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDO> getClassroomDOById(long id);

    /**
     * 通过userId和lessonId返回得分
     * 
     * @param userId
     * @param lessonId
     * @return
     */
    public ResultDO<ClassScoreDO> getClassScoreDOByUserIdAndLessonId(long userId, long lessonId);

    /**
     * 计算本堂课所有学生的课堂评分
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<Void> calculateScoresByLessonId(long lessonId);

}
