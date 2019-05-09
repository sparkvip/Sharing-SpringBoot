package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.CodeName;
import com.baomidou.springboot.mapper.CodeNameMapper;
import com.baomidou.springboot.service.ICodeNameService;
import com.baomidou.springboot.service.IResourceInfoService;
import com.baomidou.springboot.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jin.li05@hand-china.com
 * @version 1.0
 * @ClassName CodeNameController
 * @description
 * @date 2019/5/7 15:36
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/code")
public class CodeNameController {
    @Autowired
    private ICodeNameService service;

    @PostMapping("/query")
    public ResponseEntity<Object> test( String code ) {
        List<CodeName> query = service.query(code);
        return ResponseUtil.returnObj(query,HttpStatus.OK) ;
    }
}
