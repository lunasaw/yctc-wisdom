package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.UserDO;

public class StudentDOAndAcademyAndClassesVO {

    /** studentDO */
    private UserDO studentDO;
    /** 学院 */
    private String academy;
    /** 班级 */
    private String classes;

    public UserDO getStudentDO() {
        return studentDO;
    }

    public void setStudentDO(UserDO studentDO) {
        this.studentDO = studentDO;
    }

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
        builder.append("StudentDOAndAcademyAndClassesVO [studentDO=");
        builder.append(studentDO);
        builder.append(", academy=");
        builder.append(academy);
        builder.append(", classes=");
        builder.append(classes);
        builder.append("]");
        return builder.toString();
    }
}
