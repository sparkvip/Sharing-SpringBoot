package com.baomidou.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.Friend;
import com.baomidou.springboot.entity.ResourceComment;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.entity.UsersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendMapper  extends BaseMapper<Friend> {
    // 查询申请列表
    List<UsersDto> queryRequest(Users users);

    // 查询我的好友
    List<UsersDto> queryFriend(Users users);
}