package xyz.loverbaby.impl.common.enums;


import java.util.Arrays;

/**
 * @Classname ResultCodes
 * @Description
 * @Date 2019/5/17 下午1:14
 * @Created by yccao
 */
public enum  ResultCodes {
    OK("10000","成功"),
    PARAMETER_ERROR("100001","参数错误"),
    UNKNOWN_ERROR("100002","未知错误");

    private String code;
    private String desc;


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResultCodes(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static String getByCode(String code){
        ResultCodes resultCodes = Arrays.stream(ResultCodes.values()).filter(x -> x.code.equals(code)).findAny().orElse(null);
        if (resultCodes != null){
            return resultCodes.name();
        }

        return null;
    }
}
