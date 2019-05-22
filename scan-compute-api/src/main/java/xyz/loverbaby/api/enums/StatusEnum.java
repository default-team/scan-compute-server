package xyz.loverbaby.api.enums;

import java.util.Arrays;

public enum StatusEnum {

    DELETED( 0,"作废"),
    NORMAL( 1,"正常");

    private Integer code;
    private String  desc;

    StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getByCode(Integer code){
        StatusEnum statusEnum = Arrays.stream(StatusEnum.values()).filter(x -> x.code == code).findAny().orElse(null);
        if (statusEnum != null){
            return statusEnum.name();
        }
        return null;
    }
}