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
        //我用台式机对代码进行了修改
        //我用了Git进行了代码的更改
        //我尽兴了代码混合
        //java必须要运行一个应用，这个应用必须要又springbootapplication的注解
        SpringApplication.run(HelloAppliction.class,args);
    }
}
