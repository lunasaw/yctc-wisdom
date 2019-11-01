package edu.yctc.genesis.vo;

import java.util.List;

import edu.yctc.genesis.entity.ClassDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;

public class CourseDTOAndUrlVO {

    /** courseDTO */
    private CourseDTO courseDTO;
    /** url */
    private String url;
    /** clsses */
    private List<ClassDO> classDOList;

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ClassDO> getClassDOList() {
        return classDOList;
    }

    public void setClassDOList(List<ClassDO> classDOList) {
        this.classDOList = classDOList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseDTOAndUrlVO [courseDTO=");
        builder.append(courseDTO);
        builder.append(", url=");
        builder.append(url);
        builder.append(", classDOList=");
        builder.append(classDOList);
        builder.append("]");
        return builder.toString();
    }

}
