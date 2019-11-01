package edu.yctc.genesis.vo;

import java.util.List;

import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;

public class CourseDTOAndClassesVO {

    /** courseDTO */
    private CourseDTO courseDTO;
    /** 班级集 */
    private List<ClassDO> classDOList;
    /** 专业 */
    private String profession;

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public List<ClassDO> getClassDOList() {
        return classDOList;
    }

    public void setClassDOList(List<ClassDO> classDOList) {
        this.classDOList = classDOList;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseDTOAndClassesVO [courseDTO=");
        builder.append(courseDTO);
        builder.append(", classDOList=");
        builder.append(classDOList);
        builder.append(", profession=");
        builder.append(profession);
        builder.append("]");
        return builder.toString();
    }

}
