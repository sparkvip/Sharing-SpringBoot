package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@TableName(value = "code_name")
@Data
@SuppressWarnings("serial")
public class CodeName  extends SuperEntity<CodeName> {

    /**
     * 编码
     */
    private String code;

    /**
     * 编码名称
     */
    private String name;

    /**
     * 父级编码
     */
    private String parentCode;

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

}