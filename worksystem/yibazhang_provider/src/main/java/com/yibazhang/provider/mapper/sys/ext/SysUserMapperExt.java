package com.yibazhang.provider.mapper.sys.ext;

import com.yibazhang.provider.entity.sys.SysMenu;
import com.yibazhang.provider.entity.sys.ext.SysUserExt;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/7 13:22
 * @Description TODO
 * @Version 1.0
 **/
public interface SysUserMapperExt {

    /**
     * 检查用户和密码
     * @param userId
     * @param password
     * @return
     */
    SysUserExt checkUserPwd(Integer userId,String password);


    /**
     * 查找用户的菜单
     * @param userId
     * @return
     */
    List<SysMenu> findUserMenu(Integer userId);
}
