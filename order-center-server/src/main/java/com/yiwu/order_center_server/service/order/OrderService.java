package com.yiwu.order_center_server.service.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiwu.order_center_server.config.DataSourceEnum;
import com.yiwu.order_center_server.config.target.DataSourceSwitcher;
import com.yiwu.order_center_server.dao.OrderDao;
import com.yiwu.order_center_server.domain.Order;
import com.yiwu.order_center_server.dto.OrderDto;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: fuzf
 * @Date: 2020/9/14 11:40
 */
@Service
public class OrderService implements InitializingBean {

    @Autowired
    private OrderDao orderDao;

    @PostConstruct
    public void a() {
        System.out.println("初始化前。。。。");
//        throw new NullPointerException();
    }

    //初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet。。。。");
    }

    public Long addOrder(Order order) {
        orderDao.insertOrder(order);
        return order.getId();
    }

    public Order findOrderById(Long id) {
        return orderDao.selectOrderById(id);
    }

//    @DataSourceSwitcher(DataSourceEnum.SLAVE)
    public Order findOrderByOrderNo(String orderNo) {
        return orderDao.selectOrderByOrderNo(orderNo);
    }

    public OrderDto findOrderDtoById(Long id) {
        return orderDao.selectOrderDtoById(id);
    }

    public PageInfo<Order> orderList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list = orderDao.selectByParams();
        return new PageInfo(list);

    }
}
