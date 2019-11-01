package edu.yctc.genesis.entity;

import java.util.Date;

public class ClassroomStateDO {

    /** 主键 */
    private long id;
    /** 教室id */
    private long classroomId;
    /** 课时id */
    private long lessonId;
    /** 占用状态 */
    private int state;
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

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ClassroomStateDO [id=" + id + ", classroomId=" + classroomId + ", lessonId=" + lessonId + ", state="
            + state + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
