package xyz.loverbaby.impl.common.handler;


import xyz.loverbaby.api.dto.common.CommonResult;

/**
 * @Classname CallBack
 * @Description
 * @Date 2019/4/29 下午3:54
 * @Created by yccao
 */
public interface CallBack {

    /**
     * 参数校验
     */
    void check();

    /**
     * 业务逻辑
     */
    void invoke();

}
