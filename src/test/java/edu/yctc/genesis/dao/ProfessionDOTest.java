package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.ProfessionDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfessionDOTest {

    private static final String profession    = "软件工程";
    private static final String newProfession = "计算机科学与技术";

    @Resource
    private ProfessionDAO       professionDAO;

    @Test
    public void test1Insert() {
        ProfessionDO professionDO = new ProfessionDO();
        professionDO.setProfession(profession);
        professionDAO.insert(professionDO);
    }

    @Test
    public void test2GetProfessionDOById() {
        ProfessionDO professionDO = professionDAO.getProfessionDOById(1L);
        assertNotNull(professionDO);
        assertEquals(1L, professionDO.getId());
        assertEquals(profession, professionDO.getProfession());
    }

    @Test
    public void test3GetProfessionById() {
        String name = professionDAO.getProfessionById(1L);
        assertNotNull(name);
        assertEquals(profession, name);
    }

    @Test
    public void test4Update() {
        ProfessionDO professionDO = professionDAO.getProfessionDOById(1L);
        assertNotNull(professionDO);
        assertEquals(1L, professionDO.getId());
        assertEquals(profession, professionDO.getProfession());
        professionDO.setProfession(newProfession);
        professionDAO.update(professionDO);
    }

    @Test
    public void test5DeleteById() {
        professionDAO.deleteById(1L);
    }

    @Test
    public void test6GetProfessionDOs() {
        List<ProfessionDO> list = professionDAO.getProfessionDOs();
        assertNotNull(list);
    }

    @Test
    public void test7GetProfessionDOByProfession() {
        ProfessionDO professionDO = professionDAO.getProfessionDOByProfession(profession);
        assertNotNull(professionDO);
        assertEquals(profession, professionDO.getProfession());
        assertEquals(1L, professionDO.getId());
    }
}
