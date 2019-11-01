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

import edu.yctc.genesis.entity.CourseDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDAOTest {

    private static final String number       = "20086408";
    private static final String name         = "新课程";
    private static final int    lessionSum   = 64;
    private static final String year         = "2018--2019学年";
    private static final int    term         = 1;
    private static final long   professionId = 1;
    private static final String classes      = "[1,2,3,4]";
    private static final int    newTerm      = 2;
    @Autowired
    private CourseDAO           courseDAO;

    @Test
    public void test1Insert() {
        CourseDO courseDO = new CourseDO();
        courseDO.setNumber(number);
        courseDO.setName(name);
        courseDO.setLessonSum(lessionSum);
        courseDO.setYear(year);
        courseDO.setTerm(term);
        courseDO.setProfessionId(professionId);
        courseDO.setClassId(classes);
        courseDAO.insert(courseDO);
    }

    @Test
    public void test2GetCourseDOById() {
        CourseDO courseDO = courseDAO.getCourseDOById(3L);
        assertEquals(3L, courseDO.getId());
        assertNotNull(courseDO.getCreateTime());
        assertNotNull(courseDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        CourseDO courseDO = courseDAO.getCourseDOById(3L);
        assertEquals(3L, courseDO.getId());
        courseDO.setTerm(newTerm);
        courseDAO.update(courseDO);
    }

    @Test
    public void test4DeleteById() {
        courseDAO.deleteById(3L);
    }

    @Test
    public void test5GetYears() {
        List<String> list = courseDAO.getYears();
        assertNotNull(list);
    }

    @Test
    public void test6GetCourseDOByYearAndTerm() {
        List<CourseDO> list = courseDAO.getCourseDOByYearAndTerm(year, term);
        assertNotNull(list);
    }

    @Test
    public void test7GetYears() {
        List<String> list = courseDAO.getYears();
        assertNotNull(list);
    }

    @Test
    public void test8GetTermByYear() {
        List<String> list = courseDAO.getTermByYear("2017--2018学年");
        assertNotNull(list);
    }

    @Test
    public void test9GetCourseByYearAndTerm() {
        List<String> list = courseDAO.getCourseByYearAndTerm(year, term);
        assertNotNull(list);
    }

    @Test
    public void test10getCourseDOByYearAndTermAndCourse() {
        CourseDO courseDO = courseDAO.getCourseDOByYearAndTermAndCourse(year, term, name);
        assertNotNull(courseDO);
    }

    @Test
    public void test9getCourseIdByName() {
        Long courseId = courseDAO.getCourseIdByName(name);
        assertNotNull(courseId);
    }

    @Test
    public void test10CheckByClassId() {
        List<String> list = courseDAO.checkByClassId(10L);
        assertNotNull(list);
    }
}
