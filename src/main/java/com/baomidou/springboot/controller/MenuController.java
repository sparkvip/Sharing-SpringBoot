package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.entity.LoginInfo;
import com.baomidou.springboot.entity.Menu;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.mapper.MenuMapper;
import com.baomidou.springboot.service.IUserService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/menu")
public class MenuController extends ApiController {
    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/query")
    @ResponseBody
    public ResponseEntity<Object> login(String userId) {
        List<Menu> menus = menuMapper.queryMenus(userId);
        return ResponseUtil.returnObj(menus,HttpStatus.OK);
    }


}
