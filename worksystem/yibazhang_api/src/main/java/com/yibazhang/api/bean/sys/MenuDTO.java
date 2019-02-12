package com.yibazhang.api.bean.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/2/6 20:55
 * @Description 菜单
 * @Version 1.0
 **/
@Setter
@Getter
public class MenuDTO implements Serializable {

    private Integer menuId;

    private String menuName;

    private String menuHref;

    private List<MenuDTO> subMenuList;

    private Integer menuLevel;
}
