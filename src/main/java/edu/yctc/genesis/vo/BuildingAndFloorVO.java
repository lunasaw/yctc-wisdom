package edu.yctc.genesis.vo;

public class BuildingAndFloorVO {

    /** 楼号 */
    private String building;
    /** 楼层号 */
    private String floor;

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
        builder.append("BuildAndFloorsVO [building=");
        builder.append(building);
        builder.append(", floor=");
        builder.append(floor);
        builder.append("]");
        return builder.toString();
    }

}
