package edu.yctc.genesis.vo;

import java.util.List;

import edu.yctc.genesis.entity.LessonDO;
import edu.yctc.genesis.entity.transfer.CourseDTO;

public class LessonDetailsVO {

    /** courseDTO */
    private CourseDTO courseDTO;
    /** lessonDO */
    private LessonDO lessonDO;
    /** 专业名 */
    private String profession;
    /** 班级名List */
    private List<String> classNameList;
    /** classroom(Building Number) */
    private String classroom;
    /** attendanceRate */
    private String attendanceRate;
    /** score */
    private double score;

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public LessonDO getLessonDO() {
        return lessonDO;
    }

    public void setLessonDO(LessonDO lessonDO) {
        this.lessonDO = lessonDO;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getClassNameList() {
        return classNameList;
    }

    public void setClassNameList(List<String> classNameList) {
        this.classNameList = classNameList;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseAndAttendanceRateAndScoreVO [courseDO=");
        builder.append(courseDTO);
        builder.append(", lessonDO=");
        builder.append(lessonDO);
        builder.append(", profession=");
        builder.append(profession);
        builder.append(", classNameList=");
        builder.append(classNameList);
        builder.append(", classroom=");
        builder.append(classroom);
        builder.append(", attendanceRate=");
        builder.append(attendanceRate);
        builder.append(", score=");
        builder.append(score);
        builder.append("]");
        return builder.toString();
    }

}
