package com.yibazhang.consumer;

import com.yibazhang.api.bean.HomeWorkDTO;
import com.yibazhang.consumer.service.HomeWorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YibazhangConsumerApplicationTests {


    @Autowired
    HomeWorkService homeWorkService;

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        List<Long> ids = new ArrayList<>();
        ids.add(1553242839000704392l);
        map.put("ids",ids);
        List<Map<String,Object>> list = homeWorkService.getDownloadFiles(map,1);
        for (Map<String,Object> temp:
                list) {
            System.out.println(temp.get("path").toString()+temp.get("uuidName"));
        }
    }


    @Test
    public void testUpdateHomeworkStatus(){
        Map<String,Object> map = new HashMap<>();
        List<Long> ids = new ArrayList<>();
        ids.add(1553242839000704392l);
        map.put("hStatusStu",0);
        map.put("sId",1506010210);
        map.put("ids",ids);
        int i =homeWorkService.updateHomeworkStatusBatch(map,1);
        if(i>0) System.out.println("update is success!");
        else System.err.println("update is fail!");
    }

    @Test
    public void testSelectHomeworkOfStudent(){
        HomeWorkDTO homeWorkDTO = new HomeWorkDTO();
        homeWorkDTO.setSId(1506010210);
        List<Map<String,Object>> list = homeWorkService.selectHomeworkOfStudent(homeWorkDTO);
        for (Map<String,Object> map:
             list) {
            System.out.println(map.get("hId"));
        }
    }
}

