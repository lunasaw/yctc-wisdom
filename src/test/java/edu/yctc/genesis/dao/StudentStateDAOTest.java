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

import edu.yctc.genesis.entity.StudentStateDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentStateDAOTest {

    private static final long   userId       = 38L;
    private static final long   lessonId     = 1L;
    private static final int    state        = 2;
    private static final String faceToken    = "123sad";
    private static final String newFaceToken = "1234";

    @Autowired
    private StudentStateDAO     studentStateDAO;

    @Test
    public void test1Insert() {
        StudentStateDO studentStateDO = new StudentStateDO();
        studentStateDO.setUserId(userId);
        studentStateDO.setLessonId(lessonId);
        studentStateDO.setState(state);
        studentStateDO.setFaceToken(faceToken);
        studentStateDAO.insert(studentStateDO);
    }

    @Test
    public void test2GetStudentStateDOById() {
        StudentStateDO studentStateDO = studentStateDAO.getStudentStateDOById(2L);
        assertEquals(2L, studentStateDO.getId());
        assertEquals(lessonId, studentStateDO.getLessonId());
        assertEquals(state, studentStateDO.getState());
        assertNotNull(studentStateDO.getCreateTime());
        assertNotNull(studentStateDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        StudentStateDO studentStateDO = studentStateDAO.getStudentStateDOById(2L);
        assertEquals(2L, studentStateDO.getId());
        studentStateDO.setFaceToken(newFaceToken);
        studentStateDAO.update(studentStateDO);
    }

    @Test
    public void test4DeleteById() {
        studentStateDAO.deleteById(2L);
    }

    @Test
    public void test5UpdateScanEndTimeById() {
        studentStateDAO.updateScanEndTimeById(34L);
    }

    @Test
    public void test6GetStudentStateDOByUserIdAndLessonId() {
        List<StudentStateDO> list = studentStateDAO.getStudentStateDOByUserIdAndLessonId(userId, lessonId);
        assertNotNull(list);
    }

    @Test
    public void test7GetUserIdsByLessonId() {
        List<Long> list = studentStateDAO.getUserIdsByLessonId(118L);
        assertNotNull(list);
    }
}
