package com.yibazhang.api.service.sys;

import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.MenuDTO;
import com.yibazhang.api.bean.sys.UserDTO;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/6 20:41
 * @Description TODO
 * @Version 1.0
 **/
public interface UserApi {

    /**
     * 用户登录接口
     * @param userId
     * @param password
     * @return 成功返回用户信息失败返回Null
     */
    UserDTO userLogin(Integer userId,String password);

    /**
     * 获取当前用户的菜单
     * @param userId
     * @return
     */
    List<MenuDTO> getUserMenu(Integer userId);

    /**
     * 用户注册 但是注册的用户只能是学生
     * @param student
     * @return
     */
    Student userRegister(Student student);
}
