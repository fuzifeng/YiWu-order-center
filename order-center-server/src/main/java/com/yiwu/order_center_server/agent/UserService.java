package com.yiwu.order_center_server.agent;


import com.yiwu.common.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "USER-CENTER", path = "/userCenter/v1")
public interface UserService {

    @PostMapping("/user/isValidUserByToken")
    public Resp<Boolean> isValidUserByToken(@RequestParam String token);


}
