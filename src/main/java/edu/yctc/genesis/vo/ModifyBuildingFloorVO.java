package edu.yctc.genesis.vo;

public class ModifyBuildingFloorVO {

    /** id */
    private long id;
    /** 楼号 */
    private String building;
    /** 楼层 */
    private String floor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        builder.append("ModifyBuildingFloorVO [id=");
        builder.append(id);
        builder.append(", building=");
        builder.append(building);
        builder.append(", floor=");
        builder.append(floor);
        builder.append("]");
        return builder.toString();
    }
}
