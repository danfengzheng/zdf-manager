package com.zhengdf.manager.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName WebLogAspect
 * @Description TODO
 * @Author zhengdf
 * @Date 2020/1/8 18:55
 * @Version 1.0
 * @Memo
 **/
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.zhengdf.manager.admin.conf.aop.Log)")
    public void controllerLog(){
        // 该方法无方法体,主要为了让同类中其他方法使用此切入点
    }//签名，可以理解成这个切入点的一个名称

//    @Before("controllerLog()") //在切入点的方法run之前要干的
//    public void logBeforeController(JoinPoint joinPoint) {
//
//        //这个RequestContextHolder是Springmvc提供来获得请求的东西
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//
//        // 记录下请求内容
//        log.info("################URL : {}" , request.getRequestURL().toString());
//        log.info("################HTTP_METHOD : {}" , request.getMethod());
//        log.info("################IP : {}" , request.getRemoteAddr());
//        log.info("################THE ARGS OF THE CONTROLLER : {}" , Arrays.toString(joinPoint.getArgs()));
//
//        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
//        log.info("################CLASS_METHOD : {}" , joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
//        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
//
//    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("controllerLog()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
//        currentTime.set(System.currentTimeMillis());
        result = joinPoint.proceed();
//        Log log = new Log("INFO",System.currentTimeMillis() - currentTime.get());
//        currentTime.remove();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        log.info("username: {} , Browser: {} , IP: {} , joinPoint {} , log :{}",getUsername(), StringUtils.getBrowser(request), StringUtils.getIp(request),joinPoint, log);
        return result;
    }

    public String getUsername(){
        return "";
    }
}
