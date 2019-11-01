package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.LessonDO;

public class LessonDOAndUrlVO {

    /** lessonDO */
    private LessonDO lessonDO;
    /** url */
    private String url;

    public LessonDO getLessonDO() {
        return lessonDO;
    }

    public void setLessonDO(LessonDO lessonDO) {
        this.lessonDO = lessonDO;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LessonDODOAndUrlVO [lessonDO=");
        builder.append(lessonDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }
}
