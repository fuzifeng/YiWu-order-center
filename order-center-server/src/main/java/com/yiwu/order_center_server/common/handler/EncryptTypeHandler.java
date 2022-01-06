/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.common.handler;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.yiwu.order_center_server.common.bean.Encrypt;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author fuzf
 * @Date 2022/1/6:17:52
 * @Description:
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Encrypt.class)
public class EncryptTypeHandler extends BaseTypeHandler<Encrypt> {

    private static final byte[] KEYS = "12345678abcdefgh".getBytes(StandardCharsets.UTF_8);

    /**
     *  设置参数
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2022/1/6 17:54
     * @updateAt 2022/1/6 17:54
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Encrypt encrypt, JdbcType jdbcType) throws SQLException {
        if (encrypt == null || encrypt.getValue() == null) {
            ps.setString(i, null);
            return;
        }
        AES aes = SecureUtil.aes(KEYS);
        String v = aes.encryptHex(encrypt.getValue());
        ps.setString(i, v);
    }

    /**
     * 获取值
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2022/1/6 18:08
     * @updateAt 2022/1/6 18:08
     */
    @Override
    public Encrypt getNullableResult(ResultSet rs, String s) throws SQLException {
        return decrypt(rs.getString(s));
    }

    /**
     * 获取值
     *
     * @param
     * @return
     * @author fuzf
     * @createAt 2022/1/6 18:09
     * @updateAt 2022/1/6 18:09
     */
    @Override
    public Encrypt getNullableResult(ResultSet rs, int i) throws SQLException {
        return decrypt(rs.getString(i));
    }

    @Override
    public Encrypt getNullableResult(CallableStatement cs, int i) throws SQLException {
        return decrypt(cs.getString(i));
    }

    public Encrypt decrypt(String value) {
        if (null == value) {
            return null;
        }
        return new Encrypt(SecureUtil.aes(KEYS).decryptStr(value));
    }
}
