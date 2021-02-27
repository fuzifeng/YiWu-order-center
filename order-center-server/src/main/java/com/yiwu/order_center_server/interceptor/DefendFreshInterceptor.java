package com.yiwu.order_center_server.interceptor;

import com.google.gson.Gson;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.config.target.AccessLimit;
import com.yiwu.order_center_server.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * 防刷过滤器
 *
 * @author fuzf
 */
@Slf4j
public class DefendFreshInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

//    @Autowired
//    OrderDao orderDao;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            //获取方法中的注解
            AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.second();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();
            String key = request.getRequestURI();
            //如果需要登录，判断一下userId等信息
            if (needLogin) {
                //正式情况需要加密
                String userId = request.getHeader("userId");
                if (Strings.isEmpty(userId)) {
                    //没有登陆
                    render(response,"请登录后访问");
                    return false;
                }
                key = key + "_" + userId;
            }
//            redisTemplate.opsForValue().increment()
            log.info("seconds:{}, maxCount:{}, needLogin:{}", seconds, maxCount, needLogin);
        }


        return true;
    }

    private void render(HttpServletResponse response, String errorMessage)throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = new Gson().toJson(Resp.error(errorMessage));
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
