package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.TeacherLessonDO;

@Mapper
public interface TeacherLessonDAO {

    /**
     * 插入教师课时信息
     * 
     * @param teacherLessonDO
     */
    public void insert(TeacherLessonDO teacherLessonDO);

    /**
     * id查询教师课时信息
     * 
     * @param id
     * @return
     */
    public TeacherLessonDO getTeacherLessonDOById(long id);

    /**
     * 更新教师课时信息
     * 
     * @param teacherLessonDO
     */
    public void update(TeacherLessonDO teacherLessonDO);

    /**
     * id删除教师课时信息
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * lessonId返回教师课时信息
     * 
     * @param lessonId
     * @return
     */
    public TeacherLessonDO getTeacherLessonDOByLessonId(long lessonId);

    /**
     * 通过userId获得lessonId集
     * 
     * @param userId
     */
    public List<Long> getLessonIdsByUserId(long userId);

    /**
     * 通过userId返回TeacherLessonDO
     * 
     * @param userId
     * @return
     */
    public List<TeacherLessonDO> getTeacherLessonDOByUserId(long userId);

    /**
     * 判断是否有userId对应的教师
     * 
     * @param userId
     * @return
     */
    public Long checkByTeacherId(long userId);

}
