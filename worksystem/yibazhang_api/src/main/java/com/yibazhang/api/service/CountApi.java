package com.yibazhang.api.service;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/5/15 18:48
 * @Description TODO
 * @Version 1.0
 **/
public interface CountApi {

    /**
     * 查询作业最好和最差TOP5
     * type:1 最好
     * type:0 最差
     * @param tId
     * @param type
     * @return
     */
    List<String> selectCommentBySort(Integer tId, Integer type);
}
