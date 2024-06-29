package com.itjing.user.context;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @description: 请求头上下文
 * @author: lijing
 * @date: 2023-02-03 20:44
 */
@Slf4j
public class RequestHeaderHandler {

    public static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new ThreadLocal<>();

    public static void setHeaderMap(Map<String, String> headerMap) {
        THREAD_LOCAL.set(headerMap);
    }

    public static Map<String, String> getHeaderMap() {
        return THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }


}