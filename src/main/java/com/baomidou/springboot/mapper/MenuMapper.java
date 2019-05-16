package com.baomidou.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> queryMenus(String userId);
}