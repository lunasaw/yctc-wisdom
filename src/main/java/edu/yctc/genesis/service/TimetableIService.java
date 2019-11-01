package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.ResultDO;

public interface TimetableIService {

    /**
     * 通过userId返回课程安排
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOListByUserId4Student(long userId);

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
     * 通过lessonId返回授课教师姓名
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<String> getTeacherNameByLessonId(long lessonId);

    /**
     * 通过教师id返回课时安排
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOListByUserId4Teacher(long userId);

    /**
     * 通过id返回classDO
     * 
     * @param classId
     * @return
     */
    public ResultDO<ClassDO> getClassDOById(long classId);
}
