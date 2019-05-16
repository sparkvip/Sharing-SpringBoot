package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@TableName(value = "friend")
@Data
@SuppressWarnings("serial")
public class Friend  extends SuperEntity<Friend> {

    private String usera;

    private String userb;

    // 默认为2，同意为1，拒绝为0
    private Integer status;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private static final long serialVersionUID = 1L;

}