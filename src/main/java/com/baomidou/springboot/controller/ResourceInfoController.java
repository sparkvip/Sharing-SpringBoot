package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (ResourceInfo)表控制层
 *
 * @author jin.li05@hand-china.com
 * @since 2019-04-14 18:10:09
 */
@RestController
@RequestMapping("/resource")
public class ResourceInfoController {

    @Autowired
    private IResourceInfoService iResourceInfoService;

    @GetMapping("/test")
    public ResponseEntity<String> test(String file) {
        System.out.println("test....:\n");
        return ResponseUtil.returnStr("ookkk", HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(ResourceInfo params) {
        iResourceInfoService.insertResource(params);
        return ResponseUtil.returnStr("插入成功", HttpStatus.OK);
    }

    // 资源推荐
    @GetMapping("/query/all")
    public ResponseEntity<Object> queryAll() {
        List<ResourceInfo> resourceInfos = iResourceInfoService.queryAll();
        return ResponseUtil.returnObj(resourceInfos, HttpStatus.OK);
    }

    // 分类搜索
    @PostMapping("/query")
    public ResponseEntity<Object> query(@RequestBody  ResourceInfo params) {
        List<ResourceInfoDto> resourceInfos = iResourceInfoService.query(params);
        return ResponseUtil.returnObj(resourceInfos, HttpStatus.OK);
    }

    // 查看我的资源
    @PostMapping("/query/my")
    public ResponseEntity<Object> queryMy(@RequestBody  ResourceInfo params) {
        List<ResourceInfoDto> resourceInfos = iResourceInfoService.queryMy(params);
        return ResponseUtil.returnObj(resourceInfos, HttpStatus.OK);
    }

    // 删除资源
    @PostMapping("/remove")
    public ResponseEntity<Object> query(@RequestBody  List<ResourceInfo> params) {
        List<Long> ids = params.stream().map((item) -> {
            return item.getId();
        }).collect(Collectors.toList());
        return ResponseUtil.returnObj(iResourceInfoService.deleteResource(ids), HttpStatus.OK);
    }
    // 好友资源共享
    @PostMapping("/share")
    public ResponseEntity<Object> share(@RequestBody  List<ResourceInfo> params) {
        for(ResourceInfo  param:params){
            param.setIsFriend("1");
            param.updateById();
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }

    // 更新资源
    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ResourceInfo params) {
        boolean flag = params.updateById();
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setUserId(params.getUserId());
        return ResponseUtil.returnObj(iResourceInfoService.query(resourceInfo), HttpStatus.OK);
    }

    // 查看好友共享资源
    @PostMapping("/query/friend/resource")
    public ResponseEntity<Object> queryFriendResource(@RequestBody  ResourceInfo params) {
        List<ResourceInfoDto> resourceInfos = iResourceInfoService.queryFriendResource(params);
        return ResponseUtil.returnObj(resourceInfos, HttpStatus.OK);
    }
}