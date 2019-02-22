package com.yibazhang.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yibazhang.api.bean.AcademyDTO;
import com.yibazhang.api.bean.ClassDTO;
import com.yibazhang.api.bean.ProfessionDTO;
import com.yibazhang.api.bean.TeacherDTO;
import com.yibazhang.api.bean.ext.AcaDTOExt;
import com.yibazhang.consumer.common.BaseController;
import com.yibazhang.consumer.service.AdminService;
import com.yibazhang.consumer.utils.EnclosureJsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/15 17:56
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    AdminService adminService;

    /**
     *根据type添加信息
     * 当
     * type==0时为学院
     * type==1时为专业
     * type==2时为班级
     * @param academyDTO
     * @param type
     * @return
     */
    @RequestMapping(value = "/addAcaAnaProAndClassInfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject insertAcaAndProessInfo(AcademyDTO academyDTO, ProfessionDTO professionDTO, ClassDTO classDTO,Integer type){
        if(academyDTO==null||type==null) return fail4Param("参数为空！");
        AcaDTOExt acaDTOExt = new AcaDTOExt();
        acaDTOExt.setType(type);
        if(type==0&&academyDTO!=null){
            acaDTOExt.setAcaId(academyDTO.getAcaId());
            if(!adminService.selectAcas(acaDTOExt).isEmpty())return fail(401,"学院信息已存在");
            if (adminService.addAca(academyDTO))return success("学院信息添加成功");
        }
        if(type==1&&professionDTO!=null){
            acaDTOExt.setProfessionId(professionDTO.getProfessionId());
            if(!adminService.selectAcaAndProfess(acaDTOExt).isEmpty())return fail(401,"专业信息已从在");
            professionDTO.setProfessionAca(academyDTO.getAcaId());
            if (adminService.addProess(professionDTO))return success("专业信息添加成功");
        }
        if(type==0&&classDTO!=null){
            acaDTOExt.setCId(classDTO.getCId());
            if (!adminService.selectAcaAndProfessAndClass(acaDTOExt).isEmpty())return fail(401,"班级信息已存在");
            classDTO.setCProfession(professionDTO.getProfessionId());
            classDTO.setCAca(academyDTO.getAcaId());
            if (adminService.addClass(classDTO))return success("班级信息添加成功");
        }
        return fail(400,"信息添加失败");
    }


    @RequestMapping(value = "/addTeacher",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject insertTeacherInfo(TeacherDTO teacherDTO){
        if (teacherDTO==null)return fail4Param("参数为空！");
        if(!adminService.selectTeachers(teacherDTO).isEmpty())return fail(401,"教师信息已存在");
        if(adminService.addTeacherInfo(teacherDTO))return success("教师信息添加成功！");
        return fail(400,"信息添加失败");
    }


    @RequestMapping(value = "/selectAcaInfo",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectAcaOrProOrClass(AcaDTOExt acaDTOExt){
        if(acaDTOExt.getPage()==null)acaDTOExt.setPage(1);
        if (acaDTOExt.getLimit()==null)acaDTOExt.setLimit(5);
        PageHelper.startPage(acaDTOExt.getPage(),acaDTOExt.getLimit());
        List<Map<String,Object>> list = null;
        if(acaDTOExt.getType()==0){
            if(acaDTOExt.getSelType()!=null) {
                if (acaDTOExt.getSelType() == 0) acaDTOExt.setAcaId(Integer.parseInt(acaDTOExt.getSelVal()));
                if (acaDTOExt.getSelType() == 1) acaDTOExt.setAcaName(acaDTOExt.getSelVal());
            }
            list = adminService.selectAcas(acaDTOExt);
        }else if(acaDTOExt.getType()==1){
            if(acaDTOExt.getSelType()!=null) {
                if (acaDTOExt.getSelType() == 0) acaDTOExt.setProfessionId(Integer.parseInt(acaDTOExt.getSelVal()));
                if (acaDTOExt.getSelType() == 1) acaDTOExt.setProfessionName(acaDTOExt.getSelVal());
            }
            list = adminService.selectAcaAndProfess(acaDTOExt);
        }else {
            if(acaDTOExt.getSelType()!=null) {
                if (acaDTOExt.getSelType() == 0) acaDTOExt.setCId(Integer.parseInt(acaDTOExt.getSelVal()));
                if (acaDTOExt.getSelType() == 1) acaDTOExt.setCName(acaDTOExt.getSelVal());
            }
            list=adminService.selectAcaAndProfessAndClass(acaDTOExt);
        }
        PageInfo<Map<String,Object>> pageInfo =  new PageInfo<>(list,5);
        Long count = pageInfo.getTotal();
        List<Map<String,Object>> data = pageInfo.getList();
        return EnclosureJsonData.getJSONData(count,data);
    }

    @RequestMapping(value = "/selectTeachers",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectTeacherInfo(TeacherDTO teacherDTO){
        if (teacherDTO.getPage()==null)teacherDTO.setPage(1);
        if (teacherDTO.getLimit()==null)teacherDTO.setLimit(5);
        PageHelper.startPage(teacherDTO.getPage(),teacherDTO.getLimit());
        List<Map<String,Object>> list =adminService.selectTeachers(teacherDTO);
        PageInfo<Map<String,Object>> pageInf = new PageInfo<>(list,5);
        return EnclosureJsonData.getJSONData(pageInf.getTotal(),pageInf.getList());
    }
}
