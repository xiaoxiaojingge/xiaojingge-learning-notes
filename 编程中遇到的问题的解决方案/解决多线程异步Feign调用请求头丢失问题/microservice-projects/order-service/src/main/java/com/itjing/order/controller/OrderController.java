package com.itjing.order.controller;

import com.google.common.collect.Lists;
import com.itjing.order.entity.Order;
import com.itjing.order.util.RequestContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: 订单控制器
 * @Author: lijing
 * @CreateTime: 2023-02-01 14:40
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     * 用户订单列表
     *
     * @param userId
     * @return 这里的返回值只是为了测试，实际开发请封装统一结果类
     */
    @GetMapping("/list/{userId}")
    public List<Order> orderList(@PathVariable("userId") Long userId) {
        Map<String, String> headerMap = RequestContextUtil.getHeaderMap();
        log.info("headerMap->{}", headerMap);
        List<Order> orders = Lists.newArrayList(
                new Order(1L, "1234"),
                new Order(2L, "5678")
        );
        return orders;
    }
}
