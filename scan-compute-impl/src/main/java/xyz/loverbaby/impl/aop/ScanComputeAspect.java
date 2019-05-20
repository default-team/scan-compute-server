package xyz.loverbaby.impl.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.loverbaby.impl.common.enums.StatusEnum;
import xyz.loverbaby.impl.model.BaseModel;

import java.util.Date;

/**
 * @Classname ScanComputeAspect
 * @Description 业务切面
 * @Date 2019/5/20 上午10:47
 * @Created by yccao
 */
@Aspect
@Component
@Slf4j
public class ScanComputeAspect {
    /**
     * 拦截service层inset*()方法,如果方法参数中status和createDate为null都会为其附上默认值
     * 注意：该方法参数一定要继承BaseModel，否则将切面失败。
     */
    @Pointcut("execution(* xyz.loverbaby.impl.biz.manager.*Biz.insert*(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void beforeInsert(JoinPoint joinPoint) {
        try {
            Object[] params = joinPoint.getArgs();
            BaseModel baseModel = (BaseModel) params[0];
            if (baseModel.getStatus() == null) {
                baseModel.setStatus(StatusEnum.NORMAL.name());
            }
            if (baseModel.getCreateDatetime() == null) {
                baseModel.setCreateDatetime(new Date());
            }
            if (baseModel.getUpdateDatetime() == null) {
                baseModel.setUpdateDatetime(new Date());
            }
        } catch (Throwable throwable) {
            log.error("切面自动生成status&createDate失败");
        }

    }
}
