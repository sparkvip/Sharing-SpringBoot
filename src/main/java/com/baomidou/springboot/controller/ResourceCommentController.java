package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.ResourceComment;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.mapper.ResourceCommentMapper;
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

import java.sql.Date;
import java.util.List;

/**
 * (ResourceInfo)资源审批表
 *
 * @author jin.li05@hand-china.com
 * @since 2019-04-14 18:10:09
 */
@RestController
@RequestMapping("/comment")
public class ResourceCommentController {
    @Autowired
    private ResourceCommentMapper mapper ;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(ResourceComment comment) {
        comment.setDatetime(new Date(System.currentTimeMillis()));
        return ResponseUtil.returnObj(comment.insert(), HttpStatus.OK);
    }

    @PostMapping("/query")
    public ResponseEntity<Object> query(ResourceInfo info) {
        List<ResourceComment> resourceComments = mapper.selectByResId(info);
        return ResponseUtil.returnObj(resourceComments, HttpStatus.OK);
    }

}