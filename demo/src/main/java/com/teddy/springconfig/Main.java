package com.teddy.springconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class Main {
    public static void main(String[] args){
        //通过java配置来实例化spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = (UserService) context.getBean("userService");

        System.out.println(userService.getUserDao());

        context.destroy();
    }
}
