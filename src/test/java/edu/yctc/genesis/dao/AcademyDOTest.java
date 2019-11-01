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

import edu.yctc.genesis.entity.AcademyDO;
import edu.yctc.genesis.service.KnowledgeIService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AcademyDOTest {

    private static final String academy    = "信息工程学院";
    private static final String newAcademy = "文学院";

    @Autowired
    AcademyDAO                  academyDAO;

    @Autowired
    KnowledgeIService           knowledgeService;

    @Test
    public void test1Insert() {
        AcademyDO academyDO = new AcademyDO();
        academyDO.setAcademy(academy);
        academyDAO.insert(academyDO);
    }

    @Test
    public void test2GetAcademyDOById() {
        AcademyDO academyDO = academyDAO.getAcademyDOById(1L);
        assertNotNull(academyDO);
        assertEquals(academyDO.getId(), 1L);
        assertEquals(academyDO.getAcademy(), academy);
    }

    @Test
    public void test3Update() {
        AcademyDO academyDO = academyDAO.getAcademyDOById(1L);
        assertNotNull(academyDO);
        assertEquals(academyDO.getId(), 1L);
        assertEquals(academyDO.getAcademy(), academy);
        academyDO.setAcademy(newAcademy);
        academyDAO.update(academyDO);
    }

    @Test
    public void test4GetAcademies() {
        List<String> list = academyDAO.getAcademies();
        assertNotNull(list);
    }

    @Test
    public void test5GetAcademyDOByAcademy() {
        AcademyDO academyDO = academyDAO.getAcademyDOByAcademy(newAcademy);
        assertEquals(academyDO.getAcademy(), newAcademy);
    }

    @Test
    public void test6DeleteById() {
        academyDAO.deleteById(1L);
    }

    @Test
    public void test7GetAcademyById() {
        String Academy = academyDAO.getAcademyById(1L);
        assertEquals(Academy, "文学院");
    }
}
