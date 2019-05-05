package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.mapper.ResourceInfoMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 资源明细表服务接口
 *
 * @author jin.li05@hand-china.com
 * @version 1.0
 * @date 2019/4/14 18:16
 * @param null
 * @return
 * @since JDK 1.8
 */
@Service
public class ResourceInfoServiceImpl extends ServiceImpl<ResourceInfoMapper, ResourceInfo> implements IResourceInfoService {

    @Autowired
    private ResourceInfoMapper mapper;

    @Override
    public List<ResourceInfo> queryAll() {
        return mapper.queryAll();
    }
}