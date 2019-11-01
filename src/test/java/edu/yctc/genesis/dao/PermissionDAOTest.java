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

import edu.yctc.genesis.entity.PermissionDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PermissionDAOTest {

    private static final String name     = "123";
    private static final String newName  = "312";
    private static final String resource = "33";
    @Autowired
    private PermissionDAO       permissionDAO;

    @Test
    public void test1Insert() {
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setName(name);
        permissionDO.setResource(resource);
        permissionDAO.insert(permissionDO);
    }

    @Test
    public void test2GetPermissionDOById() {
        PermissionDO permissionDO = permissionDAO.getPermissionDOById(1L);
        assertEquals(1L, permissionDO.getId());
        assertNotNull(permissionDO.getCreateTime());
        assertNotNull(permissionDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        PermissionDO permissionDO = permissionDAO.getPermissionDOById(1L);
        assertEquals(1L, permissionDO.getId());
        assertNotNull(permissionDO.getCreateTime());
        assertNotNull(permissionDO.getModifyTime());
        permissionDO.setName(newName);
        permissionDAO.update(permissionDO);
    }

    @Test
    public void test4DeleteById() {
        permissionDAO.deleteById(1);
    }

    @Test
    public void test5ShowAllPermissions() {
        List<PermissionDO> permissionDOList = permissionDAO.showAllPermissions();
        assertNotNull(permissionDOList);
    }

}
