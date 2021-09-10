package com.yiwu.order_center_server.config.target;

import com.yiwu.order_center_server.config.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @Author fuzf
 * @Date 2021/9/10:16:17
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSwitcher {
    /**
     * 默认数据源
     * @return
     */
    DataSourceEnum value() default DataSourceEnum.MASTER;
    /**
     * 清除
     * @return
     */
    boolean clear() default true;
}
