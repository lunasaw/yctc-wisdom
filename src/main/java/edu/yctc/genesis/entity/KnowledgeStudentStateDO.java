package edu.yctc.genesis.entity;

import java.util.Date;

public class KnowledgeStudentStateDO {

    /** 主键 */
    private long id;
    /** userId */
    private long userId;
    /** lessonId */
    private long lessonId;
    /** knowledgeId */
    private long knowledgeId;
    /** 状态 */
    private int state;
    /** 开始扫描时间 */
    private Date scanStartTime;
    /** 扫描结束时间 */
    private Date scanEndTime;
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

    public long getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        builder.append("KnowledgeStudentStateDO [id=");
        builder.append(id);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", lessonId=");
        builder.append(lessonId);
        builder.append(", knowledgeId=");
        builder.append(knowledgeId);
        builder.append(", state=");
        builder.append(state);
        builder.append(", scanStartTime=");
        builder.append(scanStartTime);
        builder.append(", scanEndTime=");
        builder.append(scanEndTime);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

}
