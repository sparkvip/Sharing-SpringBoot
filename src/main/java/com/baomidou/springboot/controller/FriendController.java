package com.baomidou.springboot.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.entity.Friend;
import com.baomidou.springboot.entity.LoginInfo;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/friend")
public class FriendController extends ApiController {
    @Autowired
    private IUserService userService;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Object> login(Users user) {
        List<Users> list = userMapper.selectListByWrapper(new QueryWrapper<Users>().eq("name", user.getName()));
        int count = list.size();
        if (count == 1) {
            Friend friend = new Friend();
            friend.setUsera(user.getId() + "");
            friend.setUserb(list.get(0).getId() + "");
            // 查询是否已经是好友关系,正反都需要查
            Friend friend1 = friendMapper.selectOne(new QueryWrapper<Friend>().eq("usera", friend.getUsera()).eq("userb", friend.getUserb()));
            Friend friend2 = friendMapper.selectOne(new QueryWrapper<Friend>().eq("userb", friend.getUsera()).eq("usera", friend.getUserb()));
            if (friend1 != null) {
                if (friend1.getStatus() == 2) {
                    // 表示好友请求已经发送，但是没有成为好友关系
                    return ResponseUtil.returnObj("2", HttpStatus.OK);
                } else if (friend1.getStatus() == 1) {
                    // 表示已经是好友关系
                    return ResponseUtil.returnObj("1", HttpStatus.OK);
                } else {
                    friend1.setStatus(2);
                    friend1.updateById();
                    return ResponseUtil.returnObj("ok", HttpStatus.OK);
                }
            }else if(friend2 != null){
                if (friend2.getStatus() == 2) {
                    // 表示好友请求已经发送，但是没有成为好友关系
                    return ResponseUtil.returnObj("2", HttpStatus.OK);
                } else if (friend2.getStatus() == 1) {
                    // 表示已经是好友关系
                    return ResponseUtil.returnObj("1", HttpStatus.OK);
                } else {
                    friend2.setStatus(2);
                    friend2.updateById();
                    return ResponseUtil.returnObj("ok", HttpStatus.OK);
                }
            }
            friend.insert();
            return ResponseUtil.returnObj("ok", HttpStatus.OK);
        } else {
            return ResponseUtil.returnObj("error", HttpStatus.BAD_GATEWAY);
        }
    }

    /**
     * 查询请求列表
     * @param user
     * @return
     */
    @PostMapping("/query/request")
    @ResponseBody
    public ResponseEntity<Object> queryRequest(@RequestBody  Users user) {
        List<UsersDto> usersDtos = friendMapper.queryRequest(user);
        return ResponseUtil.returnObj(usersDtos, HttpStatus.OK);
    }

    /**
     * 查询我的好友
     * @param user
     * @return
     */
    @PostMapping("/query/friend")
    @ResponseBody
    public ResponseEntity<Object> queryFriend(@RequestBody  Users user) {
        List<UsersDto> usersDtos = friendMapper.queryFriend(user);
        return ResponseUtil.returnObj(usersDtos, HttpStatus.OK);
    }

    @PostMapping("/agree")
    @ResponseBody
    public ResponseEntity<Object> agree(@RequestBody  List<Users> users) {
        Friend friend = new Friend();
        for (Users user:users){
            friend.setId(user.getId());
            friend.setStatus(1);
            friend.updateById();
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }
    @PostMapping("/reject")
    @ResponseBody
    public ResponseEntity<Object> reject(@RequestBody  List<Users> users) {
        Friend friend = new Friend();
        for (Users user:users){
            friend.setId(user.getId());
            friend.setStatus(0);
            friend.updateById();
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }
    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Object> remove(@RequestBody  List<Users> users) {
        Friend friend = new Friend();
        for (Users user:users){
            friend.setId(user.getId());
            friend.deleteById();
        }
        return ResponseUtil.returnObj("ok", HttpStatus.OK);
    }
}
