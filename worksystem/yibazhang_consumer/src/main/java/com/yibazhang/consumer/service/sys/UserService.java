package com.yibazhang.consumer.service.sys;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.MenuDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.api.service.sys.UserApi;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/10 23:22
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class UserService {

    @Reference(version = "${yibazhang.service.version}")
    UserApi userApi;

    public Student userRegister(Student student){
        if (student==null)return null;
        return userApi.userRegister(student);
    }


    public UserDTO userLogin(Integer userId, String password){
        if(userId==null||password==null)return null;
        return userApi.userLogin(userId,password);
    }

    public List<MenuDTO> getUserMenu(Integer userId){
        if (userId==null) return null;
        return userApi.getUserMenu(userId);
    }

}
