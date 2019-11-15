package edu.yctc.genesis.service.impl;

import java.util.*;

import javax.annotation.Resource;

import edu.yctc.genesis.dao.*;
import edu.yctc.genesis.entity.KnowledgeLessonDO;
import edu.yctc.genesis.entity.KnowledgePictureDO;
import edu.yctc.genesis.face.function.FaceFunction;
import edu.yctc.genesis.face.function.impl.FaceFunctionImpl;
import edu.yctc.genesis.face.util.DealImage;
import edu.yctc.genesis.face.util.DealMedia;
import edu.yctc.genesis.face.util.GetFoldFileNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.service.StatisticalIService;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private KnowledgeLessonDAO knowledgeLessonDAO; //知识点课程

    @Resource
    private KnowledgeDAO knowledgeDAO;

    @Resource
    private ClassroomDAO classroomDAO;//教室

    @Resource
    private PictureKnowledgeDAO pictureKnowledgeDAO;//知识点图片

    private FaceFunctionImpl faceFunction;

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

    public void insert() {
//        faceFunction.dealMedia("D:\\ffmpeg\\mp4\\亲子关系与小学生品德培养.mp4",
//                "src\\img","00:03","04:30","04:30","1","1920*1080");
        try {
            List<String> fileNames = new ArrayList<>();
            GetFoldFileNames.getFileName(fileNames, "src\\img");
            KnowledgePictureDO knowledgePictureDO=new KnowledgePictureDO();
            String s="";
            for (String temp : fileNames) {
                System.out.println("src\\img\\" + temp);
                s="src\\img\\" + temp;
                knowledgePictureDO.setPicture(s);
                pictureKnowledgeDAO.insertbypicture(knowledgePictureDO);
            }

        } catch (Exception e) {
//            LOG.error("img is not exist!, exception={}", e.toString());
            e.printStackTrace();
        }



    }
}
