package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassDO;

public class AcademyAndClassesAndUrlVO {

    /** 学院 */
    private String academy;
    /** classDO */
    private ClassDO classDO;
    /** url */
    private String url;

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public ClassDO getClassDO() {
        return classDO;
    }

    public void setClassDO(ClassDO classDO) {
        this.classDO = classDO;
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
        builder.append("AcademyAndClassesAndUrlVO [academy=");
        builder.append(academy);
        builder.append(", classDO=");
        builder.append(classDO);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }
}
