package edu.yctc.genesis.vo;

/**
 * 插入知识点VO
 * 
 * @author 15272
 *
 */
public class KnowledgeAndLesson4InsertVO {

    /** 课时id */
    private long lessonId;
    /** 知识点描述 */
    private String content;
    /** 预计时长 */
    private double length;

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("KnowledgeAndLesson4InsertVO [lessonId=");
        builder.append(lessonId);
        builder.append(", content=");
        builder.append(content);
        builder.append(", length=");
        builder.append(length);
        builder.append("]");
        return builder.toString();
    }
}
