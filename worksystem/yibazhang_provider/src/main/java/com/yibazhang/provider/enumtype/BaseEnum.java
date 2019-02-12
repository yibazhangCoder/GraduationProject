package com.yibazhang.provider.enumtype;

/**
 * @Author 一巴掌
 * @Date 2019/2/6 21:43
 * @Description TODO
 * @Version 1.0
 **/
public interface BaseEnum<E extends Enum<?>,T> {

    /**
     *
     * @return
     */
    T getValue();

    /**
     *
     * @return
     */
    String getDisplayName();
}
