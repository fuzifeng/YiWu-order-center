package com.yiwu.order_center_server.interceptor;

import com.google.gson.Gson;
import com.yiwu.order_center_client.common.Resp;
import com.yiwu.order_center_server.config.target.LoginLimit;
import com.yiwu.order_center_server.dao.OrderDao;
import com.yiwu.order_center_server.domain.Order;
import com.yiwu.order_center_server.jwt.UserTokenDto;
import com.yiwu.order_center_server.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    OrderDao orderDao;

    private static String admin = "fuzifeng";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginCheckInterceptor preHandle");

        if (request.getRequestURI().contains("login")
                || request.getRequestURI().contains("swagger")) {
            return true;
        }

        String authToken = request.getHeader("authToken");
        if (Strings.isEmpty(authToken)) {
            render(response, "登录校验没有,请登录");
            return false;
        }
        UserTokenDto userTokenDto = JwtUtils.parseToken(authToken);
        if (!userTokenDto.getUsername().equals(admin)) {
            render(response, "登录校验不通过，不是管理员,请登录");
            return false;
        }


        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;

            LoginLimit loginLimit = method.getMethodAnnotation(LoginLimit.class);
            if (loginLimit != null && loginLimit.login()) {
                //说明此接口需要登录验证
                String methodName = loginLimit.methodName();
                String token = request.getHeader("token");
                Order order = orderDao.selectOrderByOrderNo(token);

                if (Strings.isEmpty(token)) {
                    render(response, methodName + "请登录");
                    return false;
                }
            } else {

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginCheckInterceptor postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginCheckInterceptor afterCompletion");

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
