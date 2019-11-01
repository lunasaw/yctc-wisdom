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

import edu.yctc.genesis.entity.KnowledgeLessonDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KnowledgeLessonDOTest {

    private static final long  lessonId    = 1L;
    private static final long  knowledgeId = 2L;
    private static final long  newLessonId = 3L;

    @Autowired
    private KnowledgeLessonDAO knowledgeLessonDAO;

    @Test
    public void test1Insert() {
        KnowledgeLessonDO knowledgeLessonDO = new KnowledgeLessonDO();
        knowledgeLessonDO.setKnowledgeId(knowledgeId);
        knowledgeLessonDO.setLessonId(lessonId);
        knowledgeLessonDAO.insert(knowledgeLessonDO);
    }

    @Test
    public void test2GetKnowledgeLessonDOById() {
        KnowledgeLessonDO knowledgeLessonDO = knowledgeLessonDAO.getKnowledgeLessonDOById(1L);
        assertEquals(1L, knowledgeLessonDO.getId());
    }

    @Test
    public void test3Update() {
        KnowledgeLessonDO knowledgeLessonDO = knowledgeLessonDAO.getKnowledgeLessonDOById(1L);
        assertEquals(1L, knowledgeLessonDO.getId());
        knowledgeLessonDO.setLessonId(newLessonId);
        knowledgeLessonDAO.update(knowledgeLessonDO);
    }

    @Test
    public void test4GetKnowledgeLessonDOsByLessonId() {
        List<KnowledgeLessonDO> list = knowledgeLessonDAO.getKnowledgeLessonDOsByLessonId(lessonId);
        assertNotNull(list);
    }

    @Test
    public void test5DeleteById() {
        knowledgeLessonDAO.deleteById(1L);
    }

}
