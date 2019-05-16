package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.controller.FriendController;
import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.Friend;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.entity.UsersDto;
import com.baomidou.springboot.mapper.AduitMapper;
import com.baomidou.springboot.mapper.FriendMapper;
import com.baomidou.springboot.mapper.ResourceInfoMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private AduitMapper aduitMapper;

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<ResourceInfo> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<ResourceInfoDto> query(ResourceInfo params) {
        return mapper.query(params);
    }
    @Override
    public List<ResourceInfoDto> queryFriendResource(ResourceInfo params) {
        List<ResourceInfoDto> resourceInfoDtos = mapper.queryFriendResource(params);
        // 存储当前用户的好友id(包括自己)
        List<String> collect = new ArrayList<>();
        List<Friend> userb = friendMapper.selectList(new QueryWrapper<Friend>().eq("usera", params.getCurrentUserId()).eq("status","1"));
        List<Friend> usera = friendMapper.selectList(new QueryWrapper<Friend>().eq("userb", params.getCurrentUserId()).eq("status","1"));
        List<String> collect1 = userb.stream().map((item) -> {
            return item.getUserb();
        }).collect(Collectors.toList());
        List<String> collect2 = usera.stream().map((item) -> {
            return item.getUsera();
        }).collect(Collectors.toList());
        collect.addAll(collect1);
        collect.addAll(collect2);
        collect.add(params.getCurrentUserId());
        // 去除创建者不是当前用户的好友的资源
        List<ResourceInfoDto> returnList = resourceInfoDtos.stream().filter((item) -> {
            return  collect.contains(item.getUserId());
        }).collect(Collectors.toList());

        return returnList;
    }

    @Override
    public List<ResourceInfoDto> queryMy(ResourceInfo params) {
        return mapper.queryMy(params);
    }

    @Override
    public void insertResource(ResourceInfo params) {
        params.setUploadTime(new Date(System.currentTimeMillis()));
        params.setDownloadAmount(0L);
        if ("1".equals(params.getIsShared())) {
            params.setAttribute1("submit");
            // 先插入资源表
            params.insert();
            Aduit aduit = new Aduit();
            aduit.setInfoId(params.getId());
            // 设置审批人为admin用户
            aduit.setUserId(1122776702098710530L);
            aduitMapper.insert(aduit);
        }else{
            params.setAttribute1("unsubmit");
            params.insert();
        }
    }

    @Override
    public Boolean deleteResource(List<Long> ids) {
        boolean flag = this.removeByIds(ids);
        return flag;
    }

}