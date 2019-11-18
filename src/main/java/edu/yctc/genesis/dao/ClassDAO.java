package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.ClassDO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassDAO {

    /**
     * 插入ClassDO
     * 
     * @param classDO
     */
    public void insert(ClassDO classDO);

    /**
     * 通过id返回ClassDO
     * 
     * @param id
     * @return
     */
    public ClassDO getClassDOById(long id);

    /**
     * 更新ClassDO
     * 
     * @param classDO
     */
    public void update(ClassDO classDO);

    /**
     * 通过id删除ClassDO
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过学院id返回ClassDO集
     * 
     * @param academyId
     * @return
     */
    public List<ClassDO> getClassDOsByAcademyId(long academyId);

    /**
     * 通过学院id和班级号返回ClassDO
     * 
     * @param academyId
     * @param number
     * @return
     */
    public ClassDO getClassDOByAcademyIdAndNumber(@Param("academyId") long academyId,@Param("number") String number);

    /**
     * 通过number返回classDO
     * 
     * @param number
     * @return
     */
    public ClassDO getClassDOByNumber(String number);

    /**
     * 通过id返回ClassDO的number
     * 
     * @param id
     * @return
     */
    public String getNumberById(long id);
}
