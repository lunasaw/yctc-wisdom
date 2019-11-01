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

import edu.yctc.genesis.entity.UserDO;
import edu.yctc.genesis.util.SHA256Util;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {

    private static final String number       = "17263829";
    private static final String password     = "222222";
    private static final String name         = "tony";
    private static final int    type         = 1;
    private static final String sex          = "男";
    private static final String idCardNumber = "lsakdlaskd";
    private static final String phone        = "1195656";
    private static final String mail         = "6565sd65";
    private static final String picture      = "123as98d9a8";
    private static final String faceToken    = "321s9a8d9";
    private static final String newPassword  = "123";
    private static final long   academyId    = 2L;
    private static final long   classId      = 2L;
    @Autowired
    private UserDAO             userDAO;

    @Test
    public void test1Insert() {
        UserDO userDO = new UserDO();
        userDO.setName(name);
        userDO.setPassword(SHA256Util.SHA256(password));
        userDO.setIdCardNumber(idCardNumber);
        userDO.setMail(mail);
        userDO.setNumber(number);
        userDO.setPhone(phone);
        userDO.setSex(sex);
        userDO.setType(type);
        userDO.setFaceToken(faceToken);
        userDO.setPicture(picture);
        userDO.setAcademyId(academyId);
        userDO.setClassId(classId);
        userDAO.insert(userDO);
    }

    @Test
    public void test2GetUserDOById() {
        UserDO userDO = userDAO.getUserDOById(47L);
        assertEquals(47L, userDO.getId());
        assertEquals(name, userDO.getName());
        assertEquals(password, userDO.getPassword());
        assertNotNull(userDO.getCreateTime());
        assertNotNull(userDO.getModifyTime());
    }

    @Test
    public void test3GetUserDOByNumberAndPassword() {

        UserDO userDO = userDAO.getUserDOByNumberAndPassword(number, SHA256Util.SHA256(password));
        assertEquals(50L, userDO.getId());
        assertEquals(number, userDO.getNumber());
        assertEquals(SHA256Util.SHA256(password), userDO.getPassword());
        assertNotNull(userDO.getCreateTime());
        assertNotNull(userDO.getModifyTime());
    }

    @Test
    public void test4Update() {
        UserDO userDO = userDAO.getUserDOById(50L);
        assertEquals(50L, userDO.getId());
        assertNotNull(userDO.getCreateTime());
        assertNotNull(userDO.getModifyTime());
        userDO.setPassword(SHA256Util.SHA256(newPassword));
        userDAO.update(userDO);
    }

    @Test
    public void test5DeleteById() {
        userDAO.deleteById(50L);
    }

    @Test
    public void test6GetUserDOByNumber() {
        UserDO userDO = userDAO.getUserDOByNumber(number);
        assertEquals(number, userDO.getNumber());
        assertNotNull(userDO.getCreateTime());
        assertNotNull(userDO.getModifyTime());
    }

    @Test
    public void test7GetUserDOByMail() {
        UserDO userDO = userDAO.getUserDOByMail(mail);
        assertEquals("520", userDO.getNumber());
    }

    @Test
    public void test8GetUserDOByFaceToken() {
        UserDO userDO = userDAO.getUserDOByFaceToken("sa65d6as53ds2a32");
        assertEquals("sa65d6as53ds2a32", userDO.getFaceToken());
    }

    @Test
    public void test9GetUserDOByPhone() {
        UserDO userDO = userDAO.getUserDOByPhone("17715939829");
        assertEquals("17715939829", userDO.getPhone());
    }

    @Test
    public void test10GetClassIdsByAcademyId() {
        List<Long> list = userDAO.getClassIdsByAcademyId(academyId);
        assertNotNull(list);
    }

    @Test
    public void test11GetStudentDOByAcademyIdAndClassId() {
        List<UserDO> list = userDAO.getStudentDOByAcademyIdAndClassId(academyId, classId);
        assertNotNull(list);
    }

    @Test
    public void test12GetClasses() {
        List<Long> list = userDAO.getClasses();
        assertNotNull(list);
    }

    @Test
    public void test13GetTeacherDOByAcademyId() {
        List<UserDO> userDOList = userDAO.getTeacherDOByAcademyId(academyId);
        assertNotNull(userDOList);
    }

    @Test
    public void test14GetAcademies() {
        List<Long> list = userDAO.getAcademies();
        assertNotNull(list);
    }

    @Test
    public void test15GetIdByName() {
        long userId = userDAO.getIdByNumber("2");
        assertEquals(134L, userId);
    }

    @Test
    public void test16GetAcademyIdByUserDO() {
        UserDO userDO = userDAO.getUserDOById(38L);
        long academyId = userDAO.getAcademyIdByUserDO(userDO);
        assertEquals(2L, academyId);
    }

    @Test
    public void test17CheckByClassId() {
        Long classIdCheck = userDAO.checkByClassId(classId);
        assertNotNull(classIdCheck);
        assertEquals(classId, classIdCheck.longValue());
    }

}
