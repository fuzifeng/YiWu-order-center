package com.yiwu.order_center_server.es.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(indexName = "raw_materials", createIndex = true)
public class RawMaterialsEs {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(name = "category_id", type = FieldType.Keyword)
    private Long categoryId;

    @Field(name = "category_code", type = FieldType.Keyword)
    private String categoryCode;

    @Field(name = "status", type = FieldType.Integer)
    private Integer status;

    @Field(name = "is_del", type = FieldType.Integer)
    private Integer isDel;

    @Field(name = "create_time", type = FieldType.Date, format = DateFormat.date_hour_minute_second,
            pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Field(name = "update_time", type = FieldType.Date, format = DateFormat.date_hour_minute_second,
            pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}