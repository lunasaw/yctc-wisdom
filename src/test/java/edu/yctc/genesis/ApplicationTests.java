package edu.yctc.genesis;

import edu.yctc.genesis.controller.rest.impl.KnowledgeRestControllerImpl;
import edu.yctc.genesis.face.function.impl.FaceFunctionImpl;
import edu.yctc.genesis.face.util.DealMedia;
import edu.yctc.genesis.face.util.OCRUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void  contextLoads() {
        FaceFunctionImpl faceFunction=new FaceFunctionImpl();
        DealMedia.decode("D:\\ffmpeg\\2.MP4", "D:\\ffmpeg\\img", "D:\\ffmpeg\\ffmpeg\\bin\\ffmpeg.exe");
    }


    @Test
    public void ocrfunction(){

        try {
            //图片文件：此图片是需要被识别的图片路径
            File file = new File("D://2.jpg");
            //String recognizeText = new OCRHelper().recognizeText(file);
            String recognizeText = new OCRUtil().recognizeText(file, "jpg");
            System.out.print(recognizeText + "\t");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test(){

    }
}
