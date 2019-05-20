package xyz.loverbaby.impl.common.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import xyz.loverbaby.api.dto.common.CommonResult;
import xyz.loverbaby.api.dto.request.BaseRequest;
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

    public static <T extends CommonResult> void execute(BaseRequest request, T result, CallBack callBack) {
        StringBuilder strBuff = new StringBuilder();
        long startTime = System.currentTimeMillis();
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        String methodName = ste.getMethodName();
        String className = ste.getClassName();
        String restName = getRestName(className);
        String serviceName = className.concat(".").concat(methodName);
        String req = JSON.toJSONString(request);
        strBuff.append("服务被调用==").append(serviceName).append(";请求数据==").append(req).append(";");
        //校验参数
        try {
            long checkStartTime = System.currentTimeMillis();
            callBack.check();
            strBuff.append("检查数据合法性耗时==").append(System.currentTimeMillis() - checkStartTime).append("ms;");
        } catch (BizException e) {
            log.error("{}.{}参数异常:cause:{}", restName, methodName, e.getMessage());
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            result.setCode(ResultCodes.PARAMETER_ERROR.getCode());
        }
        // 执行逻辑
        try {

            callBack.invoke();
            result.setCode(ResultCodes.OK.getCode());
            result.setSuccess(true);
            result.setMessage("操作成功");
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

        strBuff.append(";共耗时==").append(System.currentTimeMillis() - startTime).append("ms");
        strBuff.append(";response==" + JSON.toJSONString(result));
        log.info(strBuff.toString());

    }

    private ScanComputeHandler() {
    }

    private static String getRestName(String className) {
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
