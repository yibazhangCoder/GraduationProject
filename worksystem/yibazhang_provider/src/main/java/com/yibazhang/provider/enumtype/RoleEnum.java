package com.yibazhang.provider.enumtype;

public enum RoleEnum implements BaseEnum<RoleEnum,Integer>{

    /**
     * 管理员
     */
    ADMIN_ENUM(0,"管理员"),
    /**
     * 学生
     */
    STU_ENUM(1,"学生"),

    /**
     * 教师
     */
    TEA_ENUM(2,"教师")

    ;

    Integer value;

    String name;

    RoleEnum(Integer value,String name){
        this.value=value;
        this.name=name;
    }
    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    public static RoleEnum valueOf(Integer value){
        if(value==null)return  null;

        for (RoleEnum roleEnum :RoleEnum.values()){
            if(roleEnum.getValue().equals(value))
                return roleEnum;
        }
        return null;
    }
}
