package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.ClassroomDO;

@Mapper
public interface ClassroomDAO {

    /**
     * 插入教室
     * 
     * @param classroomDO
     */
    public void insert(ClassroomDO classroomDO);

    /**
     * id查询教室
     * 
     * @param id
     * @return
     */
    public ClassroomDO getClassroomDOById(long id);

    /**
     * 更新教室信息
     * 
     * @param classroomDO
     */
    public void update(ClassroomDO classroomDO);

    /**
     * id删除教室
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 返回库中教室Id集
     * 
     * @return
     */
    public List<Long> getClassroomId();

    /**
     * 通过buildingFloorId返回教室集
     * 
     * @param buildingFloorId
     * @return
     */
    public List<ClassroomDO> getClassroomDOByBuildingFloorId(long buildingFloorId);

    /**
     * 判断是否存在buildingFloorId
     * 
     * @param buildingFloorId
     * @return
     */
    public Long checkByBuildingFloorId(long buildingFloorId);

    /**
     * 返回教室数
     * 
     * @return
     */
    public int SummaryClassroom();

    /**
     * 通过教室number返回设备id
     * 
     * @param number
     * @return
     */
    public String getEquipmentIdsByClassroomNumber(String number);
}
