package com.yiwu.order_center_server.es.repositories;

import com.yiwu.order_center_server.es.bean.GoodsEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author fuzf
 * @Date 2021/9/26:11:05
 * @Description:
 */
@Repository
public interface GoodsRepositories extends ElasticsearchRepository<GoodsEs, String> {

}
