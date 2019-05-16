package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "friend_share")
@Data
@SuppressWarnings("serial")
public class FriendShare implements Serializable {

    private String friendId;

    private String resourceId;

    private Date deadLine;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private static final long serialVersionUID = 1L;

}