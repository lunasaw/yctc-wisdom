package edu.yctc.genesis.entity;

import java.util.Date;

public class EquipmentDO {

    /** 设备id */
    private long id;
    /** 设备号 */
    private String number;
    /** 设备名 */
    private String name;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifyTime;
    /** 视频播放地址 */
    private String video;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "EquipmentDO [id=" + id + ", number=" + number + ", name=" + name + ", createTime=" + createTime
            + ", modifyTime=" + modifyTime + ", video=" + video + "]";
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
