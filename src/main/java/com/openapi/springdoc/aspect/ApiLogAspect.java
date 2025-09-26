package com.openapi.springdoc.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openapi.springdoc.annotation.ApiLog;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class ApiLogAspect {
//    private static final Logger log = LogManager.getLogger(ApiLogAspect.class);

    private final ObjectMapper objectMapper;

    public ApiLogAspect(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //切入点：所有标记了@ApiLog的方法
    @Pointcut("@annotation(com.openapi.springdoc.annotation.ApiLog)")
    public void apiLogPointCut(){}

    @Around("apiLogPointCut()")
    public Object aroundApiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取使用注解的方法名
        String methodName = methodSignature.getMethod().getName();

        //获取方法上的@ApiLog注解
        ApiLog apiLog = methodSignature.getMethod().getAnnotation(ApiLog.class);
        String desc = apiLog != null ? apiLog.value() : "";
        if (apiLog != null) {
            String annoatationClassName = apiLog.annotationType().getName();
            String annotationSimpleName = apiLog.annotationType().getSimpleName();
        }

        //获取当前切片名
        String aspectName = this.getClass().getSimpleName();

        //获取目标方法所在类（接口或实现类）
        Class<?> targetClass = methodSignature.getDeclaringType();
        String classFullName = targetClass.getName();

        //获取方法参数
        String args = objectMapper.writeValueAsString(joinPoint.getArgs());
        //动态创建Logger
        Logger targetLogger = LogManager.getLogger(targetClass);
        targetLogger.info(":Aspect:{}, 调用接口:{} {}, 参数:{}, 描述:{}",
                aspectName, classFullName, methodName, args, desc);

        Object result;
        long startTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            targetLogger.info("调用结束:{}, 返回值:{}, 耗时:{}, 描述:{}",
                    methodName, objectMapper.writeValueAsString(result), endTime - startTime, desc);
        }catch (Exception ex){
            targetLogger.error("接口调用异常:{}, 参数:{}, 描述:{}",
                    methodName, args, desc, ex);
            throw ex;
        }
        return result;
    }
}
