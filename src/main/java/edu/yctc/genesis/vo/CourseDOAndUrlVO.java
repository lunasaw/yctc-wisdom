package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.CourseDO;

public class CourseDOAndUrlVO {

    /** courseDO */
    private CourseDO courseDO;
    /** url */
    private String url;

    public CourseDO getCourseDO() {
        return courseDO;
    }

    public void setCourseDO(CourseDO courseDO) {
        this.courseDO = courseDO;
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
        builder.append("CourseDOAndUrlVO [courseDO=");
        builder.append(courseDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }
}
