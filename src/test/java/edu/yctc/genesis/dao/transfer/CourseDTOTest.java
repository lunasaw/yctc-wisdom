package edu.yctc.genesis.dao.transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.yctc.genesis.dao.CourseDAO;
import edu.yctc.genesis.entity.CourseDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDTOTest {

    private static final long   id             = 9L;
    private static final String number         = "123";
    private static final String name           = "123";
    private static final int    lessonSum      = 64;
    private static final String year           = "123";
    private static final int    term           = 1;
    private static final long   professionId   = 1;
    private static List<Long>   classId        = new ArrayList<>();
    private static final Date   createTime     = new Date();
    private static final Date   modifyTime     = new Date();
    private static final long   firstClassId   = 1;
    private static final long   secondeClassId = 2;
    @Autowired
    CourseDAO                   courseDAO;

    @Test
    public void test1CourseDOToCourseDTO() {
        CourseDO courseDO = courseDAO.getCourseDOById(id);
        assertNotNull(courseDO);
        assertEquals(courseDO.getId(), id);
        CourseDTO courseDTO = new CourseDTO(courseDO);
        assertNotNull(courseDTO);
        assertEquals(courseDTO.getId(), courseDO.getId());
    }

    @Test
    public void test2CoutseDTOToCourseDO() {
        CourseDTO courseDTO = new CourseDTO();
        classId.add(firstClassId);
        classId.add(secondeClassId);
        courseDTO.setClassId(classId);
        courseDTO.setCreateTime(createTime);
        courseDTO.setId(id);
        courseDTO.setLessonSum(lessonSum);
        courseDTO.setName(name);
        courseDTO.setNumber(number);
        courseDTO.setProfessionId(professionId);
        courseDTO.setTerm(term);
        courseDTO.setYear(year);
        courseDTO.setModifyTime(modifyTime);
        CourseDO courseDO = new CourseDO(courseDTO);
        assertNotNull(courseDO);
        assertEquals(courseDTO.getId(), courseDO.getId());
    }
}
