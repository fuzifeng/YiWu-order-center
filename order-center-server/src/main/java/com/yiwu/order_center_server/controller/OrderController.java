package com.yiwu.order_center_server.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.common.rabbitmq.producer.HelloSender;
import com.yiwu.order_center_server.common.rabbitmq.producer.TopicSender;
import com.yiwu.order_center_server.config.target.AccessLimit;
import com.yiwu.order_center_server.config.target.LoginLimit;
import com.yiwu.order_center_server.domain.Order;
import com.yiwu.order_center_server.domain.OrderDispatch;
import com.yiwu.order_center_server.domain.redis.OrderCache;
import com.yiwu.order_center_server.dto.OrderDto;
import com.yiwu.order_center_server.exception.BusinessException;
import com.yiwu.order_center_server.service.order.OrderService;
import com.yiwu.order_center_server.service.order.strategy.IOrderService;
import com.yiwu.order_center_server.service.order.strategy.handler.OrderServiceImpl;
import com.yiwu.order_center_server.service.repository.OrderCacheRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: fuzf
 * @Date: 2020/9/10 15:37
 */
@RestController
@RequestMapping("/web/order-center/order")
public class OrderController {
    private static ThreadLocal<Gson> gsonThreadLocal = new ThreadLocal<Gson>(){
        @Override
        protected Gson initialValue() {
            return new Gson();
        }
    };
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OrderController.class);

    private static final String getOrderKey = "orderNo:";

    @Autowired
    private OrderService orderService;
    @Autowired
    HelloSender helloSender;
    @Autowired
    TopicSender topicSender;

    @Autowired
    OrderCacheRepository orderCacheRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/createOrder")
    public Resp<Long> order(@RequestBody Order order) {
        Date now = new Date();
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setTotalMoney(12340000L);
        Long orderId = orderService.addOrder(order);
        String orderStr = gsonThreadLocal.get().toJson(order);
//        helloSender.send(orderStr);
//        topicSender.send1(orderStr);
//        topicSender.send2(orderStr);
        topicSender.sendOrder(order.getOrderNo());

        return Resp.success(orderId);
    }

//    @AccessLimit(second = 10, maxCount = 2)
//    @LoginLimit(methodName = "通过订单号查询订单")
    @GetMapping("/findOrderByOrderNo")
    public Resp<Order> findOrderInfoByOrderNo(@RequestParam String orderNo) {
        Order order = null;
        String redisKey = getOrderKey + orderNo;
        if (redisTemplate.opsForValue().setIfAbsent(redisKey, 1, 10, TimeUnit.HOURS)) {
            try {
                Object redisOrder = redisTemplate.opsForValue().get(orderNo);
                if (redisOrder != null) {
                    log.info("read order info from redis");
                    order = gsonThreadLocal.get().fromJson(redisOrder.toString(), Order.class);
                }
                if (order == null) {
                    order = orderService.findOrderByOrderNo(orderNo);
                    redisTemplate.opsForValue().set(orderNo, gsonThreadLocal.get().toJson(order), 30, TimeUnit.MINUTES);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisTemplate.delete(redisKey);
            }
        } else {
            return Resp.error("请求频繁");
        }

        return Resp.success(order);
    }

    @GetMapping("/findOrderByOrderNo2")
    public Resp<OrderCache> findOrderInfoByOrderNo2(@RequestParam String orderNo) {
        OrderCache cache = orderCacheRepository.findByOrderNo(orderNo);
        if (cache == null) {
            Order order = orderService.findOrderByOrderNo(orderNo);
            if (order != null) {
                cache = new OrderCache();
                BeanUtils.copyProperties(order, cache);
                orderCacheRepository.save(cache);
            }
        }
        return Resp.success(cache);
    }

    @GetMapping("/findOrderById")
    public Resp<OrderDto> findOrderInfoByOrderNo(@RequestParam Long id) {
        OrderDto order = orderService.findOrderDtoById(id);
        return Resp.success(order);
    }

    @GetMapping("/findOrderList")
    public Resp<PageInfo<Order>> orderList(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        return Resp.success(orderService.orderList(pageNum, pageSize));
    }

    @GetMapping("/test")
    public Resp errorTest() {
        log.error("sasasaa");
        int i = 0;
        int j = 1;
        try {
            int k = j / i;
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        } catch (RuntimeException e) {

            throw new BusinessException(1, e.getMessage());
        }
        return Resp.success();
    }

    @PostMapping("/payOrder")
    public Resp payOrder(@RequestParam String orderNo) {
        Order order = orderService.findOrderByOrderNo(orderNo);
        if (order != null) {
            OrderDispatch dispatch = new OrderDispatch();
            dispatch.setOrderId(order.getId());
            dispatch.setOrderNo(order.getOrderNo());
            dispatch.setAddress("暂无");
            dispatch.setStatus(0);
        }
        return Resp.error("无效订单号");
    }

    @Autowired
    private OrderServiceImpl iOrderService;

    @GetMapping("/api/order")
    @ResponseBody
    public String orderSave(String type) {
        String str = iOrderService.orderHandler(type);
        return "{\"status\":1,\"msg\":\"保存成功\",\"data\":\"" + str + "\"}";
    }
}
