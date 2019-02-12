package com.yibazhang.provider.mapper.sys;

import com.yibazhang.provider.entity.sys.SysMenuRole;

public interface SysMenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuRole record);

    int insertSelective(SysMenuRole record);

    SysMenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuRole record);

    int updateByPrimaryKey(SysMenuRole record);
}