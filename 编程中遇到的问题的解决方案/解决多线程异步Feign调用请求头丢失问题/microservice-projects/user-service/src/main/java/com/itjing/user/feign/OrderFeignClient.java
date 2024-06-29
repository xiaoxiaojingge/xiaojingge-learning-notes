package com.itjing.user.feign;

import com.itjing.user.feign.vo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description: 订单远程调用接口
 * @Author: lijing
 * @CreateTime: 2023-02-01 15:41
 */
@FeignClient("order-service")
public interface OrderFeignClient {

    @GetMapping("/order/list/{userId}")
    List<Order> getUserOrderList(@PathVariable("userId") Long userId);

}
