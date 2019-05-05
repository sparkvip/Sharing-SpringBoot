package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.springboot.entity.ResourceInfo;
import com.baomidou.springboot.utils.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
            return ResponseUtil.returnStr("上传失败，未选择文件!", HttpStatus.OK);
        }
        if (userId == null) {
            return ResponseUtil.returnStr("未传入用户id!", HttpStatus.OK);
        }
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\school\\temp\\";
        File dest = new File(filePath + userId + "\\" + fileName);
        // 如果目标文件所在的目录不存在，则创建父目录
        if (!dest.getParentFile().exists()) {
            log.info("目标文件所在目录不存在，准备创建它！");
            if (!dest.getParentFile().mkdirs()) {
                log.info("创建目标文件所在目录失败！");
                return ResponseUtil.returnStr("文件路径创建失败", HttpStatus.OK);
            }
        }
        // 如果上传的文件名与已经存在的文件同名，则报错
        if (dest.exists()) {
            log.info("文件名称与已上传的文件同名，请重新上传！");
            return ResponseUtil.returnStr("文件名称与已上传的文件同名，请重新上传！", HttpStatus.OK);
        }
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return ResponseUtil.returnStr("success", HttpStatus.OK);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return ResponseUtil.returnStr("上传失败!", HttpStatus.OK);
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestBody ResourceInfo params)
            throws IOException {
        if(params==null){
            throw  new IOException("请求参数不存在");
        }
        if(!StringUtils.isNotBlank(params.getPath())){
            throw  new IOException("文件路径不存在或没有存储文件路径");
        }
        String[] split = params.getPath().split(";");
        String filePath = "E:\\school\\temp\\"+params.getUserId()+"\\"+split[0];
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires",
                "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
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
