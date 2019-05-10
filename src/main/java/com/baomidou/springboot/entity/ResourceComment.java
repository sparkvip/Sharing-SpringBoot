package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "resource_comment")
@Data
@SuppressWarnings("serial")
public class ResourceComment extends SuperEntity<ResourceComment> {

    private String resourceId;

    private String author;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date datetime;

    private String avatar;

    private String grade;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private static final long serialVersionUID = 1L;

}