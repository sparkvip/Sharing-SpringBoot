package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @description (RESOURCE_INFO)表实体类
 * @author zhanhua.cheng
 * @date 2019-04-14 18:10:08
 */
 
@Data
@SuppressWarnings("serial")
public class ResourceInfoDto{
    private String id;
    /**
      资源名称 
    */
    private String name;
    
    /**
      资源类别
    */
    private String category;
    
    /**
      所属用户id
    */
    private String userId;

    /**
      资源存放路
    */
    private String path;
    
    /**
      下载次数
    */
    private Long downloadAmount;
    
    /**
      成为推荐资源时间
    */
    private Date uploadTime;
    
    /**
      资源介绍
    */
    private String introduction;
    
    /**
      是否是推荐资源(0/1)
    */
    private String isShared;
    
    /**
      文件后缀名
    */
    private String fileType;

    private String attribute1;
    
    private String attribute2;
    
    private String attribute3;

    // 上传用户名
    private String userName;

    // 排名
    private String resourceIndex;

    private String isFriend;
}