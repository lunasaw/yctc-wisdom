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

import edu.yctc.genesis.entity.ClassDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassDOTest {

    private static final long   academyId    = 1L;
    private static final long   professionId = 1L;
    private static final String number       = "软件175";
    private static final String newNumber    = "软件177";

    @Autowired
    ClassDAO                    classDAO;

    @Test
    public void test1Insert() {
        ClassDO classDO = new ClassDO();
        classDO.setAcademyId(academyId);
        classDO.setNumber(number);
        classDO.setProfessionId(professionId);
        classDAO.insert(classDO);
    }

    @Test
    public void test2GetClassDOById() {
        ClassDO classDO = classDAO.getClassDOById(1L);
        assertNotNull(classDO);
        assertEquals(classDO.getId(), 1L);
        assertEquals(classDO.getAcademyId(), academyId);
        assertEquals(classDO.getNumber(), number);
    }

    @Test
    public void test3Update() {
        ClassDO classDO = classDAO.getClassDOById(1L);
        assertNotNull(classDO);
        assertEquals(classDO.getId(), 1L);
        assertEquals(classDO.getAcademyId(), academyId);
        assertEquals(classDO.getNumber(), number);
        classDO.setNumber(newNumber);
        classDAO.update(classDO);
    }

    @Test
    public void test4GetClassDOsByAcademyId() {
        List<ClassDO> list = classDAO.getClassDOsByAcademyId(academyId);
        assertNotNull(list);
    }

    @Test
    public void test5GetClassDOByAcademyIdAndNumber() {
        ClassDO classDO = classDAO.getClassDOByAcademyIdAndNumber(academyId, newNumber);
        assertEquals(classDO.getAcademyId(), academyId);
        assertEquals(classDO.getNumber(), newNumber);
    }

    @Test
    public void test6DeleteById() {
        classDAO.deleteById(1L);
    }

    @Test
    public void test7GetClassDOByNumber() {
        ClassDO classDO = classDAO.getClassDOByNumber(newNumber);
        assertNotNull(classDO);
    }

    @Test
    public void test8GetNumberById() {
        String number = classDAO.getNumberById(1L);
        assertNotNull(number);
    }

}
