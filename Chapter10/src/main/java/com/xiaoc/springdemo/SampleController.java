package com.xiaoc.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/12/23.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class);
    }
}
