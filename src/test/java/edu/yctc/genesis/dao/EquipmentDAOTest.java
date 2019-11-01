package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.EquipmentDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EquipmentDAOTest {

    private static final String number   = "123";
    private static final String name     = "123";
    private static final String video    = "123";
    private static final String newVideo = "123";
    @Autowired
    private EquipmentDAO        equipmentDAO;

    @Test
    public void test1Insert() {
        EquipmentDO equipmentDO = new EquipmentDO();
        equipmentDO.setName(name);
        equipmentDO.setNumber(number);
        equipmentDO.setVideo(video);
        equipmentDAO.insert(equipmentDO);
    }

    @Test
    public void test2GetEquipmentDOById() {
        EquipmentDO equipmentDO = equipmentDAO.getEquipmentDOById(5L);
        assertEquals(5L, equipmentDO.getId());
        assertNotNull(equipmentDO.getCreateTime());
        assertNotNull(equipmentDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        EquipmentDO equipmentDO = equipmentDAO.getEquipmentDOById(5L);
        assertEquals(5L, equipmentDO.getId());
        equipmentDO.setVideo(newVideo);
        equipmentDAO.update(equipmentDO);
    }

    @Test
    public void test4DeleteById() {
        equipmentDAO.deleteById(5);
    }
}
