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

import edu.yctc.genesis.entity.StudentCourseDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCourseDAOTest {

    private static final long userId      = 1L;
    private static final long courseId    = 2L;
    private static final long newCourseId = 2L;
    @Autowired
    private StudentCourseDAO  studentCourseDAO;

    @Test
    public void test1Insert() {
        StudentCourseDO studentCourseDO = new StudentCourseDO();
        studentCourseDO.setCourseId(courseId);
        studentCourseDO.setUserId(userId);
        studentCourseDAO.insert(studentCourseDO);
    }

    @Test
    public void test2GetCourseDOById() {
        StudentCourseDO studentCourseDO = studentCourseDAO.getCourseDOById(1L);
        assertEquals(1L, studentCourseDO.getId());
        assertEquals(courseId, studentCourseDO.getCourseId());
        assertNotNull(studentCourseDO.getCreateTime());
        assertNotNull(studentCourseDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        StudentCourseDO studentCourseDO = studentCourseDAO.getCourseDOById(1L);
        assertEquals(1L, studentCourseDO.getId());
        assertNotNull(studentCourseDO.getCreateTime());
        assertNotNull(studentCourseDO.getModifyTime());
        studentCourseDO.setCourseId(newCourseId);
        studentCourseDAO.update(studentCourseDO);
    }

    @Test
    public void test4DeleteById() {
        studentCourseDAO.deleteById(1L);
    }

    @Test
    public void test5GetCourseIdsByUserId() {
        List<Long> studentCourseDOList = studentCourseDAO.getCourseIdsByUserId(134L);
        assertNotNull(studentCourseDOList);
    }

    @Test
    public void test6GetStudentCourseDOByCourseId() {
        List<StudentCourseDO> list = studentCourseDAO.getStudentCourseDOByCourseId(courseId);
        assertNotNull(list);
    }

    @Test
    public void test7GetUserIdsByCourseId() {
        List<Long> list = studentCourseDAO.getUserIdsByCourseId(courseId);
        assertNotNull(list);
    }

    @Test
    public void test11CheckByCourseId() {
        Long courseId = studentCourseDAO.checkByCourseId(1L);
        assertNotNull(courseId);
        assertEquals(1L, courseId.longValue());
    }

    @Test
    public void test12CheckByStudentId() {
        Long studentId = studentCourseDAO.checkByStudentId(38L);
        assertNotNull(studentId);
        assertEquals(38L, studentId.longValue());
    }

}
