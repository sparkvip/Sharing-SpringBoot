package com.baomidou.springboot.entity;

import java.util.Date;

import lombok.Data;

/**
 * 用户表
 */
@SuppressWarnings("serial")
@Data
public class Users extends SuperEntity<Users> {
    /**
     * 名称
     */
    private String name;
    /**
     * 学院
     */
    private String insititute;

    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String portrait;
    /**
     * 权限
     */
    private String privilege;
    /**
     * 电话
     */
    private String phone;

}
