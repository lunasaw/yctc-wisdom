package edu.yctc.genesis.entity;

import java.util.Date;

public class KnowledgeLessonDO {

    /** 主键 */
    private long id;
    /** lessonId */
    private long lessonId;
    /** knowledgeId */
    private long knowledgeId;
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
        builder.append("KnowledgeLessonDO [id=");
        builder.append(id);
        builder.append(", lessonId=");
        builder.append(lessonId);
        builder.append(", knowledgeId=");
        builder.append(knowledgeId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

    public KnowledgeLessonDO(long lessonId, long knowledgeId) {
        super();
        this.lessonId = lessonId;
        this.knowledgeId = knowledgeId;
    }

    public KnowledgeLessonDO() {
        super();
    }

}
