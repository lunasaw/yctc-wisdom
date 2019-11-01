package edu.yctc.genesis.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import edu.yctc.genesis.entity.KnowledgeDO;
import edu.yctc.genesis.entity.ResultDO;
import edu.yctc.genesis.vo.KnowledgeAndLesson4InsertVO;
import edu.yctc.genesis.vo.LessonAndKnowledgeVO;
import edu.yctc.genesis.vo.OneKnowledgeDetailsVO;

public interface KnowledgeRestController {

    /**
     * 查看教师授课的知识点
     * 
     * @param httpSession
     * @return
     */
    public ResultDO<List<LessonAndKnowledgeVO>> getLessonAndKnowledgeByTeacherId(HttpSession httpSession);

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
}
