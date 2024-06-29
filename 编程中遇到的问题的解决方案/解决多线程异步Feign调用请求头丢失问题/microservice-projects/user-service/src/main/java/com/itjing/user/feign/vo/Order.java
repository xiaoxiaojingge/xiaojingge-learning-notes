package com.itjing.user.feign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 订单实体类
 * @Author: lijing
 * @CreateTime: 2023-02-01 15:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;

    private String orderNo;

}
