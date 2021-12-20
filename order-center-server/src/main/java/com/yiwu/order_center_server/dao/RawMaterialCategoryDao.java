package com.yiwu.order_center_server.dao;

import com.yiwu.order_center_server.domain.RawMaterialCategory;

import java.util.List;

public interface RawMaterialCategoryDao {

    int insert(RawMaterialCategory record);


    int insertSelective(RawMaterialCategory record);

    List<RawMaterialCategory> selectAll();
}