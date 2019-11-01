package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.ProfessionDO;

@Mapper
public interface ProfessionDAO {

    /**
     * 插入
     * 
     * @param professionDO
     */
    public void insert(ProfessionDO professionDO);

    /**
     * 通过id返回ProfessionDO
     * 
     * @param id
     * @return
     */
    public ProfessionDO getProfessionDOById(long id);

    /**
     * 更新
     * 
     * @param professionDO
     */
    public void update(ProfessionDO professionDO);

    /**
     * 通过id删除
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过id返回专业名称
     * 
     * @param id
     * @return
     */
    public String getProfessionById(long id);

    /**
     * 获取库中所有专业
     * 
     * @return
     */
    public List<ProfessionDO> getProfessionDOs();

    /**
     * 通过专业名返回ProfessionDO
     * 
     * @param profession
     * @return
     */
    public ProfessionDO getProfessionDOByProfession(String profession);
}
