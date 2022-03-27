package com.joe.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义bean的注解
 *
 * @Author: fuzf
 * @Date: 2022/3/24 23:00
 */
@Retention(RetentionPolicy.RUNTIME) //生效时间
@Target(ElementType.FIELD) //只能写在字段上面
public @interface Autowired {
//    String value() default ""; //给bean取名字
}
