package com.baomidou.springboot.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * User 表数据库控制层接口
 */
@Mapper
public interface UserMapper extends BaseMapper<Users> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    @Select("count(*) from users ")
    List<Users> selectListBySQL();

    List<Users> selectListByWrapper(@Param("ew") Wrapper wrapper);

}