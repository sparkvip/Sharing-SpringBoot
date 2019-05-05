package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (ResourceInfo)表Mapper接口
 *
 * @author zhanhua.cheng
 * @since 2019-04-14 18:10:25
 */
@Mapper
public interface ResourceInfoMapper extends BaseMapper<ResourceInfo> {
    // 查询推荐信息
    List<ResourceInfo> queryAll();
}