package com.example.aop;

import com.example.aop.aop.MyAspect;
import com.example.aop.aop.MyAspect1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//指定扫描包
@SpringBootApplication(scanBasePackages = {"com.example.aop.aop"})
public class AopApplication {
    //定义切面
    @Bean(name="myAspect")
    public MyAspect initMyAspect(){
        return new MyAspect();
    }
    @Bean(name="myAspect1")
    public MyAspect1 initMyAspect1(){
        return new MyAspect1();
    }
    //启动程序
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

}
