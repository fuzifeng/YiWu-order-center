package com.yiwu.order_center_server.dao;


import com.yiwu.order_center_server.common.bean.Encrypt;
import com.yiwu.order_center_server.dao.dto.AccountRegisterDto;
import com.yiwu.order_center_server.domain.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbg.generated Thu Jan 06 18:34:10 CST 2022
     */
    int insert(Account record);

    int register(@Param("name") String name,
                 @Param("account") Encrypt account,
                 @Param("password") Encrypt password);

    int register2(@Param("name") String name,
                 @Param("account") String account,
                 @Param("password") String password);

    AccountRegisterDto findByAccount(@Param("account") Encrypt account);

}