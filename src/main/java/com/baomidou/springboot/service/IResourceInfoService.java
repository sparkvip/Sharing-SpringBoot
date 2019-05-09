package com.baomidou.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;

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
     */
    List<ResourceInfo> queryAll();

    /*
     * queryAll : 分类搜索
     */
    List<ResourceInfoDto> query(ResourceInfo params);

    /*
     * insertResource : 新增
     */
    void insertResource(ResourceInfo params);
    /*
     * deleteResource : 删除资源
     */
    Boolean deleteResource(List<Long> ids);
}