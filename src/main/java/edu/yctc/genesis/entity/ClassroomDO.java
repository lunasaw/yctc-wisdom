package edu.yctc.genesis.entity;

import java.util.Date;

import com.alibaba.fastjson.JSON;

import edu.yctc.genesis.entity.transfer.ClassroomDTO;

public class ClassroomDO {

    /** 教室id */
    private long id;
    /** 楼号层号id */
    private long buildingFloorId;
    /** 教室号 */
    private String number;
    /** 设备id */
    private String equipmentId;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public long getBuildingFloorId() {
        return buildingFloorId;
    }

    public void setBuildingFloorId(long buildingFloorId) {
        this.buildingFloorId = buildingFloorId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClassroomDO [id=");
        builder.append(id);
        builder.append(", buildingFloorId=");
        builder.append(buildingFloorId);
        builder.append(", number=");
        builder.append(number);
        builder.append(", equipmentId=");
        builder.append(equipmentId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

    public ClassroomDO() {
        super();
    }

    public ClassroomDO(ClassroomDTO classroomDTO) {
        super();
        this.id = classroomDTO.getId();
        this.buildingFloorId = classroomDTO.getBuildingFloorId();
        this.number = classroomDTO.getNumber();
        this.createTime = classroomDTO.getCreateTime();
        this.modifyTime = classroomDTO.getModifyTime();
        String equipmentIdToString = JSON.toJSONString(classroomDTO.getEquipmentIdList());
        String idList = JSON.parseObject(equipmentIdToString, String.class);
        this.equipmentId = idList;
    }
}
