package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "*");
        headers.add("Access-Control-Allow-Headers:x-requested-with", "content-type");
        return new ResponseEntity<String>("ookkk!", headers, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(ResourceInfo params) {
        // System.out.println("params\n\n\n\n"+params);
        params.insert();
        return ResponseUtil.returnStr("okkya !呀", HttpStatus.OK);
    }
}