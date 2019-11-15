package edu.yctc.genesis;

import edu.yctc.genesis.controller.rest.impl.KnowledgeRestControllerImpl;
import edu.yctc.genesis.dao.PictureKnowledgeDAO;
import edu.yctc.genesis.entity.KnowledgePictureDO;
import edu.yctc.genesis.face.function.impl.FaceFunctionImpl;
import edu.yctc.genesis.face.util.CheckKnowledgeThread;
import edu.yctc.genesis.face.util.DealMedia;
import edu.yctc.genesis.face.util.GetFoldFileNames;
import edu.yctc.genesis.face.util.OCRUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Resource
    private PictureKnowledgeDAO pictureKnowledgeDAO;//知识点图片
    @Test
    public void  contextLoads() {
        DealMedia.decode("D:\\ffmpeg\\亲子关系与小学生品德培养.mp4", "D:\\ffmpeg\\img", "D:\\ffmpeg\\ffmpeg\\bin\\ffmpeg.exe");
    }

    @Test
    public void insert() {
//        faceFunction.dealMedia("D:\\ffmpeg\\mp4\\亲子关系与小学生品德培养.mp4",
//                "src\\img","00:03","04:30","04:30","1","1920*1080");
        try {
            List<String> fileNames = new ArrayList<>();
            GetFoldFileNames.getFileName(fileNames, "src\\img");
            KnowledgePictureDO knowledgePictureDO=new KnowledgePictureDO();
            String s="";
            for (String temp : fileNames) {
                System.out.println("src/img/" + temp);
                s="src/img/" + temp;
                knowledgePictureDO.setPicture(s);
                pictureKnowledgeDAO.insertbypicture(knowledgePictureDO);
            }

        } catch (Exception e) {
//            LOG.error("img is not exist!, exception={}", e.toString());
            e.printStackTrace();
        }



    }


}
