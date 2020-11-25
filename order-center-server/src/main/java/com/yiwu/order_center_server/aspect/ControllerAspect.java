package com.yiwu.order_center_server.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Around("daoAroundLog()")
    public Object logDao(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        methodInfo(point);
        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("interface use time: {} ms", endTime - startTime);
        }
    }

    @Pointcut("execution(* com.yiwu.order_center_server.controller..*(..))")
    private void daoAroundLog() {
    }

    private void methodInfo(ProceedingJoinPoint jp) throws NoSuchMethodException {
        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetCls=jp.getTarget().getClass();
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms=(MethodSignature)jp.getSignature();
        //获取目标方法上的注解指定的操作名称
        Method targetMethod=
                targetCls.getDeclaredMethod(
                        ms.getName(),
                        ms.getParameterTypes());
        /*RequiredLog requiredLog=
                targetMethod.getAnnotation(RequiredLog.class);
        String operation=requiredLog.value();*/
        System.out.println("targetMethod="+targetMethod);
        //获取目标方法名(目标类型+方法名)
        String targetClsName=targetCls.getName();
        String targetObjectMethodName=targetClsName+"."+ms.getName();
        //获取请求参数
        String targetMethodParams= Arrays.toString(jp.getArgs());
        log.info("targetClsName:{}, targetObjectMethodName:{}, targetMethodParams:{}",
                targetClsName, targetObjectMethodName, targetMethodParams);
    }
}
