package edu.yctc.genesis.vo;

import java.util.Date;
import java.util.List;

import edu.yctc.genesis.entity.KnowledgeDO;

public class LessonAndKnowledgeVO {

    /** 课程名称 */
    private String courseName;
    /** 上课教室 */
    private String classroom;
    /** 上课时间 */
    private Date begin;
    /** lessonId */
    private long lessonId;
    /** 知识点集 */
    private List<KnowledgeDO> knowledgeDOs;
    /** url */
    private String url;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public List<KnowledgeDO> getKnowledgeDOs() {
        return knowledgeDOs;
    }

    public void setKnowledgeDOs(List<KnowledgeDO> knowledgeDOs) {
        this.knowledgeDOs = knowledgeDOs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LessonAndKnowledgeVO [courseName=");
        builder.append(courseName);
        builder.append(", classroom=");
        builder.append(classroom);
        builder.append(", begin=");
        builder.append(begin);
        builder.append(", lessonId=");
        builder.append(lessonId);
        builder.append(", knowledgeDOs=");
        builder.append(knowledgeDOs);
        builder.append("]");
        return builder.toString();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
