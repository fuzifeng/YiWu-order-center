package com.yiwu.order_center_server.es.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Author fuzf
 * @Date 2021/9/26:10:52
 * @Description:
 */
@Data
@Document(indexName = "goods", createIndex = true)
public class GoodsEs {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String author;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Keyword)
    private String ucode;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date publishTime;
}
