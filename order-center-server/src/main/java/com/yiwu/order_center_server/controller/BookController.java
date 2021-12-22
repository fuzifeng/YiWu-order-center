/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.controller;/**
 * @Author fuzf
 * @Date 2021/12/17:14:09
 * @Description:
 */

import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.dto.book.BookVo;
import com.yiwu.order_center_server.es.bean.BookEs;
import com.yiwu.order_center_server.service.es.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * todo 写下 你的注释
 *
 * @author fuzifeng
 * @version 1.0.0
 * @createdAt 2021/12/17 14:09
 * @updatedAt 2021/12/17 14:09
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public Resp<Long> addGoods(@RequestBody BookVo bookVo) {
        BookEs bookEs = new BookEs();
        bookEs.setBid(System.currentTimeMillis());
        bookEs.setId(System.currentTimeMillis() + 9999999999999L);
        bookEs.setName(bookVo.getName());
        bookEs.setAuthor(bookVo.getAuthor());
        bookEs.setContent(bookVo.getContent());
        bookEs.setPrice(bookVo.getPrice());
        bookEs.setUcode(bookVo.getUcode());
        bookEs.setUpdateTime(LocalDateTime.now());
        bookEs.setCreateTime(LocalDateTime.now());
        if (bookVo.getPublishTime() != null) {
            bookEs.setPublishTime(bookVo.getPublishTime().getTime());
        } else {
            bookEs.setPublishTime(System.currentTimeMillis());
        }
        bookService.saveBook(bookEs);
        return Resp.success(bookEs.getBid());
    }

    @GetMapping("/findBook")
    public Resp<BookEs> findGoods(Long id) {
        BookEs byId = bookService.findById(id);
        return Resp.success(byId);
    }

    @GetMapping("/findList")
    public Resp<Page<BookEs>> findList(
            Integer pageNum, Integer pageSize) {
        return Resp.success(bookService.findList(pageNum, pageSize));
    }

    @GetMapping("/findListParam")
    public Resp<Page<BookEs>> findListByParams(
            String name,
            Integer type,
            BigDecimal lowPrice,
            BigDecimal highPrice,
            String code,
            Integer pageNum, Integer pageSize) {
        return Resp.success(bookService.findListByParams(name, type, code, lowPrice, highPrice, pageNum, pageSize));
    }




}
