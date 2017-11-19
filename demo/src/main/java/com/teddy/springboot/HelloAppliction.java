package com.teddy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

@Controller//是一个springmvc中handler
@SpringBootApplication//是springboot
@Configuration//自身是一个配置
public class HelloAppliction {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    public static void main(String[] args){
        //我是1.0版本12
        SpringApplication.run(HelloAppliction.class,args);
    }
}
