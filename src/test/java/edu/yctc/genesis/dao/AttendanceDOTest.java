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

import edu.yctc.genesis.entity.AttendanceDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttendanceDOTest {

    private static long   userId         = 134L;
    private static long   lessonId       = 1L;
    private static int    attendState    = 1;
    private static int    newAttendState = 2;
    @Autowired
    private AttendanceDAO attendanceDAO;

    @Test
    public void test1Insert() {
        AttendanceDO attendanceDO = new AttendanceDO();
        attendanceDO.setUserId(userId);
        attendanceDO.setLessonId(lessonId);
        attendanceDO.setAttendState(attendState);
        attendanceDAO.insert(attendanceDO);
    }

    @Test
    public void test2GetAttendanceDOById() {
        AttendanceDO attendanceDO = attendanceDAO.getAttendanceDOById(1L);
        assertEquals(1L, attendanceDO.getId());
        assertEquals(userId, attendanceDO.getUserId());
        assertNotNull(attendanceDO.getCreateTime());
        assertNotNull(attendanceDO.getModifyTime());
    }

    @Test
    public void test3Update() {
        AttendanceDO attendanceDO = attendanceDAO.getAttendanceDOById(1L);
        attendanceDO.setAttendState(newAttendState);
        attendanceDAO.update(attendanceDO);
    }

    @Test
    public void test4DeleteById() {
        attendanceDAO.deleteById(3L);
    }

    @Test
    public void test5GetIdsByLessonId() {
        attendanceDAO.getIdsByLessonId(9L);
    }

    @Test
    public void test6GetAttendStateByLessonIdAndUserId() {
        attendanceDAO.getAttendStateByLessonIdAndUserId(911L, 134L);
    }

    @Test
    public void test7GetAttendStatesByLessonId() {
        attendanceDAO.getAttendStatesByLessonId(9L);
    }

    @Test
    public void test8getSumByLessonIdAndUserIdAndAttendState() {
        attendanceDAO.getSumByLessonIdAndUserIdAndAttendState(9L, 136L, 1);
    }

    @Test
    public void test9getSumByLessonIdAndUserId() {
        attendanceDAO.getSumByLessonIdAndUserId(9L, 136L);
    }

    @Test
    public void test10CheckByStudentId() {
        Long studentId = attendanceDAO.checkByStudentId(userId);
        assertNotNull(studentId);
        assertEquals(userId, studentId.longValue());
    }

    @Test
    public void test3UpdateAttendStateByUserIdAndLessonId() {
        AttendanceDO attendanceDO = attendanceDAO.getAttendanceDOById(1L);
        long userId = attendanceDO.getUserId();
        long lessonId = attendanceDO.getLessonId();
        attendanceDAO.updateAttendStateByUserIdAndLessonId(userId, lessonId, newAttendState);
    }

    @Test
    public void test4GetAttendanceDOsByLessonId() {
        List<AttendanceDO> attendanceDOList = attendanceDAO.getAttendanceDOsByLessonId(118L);
        assertNotNull(attendanceDOList);
    }
}
