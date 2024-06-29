package com.itjing.user.controller;

import com.google.common.collect.Lists;
import com.itjing.user.context.RequestHeaderHandler;
import com.itjing.user.entity.User;
import com.itjing.user.feign.OrderFeignClient;
import com.itjing.user.feign.vo.Order;
import com.itjing.user.util.RequestContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 用户控制器
 * @Author: lijing
 * @CreateTime: 2023-02-01 14:13
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 用户列表
     *
     * @return 这里的返回值只是为了测试，实际开发请封装统一结果类
     */
    @GetMapping("/list")
    public List<User> getUserList() {
        List<User> users = Lists.newArrayList(
                new User(1L, "zs", 18),
                new User(2L, "ls", 20)
        );
        return users;
    }

    /**
     * 用户列表
     *
     * @return 这里的返回值只是为了测试，实际开发请封装统一结果类
     */
    @GetMapping("/getUserOrderList/{userId}")
    public List<Order> getUserOrderList(@PathVariable("userId") Long userId) {
        Map<String, String> headerMap = RequestContextUtil.getHeaderMap();
        log.info("headerMap->{}", headerMap);
        taskExecutor.execute(() -> {
            // 让主线程先行结束
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            RequestHeaderHandler.setHeaderMap(headerMap);
            List<Order> userOrderList = orderFeignClient.getUserOrderList(userId);
            // 清除数据，否则可能造成内存泄露
            RequestHeaderHandler.remove();
        });
        return Lists.newArrayList();
    }

}
