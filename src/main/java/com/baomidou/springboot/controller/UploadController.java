package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class UploadController extends ApiController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    // HttpServletRequest request
    public ResponseEntity<String> upload(MultipartFile file, Long userId) {
        if (file.isEmpty()) {
            return ResponseUtil.returnStr("上传失败，未选择文件!", HttpStatus.PROCESSING);
        }
        if (userId == null) {
            return ResponseUtil.returnStr("未传入用户id!", HttpStatus.PROCESSING);
        }
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\school\\temp\\";
        File dest = new File(filePath + userId + "\\" + fileName);
        if (!dest.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            log.info("目标文件所在目录不存在，准备创建它！");
            if (!dest.getParentFile().mkdirs()) {
                log.info("创建目标文件所在目录失败！");
                return ResponseUtil.returnStr("文件路径创建失败", HttpStatus.PROCESSING);
            }
        }
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return ResponseUtil.returnStr("上传成功!", HttpStatus.OK);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseUtil.returnStr("上传失败!", HttpStatus.PROCESSING);
    }

    // 多文件上传 （暂时没有用）
    @PostMapping("/multi/upload")
    public ResponseEntity<String> multiUpload(List<MultipartFile> files) {
        System.out.println("file:\n" + files + "\n\n\n\n\n");
        String filePath = "E:\\school\\temp1\\";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                String returnStr = "上传第" + (i++) + "个文件失败";
                return ResponseUtil.returnStr(returnStr, HttpStatus.PROCESSING);
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
                String returnStr = "上传第" + (i++) + "个文件失败";
                return ResponseUtil.returnStr(returnStr, HttpStatus.PROCESSING);
            }
        }
        return ResponseUtil.returnStr("上传成功", HttpStatus.OK);
    }

}
