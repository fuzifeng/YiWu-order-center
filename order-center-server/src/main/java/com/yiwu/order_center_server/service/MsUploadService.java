package com.yiwu.order_center_server.service;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.yiwu.order_center_server.config.ManageConfig;
import com.yiwu.order_center_server.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class MsUploadService {

    @Value("${file.uploadFolder}")
    private String realBasePath;
    @Value("${file.accessPath}")
    private String accessPath;

    public String uploadImg(MultipartFile file, HttpServletRequest request) {

        String fileName = file.getOriginalFilename();  // 原始文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = "BU_" + UUID.randomUUID() + suffixName;

        //域名访问的相对路径
        String savePath = accessPath + "/";
        String realPath = realBasePath + "/";

        String filePath = realPath + fileName;
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
        System.out.println(savePath+fileName);

        return "/orderCenter/v1" + savePath + fileName;

    }



    @Autowired
    private ManageConfig manageConfig;

    public String upload(MultipartFile file, HttpServletRequest request) {

//        String aStatic = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String aStatic = request.getSession().getServletContext().getRealPath("");

        //TODO 原始文件名 获取
        String fileName = file.getOriginalFilename();  // 原始文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        if(!suffixName.equals(".jpg") && !suffixName.equals(".png")){
            throw new BusinessException(1, "");
        }

        fileName = "BU_" + UUID.randomUUID() + suffixName; // 新文件名
        String urlPath = "images" + File.separator + fileName;

        String savePath = aStatic + File.separator + urlPath;

//        String visitPath = "static/" + urlPath;
//        String filePath = manageConfig.getFileUploadPath() + fileName;
//        String filePath = aStatic +"images"+ fileName;
//        String filePath = ServletAc + fileName;
        File dest = new File(savePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(savePath);

        return savePath;
    }

    public static void main(String[] args) {
//        this.getClass().get
        String s = Class.class.getClass().getResource("/").getPath();
        System.out.println(s);
    }
}
