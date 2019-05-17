package xyz.loverbaby.impl.excptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @Classname BizException
 * @Description 业务异常
 * @Date 2019/5/17 下午1:03
 * @Created by yccao
 */
@Setter
@Getter
public class BizException extends RuntimeException{

    private String errCode;

    private String msg;

    public BizException(String errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }
    public static BizException build(String message){
       return new BizException("100001",message);
    }

}
