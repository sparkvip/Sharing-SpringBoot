package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.ResourceComment;
import com.baomidou.springboot.entity.ResourceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceCommentMapper  extends BaseMapper<ResourceComment> {
    List<ResourceComment> selectByResId(ResourceInfo resourceInfo);
}