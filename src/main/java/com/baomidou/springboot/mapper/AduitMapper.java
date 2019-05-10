package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.springboot.entity.Aduit;
import com.baomidou.springboot.entity.AduitDto;
import java.util.List;

import com.baomidou.springboot.entity.CodeName;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.entity.ResourceInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AduitMapper  extends BaseMapper<Aduit> {
}