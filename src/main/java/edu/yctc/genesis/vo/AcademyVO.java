package edu.yctc.genesis.vo;

public class AcademyVO {

    /** 学院号 */
    private String academy;

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AcademyVO [academy=");
        builder.append(academy);
        builder.append("]");
        return builder.toString();
    }

}
