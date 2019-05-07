package com.yibazhang.provider.enumtype;

public enum HomeWorkStatusEnum implements BaseEnum<HomeWorkStatusEnum,Integer> {
    /**
     * 作业状态（0：已上传；1：已发放；2：已结束；3：已删除）
     */


    /**
     * 0    - >   已上传
     */
    HAS_UPLOADED(0,"已上传"),

    /**
     * 1   - >  已发放
     */

    HAS_PUBLICED(1,"已发放"),

    /**
     * 2   -  > 已结束
     */
    HAS_FINISHED(2,"已结束"),

    /**
     * 3  -  >  已删除
     */

    HAS_DELETED(3,"已删除")
    ;

    Integer value;

    String key;

    HomeWorkStatusEnum(Integer value,String key){
        this.value=value;
        this.key=key;
    }
    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return key;
    }

    public static HomeWorkStatusEnum valueOf(Integer value){
        if(value==null)return null;
        for (HomeWorkStatusEnum h:
             HomeWorkStatusEnum.values()) {
            if(h.getValue().equals(value))return h;
        }

        return null;
    }
}
