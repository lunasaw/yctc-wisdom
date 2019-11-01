package edu.yctc.genesis.vo;

public class ApplyClassroomVO {

    /** 教师id */
    private long teacherId;
    /** 课程名 */
    private String courseName;
    /** 课时号 */
    private int number;
    /** 教室id */
    private long classroomId;
    /** 上课时间 */
    private String lessonTime;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public String getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ApplyClassroomVO [teacherId=");
        builder.append(teacherId);
        builder.append(", courseName=");
        builder.append(courseName);
        builder.append(", number=");
        builder.append(number);
        builder.append(", classroomId=");
        builder.append(classroomId);
        builder.append(", lessonTime=");
        builder.append(lessonTime);
        builder.append("]");
        return builder.toString();
    }
}
