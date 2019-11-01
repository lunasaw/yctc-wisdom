package edu.yctc.genesis.vo;

public class ModifyClassroomVO {

    /** classroomId */
    private long id;
    /** building */
    private String building;
    /** floor */
    private String floor;
    /** number */
    private String number;
    /** equipmentId */
    private String equipmentId;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ModifyClassroomVO [id=");
        builder.append(id);
        builder.append(", building=");
        builder.append(building);
        builder.append(", floor=");
        builder.append(floor);
        builder.append(", number=");
        builder.append(number);
        builder.append(", equipmentId=");
        builder.append(equipmentId);
        builder.append("]");
        return builder.toString();
    }

}
