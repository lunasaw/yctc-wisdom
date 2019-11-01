package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.StudentCourseDO;

@Mapper
public interface StudentCourseDAO {

    /**
     * 插入学生选课记录
     * 
     * @param studentCourseDO
     */
    public void insert(StudentCourseDO studentCourseDO);

    /**
     * 用户id查询该用户所有选课
     * 
     * @param id
     * @return
     */
    public StudentCourseDO getCourseDOById(long id);

    /**
     * 更新学生课程
     * 
     * @param studentCourseDO
     */
    public void update(StudentCourseDO studentCourseDO);

    /**
     * id删除学生课程
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过userId查询,获得courseId集
     * 
     * @param userId
     * @return
     */
    public List<Long> getCourseIdsByUserId(long userId);

    /**
     * 通过课程号返回StudentCourseDO集
     * 
     * @param courseId
     * @return
     */
    public List<StudentCourseDO> getStudentCourseDOByCourseId(long courseId);

    /**
     * 通过课程号返回userId集
     * 
     * @param courseId
     * @return
     */
    public List<Long> getUserIdsByCourseId(long courseId);

    /**
     * 验证是否存在课程id
     * 
     * @param courseId
     * @return
     */
    public Long checkByCourseId(long courseId);

    /**
     * 验证是否存在学生id
     * 
     * @param userId
     * @return
     */
    public Long checkByStudentId(long userId);

}
