package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.UserDO;

public class TeacherDOAndAcademyVO {

    /** teacherDO */
    private UserDO teacherDO;
    /** 学院 */
    private String academy;

    public UserDO getTeacherDO() {
        return teacherDO;
    }

    public void setTeacherDO(UserDO teacherDO) {
        this.teacherDO = teacherDO;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TeacherDOAndAcademyVO [teacherDO=");
        builder.append(teacherDO);
        builder.append(", academy=");
        builder.append(academy);
        builder.append("]");
        return builder.toString();
    }
}
