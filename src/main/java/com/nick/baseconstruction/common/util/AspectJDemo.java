package com.nick.baseconstruction.common.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJDemo {

    @Pointcut("execution(* com.nick.baseconstruction.web.controller..*.*(..))")
    public void getPointcutMethod(){

    }

    /*@Around(value = "execution(* com.nick.baseconstruction.web.controller.package1231.OptionalController.method(..))")
    public void method1(){
        System.out.println("环绕方法！");
    }*/


    @Before(value = "getPointcutMethod()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("前置");
    }

/*    @After(value = "getPointcutMethodTwo()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("后置");
    }*/

}
