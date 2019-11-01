package edu.yctc.genesis.entity;

import java.util.Date;

public class StudentStateDO {

    /** 主键 */
    private long id;
    /** 用户id */
    private long userId;
    /** 课时id */
    private long lessonId;
    /**
     * 上课状态，见{@link edu.yctc.genesis.constant.entity.studentstate.StudentState}}
     */
    private int state;
    /** 扫描开始时间 */
    private Date scanStartTime;
    /** 扫描结束时间 */
    private Date scanEndTime;
    /** 人脸标识 */
    private String faceToken;
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

    public Date getScanStartTime() {
        return scanStartTime;
    }

    public void setScanStartTime(Date scanStartTime) {
        this.scanStartTime = scanStartTime;
    }

    public Date getScanEndTime() {
        return scanEndTime;
    }

    public void setScanEndTime(Date scanEndTime) {
        this.scanEndTime = scanEndTime;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
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
        StringBuilder builder = new StringBuilder();
        builder.append("StudentStateDO [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", lessonId=");
        builder.append(lessonId);
        builder.append(", state=");
        builder.append(state);
        builder.append(", scanStartTime=");
        builder.append(scanStartTime);
        builder.append(", scanEndTime=");
        builder.append(scanEndTime);
        builder.append(", faceToken=");
        builder.append(faceToken);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

}
