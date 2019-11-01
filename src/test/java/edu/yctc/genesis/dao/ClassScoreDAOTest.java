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

import edu.yctc.genesis.entity.ClassScoreDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassScoreDAOTest {

    private static final long   userId   = 134L;
    private static final long   lessonId = 9L;
    private static final double score    = 1.0;
    private static final double newScore = 2.0;
    @Autowired
    private ClassScoreDAO       classScoreDAO;

    @Test
    public void test1Insert() {
        ClassScoreDO classScoreDO = new ClassScoreDO();
        classScoreDO.setLessonId(lessonId);
        classScoreDO.setUserId(userId);
        classScoreDO.setScore(score);
        classScoreDAO.insert(classScoreDO);
    }

    @Test
    public void test2GetClassScoreDOById() {
        ClassScoreDO classScoreDO = classScoreDAO.getClassScoreDOById(1L);
        assertEquals(2L, classScoreDO.getId());
        assertNotNull(classScoreDO.getCreateTime());
        assertNotNull(classScoreDO.getModifyTime());

    }

    @Test
    public void test3Update() {
        ClassScoreDO classScoreDO = classScoreDAO.getClassScoreDOById(1L);
        assertEquals(1L, classScoreDO.getId());

        classScoreDO.setScore(newScore);
        classScoreDAO.update(classScoreDO);
    }

    @Test
    public void test4DeleteById() {
        classScoreDAO.deleteById(1L);
    }

    @Test
    public void test5CheckByStudentId() {
        Long studentId = classScoreDAO.checkByStudentId(userId);
        assertNotNull(studentId);
        assertEquals(userId, studentId.longValue());
    }

    @Test
    public void test6GetClassScoreDOByUserIdAndLessonId() {
        ClassScoreDO classScoreDO = classScoreDAO.getClassScoreDOByUserIdAndLessonId(userId, lessonId);
        assertNotNull(classScoreDO);
        assertEquals(userId, classScoreDO.getUserId());
        assertEquals(lessonId, classScoreDO.getLessonId());
    }
}
