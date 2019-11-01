package edu.yctc.genesis.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.dao.ClassroomDAO;
import edu.yctc.genesis.dao.LessonDAO;
import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.service.StatisticalIService;

/**
 * 统计业务实现
 * 
 * @author 15272
 */
@ComponentScan({"edu.yctc.genesis.dao"})
@Service("statisticalService")
public class StatisticalServiceImpl implements StatisticalIService {

    private final static Logger LOG = LoggerFactory.getLogger("serviceLog");

    private static final String USED = "used";

    private static final String UNUSED = "unused";

    @Resource
    private LessonDAO lessonDAO;//课程

    @Resource
    private ClassroomDAO classroomDAO;//教室

    //获得教室占用状况
    @Override
    public Map<String, Integer> getClassroomUsingState() {

        // 获取数据库中所有的课时
        List<LessonDO> lessonDOs = lessonDAO.getLessonDOs();
        // 筛选正在上的课
        int currentLesson = 0;
        for (LessonDO lessonDO : lessonDOs) {
            // 如果是正在上的课
            if (lessonDO.getBegin().before(new Date()) && new Date().before(lessonDO.getEnd())) {
                currentLesson++;
            } else {
                continue;
            }
        }
        int classroomSum = classroomDAO.SummaryClassroom();
        Map<String, Integer> map = new HashMap<>();
        map.put(USED, currentLesson);
        map.put(UNUSED, classroomSum - currentLesson);
        LOG.info("statistical success, used={}, unused={}, map={}", currentLesson, classroomSum - currentLesson, map);
        return map;
    }

}
