package com.baomidou.springboot.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.entity.Users;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends IService<Users> {

	boolean deleteAll();
//
//	public List<User> selecstListBySQL();
//s
	public List<Users> selectListByWrapper(Wrapper wrapper);
}