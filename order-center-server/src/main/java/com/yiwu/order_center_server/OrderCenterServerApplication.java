package com.yiwu.order_center_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author fuzf
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.yiwu.order_center_server.dao")
public class OrderCenterServerApplication {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterServerApplication.class, args);
    }

    @PostConstruct
    public void initEs() {
        String url = "http://localhost:9200/_all/_settings";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE));
        String json = "{\"index.blocks.read_only_allow_delete\":null}";
        HttpEntity entity = new HttpEntity(json, httpHeaders);
        restTemplate.put(url, entity);
    }


}
