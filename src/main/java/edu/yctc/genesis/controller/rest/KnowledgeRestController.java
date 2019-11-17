package edu.yctc.genesis.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.KnowledgeDO;
import edu.yctc.genesis.entity.KnowledgePictureDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface KnowledgeRestController {

    /**
     * 查看教师授课的知识点
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<List<LessonAndKnowledgeVO>> getLessonAndKnowledgeByTeacherId(HttpSession httpSession);

    /*
    获取知识点识别到的知识点图片
     */
    ResultDO<List<KnowledgePictureDO>> getKnowledgePictureDOsByLessonId(long knowledgeid);

    /*
    获取课程的知识点对应的所有图片集合
     */
    ResultDO<List<GetPictureVO>> getAllPictureByLessonId(long lessonId);
    /**
     * 通过lessonId返回knowledgeDO集
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<KnowledgeDO>> getKnowledgeDOsByLessonId(long lessonId);

    /**
     * 修改知识点
     * 
     * @param knowledgeDO
     * @return
     */
    public ResultDO<Void> modifyKnowledge(KnowledgeDO knowledgeDO);

    /**
     * 通过id删除knowledge
     * 
     * @param id
     * @return
     */
    public ResultDO<Void> deleteKnowledgeById(long id);

    /**
     * 插入知识点
     * 
     * @param knowledgeAndLesson4InsertVO
     * @return
     */
    public ResultDO<Void> insertKnowledge(KnowledgeAndLesson4InsertVO knowledgeAndLesson4InsertVO);

    /**
     * 通过lessonId获得该堂课的所有知识点的KnowledgeDetailsVO集
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<OneKnowledgeDetailsVO>> getknowledgesDetailsVOByLessonId(long lessonId);

    /*
    通过lessonid获得该堂课的所有知识点的学生状态集合百分比
     */
    public ResultDO<StudentsLessonStateVO> studentsLessonStateVO(long lessonId,long knowledgeId);
//    public ResultDO<StudentsLessonStateVO> studentsLessonStateVO();

     /*
    通过图片id获取GetBooleanByPictureid
     */
     public ResultDO<GetBooleanByPictureVO> GetPictureBooleanLastVO(long pictureId);
//    public ResultDO<GetBooleanByPictureVO> GetPictureBooleanLastVO();

}
