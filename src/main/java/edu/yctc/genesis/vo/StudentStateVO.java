package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.StudentStateDO;

public class StudentStateVO {

    /** 学号 */
    private String number;
    /** 姓名 */
    private String name;
    /** studentStateDO */
    private StudentStateDO studentStateDO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentStateDO getStudentStateDO() {
        return studentStateDO;
    }

    public void setStudentStateDO(StudentStateDO studentStateDO) {
        this.studentStateDO = studentStateDO;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StudentStateVO [number=");
        builder.append(number);
        builder.append(", name=");
        builder.append(name);
        builder.append(", studentStateDO=");
        builder.append(studentStateDO);
        builder.append("]");
        return builder.toString();
    }

}
