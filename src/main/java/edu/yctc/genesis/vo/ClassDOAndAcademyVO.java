package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassDO;

public class ClassDOAndAcademyVO {

    /** classDO */
    private ClassDO classDO;
    /** 学院 */
    private String academy;
    /** 专业 */
    private String profession;

    public ClassDO getClassDO() {
        return classDO;
    }

    public void setClassDO(ClassDO classDO) {
        this.classDO = classDO;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClassDOAndAcademyVO [classDO=");
        builder.append(classDO);
        builder.append(", academy=");
        builder.append(academy);
        builder.append(", profession=");
        builder.append(profession);
        builder.append("]");
        return builder.toString();
    }

}
