package edu.yctc.genesis.dao;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.entity.NewsDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewsDOTest {

    private static final String title      = "通知1";
    private static final String content    = "通知正文";
    private static final String newContent = "新通知正文";
    @Autowired
    NewsDAO                     newsDAO;

    @Test
    public void test1Insert() {
        NewsDO newsDO = new NewsDO();
        newsDO.setTitle(title);
        newsDO.setContent(content);
        newsDAO.insert(newsDO);
    }

    @Test
    public void test2GetNewsDOById() {
        NewsDO newsDO = newsDAO.getNewsDOById(1L);
        assertEquals(1L, newsDO.getId());
    }

    @Test
    public void test3Update() {
        NewsDO newsDO = newsDAO.getNewsDOById(1L);
        assertEquals(1L, newsDO.getId());
        newsDO.setContent(newContent);
        newsDAO.update(newsDO);
    }

    @Test
    public void test4DeleteById() {
        newsDAO.deleteById(1L);
    }
}
