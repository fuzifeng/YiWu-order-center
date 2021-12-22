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

/**
 * @Author fuzf
 * @Date 2021/9/26:10:52
 * @Description:
 */
@Data
@Document(indexName = "book", createIndex = true)
public class BookEs {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Long)
    private Long bid;

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

    @Field(name = "publish_time", type = FieldType.Long)
    private Long publishTime;

    // 指定字段对应ES中的类型是Date，使用自定义的日期格式化，pattern指定格式化
    // 规则是“日期时间”或“日期”或“时间毫秒”
    @Field(name = "create_time", type = FieldType.Date, format = DateFormat.date_hour_minute_second,
            pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;     // 文章创建时间

    @Field(name = "update_time", type = FieldType.Date, format = DateFormat.date_hour_minute_second,
            pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime  updateTime;

}
