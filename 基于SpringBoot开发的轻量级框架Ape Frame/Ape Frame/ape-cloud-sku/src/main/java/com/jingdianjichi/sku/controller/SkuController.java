package com.jingdianjichi.sku.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SkuController {

    @GetMapping("/test")
    public String test() {
        return "Hello Sku World";
    }


    @GetMapping("/testTimeout")
    public String testTimeout() throws InterruptedException {
        Thread.sleep(3000);
        return "Hello Sku World timeOut!";
    }

    @GetMapping("/testHystrix")
    public String testHystrix() {
        return "Hello Hystrix";
    }

    @GetMapping("/testHystrixTimeout")
    @HystrixCommand(fallbackMethod = "testHystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String testHystrixTimeout()  throws InterruptedException{
        Thread.sleep(5000);
        return "Hello Hystrix timeOut!";
    }

    public String testHystrixTimeoutHandler(){
        return "接口降级啦！！！!";
    }


}
