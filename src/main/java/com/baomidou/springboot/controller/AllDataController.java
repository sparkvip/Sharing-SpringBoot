package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.entity.AllData;
import com.baomidou.springboot.entity.Menu;
import com.baomidou.springboot.mapper.AllDataMapper;
import com.baomidou.springboot.mapper.MenuMapper;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 代码生成器，参考源码测试用例：
 * <p>
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 */
@RestController
@RequestMapping("/all")
public class AllDataController extends ApiController {

    @Autowired
    private AllDataMapper allDataMapper;
    @GetMapping("/query")
    @ResponseBody
    public ResponseEntity<Object> query() {
        AllData allData = allDataMapper.queryDownloadAndUpload();
        AllData allData_temp = allDataMapper.queryUsers();
        allData.setLoginNum(allData_temp.getLoginNum());
        return ResponseUtil.returnObj(allData,HttpStatus.OK);
    }


}
