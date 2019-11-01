package edu.yctc.genesis.entity;

import java.util.Date;

import com.alibaba.fastjson.JSON;

import edu.yctc.genesis.entity.transfer.CourseDTO;
import edu.yctc.genesis.vo.ModifyCourseVO;

public class CourseDO {

    /** 课程id */
    private long id;
    /** 课程号 */
    private String number;
    /** 课程名 */
    private String name;
    /** 课程课时总数 */
    private int lessonSum;
    /** 开课学年 */
    private String year;
    /** 开课学期 ，{@link edu.yctc.genesis.constant.entity.term.Term} */
    private int term;
    /** 开课专业id */
    private long professionId;
    /** 开课班级 */
    private String classId;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLessonSum() {
        return lessonSum;
    }

    public void setLessonSum(int lessonSum) {
        this.lessonSum = lessonSum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseDO [id=");
        builder.append(id);
        builder.append(", number=");
        builder.append(number);
        builder.append(", name=");
        builder.append(name);
        builder.append(", lessonSum=");
        builder.append(lessonSum);
        builder.append(", year=");
        builder.append(year);
        builder.append(", term=");
        builder.append(term);
        builder.append(", professionId=");
        builder.append(professionId);
        builder.append(", classId=");
        builder.append(classId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

    public CourseDO(CourseDTO courseDTO) {
        super();
        this.id = courseDTO.getId();
        this.lessonSum = courseDTO.getLessonSum();
        this.name = courseDTO.getName();
        this.number = courseDTO.getNumber();
        this.professionId = courseDTO.getProfessionId();
        this.term = courseDTO.getTerm();
        this.year = courseDTO.getYear();
        this.createTime = courseDTO.getCreateTime();
        this.modifyTime = courseDTO.getModifyTime();
        String classIdJsonString = JSON.toJSONString(courseDTO.getClassId());
        String classIdList = JSON.parseObject(classIdJsonString, String.class);
        this.classId = classIdList;
    }

    public CourseDO() {
        super();
    }

    public CourseDO(ModifyCourseVO modifyCourseVO) {
        super();
        this.id = modifyCourseVO.getId();
        this.number = modifyCourseVO.getNumber();
        this.name = modifyCourseVO.getName();
        this.lessonSum = modifyCourseVO.getLessonSum();
        this.year = modifyCourseVO.getYear();
        this.term = modifyCourseVO.getTerm();
        this.classId = modifyCourseVO.getClassId();
    }
}
