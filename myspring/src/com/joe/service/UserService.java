package com.joe.service;

import com.joe.spring.*;

/**
 * @Author: fuzf
 * @Date: 2022/3/24 22:54
 */
@Component("userService")
//@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean, UserInterface {



    @Autowired
    private OrderService orderService;

    private String beanName;

    //自定义属性
    private String appField;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("/////.......初始化方法");
    }

    public void setAppField() {

    }

    public void test() {
        System.out.println(orderService);
    }
}
