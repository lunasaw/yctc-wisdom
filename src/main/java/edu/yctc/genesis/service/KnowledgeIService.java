package edu.yctc.genesis.service;

import java.util.List;

import edu.yctc.genesis.entity.*;
import edu.yctc.genesis.vo.GetPictureVO;
import edu.yctc.genesis.vo.OneKnowledgeDetailsVO;
import edu.yctc.genesis.vo.StudentsLessonStateVO;

public interface KnowledgeIService {

    /**
     * 判断待匹配字符串中是否存在知识点
     * 
     * @param knowledge
     * @param toMatch
     * @return
     */
    public ResultDO<Boolean> checkKnowledge(String knowledge, String toMatch);

    /**
     * 通过教师id返回课时安排
     * 
     * @param userId
     * @return
     */
    public ResultDO<List<LessonDO>> getLessonDOListByUserId4Teacher(long userId);

    /**
     * 通过id返回courseDO
     * 
     * @param id
     * @return
     */
    public ResultDO<CourseDO> getCourseDOById(long id);

    /**
     * 通过id返回classroomDO
     * 
     * @param id
     * @return
     */
    public ResultDO<ClassroomDO> getClassroomDOById(long id);

    /*
    @knowledgeId 知识点id
    通过KnowledgeID返回picture
     */
    public ResultDO<List<KnowledgePictureDO>> getKnowledgePictureDOsByKnowledgeId(long knowledgeId);

    /*
    插入知识点对应的图片
     */
    public  ResultDO<Void> insertPictureByKnowledgeId (String picture,long knowledgeId);

    /**
     * 通过lessonId返回KnowledgeDO集
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
     * @param lessonId
     * @param content
     * @param length
     * @return
     */
    public ResultDO<Void> insertKnowledge(long lessonId, String content, double length);

    /**
     * 通过lessonId返回OneKnowledgeDetailsVO集
     * 
     * @param lessonId
     * @return
     */
    public ResultDO<List<OneKnowledgeDetailsVO>> getKnowledgesDetailsVOByLessonId(long lessonId);

    /**
     * 插入KnowledgeStudentStateDO
     * 
     * @param knowledgeStudentStateDO
     * @return
     */
    public ResultDO<Void> insertKnowledgeAndStudentStateDO(KnowledgeStudentStateDO knowledgeStudentStateDO);

    /*
    通过lessonid获得该堂课的所有知识点的学生状态人数
     */
    public ResultDO<StudentsLessonStateVO> getStudentsLessonStateVO(long lessonId,long knowledgeId);

}
