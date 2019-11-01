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

import edu.yctc.genesis.entity.ClassroomStateDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassroomStateDAOTest {

    private static final long classroomId = 1L;
    private static final long lessonId    = 1L;
    private static final int  state       = 0;
    private static final int  newState    = 1;
    @Autowired
    private ClassroomStateDAO classroomStateDAO;

    @Test
    public void test1Insert() {
        ClassroomStateDO classroomStateDO = new ClassroomStateDO();
        classroomStateDO.setLessonId(lessonId);
        classroomStateDO.setClassroomId(classroomId);
        classroomStateDO.setState(state);
        classroomStateDAO.insert(classroomStateDO);
    }

    @Test
    public void test2GetClassroomStateDOById() {
        ClassroomStateDO classroomStateDO = classroomStateDAO.getClassroomStateDOById(1L);
        assertEquals(1L, classroomStateDO.getId());
        assertNotNull(classroomStateDO.getCreateTime());
        assertNotNull(classroomStateDO.getModifyTime());

    }

    @Test
    public void test3Update() {
        ClassroomStateDO classroomStateDO = classroomStateDAO.getClassroomStateDOById(1L);
        assertEquals(1L, classroomStateDO.getId());
        classroomStateDO.setState(newState);
        classroomStateDAO.update(classroomStateDO);
    }

    @Test
    public void test4DeleteById() {
        classroomStateDAO.deleteById(1L);
    }

    @Test
    public void test5CheckByclassroomId() {
        Long classroomId = classroomStateDAO.checkByclassroomId(3L);
        assertNotNull(classroomId);
    }
}
