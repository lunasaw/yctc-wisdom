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

import edu.yctc.genesis.entity.PermissionGroupDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PermissionGroupDAOTest {

    private static final String name    = "123";
    private static final String newName = "1234";
    @Autowired
    private PermissionGroupDAO  permissionGroupDAO;

    @Test
    public void test1Insert() {
        PermissionGroupDO permissionGroupDO = new PermissionGroupDO();
        permissionGroupDO.setName(name);
        permissionGroupDAO.insert(permissionGroupDO);
    }

    @Test
    public void test2GetPermissionGroupDOById() {
        PermissionGroupDO permissionGroupDO = permissionGroupDAO.getPermissionGroupDOById(1L);
        assertEquals(1L, permissionGroupDO.getId());
        assertNotNull(permissionGroupDO.getCreateTime());
        assertNotNull(permissionGroupDO.getModifyTime());

    }

    @Test
    public void test3Update() {
        PermissionGroupDO permissionGroupDO = permissionGroupDAO.getPermissionGroupDOById(1L);
        assertEquals(1L, permissionGroupDO.getId());
        assertNotNull(permissionGroupDO.getCreateTime());
        assertNotNull(permissionGroupDO.getModifyTime());
        permissionGroupDO.setName(newName);
        permissionGroupDAO.update(permissionGroupDO);
    }

    @Test
    public void test4DeleteById() {
        permissionGroupDAO.deleteById(1);
    }

    @Test
    public void test5GetPermissionGroupIdByName() {
        long id = permissionGroupDAO.getPermissionGroupIdByName("permTeacher");
        assertEquals(1L, id);
    }
}
