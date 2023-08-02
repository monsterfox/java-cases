package com.foxbill.test07.handler;

import java.sql.ResultSet;

/*
    用于处理结果集的接口
 */
public interface ResultSetHandler<T> {
    //处理结果集的抽象方法。
    <T> T handler(ResultSet rs);
}
