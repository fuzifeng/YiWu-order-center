package com.yiwu.order_center_server.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class DaoAspect {

    @Around("daoAroundLog()")
    public Object logDao(ProceedingJoinPoint point) throws Throwable {
        long t1 = System.currentTimeMillis();

        String name = "-";
        String targetMethodParams= "-";
        try {
            name = point.getSignature().toShortString();
            targetMethodParams = Arrays.toString(point.getArgs());
            return point.proceed();
        }  catch (Throwable throwable) {
            log.error(throwable.getMessage());
            throw throwable;
        } finally {
            long t2 = System.currentTimeMillis();
            log.info("mysql time log, name: {}, params: {}, use time: {}ms",
                    name, targetMethodParams, (t2 - t1));

        }
    }


    @Pointcut("execution(* com.yiwu.order_center_server.dao..*(..))")
    private void daoAroundLog() {

    }
}
