package xyz.loverbaby.api.dto.common;

import lombok.Data;

/**
 * @Classname CommonResult
 * @Description 统一结果
 * @Date 2019/5/17 上午9:41
 * @Created by yccao
 */
@Data
public class CommonResult <T>{

    private boolean success;
    private T data;
    private String code;
    private String message;
    private Exception exception;

    public boolean isSuccess() {
        return this.success;
    }
}
