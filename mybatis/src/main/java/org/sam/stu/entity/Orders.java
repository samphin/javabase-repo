package org.sam.stu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

/**
 * 商品表
 */
@Setter
@Getter
public class Orders {

    @Id
    private String id;

    private String orderCode;

    private String useCode;

    private Double price;

    private Date orderTime;

    private String userId;

}
