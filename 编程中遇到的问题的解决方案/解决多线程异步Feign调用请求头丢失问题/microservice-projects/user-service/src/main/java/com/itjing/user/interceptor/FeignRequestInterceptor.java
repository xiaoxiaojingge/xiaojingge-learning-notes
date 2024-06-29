package com.itjing.user.interceptor;

import com.itjing.user.context.RequestHeaderHandler;
import com.itjing.user.util.RequestContextUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @description: SpringCloud的微服务使用Feign进行服务间调用的时候可以使用RequestInterceptor统一拦截请求来完成设置header等相关请求
 * @author: lijing
 * @date: 2023-02-03 20:44
 */
@Slf4j
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    @SneakyThrows
    public void apply(RequestTemplate requestTemplate) {
        log.info("========================== ↓↓↓↓↓↓ <FeignRequestInterceptor> Start... ↓↓↓↓↓↓ ==========================");
        // 新增手动设置的请求头值 （主要解决多线程异步+feign调用时请求头丢失问题）
        Map<String, String> threadHeaderNameMap = RequestHeaderHandler.getHeaderMap();
        if (!CollectionUtils.isEmpty(threadHeaderNameMap)) {
            threadHeaderNameMap.forEach((headerName, headerValue) -> {
                log.info("<FeignRequestInterceptor> 多线程 headerName:[{}] headerValue:[{}]", headerName, headerValue);
                requestTemplate.header(headerName, headerValue);
            });
        }
        Map<String, String> headerMap = RequestContextUtil.getHeaderMap();
        headerMap.forEach((headerName, headerValue) -> {
            log.info("<FeignRequestInterceptor> headerName:[{}] headerValue:[{}]", headerName, headerValue);
            requestTemplate.header(headerName, headerValue);
        });
        log.info("========================== ↑↑↑↑↑↑ <FeignRequestInterceptor>  End... ↑↑↑↑↑↑ ==========================");
    }

}
