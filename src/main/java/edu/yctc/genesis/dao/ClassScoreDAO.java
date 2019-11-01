package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.ClassScoreDO;

@Mapper
public interface ClassScoreDAO {

    /**
     * 插入一条课堂评分记录
     * 
     * @param classScoreDO
     */
    public void insert(ClassScoreDO classScoreDO);

    /**
     * id查询考勤情况
     * 
     * @param id
     * @return
     */
    public ClassScoreDO getClassScoreDOById(long id);

    /**
     * 更新课堂评分记录
     * 
     * @param classScoreDO
     */
    public void update(ClassScoreDO classScoreDO);

    /**
     * id删除课堂评分记录
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过lessonId和userId获得score
     * 
     * @param lessonId
     * @param userId
     */
    public Double getScoreByLessonIdAndUserId(long lessonId, long userId);

    /**
     * 通过lessonId和获得score集
     * 
     * @param lessonId
     */
    public List<Double> getScoresByLessonId(long lessonId);

    /**
     * 验证是否存在学生id
     * 
     * @param userId
     * @return
     */
    public Long checkByStudentId(long userId);

    /**
     * 通过userId和lessonId获得classScoreDO
     * 
     * @param userId
     * @param lessonId
     * @return
     */
    public ClassScoreDO getClassScoreDOByUserIdAndLessonId(long userId, long lessonId);

}
