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

import edu.yctc.genesis.entity.UserNewsDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserNewsDOTest {

    private static final long userId   = 38L;
    private static final long newsId   = 1L;
    private static final int  state    = 0;
    private static final int  newState = 1;
    @Autowired
    UserNewsDAO               userNewsDAO;

    @Test
    public void test1Insert() {
        UserNewsDO userNewsDO = new UserNewsDO();
        userNewsDO.setUserId(userId);
        userNewsDO.setNewsId(newsId);
        userNewsDO.setState(state);
        userNewsDAO.insert(userNewsDO);
    }

    @Test
    public void test2GetUserNewsDOById() {
        UserNewsDO userNewsDO = userNewsDAO.getUserNewsDOById(1L);
        assertEquals(1L, userNewsDO.getId());
    }

    @Test
    public void test3Update() {
        UserNewsDO userNewsDO = userNewsDAO.getUserNewsDOById(1L);
        assertEquals(1L, userNewsDO.getId());
        userNewsDO.setState(newState);
        userNewsDAO.update(userNewsDO);
    }

    @Test
    public void test4GetNewsIdByUserId() {
        List<Long> list = userNewsDAO.getNewsIdByUserId(1L);
        assertNotNull(list);
    }

    @Test
    public void test5DeleteById() {
        userNewsDAO.deleteById(1L);
    }

    @Test
    public void test6GetStateByUserIdAndNewsId() {
        UserNewsDO userNewsDO = userNewsDAO.getUserNewsDOByUserIdAndNewsId(userId, newsId);
        assertEquals(userId, 38L);
        assertEquals(newsId, 1L);
        assertNotNull(userNewsDO);
    }

    @Test
    public void test7GetNoReadNewsIdByUserId() {
        List<Long> list = userNewsDAO.getNoReadNewsIdByUserId(38L);
        assertNotNull(list);
    }

    @Test
    public void test8UpdateStateByUserIdAndNewsId() {
        userNewsDAO.updateStateByUserIdAndNewsId(38L, newsId, state);
    }

    @Test
    public void test9GetReadedNewsIdByUserId() {
        List<Long> list = userNewsDAO.getReadedNewsIdByUserId(38L);
        assertNotNull(list);
    }

    @Test
    public void test10DeleteByUserIdAndNewsId() {
        userNewsDAO.deletByUserIdAndNewsId(1L, 1L);
    }

    @Test
    public void test11DeleteAllReadedNewsByUserId() {
        userNewsDAO.deleteAllReadedNewsByUserId(userId);
    }
}
