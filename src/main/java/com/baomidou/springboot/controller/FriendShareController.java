package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.entity.Friend;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.entity.UsersDto;
import com.baomidou.springboot.mapper.FriendMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IUserService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend/share")
public class FriendShareController extends ApiController {
    @Autowired
    private IUserService userService;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询列表
     * @param user
     * @return
     */
    @PostMapping("/query")
    @ResponseBody
    public ResponseEntity<Object> queryRequest(@RequestBody  Users user) {
        List<UsersDto> usersDtos = friendMapper.queryRequest(user);
        return ResponseUtil.returnObj(usersDtos, HttpStatus.OK);
    }


}
