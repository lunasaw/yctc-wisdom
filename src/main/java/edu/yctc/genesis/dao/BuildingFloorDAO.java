package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.BuildingFloorDO;

@Mapper
public interface BuildingFloorDAO {

    /**
     * 插入一条楼号楼层记录
     * 
     * @param buildingFloorDO
     */
    public void insert(BuildingFloorDO buildingFloorDO);

    /**
     * 根据id返回BuildingFloorDO
     * 
     * @param id
     * @return
     */
    public BuildingFloorDO getBuildingFloorDOById(long id);

    /**
     * 更新
     * 
     * @param buildingFloorDO
     */
    public void update(BuildingFloorDO buildingFloorDO);

    /**
     * 删除
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 根据楼号和楼层返回BuildingFloorDO
     * 
     * @param building
     * @param floor
     * @return
     */
    public BuildingFloorDO getBuildingFloorDOByBuildingAndFloor(String building, String floor);

    /**
     * 返回库中楼号集
     * 
     * @return
     */
    public List<String> getBuildings();

    /**
     * 返回某楼的所有楼层
     * 
     * @param building
     * @return
     */
    public List<String> getFloorsByBuilding(String building);

    /**
     * 通过楼号返回BuildingFloorDO
     * 
     * @param building
     * @return
     */
    public List<BuildingFloorDO> getBuildingFloorDOsByBuilding(String building);

}
