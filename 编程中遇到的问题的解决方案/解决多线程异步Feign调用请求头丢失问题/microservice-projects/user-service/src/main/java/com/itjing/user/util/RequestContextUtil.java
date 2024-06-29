package com.itjing.user.util;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @description: 请求工具类
 * @author: lijing
 * @date: 2023-02-03 20:00
 */
@Slf4j
public class RequestContextUtil {

    /**
     * 获取请求头数据
     *
     * @return key->请求头名称 value->请求头值
     */
    public static Map<String, String> getHeaderMap() {
        Map<String, String> headerMap = Maps.newLinkedHashMap();
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null) {
                return headerMap;
            }
            HttpServletRequest request = requestAttributes.getRequest();
            Enumeration<String> enumeration = request.getHeaderNames();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                String value = request.getHeader(key);
                headerMap.put(key, value);
            }
        } catch (Exception e) {
            log.error("<RequestContextUtil> 获取请求头参数失败：", e);
        }
        return headerMap;
    }

}
