/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.service.es;/**
 * @Author fuzf
 * @Date 2021/12/17:14:42
 * @Description:
 */

import com.yiwu.order_center_server.es.bean.BookEs;
import com.yiwu.order_center_server.es.repositories.BookRepositories;
import org.apache.logging.log4j.util.Strings;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * todo 写下 你的注释
 *
 * @author
 * @version 1.0.0
 * @createdAt 2021/12/17 14:42
 * @updatedAt 2021/12/17 14:42
 */
@Service
public class BookService {
    @Autowired
    BookRepositories bookRepositories;

    public Long saveBook(BookEs goods) {
        BookEs bookEs = bookRepositories.save(goods);
        return bookEs.getBid();
    }

    public BookEs findById(Long id) {
        Optional<BookEs> byId = bookRepositories.findById(id.toString());
        return byId.get();
    }

    public Page<BookEs> findList(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<BookEs> all = bookRepositories.findAll(pageable);
        return all;
    }

    public Page<BookEs> findListByParams(String name, Integer type, String categoryCode,
                                         BigDecimal lowPrice, BigDecimal highPrice,
                                         Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (Strings.isNotEmpty(name)) {
            WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("name", "*" + name + "*");
            boolQueryBuilder.must(wildcardQueryBuilder);
        }
        if (Strings.isNotBlank(categoryCode)) {
            WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("ucode", categoryCode + "*");
            boolQueryBuilder.must(wildcardQueryBuilder);
        }
        if (lowPrice != null && highPrice != null) {
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").from(lowPrice).to(highPrice));
        }
        FieldSortBuilder sortBuilder = null;
        if (type == null || type == 3) {
            sortBuilder = SortBuilders.fieldSort("publish_time").order(SortOrder.DESC);
//            boolQueryBuilder.must(sortBuilder);
        }else {
            sortBuilder = SortBuilders.fieldSort("id").order(SortOrder.ASC);
        }

        queryBuilder.withQuery(boolQueryBuilder).withSort(sortBuilder).withPageable(pageable);
        NativeSearchQuery build = queryBuilder.build();
//        queryBuilder;

        Page<BookEs> search = bookRepositories.search(build);
        return search;
    }
}
