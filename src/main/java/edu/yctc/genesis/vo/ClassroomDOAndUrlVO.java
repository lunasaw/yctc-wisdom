package edu.yctc.genesis.vo;

import edu.yctc.genesis.entity.ClassroomDO;

public class ClassroomDOAndUrlVO {

    /** classroomDO */
    private ClassroomDO classroomDO;
    /** url */
    private String url;
    /** 楼号 */
    private String building;
    /** 层号 */
    private String floor;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
        builder.append("ClassroomDOAndUrlVO [classroomDO=");
        builder.append(classroomDO);
        builder.append(", url=");
        builder.append(url);
        builder.append(", building=");
        builder.append(building);
        builder.append(", floor=");
        builder.append(floor);
        builder.append("]");
        return builder.toString();
    }

}
