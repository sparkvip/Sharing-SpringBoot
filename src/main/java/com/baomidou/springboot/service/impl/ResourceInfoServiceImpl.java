package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.mapper.AduitMapper;
import com.baomidou.springboot.mapper.ResourceInfoMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    @Override
    public List<ResourceInfo> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<ResourceInfoDto> query(ResourceInfo params) {
        return mapper.query(params);
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
            params.insert();
            params.setAttribute1("submit");
            Aduit aduit = new Aduit();
            aduit.setInfoId(params.getId());
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