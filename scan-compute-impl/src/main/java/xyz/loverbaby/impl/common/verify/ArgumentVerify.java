package xyz.loverbaby.impl.common.verify;


import xyz.loverbaby.impl.excptions.BizException;

/**
 * @Classname ArgumentVerify
 * @Description 参数校验器
 * @Date 2019/4/29 下午4:55
 * @Created by yccao
 */
public class ArgumentVerify {
    /**
     * 语义：如果不满足条件，则抛出异常。
     * @param expect
     * @param msg
     */
    public static void assertParam(boolean expect, String msg){
        if (!expect){
            throw BizException.build(msg);
        }
    }
}
