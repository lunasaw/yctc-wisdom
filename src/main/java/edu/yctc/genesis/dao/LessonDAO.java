package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.LessonDO;

@Mapper
public interface LessonDAO {

    /**
     * 插入一节课
     * 
     * @param lessonDO
     */
    public void insert(LessonDO lessonDO);

    /**
     * id查询课时
     * 
     * @param id
     * @return
     */
    public LessonDO getLessonDOById(long id);

    /**
     * 更新课时
     * 
     * @param lessonDO
     */
    public void update(LessonDO lessonDO);

    /**
     * id删除课时
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 返回库中课程集
     * 
     * @return
     */
    public List<LessonDO> getLessonDOs();

    /**
     * 通过courseId返回id集
     * 
     * @param courseId
     * @return
     */
    public List<Long> getIdsByCourseId(long courseId);

    /**
     * 通过id返回CourseId
     * 
     * @param id
     * @return
     */
    public Long getCourseIdById(long id);

    /**
     * 通过id返回ClassroomId
     * 
     * @param id
     * @return
     */
    public long getClassroomIdById(long id);

    /**
     * 通过courseId获取该用户课堂集
     * 
     * @param courseId
     * @return
     */
    public List<LessonDO> getLessonDOByCourseId(long courseId);

    /**
     * 判断是否存在教室id
     * 
     * @param classroomId
     * @return
     */
    public Long checkByclassroomId(long classroomId);

    /**
     * 验证是否存在课程id
     * 
     * @param courseId
     * @return
     */
    public Long checkByCourseId(long courseId);

    /**
     * 获取正在上的课
     * 
     * @param lessonId
     * @return
     */
    public LessonDO getCurrentLessonDOByLessonId(long lessonId);

}
