package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.AcademyDO;

@Mapper
public interface AcademyDAO {

    /**
     * 插入AcademyDO
     * 
     * @param academyDO
     */
    public void insert(AcademyDO academyDO);

    /**
     * 通过id返回AcademyDO
     * 
     * @param id
     * @return
     */
    public AcademyDO getAcademyDOById(long id);

    /**
     * 更新AcademyDO
     * 
     * @param academyDO
     */
    public void update(AcademyDO academyDO);

    /**
     * 通过id删除AcademyDO
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 返回库中学院集
     * 
     * @return
     */
    public List<String> getAcademies();

    /**
     * 通过学院名称返回AcademyDO
     * 
     * @param academy
     * @return
     */
    public AcademyDO getAcademyDOByAcademy(String academy);

    /**
     * 通过id返回Academy
     * 
     * @param id
     * @return
     */
    public String getAcademyById(long id);
}
