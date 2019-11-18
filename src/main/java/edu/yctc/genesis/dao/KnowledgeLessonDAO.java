package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.KnowledgeLessonDO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KnowledgeLessonDAO {

    /**
     * 插入
     * 
     * @param knowledgeLessonDO
     */
    public void insert(KnowledgeLessonDO knowledgeLessonDO);

    /**
     * 更新
     * 
     * @param knowledgeLessonDO
     */
    public void update(KnowledgeLessonDO knowledgeLessonDO);

    /**
     * 通过id拿到knowledgeLessonDO
     * 
     * @param id
     * @return
     */
    public KnowledgeLessonDO getKnowledgeLessonDOById(long id);

    /**
     * 通过id删除
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过lessonId得到knowledgeLessonDO集
     * 
     * @param lessonId
     * @return
     */
    public List<KnowledgeLessonDO> getKnowledgeLessonDOsByLessonId(long lessonId);

    /**
     * 通过knowledgeId删除
     * 
     * @param knowledgeId
     */
    public void deleteKnowledgeLessonDOByKnowledgeId(long knowledgeId);

    /**
     * 通过lessonId和knowledge返回knowledgeLessonDO
     * 
     * @param lessonId
     * @param knowledge
     * @return
     */
    public KnowledgeLessonDO getKnowledgeLessonDOByLessonIdAndKnowledge(@Param("lessonId") long lessonId,@Param("knowledge") String knowledge);

}
