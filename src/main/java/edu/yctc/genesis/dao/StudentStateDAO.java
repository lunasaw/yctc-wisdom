package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.StudentStateDO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentStateDAO {

    /**
     * 插入学生上课状态信息
     * 
     * @param studentStateDO
     */
    public void insert(StudentStateDO studentStateDO);

    /**
     * id查询上课状态信息
     * 
     * @param id
     * @return
     */
    public StudentStateDO getStudentStateDOById(long id);

    /**
     * 更新学生上课状态
     * 
     * @param studentStateDO
     */
    public void update(StudentStateDO studentStateDO);

    /**
     * id删除学生上课状态信息
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过id更新扫描结束时间
     * 
     * @param id
     */
    public void updateScanEndTimeById(long id);

    /**
     * 通过userId和lessonId返回StudentStateDO集
     * 
     * @param userId
     * @param lessonId
     * @return
     */
    public List<StudentStateDO> getStudentStateDOByUserIdAndLessonId(@Param("userId") long userId,@Param("lessonId") long lessonId);

    /**
     * 获取被检测的学生的userId
     * 
     * @param lesssonId
     * @return
     */
    public List<Long> getUserIdsByLessonId(long lesssonId);
}
