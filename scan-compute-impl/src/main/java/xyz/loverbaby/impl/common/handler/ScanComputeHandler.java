package xyz.loverbaby.impl.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.impl.excptions.BizException;
import xyz.loverbaby.impl.common.enums.ResultCodes;

/**
 * @Classname ScanComputeHandler
 * @Description
 * @Date 2019/4/29 下午3:49
 * @Created by yccao
 */
@Slf4j
public class ScanComputeHandler {

    public static <T extends CommonResult> void execute(T result, CallBack callBack) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        String methodName = ste.getMethodName();
        String className = ste.getClassName();
        String restName = getRestName(className);
        //校验参数
        try {
            callBack.check();
        } catch (BizException e) {
            log.error("{}.{}参数异常:cause:{}", restName, methodName, e.getMessage());
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setCode(ResultCodes.PARAMETER_ERROR.getCode());
        }
        // 执行逻辑
        try {

            CommonResult invoke = callBack.invoke();
            BeanUtils.copyProperties(invoke, result);
            if (!invoke.isSuccess()) {
                log.error("{}.{}服务异常:cause:{}", restName, methodName, invoke.getMessage());
            }
        } catch (BizException e) {
            log.error("{}.{}服务异常: cause:{}", restName, methodName, e.getMessage());
            result.setCode(e.getErrCode());
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        } catch (Exception e) {
            log.error("{}.{}服务异常:cause:{}", restName, methodName, e.getMessage());
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }

    }

    private ScanComputeHandler() {
    }

    private static String getRestName(String className) {
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
