package edu.yctc.genesis.vo;

public class AcademyAndClassesVO {

    /** 学院 */
    private String academy;
    /** 班级 */
    private String classes;

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AcademyAndClassesVO [academy=");
        builder.append(academy);
        builder.append(", classes=");
        builder.append(classes);
        builder.append("]");
        return builder.toString();
    }
}
