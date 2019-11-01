package edu.yctc.genesis.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.KnowledgeDO;

@Mapper
public interface KnowledgeDAO {

    /**
     * 添加知识点
     * 
     * @param knowledgeDO
     */
    public void insert(KnowledgeDO knowledgeDO);

    /**
     * 更新知识点
     * 
     * @param knowledgeDO
     */
    public void update(KnowledgeDO knowledgeDO);

    /**
     * 通过id得到knowledgeDO
     * 
     * @param id
     * @return
     */
    public KnowledgeDO getKnowledgeDOById(long id);

    /**
     * 通过id删除
     * 
     * @param id
     */
    public void deleteById(long id);

}
