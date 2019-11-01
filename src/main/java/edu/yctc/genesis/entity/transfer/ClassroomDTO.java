package edu.yctc.genesis.entity.transfer;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import edu.yctc.genesis.entity.ClassroomDO;

/**
 * classroomDO转化类
 * 
 * @author 15272
 *
 */
public class ClassroomDTO {

    /** 教室id */
    private long id;
    /** 楼号层号id */
    private long buildingFloorId;
    /** 教室号 */
    private String number;
    /** 设备id */
    private List<Long> equipmentIdList;
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

    public long getBuildingFloorId() {
        return buildingFloorId;
    }

    public void setBuildingFloorId(long buildingFloorId) {
        this.buildingFloorId = buildingFloorId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Long> getEquipmentIdList() {
        return equipmentIdList;
    }

    public void setEquipmentIdList(List<Long> equipmentIdList) {
        this.equipmentIdList = equipmentIdList;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClassroomDTO [id=");
        builder.append(id);
        builder.append(", buildingFloorId=");
        builder.append(buildingFloorId);
        builder.append(", number=");
        builder.append(number);
        builder.append(", equipmentIdList=");
        builder.append(equipmentIdList);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

    public ClassroomDTO() {
        super();
    }

    public ClassroomDTO(ClassroomDO classroomDO) {
        super();
        this.id = classroomDO.getId();
        this.buildingFloorId = classroomDO.getBuildingFloorId();
        this.number = classroomDO.getNumber();
        this.createTime = classroomDO.getCreateTime();
        this.modifyTime = classroomDO.getModifyTime();
        List<Long> idList = JSON.parseArray(classroomDO.getEquipmentId(), Long.class);
        this.equipmentIdList = idList;
    }
}
