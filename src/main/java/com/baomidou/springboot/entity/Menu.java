package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@TableName(value = "menu")
@Data
@SuppressWarnings("serial")
public class Menu  extends SuperEntity<Menu> {

    private String path;

    private String name;

    private String icon;

    private String parentId;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private static final long serialVersionUID = 1L;

}