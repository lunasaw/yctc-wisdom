package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassroomDO;

public class ClassroomDOAndBuildingAndFloorVO {

    /** classroomDO */
    private ClassroomDO classroomDO;
    /** building */
    private String building;
    /** floor */
    private String floor;

    public ClassroomDO getClassroomDO() {
        return classroomDO;
    }

    public void setClassroomDO(ClassroomDO classroomDO) {
        this.classroomDO = classroomDO;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClassroomDOAndBuildingAndFloorVO [classroomDO=");
        builder.append(classroomDO);
        builder.append(", building=");
        builder.append(building);
        builder.append(", floor=");
        builder.append(floor);
        builder.append("]");
        return builder.toString();
    }
}
