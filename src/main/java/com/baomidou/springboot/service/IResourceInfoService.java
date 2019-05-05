package com.baomidou.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.springboot.entity.ResourceInfo;

import java.util.List;


/**
 * (ResourceInfo)资源明细表服务接口
 *
 * @author zhanhua.cheng
 * @since 2019-04-14 18:10:09
 */
public interface IResourceInfoService extends IService<ResourceInfo> {
    /*
     * queryAll : 查询所有资源
     *
     * @version 1.0
     * @date 2019/4/30 14:36
     * @param
     * @return void
     * @since JDK 1.8
     */
    List<ResourceInfo> queryAll();
}