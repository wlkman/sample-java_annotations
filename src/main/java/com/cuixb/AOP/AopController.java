package com.cuixb.AOP;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping("/test")
    public String testAop(String key){
        return "testAop: key = " + key;
    }

    @RequestMapping("testAfterThrowing")
    public String testAfterThrowing(String key){
        throw new NullPointerException(key);
    }


    @RequestMapping("/testAround")
    public String testAround(String key){
        return "环绕通知：key = " + key;
    }
}