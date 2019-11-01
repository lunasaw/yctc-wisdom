package edu.yctc.genesis.entity;

import java.util.Date;

public class LessonDO {

    /** 课时id */
    private long id;
    /** 课程id */
    private long courseId;
    /** 课时号 */
    private int number;
    /** 教室id */
    private long classroomId;
    /** 上课时间 */
    private Date begin;
    /** 下课时间 */
    private Date end;
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

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
        builder.append("PermissionDO [id=");
        builder.append(id);
        builder.append(", courseId=");
        builder.append(courseId);
        builder.append(", number=");
        builder.append(number);
        builder.append(", classroomId=");
        builder.append(classroomId);
        builder.append(", begin=");
        builder.append(begin);
        builder.append(", end=");
        builder.append(end);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();

    }
}
