package org.sam.stu.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单商品关联表
 */
@Setter
@Getter
public class OrderProduct {

    private String orderId;

    private String productId;
}
