package edu.yctc.genesis.service;

import java.util.List;
import java.util.Map;

import edu.yctc.genesis.entity.AttendanceDO;
import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.EquipmentDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.entity.StudentStateDO;

/**
 * 算法业务层接口
 * 
 * @author 15272
 */
public interface FaceFunctionIService {

    /**
     * 老师上课考勤功能
     * 
     * @param teacherId
     * @return
     */
    ResultDO<List<AttendanceDO>> checkAttendanceByTeacherId(long teacherId);

    /**
     * 学生上课状态检测
     * 
     * @param teacherId
     * @return
     */
    ResultDO<Void> checkStateByTeacherId(long teacherId);

    /**
     * 返回检测状态
     * 
     * @param teacherId
     * @return
     */
    ResultDO<Map<Long, List<StudentStateDO>>> getStateByTeacherId(long teacherId);

    /**
     * 球机管理
     * 
     * @param command
     * @return
     */
    public ResultDO<Void> controlCamera(String command);

    /**
     * 知识点检测
     * 
     * @param teacherId
     * @return
     */
    public ResultDO<Void> checkKnowledgeByTeacherId(long teacherId);

    /**
     * 通过楼号返回楼号对应的所有楼层
     * 
     * @param building
     * @return
     */
    public ResultDO<List<String>> getFloorsByBuilding(String building);

    /**
     * 返回库中楼号集
     * 
     * @return
     */
    public ResultDO<List<String>> getBuildings();

    /**
     * 通过楼号和楼层号返回教室集
     * 
     * @param building
     * @param floor
     * @return
     */
    public ResultDO<List<ClassroomDO>> getClassroomDOByBuildingAndFloor(String building, String floor);

    /**
     * 通过教室号返回设备
     * 
     * @param number
     * @return
     */
    public ResultDO<List<EquipmentDO>> getEquipmentDOsByClassroomNumber(String number);

    /**
     * 通过设备号获取视频地址
     * 
     * @param number
     * @return
     */
    public ResultDO<String> getVideoByEquipmentNumber(String number);
}
