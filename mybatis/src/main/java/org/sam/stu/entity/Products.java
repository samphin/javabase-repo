package org.sam.stu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

/**
 * 商品表
 */
@Setter
@Getter
public class Products {

    @Id
    private int id;

    private String productName;

    private String productCode;

    private String productType;

}
