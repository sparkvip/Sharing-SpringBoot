package com.baomidou.springboot.entity;

import com.baomidou.springboot.utils.ResponseUtil;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 登录验证返回信息
 *
 * @author jin.li05@hand-china.com
 * @version 1.0
 * @ClassName LoginInfo
 * @description
 * @date 2019/4/28 10:51
 * @since JDK 1.8
 */
@Data
@SuppressWarnings("serial")
public class LoginInfo {
    public static String STATUS_OK = "ok";
    public static String STATUS_ERROR = "error";

    // 用户id
    String  userId;

    String userName;

    // 状态，成功或失败
    String status;

    // 登陆类型
    String type;

    // 当前认证级别
    String currentAuthority;

    public LoginInfo() {
    }

    public LoginInfo(String userId, String userName, String status, String type, String currentAuthority) {
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.type = type;
        this.currentAuthority = currentAuthority;
    }

    public ResponseEntity<Object> ResponseLoginInfo() {
        return ResponseUtil.returnObj(this, HttpStatus.OK);
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", currentAuthority='" + currentAuthority + '\'' +
                '}';
    }
}
