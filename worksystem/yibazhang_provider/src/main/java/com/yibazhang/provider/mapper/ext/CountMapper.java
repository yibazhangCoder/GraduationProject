package com.yibazhang.provider.mapper.ext;

import java.util.List;

/**
 * @Author 一巴掌
 * @Date 2019/4/23 13:21
 * @Description TODO
 * @Version 1.0
 **/
public interface CountMapper {


    /**
     * 作业最差排行
     * @param tId
     * @return
     */
    List<String> selectCommentTOPASC(Integer tId);

    /**
     * 作业最好排行
     * @param tId
     * @return
     */
    List<String> selectCommentTOPDESC(Integer tId);
}
