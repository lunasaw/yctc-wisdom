package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.BuildingFloorDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BuildingFloorDOTest {

    private static final String building = "主楼";
    private static final String floor    = "一楼";
    private static final String newFloor = "二楼";

    @Autowired
    BuildingFloorDAO            buildingFloorDAO;

    @Test
    public void test1Insert() {
        BuildingFloorDO buildingFloorDO = new BuildingFloorDO();
        buildingFloorDO.setBuilding(building);
        buildingFloorDO.setFloor(floor);
        buildingFloorDAO.insert(buildingFloorDO);
    }

    @Test
    public void test2GetBuildingFloorDOById() {
        BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(1L);
        assertEquals(1L, buildingFloorDO.getId());
        assertEquals(building, buildingFloorDO.getBuilding());
        assertEquals(floor, buildingFloorDO.getFloor());
    }

    @Test
    public void test3Update() {
        BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOById(1L);
        assertEquals(1L, buildingFloorDO.getId());
        assertEquals(building, buildingFloorDO.getBuilding());
        assertEquals(floor, buildingFloorDO.getFloor());
        buildingFloorDO.setFloor(newFloor);
        buildingFloorDAO.update(buildingFloorDO);
    }

    @Test
    public void test4Delete() {
        buildingFloorDAO.deleteById(1L);
    }

    @Test
    public void test5GetBuildingFloorDOByBuildingAndFloor() {
        BuildingFloorDO buildingFloorDO = buildingFloorDAO.getBuildingFloorDOByBuildingAndFloor(building, floor);
        assertNotNull(buildingFloorDO);
    }

    @Test
    public void test6GetBuildings() {
        List<String> list = buildingFloorDAO.getBuildings();
        assertNotNull(list);
    }

    @Test
    public void test7GetFloorsBuilding() {
        List<String> list = buildingFloorDAO.getFloorsByBuilding(building);
        assertNotNull(list);
    }

    @Test
    public void test8GetBuildingFloorDOsByBuilding() {
        List<BuildingFloorDO> list = buildingFloorDAO.getBuildingFloorDOsByBuilding(building);
        assertNotNull(list);
    }
}
