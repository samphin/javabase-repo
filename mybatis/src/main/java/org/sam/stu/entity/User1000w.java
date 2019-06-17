package org.sam.stu.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User1000w implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstName;

    private String lastName;

    private String sex;

    private Integer score;

    private Integer copyId;
}