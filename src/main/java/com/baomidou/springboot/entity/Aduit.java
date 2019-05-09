package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@TableName(value = "aduit")
@Data
@SuppressWarnings("serial")
public class Aduit extends SuperEntity<Aduit> {

    private Long userId;

    private Long infoId;

    private Date createTime;

    private Date uploadTime;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private static final long serialVersionUID = 1L;

}