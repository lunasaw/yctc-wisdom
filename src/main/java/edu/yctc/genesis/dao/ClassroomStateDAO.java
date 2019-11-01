package edu.yctc.genesis.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.ClassroomStateDO;

@Mapper
public interface ClassroomStateDAO {

    /**
     * 插入一条教室使用记录
     * 
     * @param classroomStateDO
     */
    public void insert(ClassroomStateDO classroomStateDO);

    /**
     * 教室id查询教室使用情况
     * 
     * @param id
     * @return
     */
    public ClassroomStateDO getClassroomStateDOById(long id);

    /**
     * 更新教室使用状态
     * 
     * @param classroomStateDO
     */
    public void update(ClassroomStateDO classroomStateDO);

    /**
     * id删除教室使用记录
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 判断是否存在教室id
     * 
     * @param classroomId
     * @return
     */
    public Long checkByclassroomId(long classroomId);
}
