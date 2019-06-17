package org.sam.stu.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SecUser implements Serializable{
	
	private String userId;

    private String userName;

    private String password;

    private String realName;

    private Long sex;

    private Short age;

    private String idCard;

    private Date birthday;

    private String place;

    private String telephone;

    private String email;

    private String address;

    private Integer isSuperAdmin;

    private Integer status;

    private Date enabledTime;

    private Date invalidTime;

    private String credentialsSalt;

    private String remark;

    private String createUserId;

    private Date createTime;

    private String lastUpdateUserId;

    private Date lastUpdateTime;

	private static final long serialVersionUID = 1L;
}