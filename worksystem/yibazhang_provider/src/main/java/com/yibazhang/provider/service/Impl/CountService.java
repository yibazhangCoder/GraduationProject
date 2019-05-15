package com.yibazhang.provider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibazhang.api.service.CountApi;
import com.yibazhang.provider.mapper.ext.CountMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/5/15 18:47
 * @Description TODO
 * @Version 1.0
 **/
@Service(version = "${yibazhang.service.version}")
public class CountService implements CountApi {

    @Autowired
    CountMapper countMapper;

    @Override
    public List<String> selectCommentBySort(Integer tId, Integer type) {
        if(type==null||tId==null)return null;
        if(type==1)return countMapper.selectCommentTOPDESC(tId);
        if(type==0)return countMapper.selectCommentTOPASC(tId);
        return null;
    }
}
