package com.yiwu.order_center_server.dto;

import lombok.Data;

/**
 * Oauth2获取Token返回信息封装
 *
 * @param
 * @return
 * @author fuzf
 * @createAt 2021/11/1 11:23
 * @updateAt 2021/11/1 11:23
 */
@Data
public class Oauth2TokenDto {
    /** 访问令牌 */
    private String token;
    /** 刷新令牌 */
    private String refreshToken;
    /** 访问令牌头前缀 */
    private String tokenHead;
    /** 有效时间（秒） */
    private int expiresIn;
}
