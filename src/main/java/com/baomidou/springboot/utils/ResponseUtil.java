package com.baomidou.springboot.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author jin.li05@hand-china.com
 * @version 1.0
 * @ClassName ResponseUtil
 * @description
 * @date 2019/4/15 16:07
 * @since JDK 1.8
 */
public class ResponseUtil {
    public static ResponseEntity<String> returnStr(String String,HttpStatus status){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "*");
        headers.add("Access-Control-Allow-Headers:x-requested-with","content-type");
        // return ResponseEntity.ok("33")
        return new ResponseEntity<String>(String, headers, status);
    }
}
