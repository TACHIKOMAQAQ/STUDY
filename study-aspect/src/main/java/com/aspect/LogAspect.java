package com.aspect;

import com.annotion.BaOperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author cyq
 * @date 2020-04-08
 */
@Aspect
@Component
public class LogAspect {

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.annotion.BaOperationLog)")
    public void controller(){}

    @AfterReturning(pointcut = "controller()",returning = "ret")
    public void doAfterReturning(Boolean ret) {
        System.out.println( "safdasfasfdsaf");
        System.out.println( ret);
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间:
     * @param joinPoint 切点
     */
    @Before("controller()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] a = joinPoint.getArgs();
        if(a.length > 0){
            if(a[0] instanceof String){
                System.out.println((String)a[0]);
                System.out.println(a[0]);
            }
        }
        System.out.println("qwe");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        BaOperationLog baOperationLog = method.getAnnotation(BaOperationLog.class);
        baOperationLog.description();
        baOperationLog.name();
//        AppLoginResVO appLoginResVO;
//        SystemControllerLogApp controllerLog = method.getAnnotation(SystemControllerLogApp.class);
//        //do before : 控制器之前执行
//        if(controllerLog != null && controllerLog.doBefore()){
//            log.info("控制器之前执行插入日志");
//            appLoginResVO = tokenUtil.getLoginUser();
//            executor.execute(new LogTask(controllerLog,appLoginResVO));
//        }
    }
}
