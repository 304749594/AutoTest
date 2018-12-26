package com.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2018/12/23.
 */
@EnableScheduling
/*@ComponentScan(basePackages = {"com.course.controller"})
@MapperScan(basePackages = {"mapper"})*/
@SpringBootApplication
//@EnableAutoConfiguration
public class Application {
    private static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        Application.context=SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
