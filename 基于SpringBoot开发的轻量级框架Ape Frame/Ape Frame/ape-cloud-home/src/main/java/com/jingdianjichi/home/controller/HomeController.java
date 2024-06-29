package com.jingdianjichi.home.controller;

import com.jingdianjichi.home.feign.SkuFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HomeController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private SkuFeignService skuFeignService;

    private static final String GET_SKU_INFO_URL = "http://APE-CLOUD-SKU/test";

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/getSkuInfo")
    public String getSkuInfo() {
        return restTemplate.getForObject(GET_SKU_INFO_URL,String.class);
    }

    @GetMapping("/getSkuInfoV2")
    public String getSkuInfoV2() {
        return skuFeignService.test();
    }

    @GetMapping("/getSkuInfoTimeout")
    public String getSkuInfoTimeout() {
        return skuFeignService.testTimeout();
    }

    @GetMapping("/getHystrix")
    public String getHystrix() {
        return skuFeignService.testHystrix();
    }

    @GetMapping("/getHystrixTimeout")
    @HystrixCommand(fallbackMethod = "testHystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500")
    })
    public String getHystrixTimeout() {
        return skuFeignService.testHystrixTimeout();
    }

    public String testHystrixTimeoutHandler(){
        return "调用方进行主动降级！！！!";
    }


}
