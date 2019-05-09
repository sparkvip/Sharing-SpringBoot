package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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

    @PostMapping("/query")
    public ResponseEntity<String> test(String file) {
        return ResponseUtil.returnStr("ookkk", HttpStatus.OK);
    }

}