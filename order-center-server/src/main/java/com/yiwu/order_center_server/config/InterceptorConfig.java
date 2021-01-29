package com.yiwu.order_center_server.config;

import com.yiwu.order_center_server.interceptor.DefendFreshInterceptor;
import com.yiwu.order_center_server.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fuzf
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    PermissionInterceptor interceptor() {
        return new PermissionInterceptor();
    }

    @Bean
    DefendFreshInterceptor defendFreshInterceptor(){
        return new DefendFreshInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptor());
        registry.addInterceptor(defendFreshInterceptor());
    }
}
