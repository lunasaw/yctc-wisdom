package edu.yctc.genesis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.yctc.genesis.entity.PermissionUserDO;

@Mapper
public interface PermissionUserDAO {

    /**
     * 插入用户权限信息
     * 
     * @param permissionUserDO
     */
    public void insert(PermissionUserDO permissionUserDO);

    /**
     * id查询权限
     * 
     * @param id
     * @return
     */
    public PermissionUserDO getPermissionUserDOById(long id);

    /**
     * 更新用户权限
     * 
     * @param permissionUserDO
     */
    public void update(PermissionUserDO permissionUserDO);

    /**
     * id删除用户权限
     * 
     * @param id
     */
    public void deleteById(long id);

    /**
     * 用户id返回权限id
     * 
     * @param permissionGroupId
     * @return
     */
    public List<Long> getPermissionIdByUserId(long userId);

    /**
     * 用户id和权限id查询表中该条记录
     * 
     * @param userId
     * @param permissionId
     * @return
     */
    public PermissionUserDO getPermissionUserDOIdByBothId(long userId, long permissionId);

}
