package com.sz.gmall.config.aop;


import com.sz.gmall.to.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class DataVaildAspect {
    private static final Logger logger = LoggerFactory.getLogger(DataVaildAspect.class);

    @Around("execution( * com.sz.gmall..*Controller.*(..))")
    public Object vaildAround(ProceedingJoinPoint point) throws Throwable {
        Object proceed = null;

        logger.info("{}->参数校验开始工作....", point.getThis());
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bResult = (BindingResult) arg;
                if (bResult.getErrorCount() > 0) {
                    //框架自动化检测到错误
                    logger.info("{}->框架自动化检测到错误....", bResult.getFieldErrors());
                    return new CommonResult().validateFailed(bResult);

                }
            }
        }
        logger.info("{}->准备执行目标方法", point.getSourceLocation());
        proceed = point.proceed(point.getArgs());
        logger.info("{}->执行完成，放行", point.getSourceLocation());


        return proceed;
    }

}
