package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.UserDO;

public class StudentAndAttendanceRateAndScoreVO {

    /** student */
    private UserDO userDO;
    /** 学院名 */
    private String academyName;
    /** 班级名 */
    private String classNumber;
    /** attendanceRate */
    private String attendanceRate;
    /** score */
    private double score;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
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
        builder.append("StudentAndAttendanceRateAndScoreVO [userDO=");
        builder.append(userDO);
        builder.append(", academyName=");
        builder.append(academyName);
        builder.append(", classNumber=");
        builder.append(classNumber);
        builder.append(", attendanceRate=");
        builder.append(attendanceRate);
        builder.append(", score=");
        builder.append(score);
        builder.append("]");
        return builder.toString();
    }

}
