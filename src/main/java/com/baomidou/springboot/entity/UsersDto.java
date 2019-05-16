package com.baomidou.springboot.entity;

import lombok.Data;

/**
 * 用户表
 */
@Data
public class UsersDto {
    private String id;
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

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", insititute='" + insititute + '\'' +
                ", password='" + password + '\'' +
                ", portrait='" + portrait + '\'' +
                ", privilege='" + privilege + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public UsersDto() {
    }

    public UsersDto(String id, String name, String insititute, String phone) {
        this.id = id;
        this.name = name;
        this.insititute = insititute;
        this.phone = phone;
    }
}
