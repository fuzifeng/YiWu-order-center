package com.yiwu.order_center_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

/**
 * @author fuzf
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.yiwu.order_center_server.dao")
@EnableAsync
@EnableTransactionManagement
public class OrderCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterServerApplication.class, args);
    }

    @PostConstruct
    public void initEs() {
        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = "http://localhost:9200/_all/_settings";
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE));
//            String json = "{\"index.blocks.read_only_allow_delete\":null}";
//            HttpEntity entity = new HttpEntity(json, httpHeaders);
//            restTemplate.put(url, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
