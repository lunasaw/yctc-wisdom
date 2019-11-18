package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.AttendanceDO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttendanceDAO {

    /**
     * 插入一条考勤信息
     * 
     * @param attendanceDO
     */
    public void insert(AttendanceDO attendanceDO);

    /**
     * id查询考勤情况
     * 
     * @param id
     * @return
     */
    public AttendanceDO getAttendanceDOById(long id);

    /**
     * 更新考勤信息
     * 
     * @param attendanceDO
     */
    public void update(AttendanceDO attendanceDO);

    /**
     * id删除考勤信息
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过lessonId获得所有id
     * 
     * @param lessonId
     * @param attendState
     */
    public List<Long> getIdsByLessonId(long lessonId);

    /**
     * 通过lessonId和userId获得attendState
     * 
     * @param lessonId
     * @param userId
     */
    public Integer getAttendStateByLessonIdAndUserId(@Param("lessonId") long lessonId,@Param("userId") long userId);

    /**
     * 通过lessonId获得所有attendState集
     * 
     * @param lessonId
     */
    public List<Integer> getAttendStatesByLessonId(long lessonId);

    /**
     * 通过lessonId和userId和attendState获得满足传入参数条件的记录总数量
     * 
     * @param lessonId
     * @param userId
     * @param attendState
     */
    public int getSumByLessonIdAndUserIdAndAttendState(@Param("lessonId") long lessonId,@Param("userId") long userId,@Param("attendState") int attendState);

    /**
     * 通过lessonId和userId获得满足传入参数条件的记录总数量
     * 
     * @param lessonId
     * @param userId
     */
    public int getSumByLessonIdAndUserId(long lessonId, long userId);

    /**
     * 验证是否存在学生id
     * 
     * @param userId
     * @return
     */
    public Long checkByStudentId(long userId);

    /**
     * 通过userId和lessonId获得对应记录并修改考勤状态
     * 
     * @param userId
     * @param lessonId
     * @param attendState
     */
    public void updateAttendStateByUserIdAndLessonId(long userId, long lessonId, int attendState);

    /**
     * 通过lessonId返回考勤情况集
     * 
     * @param lessonId
     * @return
     */
    public List<AttendanceDO> getAttendanceDOsByLessonId(long lessonId);
}
