package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.LessonDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LessonDAOTest {

    private static final long courseId    = 1L;
    private static final int  number      = 1;
    private static final long classroomId = 2L;
    private static final Date begin       = new Date();
    private static final Date end         = new Date();
    private static final Date newEnd      = new Date();

    @Autowired
    private LessonDAO         lessonDAO;

    @Test
    public void test1Insert() {
        LessonDO lessonDO = new LessonDO();
        lessonDO.setCourseId(courseId);
        lessonDO.setNumber(number);
        lessonDO.setClassroomId(classroomId);
        lessonDO.setBegin(begin);
        lessonDO.setEnd(end);
        lessonDAO.insert(lessonDO);
    }

    @Test
    public void test2GetLessonDOById() {
        LessonDO lessonDO = lessonDAO.getLessonDOById(1L);
        assertEquals(1L, lessonDO.getId());
        assertNotNull(lessonDO.getCreateTime());
        assertNotNull(lessonDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        LessonDO lessonDO = lessonDAO.getLessonDOById(1L);
        assertEquals(1L, lessonDO.getId());
        lessonDO.setEnd(newEnd);
        lessonDAO.update(lessonDO);
    }

    @Test
    public void test4DeleteById() {
        lessonDAO.deleteById(1);
    }

    @Test
    public void test5GetLessonDOs() {
        List<LessonDO> list = lessonDAO.getLessonDOs();
        assertNotNull(list);
    }

    @Test
    public void test6GetIdsByCourseId() {
        List<Long> list = lessonDAO.getIdsByCourseId(courseId);
        assertNotNull(list);
    }

    @Test
    public void test7GetCourseIdById() {
        long courseId = lessonDAO.getCourseIdById(1L);
        assertEquals(courseId, 1L);
    }

    @Test
    public void test8GetClassroomIdById() {
        long classroomId = lessonDAO.getClassroomIdById(1L);
        assertEquals(classroomId, 1L);
    }

    @Test
    public void test9GetLessonDOByCourseId() {
        List<LessonDO> list = lessonDAO.getLessonDOByCourseId(courseId);
        assertNotNull(list);
    }

    @Test
    public void test10CheckByclassroomId() {
        Long classroomId = lessonDAO.checkByclassroomId(3L);
        assertNotNull(classroomId);
    }

    @Test
    public void test11CheckByCourseId() {
        Long courseId = lessonDAO.checkByCourseId(1L);
        assertNotNull(courseId);
        assertEquals(1L, courseId.longValue());
    }

    @Test
    public void test12GetCurrentLessonDOByLessonId() {
        LessonDO lessonDO = lessonDAO.getCurrentLessonDOByLessonId(127L);
        assertNotNull(lessonDO);
        assertEquals(127L, lessonDO.getId());
    }
}
