package edu.yctc.genesis.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.EquipmentDO;

@Mapper
public interface EquipmentDAO {

    /**
     * 插入设备
     * 
     * @param equipmentDO
     */
    public void insert(EquipmentDO equipmentDO);

    /**
     * id查找设备
     * 
     * @param id
     * @return
     */
    public EquipmentDO getEquipmentDOById(long id);

    /**
     * 更新设备信息
     * 
     * @param equipmentDO
     */
    public void update(EquipmentDO equipmentDO);

    /**
     * id删除设备
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 通过设备号获取视频地址
     * 
     * @param number
     * @return
     */
    public EquipmentDO getEquipmentDOByNumber(String number);
}
