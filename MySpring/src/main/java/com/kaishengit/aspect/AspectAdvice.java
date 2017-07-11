package com.kaishengit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
@Component
@Aspect
public class AspectAdvice {

    @Pointcut("execution(* com.kaishengit.service..*.*(..))")
    public void pointcut(){}

   /* @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        Object result = null;
        try {
            System.out.println("around before");
            result = proceedingJoinPoint.proceed();//代表目标对象方法的执行
            System.out.println("around after returning " + result);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around throwing");
        }finally{
            System.out.println("around after");
        }

        return result;

    }
*/

    @Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("前置...通知...");
    }

    @AfterReturning(pointcut="pointcut()",returning="result")
    public void afterReturningAdvice(Object result) {
        System.out.println("后置通知：" + result);
    }

    @AfterThrowing(pointcut="pointcut()",throwing="ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("异常通知" + ex.getMessage());
    }

    @After("pointcut()")
    public void afterAdvice() {
        System.out.println("最终通知");
    }


}
