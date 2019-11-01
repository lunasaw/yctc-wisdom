package edu.yctc.genesis.vo;

/**
 * 考勤信息VO
 * 
 * @author 15272
 */
public class AttendanceVO {

    /** userId */
    private long userId;
    /** 学生姓名 */
    private String name;
    /** 考勤状态 */
    private int attendance;
    /** 班级 */
    private String studentClass;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AttendanceVO [userId=");
        builder.append(userId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", attendance=");
        builder.append(attendance);
        builder.append(", studentClass=");
        builder.append(studentClass);
        builder.append("]");
        return builder.toString();
    }

}
