package com.yibazhang.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibazhang.api.service.CountApi;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/5/15 18:55
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class CountService {
    @Reference(version = "${yibazhang.service.version}",timeout = 5000)
    CountApi countApi;

    public List<String> selectCommentTOP(Integer tId,Integer type){
        return countApi.selectCommentBySort(tId,type);
    }
}
