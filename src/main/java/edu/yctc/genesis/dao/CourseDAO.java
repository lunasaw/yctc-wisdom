package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.CourseDO;

@Mapper
public interface CourseDAO {

    /**
     * 插入课程
     * 
     * @param courseDO
     */
    public void insert(CourseDO courseDO);

    /**
     * id查询课程
     * 
     * @param id
     * @return
     */
    public CourseDO getCourseDOById(long id);

    /**
     * 更新课程
     * 
     * @param courseDO
     */
    public void update(CourseDO courseDO);

    /**
     * id删除课程
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 返回库中学年集
     * 
     * @return
     */
    public List<String> getYears();

    /**
     * 通过学年和学期返回课程集
     * 
     * @param year
     * @param term
     * @return
     */
    public List<CourseDO> getCourseDOByYearAndTerm(String year, int term);

    /**
     * 通过id和学年和学期查询课程
     * 
     * @param id
     * @return
     */
    public CourseDO getCourseDOByIdAndYearAndTerm(long id, String year, int term);

    /**
     * 通过学年返回学期集
     *
     * @param year
     * @return
     */
    public List<String> getTermByYear(String year);

    /**
     * 通过学年和学期返回课程
     *
     * @param year
     * @param term
     * @return
     */
    public List<String> getCourseByYearAndTerm(String year, int term);

    /**
     * 通过学年、学期和课程名返回课程集
     * 
     * @param year
     * @param term
     * @param courseName
     * @return
     */
    public CourseDO getCourseDOByYearAndTermAndCourse(String year, int term, String courseName);

    /**
     * 通过课程名查询课程Id
     *
     * @param courseName
     * @return
     */
    public Long getCourseIdByName(String courseName);

    /**
     * 通过id获得课程名
     * 
     * @param id
     * @return
     */
    public String getCourseNameById(long id);

    /**
     * 通过name获得课程id
     * 
     * @param id
     * @return
     */
    public long getIdByName(String name);

    /**
     * 判断是否存在classId
     * 
     * @param classId
     * @return
     */
    public List<String> checkByClassId(long classId);

}
