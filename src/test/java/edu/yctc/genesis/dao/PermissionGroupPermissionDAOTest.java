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

import edu.yctc.genesis.entity.PermissionGroupPermissionDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionGroupPermissionDAOTest {

    private static final long            permissionGroupId = 1;
    private static final long            permissionId      = 1;
    private static final long            newPermissionId   = 2;
    @Autowired
    private PermissionGroupPermissionDAO permissionGroupPermissionDAO;

    @Test
    public void test1Insert() {
        PermissionGroupPermissionDO permissionGroupPermissionDO = new PermissionGroupPermissionDO();
        permissionGroupPermissionDO.setPermissionGroupId(permissionGroupId);
        permissionGroupPermissionDO.setPermissionId(permissionId);
        permissionGroupPermissionDAO.insert(permissionGroupPermissionDO);
    }

    @Test
    public void test2GetPermissionGroupPermissionDOById() {
        PermissionGroupPermissionDO permissionGroupPermissionDO = permissionGroupPermissionDAO.getPermissionGroupPermissionDOById(1L);
        assertEquals(1L, permissionGroupPermissionDO.getId());
        assertNotNull(permissionGroupPermissionDO.getCreateTime());
        assertNotNull(permissionGroupPermissionDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        PermissionGroupPermissionDO permissionGroupPermissionDO = permissionGroupPermissionDAO.getPermissionGroupPermissionDOById(1L);
        assertEquals(1L, permissionGroupPermissionDO.getId());
        assertNotNull(permissionGroupPermissionDO.getCreateTime());
        assertNotNull(permissionGroupPermissionDO.getModifyTime());
        permissionGroupPermissionDO.setPermissionId(newPermissionId);
        permissionGroupPermissionDAO.update(permissionGroupPermissionDO);
    }

    @Test
    public void test4DeleteById() {
        permissionGroupPermissionDAO.deleteById(1);
    }

    @Test
    public void test5GetPermissionIdByPermissionGroupId() {
        List<Long> list = permissionGroupPermissionDAO.getPermissionIdByPermissionGroupId(1L);
        assertNotNull(list);
    }
}
