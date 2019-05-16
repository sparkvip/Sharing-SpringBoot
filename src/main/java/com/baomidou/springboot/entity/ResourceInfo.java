package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @description (RESOURCE_INFO)表实体类
 * @author zhanhua.cheng
 * @date 2019-04-14 18:10:08
 */
 
@TableName(value = "resource_info")
@Data
@SuppressWarnings("serial")
public class ResourceInfo extends SuperEntity<ResourceInfo>{
    /**
      资源名称 
    */
    @TableField(value = "name")
    private String name;
    
    /**
      资源类别
    */
    @TableField(value = "category")
    private String category;
    
    /**
      所属用户id
    */
    @TableField(value = "user_id")
    private String userId;

    /**
      资源存放路
    */
    @TableField(value = "path")
    private String path;
    
    /**
      下载次数
    */
    @TableField(value = "download_amount")
    private Long downloadAmount;
    
    /**
      成为推荐资源时间
    */
    @TableField(value = "upload_time")
    private Date uploadTime;
    
    /**
      资源介绍
    */
    @TableField(value = "introduction")
    private String introduction;
    
    /**
      是否是推荐资源(0/1)
    */
    @TableField(value = "is_shared")
    private String isShared;

    /**
     是否是好友共享资源(0/1)
     */
    @TableField(value = "is_friend")
    private String isFriend;

    /**
      文件后缀名
    */
    @TableField(value = "file_type")
    private String fileType;

    @TableField(value = "attribute1")
    private String attribute1;
    
    @TableField(value = "attribute2")
    private String attribute2;
    
    @TableField(value = "attribute3")
    private String attribute3;

    // 上传用户名
    @TableField(exist = false)
    private String userName;

    // 排名
    @TableField(exist = false)
    private String resourceIndex;

    // 当前用户ID
    @TableField(exist = false)
    private String currentUserId;
    
}