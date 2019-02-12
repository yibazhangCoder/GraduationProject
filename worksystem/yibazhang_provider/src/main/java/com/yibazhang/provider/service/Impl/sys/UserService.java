package com.yibazhang.provider.service.Impl.sys;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.bean.Student;
import com.yibazhang.api.bean.sys.MenuDTO;
import com.yibazhang.api.bean.sys.UserDTO;
import com.yibazhang.api.service.sys.UserApi;
import com.yibazhang.provider.domain.UserDomain;
import com.yibazhang.provider.entity.sys.SysMenu;
import com.yibazhang.provider.entity.sys.ext.SysUserExt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/6 22:13
 * @Description TODO
 * @Version 1.0
 **/

@Service(version = "${yibazhang.service.version}")
public class UserService implements UserApi {

    @Autowired
    UserDomain userDomain;

    /**
     *
     * @param userId
     * @param password
     * @return
     */
    @Override
    public UserDTO userLogin(Integer userId, String password) {
        SysUserExt sysUserExt =userDomain.checkUser(userId,password);
        if (sysUserExt==null)return null;
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(sysUserExt,userDTO);
        return userDTO;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<MenuDTO> getUserMenu(Integer userId) {
        List<SysMenu> list = userDomain.findUserMenu(userId);
        if(list==null)return null;
        List<MenuDTO> menuDTOList = querySubMenu(0,list);
        return menuDTOList;
    }

    /**
     *
     * @param student
     * @return
     */
    @Override
    public Student userRegister(Student student) {
        if (student==null) return null;
        com.yibazhang.provider.entity.Student student1 = new com.yibazhang.provider.entity.Student();
        BeanUtils.copyProperties(student,student1);
        com.yibazhang.provider.entity.Student student2 = userDomain.userRegister(student1);
        Student student3 = new Student();
        BeanUtils.copyProperties(student2,student3);
        return student3;
    }


    /**
     *
     * @param parentId
     * @param list
     * @return
     */
    private List<MenuDTO> querySubMenu(Integer parentId, List<SysMenu> list){
        if(parentId==null)return null;
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for (SysMenu menu: list) {
            if (menu!=null&&parentId.equals(menu.getParentId())){
                MenuDTO menuDTO =  new MenuDTO();
                BeanUtils.copyProperties(menu,menuDTO);
                if(menu.getMenuLevel()==1)menuDTO.setSubMenuList(querySubMenu(menuDTO.getMenuId(),list));
                menuDTOList.add(menuDTO);
            }
        }
        return menuDTOList;
    }
}
