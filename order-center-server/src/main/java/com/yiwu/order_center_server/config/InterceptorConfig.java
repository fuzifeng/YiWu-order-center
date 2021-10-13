package com.yiwu.order_center_server.config;

import com.yiwu.order_center_server.interceptor.DefendFreshInterceptor;
import com.yiwu.order_center_server.interceptor.LoginCheckInterceptor;
import com.yiwu.order_center_server.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;

/**
 * @author fuzf
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Bean
    PermissionInterceptor interceptor() {
        return new PermissionInterceptor();
    }

    @Bean
    DefendFreshInterceptor defendFreshInterceptor(){
        return new DefendFreshInterceptor();
    }

    @Bean
    LoginCheckInterceptor loginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptor());
        registry.addInterceptor(defendFreshInterceptor());
        registry.addInterceptor(loginCheckInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //跨域允许时间
                .maxAge(3600);
    }

    /**
     * 全局设置编码格式
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
