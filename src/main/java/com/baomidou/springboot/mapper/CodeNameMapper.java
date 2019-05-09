package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.CodeName;
import java.util.List;

import com.baomidou.springboot.entity.ResourceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CodeNameMapper extends BaseMapper<CodeName> {
    // 根据父级编码查询
    List<CodeName> queryByCode(String code);
}