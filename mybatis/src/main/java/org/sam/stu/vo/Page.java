package org.sam.stu.vo;

import lombok.Data;

/**
 * 翻页对象
 */
@Data
public class Page {

    private int startRow;

    private int pageSize;

    private int total;

    private int totalPage;

}
