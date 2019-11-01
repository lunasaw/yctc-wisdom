package edu.yctc.genesis.controller.rest;

import java.util.List;

import edu.yctc.genesis.entity.ClassroomDO;
import edu.yctc.genesis.entity.EquipmentDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.BuildingAndFloorVO;

public interface CameraRestController {

    /**
     * 球机管理
     * 
     * @param command
     * @return
     */
    public ResultDO<Void> controlCamera(String command);

    /**
     * 返回库中楼号集
     * 
     * @return
     */
    public ResultDO<List<String>> getBuildings();

    /**
     * 通过楼号返回楼号所有的楼层
     * 
     * @param building
     * @return
     */
    public ResultDO<List<String>> getFloorsByBuilding(String building);

    /**
     * 通过楼号和楼层号返回教室集
     * 
     * @param buildingAndFloorVO
     * @return
     */
    public ResultDO<List<ClassroomDO>> getClassroomDOByBuildingAndFloor(BuildingAndFloorVO buildingAndFloorVO);

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
