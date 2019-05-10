package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.mapper.ResourceInfoMapper;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (ResourceInfo)资源审批表
 *
 * @author jin.li05@hand-china.com
 * @since 2019-04-14 18:10:09
 */
@RestController
@RequestMapping("/aduit")
public class AduitController {

    @Autowired
    private IResourceInfoService iResourceInfoService;

    @Autowired
    private  ResourceInfoMapper resourceInfoMapper;


    @PostMapping("/query")
    public ResponseEntity<Object> query(@RequestBody Aduit aduit) {
        List<ResourceInfoDto> resourceInfoDtos = resourceInfoMapper.queryAduit(aduit);
        return ResponseUtil.returnObj(resourceInfoDtos, HttpStatus.OK);
    }

    @PostMapping("/agree")
    public ResponseEntity<Object> agree(@RequestBody List<ResourceInfo> resourceInfos) {
        Aduit aduit = new Aduit();
        for (ResourceInfo item :resourceInfos) {
            item.setAttribute1("agree");
            resourceInfoMapper.updateById(item);
            aduit.setId(item.getId());
            aduit.delete(new QueryWrapper().eq(true,"info_id",item.getId()));
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }

    @PostMapping("/reject")
    public ResponseEntity<Object> reject(@RequestBody List<ResourceInfo> resourceInfos) {
        Aduit aduit = new Aduit();
        for (ResourceInfo item :resourceInfos) {
            item.setAttribute1("reject");
            resourceInfoMapper.updateById(item);
            aduit.setId(item.getId());
            aduit.delete(new QueryWrapper().eq(true,"info_id",item.getId()));
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }
}