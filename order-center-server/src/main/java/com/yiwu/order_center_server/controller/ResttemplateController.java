/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;/**
 * @Author fuzf
 * @Date 2021/11/1:14:03
 * @Description:
 */

import com.alibaba.fastjson.JSONObject;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.dto.Oauth2TokenDto;
import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 写下 你的注释
 *
 * @author fuzifeng
 * @version 1.0.0
 * @createdAt 2021/11/1 14:03 
 * @updatedAt 2021/11/1 14:03
 */
@RestController
@RequestMapping("/rest")
public class ResttemplateController {
    @Value("${rass.resource.protocol:''}")
    private String protocol;
    //请求域名
    @Value("${rass.resource.host:''}")
    private String gatewayHost;
    //获取token接口
    @Value("${rass.resource.getToken}")
    private String getTokenUrl;
    //获取音视频接口
    @Value("${rass.resource.getPlayAuthToken}")
    private String getPlayAuthToken;
    //获取文档类接口
    @Value("${rass.resource.getDocumentAccessToken}")
    private String getDocumentAccessToken;

    @Value("${rass.resource.client_id}")
    private String client_id;
    @Value("${rass.resource.client_secret}")
    private String client_secret;
    @Value("${rass.resource.username}")
    private String username;
    @Value("${rass.resource.password}")
    private String password;


    @GetMapping("/test")
    public Resp test(Long resId) {

        return Resp.success(getDocumentAccessToken(resId));
    }

    /**
     * 获取访问资源内部token
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2021/11/1 11:47
     * @updateAt 2021/11/1 11:47
     */
    public Oauth2TokenDto getRaasToken() {
        try {
            String thisUrl = protocol + gatewayHost + getTokenUrl;
//            Map<String, String> params = new HashMap<>();
//            params.put("grantType", "password");
//            params.put("client_id", client_id);
//            params.put("client_secret", client_secret);
//            params.put("username",username);
//            params.put("password",password);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(thisUrl)
                    .queryParam("grant_type", "password")
                    .queryParam("client_id", client_id)
                    .queryParam("client_secret", client_secret)
                    .queryParam("username",username)
                    .queryParam("password",password);

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpMethod method = HttpMethod.POST;
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<?> httpEntity = new HttpEntity(headers);
            ResponseEntity<JSONObject> entity = restTemplate.exchange(builder.build().encode().toUri(), method,
                    httpEntity, JSONObject.class);
            if (entity.getStatusCodeValue() == HttpStatus.OK.value()) {
                JSONObject jsonObject = entity.getBody();
                if (jsonObject != null && jsonObject.getInteger("code") == 0) {
                    JSONObject dataJson = jsonObject.getJSONObject("data");
                    String dataStr = dataJson.toJSONString();
                    return JSONObject.parseObject(dataStr, Oauth2TokenDto.class);
                } else {
                    //todo
                }
            } else {

                //todo
            }
            int i = 0;
            return null;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    public JSONObject getPlayAuthToken(Long resId) {
        Oauth2TokenDto oauth2TokenDto = getRaasToken();
        String thisUrl = protocol + gatewayHost + getPlayAuthToken;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(thisUrl)
                .queryParam("resId", resId);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", oauth2TokenDto.getTokenHead() + oauth2TokenDto.getToken());
        HttpMethod method = HttpMethod.GET;

        HttpEntity<?> httpEntity = new HttpEntity(headers);
        ResponseEntity<JSONObject> entity = restTemplate.exchange(builder.build().encode().toUri(), method,
                httpEntity, JSONObject.class);
        if (entity.getStatusCodeValue() == HttpStatus.OK.value()) {
            JSONObject jsonObject = entity.getBody();
            if (jsonObject != null && jsonObject.getInteger("code") == 0) {
                return jsonObject.getJSONObject("data");
            } else {
//                throw new CustomException("无法获取token");
            }
        } else {
//            throw new CustomException("无法获取token");
        }
        return null;
    }

    public JSONObject getDocumentAccessToken(Long resId) {
        Oauth2TokenDto oauth2TokenDto = getRaasToken();
        String thisUrl = protocol + gatewayHost + getDocumentAccessToken;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(thisUrl)
                .queryParam("resId", resId);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", oauth2TokenDto.getTokenHead() + oauth2TokenDto.getToken());
        HttpMethod method = HttpMethod.GET;

        HttpEntity<?> httpEntity = new HttpEntity(headers);
        ResponseEntity<JSONObject> entity = restTemplate.exchange(builder.build().encode().toUri(), method,
                httpEntity, JSONObject.class);
        if (entity.getStatusCodeValue() == HttpStatus.OK.value()) {
            JSONObject jsonObject = entity.getBody();
            if (jsonObject != null && jsonObject.getInteger("code") == 0) {
                return jsonObject.getJSONObject("data");
            } else {
//                throw new CustomException("无法获取token");
            }
        } else {
//            throw new CustomException("无法获取token");
        }
        return null;
    }
}
