package edu.yctc.genesis.entity;

import java.util.Date;

public class StudentCourseDO {

    /** 主键 */
    private long id;
    /** 用户id */
    private long userId;
    /** 课程id */
    private long courseId;
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

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
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
        return "StudentCourseDO [id=" + id + ", userId=" + userId + ", courseId=" + courseId + ", createTime="
            + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
