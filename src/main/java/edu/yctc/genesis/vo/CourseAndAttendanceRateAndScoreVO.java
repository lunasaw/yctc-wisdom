package edu.yctc.genesis.vo;

import java.util.List;

import edu.yctc.genesis.entity.transfer.CourseDTO;

public class CourseAndAttendanceRateAndScoreVO {

    /** courseDTO */
    private CourseDTO courseDTO;
    /** 班级名List */
    private List<String> classNameList;
    /** 专业名 */
    private String profession;
    /** 出勤率 */
    private String attendanceRate;
    /** 听课评分 */
    private double score;

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public List<String> getClassNameList() {
        return classNameList;
    }

    public void setClassNameList(List<String> classNameList) {
        this.classNameList = classNameList;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
        builder.append("CourseAndAttendanceRateAndScoreVO [courseDTO=");
        builder.append(courseDTO);
        builder.append(", classNameList=");
        builder.append(classNameList);
        builder.append(", profession=");
        builder.append(profession);
        builder.append(", attendanceRate=");
        builder.append(attendanceRate);
        builder.append(", score=");
        builder.append(score);
        builder.append("]");
        return builder.toString();
    }

}
