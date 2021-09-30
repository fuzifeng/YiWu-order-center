package com.yiwu.order_center_server.controller;

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.service.MsUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/upload")
@Api(tags="图片上传功能")
public class UploadController {
    @Autowired
    private MsUploadService uploadService;

    @ApiOperation(value = "图片上传接口（单个file格式）", notes = "")
    @PostMapping(value = "/pic")
    public Resp uploadImage(@RequestParam(value = "file") MultipartFile file,
                            HttpServletRequest request) throws Exception {

        if (file.isEmpty()) {
            return Resp.error("sad");
        }
        String realPath = request.getSession().getServletContext().getRealPath("");
        System.out.println(realPath);
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        System.out.println(requestURL);
        System.out.println(requestURI);


        return Resp.success(uploadService.uploadImg(file,request));
//        return Resp.success();
    }
//
//    @ApiOperation(value="图片上传（base64格式）", notes="图片base64流必须以data:image/jpg;base64,data:image/png;base64data:image/jpeg;base64等开头")
//    @PostMapping(value = "/base64")
//    public Result uploadBase64Image(@RequestParam(value="img")String base64Str) throws Exception{
//        String suffixName ="";
//        if (StringUtils.isEmpty(base64Str)) {
//            return Result.error(400,"file不能为空");
//        } else if (base64Str.indexOf("data:image/png;") != -1) {
//            base64Str = base64Str.replace("data:image/png;base64,", "");
//            suffixName = ".png";
//        } else if (base64Str.indexOf("data:image/jpeg;") != -1) {
//            base64Str = base64Str.replace("data:image/jpeg;base64,", "");
//            suffixName = ".jpeg";
//        } else if (base64Str.indexOf("data:image/jpg;") != -1) {
//            base64Str = base64Str.replace("data:image/jpg;base64,", "");
//            suffixName = ".jpg";
//        }
//        else {
//            return Result.error(400,"请选择.png.jpg格式的图片");
//        }
//        byte[] fileBytes = Base64.getDecoder().decode(base64Str);
//        return Result.success(uploadService.upload(suffixName,fileBytes));
//    }
//
//    @ApiOperation(value="图片上传（批量）（base64格式）", notes="图片base64流必须以data:image/jpg;base64,data:image/png;base64data:image/jpeg;base64等开头")
//    @PostMapping(value = "/base64Batch")
//    public Result uploadBase64ImageBatch(@RequestBody BatchImageInfo batchImageInfo) throws Exception{
//        List<String> imageList = batchImageInfo.getImageList();
//        if(null==imageList||imageList.size()==0){
//            return Result.error(400,"请选择.png.jpg格式的图片");
//        }
//        if(batchImageInfo.getImageCount()>20){
//            return Result.error(400,"批量上传图片数量太大");
//        }
//        if(imageList.size()!=batchImageInfo.getImageCount()){
//            return Result.error(400,"图片数量不一致");
//        }
//        Map<String,String> result = new HashMap<>();
//        for (int i=0;i<imageList.size();i++) {
//            String base64Str = imageList.get(i);
//            String suffixName ="";
//            if (StringUtils.isEmpty(base64Str)) {
//                result.put(i+"","file不能为空");
//            } else if (base64Str.indexOf("data:image/png;") != -1) {
//                base64Str = base64Str.replace("data:image/png;base64,", "");
//                suffixName = ".png";
//            } else if (base64Str.indexOf("data:image/jpeg;") != -1) {
//                base64Str = base64Str.replace("data:image/jpeg;base64,", "");
//                suffixName = ".jpeg";
//            } else if (base64Str.indexOf("data:image/jpg;") != -1) {
//                base64Str = base64Str.replace("data:image/jpg;base64,", "");
//                suffixName = ".jpg";
//            }
//            else {
//                result.put(i+"","请选择.png.jpg格式的图片");
//            }
//            byte[] fileBytes = Base64.getDecoder().decode(base64Str);
//            result.put(i+"",uploadService.upload(suffixName,fileBytes));
//        }
//        return Result.success(result);
//    }

}
