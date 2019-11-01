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

import edu.yctc.genesis.entity.KnowledgeStudentStateDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KnowledgeStudentStateDOTest {

    private static final long        userId        = 1L;
    private static final long        lessonId      = 1L;
    private static final long        knowledgeId   = 1L;
    private static final int         state         = 1;
    private static final int         newState      = 2;
    private static final Date        scanStartTime = new Date();

    @Autowired
    private KnowledgeStudentStateDAO knowledgeStudentStateDAO;

    @Test
    public void test1Insert() {
        KnowledgeStudentStateDO knowledgeStudentStateDO = new KnowledgeStudentStateDO();
        knowledgeStudentStateDO.setUserId(userId);
        knowledgeStudentStateDO.setLessonId(lessonId);
        knowledgeStudentStateDO.setKnowledgeId(knowledgeId);
        knowledgeStudentStateDO.setKnowledgeId(knowledgeId);
        knowledgeStudentStateDO.setState(state);
        knowledgeStudentStateDO.setScanStartTime(scanStartTime);
        knowledgeStudentStateDAO.insert(knowledgeStudentStateDO);
    }

    @Test
    public void test2GetKnowledgeStudentStateDOById() {
        KnowledgeStudentStateDO knowledgeStudentStateDO = knowledgeStudentStateDAO.getKnowledgeStudentStateDOById(1L);
        assertEquals(1L, knowledgeStudentStateDO.getId());
        assertEquals(userId, knowledgeStudentStateDO.getUserId());
    }

    @Test
    public void test3Update() {
        KnowledgeStudentStateDO knowledgeStudentStateDO = knowledgeStudentStateDAO.getKnowledgeStudentStateDOById(1L);
        knowledgeStudentStateDO.setState(newState);
        knowledgeStudentStateDAO.update(knowledgeStudentStateDO);
    }

    @Test
    public void test4GetKnowledgeStudentStateDOsByUserIdAndLessonId() {
        List<KnowledgeStudentStateDO> list = knowledgeStudentStateDAO.getKnowledgeStudentStateDOsByUserIdAndLessonId(userId,
                                                                                                                     lessonId);
        assertNotNull(list);
    }

    @Test
    public void test5UpdateScanEndTime() {
        KnowledgeStudentStateDO knowledgeStudentStateDO = knowledgeStudentStateDAO.getKnowledgeStudentStateDOById(1L);
        knowledgeStudentStateDAO.updateScanEndTime(knowledgeStudentStateDO);
    }

    @Test
    public void test6DeleteById() {
        knowledgeStudentStateDAO.deleteById(1L);
    }
}
