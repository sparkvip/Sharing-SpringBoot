package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.CodeName;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.mapper.CodeNameMapper;
import com.baomidou.springboot.mapper.ResourceInfoMapper;
import com.baomidou.springboot.service.ICodeNameService;
import com.baomidou.springboot.service.IResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 资源明细表服务接口
 *
 * @author jin.li05@hand-china.com
 * @version 1.0
 * @date 2019/4/14 18:16
 * @param null
 * @return
 * @since JDK 1.8
 */
@Service
public class CodeNameServiceImpl extends ServiceImpl<CodeNameMapper, CodeName> implements ICodeNameService {

    @Autowired
    private CodeNameMapper mapper;

    @Override
    public List<CodeName> query(String code) {
        return mapper.queryByCode(code);
    }
}