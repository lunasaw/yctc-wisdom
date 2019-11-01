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

import edu.yctc.genesis.entity.ClassroomDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassroomDAOTest {

    private static final String number = "1234";
    private static final long buildingFloorId = 1L;
    public static final String equipmentId = "[2]";
    public static final long newEquipmentId = 2L;
    @Autowired
    private ClassroomDAO classroomDAO;

    @Test
    public void test1Insert() {
        ClassroomDO classroomDO = new ClassroomDO();
        classroomDO.setNumber(number);
        classroomDO.setEquipmentId(equipmentId);
        classroomDO.setBuildingFloorId(buildingFloorId);
        classroomDAO.insert(classroomDO);
    }

    @Test
    public void test2GetClassroomDOById() {
        ClassroomDO classroomDO = classroomDAO.getClassroomDOById(11L);
        assertEquals(11L, classroomDO.getId());
        assertNotNull(classroomDO.getCreateTime());
        assertNotNull(classroomDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        ClassroomDO classroomDO = classroomDAO.getClassroomDOById(11L);
        assertEquals(11L, classroomDO.getId());
        assertNotNull(classroomDO.getCreateTime());
        assertNotNull(classroomDO.getModifyTime());
        classroomDO.setEquipmentId("[3]");
        classroomDAO.update(classroomDO);
    }

    @Test
    public void test4DeleteById() {
        classroomDAO.deleteById(11L);
    }

    @Test
    public void test5GetClassroomId() {
        List<Long> list = classroomDAO.getClassroomId();
        assertNotNull(list);
    }

    @Test
    public void test6GetClassroomDOByBuildingFloorId() {
        List<ClassroomDO> list = classroomDAO.getClassroomDOByBuildingFloorId(buildingFloorId);
        assertNotNull(list);
    }

    @Test
    public void test7CheckByBuildingFloorId() {
        Long buildingFloorId = classroomDAO.checkByBuildingFloorId(1L);
        assertNotNull(buildingFloorId);
        assertEquals(1L, buildingFloorId.longValue());
    }

    @Test
    public void test8SummaryClassroom() {
        int sum = classroomDAO.SummaryClassroom();
        assertEquals(sum, 10);
    }
}
