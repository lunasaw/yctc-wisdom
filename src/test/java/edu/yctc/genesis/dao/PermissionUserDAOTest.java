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

import edu.yctc.genesis.entity.PermissionUserDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PermissionUserDAOTest {

    private static final long userId          = 1;
    private static final long permissionId    = 1;
    private static final long newPermissionId = 2;
    @Autowired
    private PermissionUserDAO permissionUserDAO;

    @Test
    public void test1Insert() {
        PermissionUserDO permissionUserDO = new PermissionUserDO();
        permissionUserDO.setUserId(userId);
        permissionUserDO.setPermissionId(permissionId);
        permissionUserDAO.insert(permissionUserDO);
    }

    @Test
    public void test2GetPermissionUserDOById() {
        PermissionUserDO permissionUserDO = permissionUserDAO.getPermissionUserDOById(1L);
        assertEquals(1L, permissionUserDO.getId());
        assertNotNull(permissionUserDO.getCreateTime());
        assertNotNull(permissionUserDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        PermissionUserDO permissionUserDO = permissionUserDAO.getPermissionUserDOById(1L);
        assertEquals(1L, permissionUserDO.getId());
        assertNotNull(permissionUserDO.getCreateTime());
        assertNotNull(permissionUserDO.getModifyTime());
        permissionUserDO.setPermissionId(newPermissionId);
        permissionUserDAO.update(permissionUserDO);
    }

    @Test
    public void test4DeleteById() {
        permissionUserDAO.deleteById(1L);
    }

    @Test
    public void test5GetPermissionIdByUserId() {
        List<Long> PermissionList = permissionUserDAO.getPermissionIdByUserId(userId);
        assertNotNull(PermissionList);
    }

    @Test
    public void test6PermissionUserDOIdByBothId() {
        PermissionUserDO permissionUserDO = permissionUserDAO.getPermissionUserDOIdByBothId(134L, 6L);
        assertNotNull(permissionUserDO);
    }
}
