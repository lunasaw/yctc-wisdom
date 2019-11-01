package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.KnowledgeDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KnowledgeDOTest {

    private static final String CONTENT   = "知识点1";
    private static final int    LENGTH    = 5;
    private static final int    newLength = 6;

    @Autowired
    private KnowledgeDAO        knowledgeDAO;

    @Test
    public void test1Insert() {
        KnowledgeDO knowledgeDO = new KnowledgeDO();
        knowledgeDO.setContent(CONTENT);
        knowledgeDO.setLength(LENGTH);
        knowledgeDAO.insert(knowledgeDO);
    }

    @Test
    public void test2Update() {
        KnowledgeDO knowledgeDO = knowledgeDAO.getKnowledgeDOById(1L);
        assertEquals(1L, knowledgeDO.getId());
        knowledgeDO.setLength(newLength);
        knowledgeDAO.update(knowledgeDO);
    }

    @Test
    public void test3GetKnowledgeDOById() {
        KnowledgeDO knowledgeDO = knowledgeDAO.getKnowledgeDOById(1L);
        assertEquals(1L, knowledgeDO.getId());
    }

    @Test
    public void test4DeleteById() {
        knowledgeDAO.deleteById(1L);
    }
}
