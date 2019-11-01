package edu.yctc.genesis.entity;

import java.util.Date;

public class AttendanceDO {

    /** 主键 */
    private long id;
    /** 用户id */
    private long userId;
    /** 课时id */
    private long lessonId;
    /** 出勤情况，{@link edu.yctc.genesis.constant.entity.attendance.AttendState} */
    private int attendState;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public int getAttendState() {
        return attendState;
    }

    public void setAttendState(int attendState) {
        this.attendState = attendState;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AttendanceDO [id=" + id + ", userId=" + userId + ", lessonId=" + lessonId + ", attendState="
            + attendState + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
