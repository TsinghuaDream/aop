package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect1 {
    @DeclareParents(value = "com.example.aop.aop.UserServiceImpl+",defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;
    @Pointcut("execution(* com.example.aop.aop.UserServiceImpl.printUser(..))")
    public void poinCut(){}
    @Before("poinCut()&&args(user)")
        public void before(JoinPoint point,User user){
            Object[] args = point.getArgs();
            System.out.println(args[0]+"before...");
        }
    @After("poinCut()")
    public void after(){
        System.out.println("after ...");
    }
    @AfterReturning("poinCut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
    @AfterThrowing("poinCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing ...");
    }
    @Around("poinCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before ...");
        joinPoint.proceed();
        System.out.println("around after ...");
    }
}
