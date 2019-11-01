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

import edu.yctc.genesis.entity.TeacherLessonDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeacherLessonDAOTest {

    private static final long userId      = 1L;
    private static final long lessonId    = 2L;
    private static final long newLessonId = 3L;
    @Autowired
    private TeacherLessonDAO  teacherLessonDAO;

    @Test
    public void test1Insert() {
        TeacherLessonDO teacherLessonDO = new TeacherLessonDO();
        teacherLessonDO.setLessonId(lessonId);
        teacherLessonDO.setUserId(userId);
        teacherLessonDAO.insert(teacherLessonDO);
    }

    @Test
    public void test2GetTeacherLessonDOByTeacherId() {
        TeacherLessonDO teacherLessonDO = teacherLessonDAO.getTeacherLessonDOById(1L);
        assertEquals(1L, teacherLessonDO.getId());
        assertEquals(lessonId, teacherLessonDO.getLessonId());
        assertNotNull(teacherLessonDO.getCreateTime());
        assertNotNull(teacherLessonDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        TeacherLessonDO teacherLessonDO = teacherLessonDAO.getTeacherLessonDOById(1L);
        assertEquals(1L, teacherLessonDO.getId());
        teacherLessonDO.setLessonId(newLessonId);
        teacherLessonDAO.update(teacherLessonDO);
    }

    @Test
    public void test4DeleteById() {
        teacherLessonDAO.deleteById(1L);
    }

    @Test
    public void test5GetTeacherLessonDOByLessonId() {
        TeacherLessonDO teacherLessonDO = teacherLessonDAO.getTeacherLessonDOByLessonId(lessonId);
        assertNotNull(teacherLessonDO);
    }

    @Test
    public void test6GetTeacherLessonDOByUserId() {
        List<TeacherLessonDO> list = teacherLessonDAO.getTeacherLessonDOByUserId(134L);
        assertNotNull(list);
    }

    @Test
    public void test7GetLessonIdsByUserId() {
        List<Long> list = teacherLessonDAO.getLessonIdsByUserId(135L);
        assertNotNull(list);
    }

    @Test
    public void test8CheckByTeacherId() {
        Long teacherId = teacherLessonDAO.checkByTeacherId(134L);
        assertNotNull(teacherId);
        assertEquals(134L, teacherId.longValue());
    }
}
