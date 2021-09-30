package com.yiwu.order_center_server.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="ms")
@PropertySource("classpath:manager-config.properties")
public class ManageConfig {

    //文件上传路径
    private String fileUploadPath;
    //腾讯云 appID
    private String smsAppId;
    //腾讯云 appKey
    private String smsAppKey;
    //腾讯云 短信id
    private String  smsSecretId;
    //腾讯云 短信key
    private String  smsSecretKey;
    //短信签名
    private String  smsSign;
    //短信模板
    private String  smsTemplateId;

    /**
     * refer 白名单
     */
    private List<String> refererDomain;

    private String imageDomain;


}
