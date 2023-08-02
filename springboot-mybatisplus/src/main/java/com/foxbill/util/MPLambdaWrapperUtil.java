package com.foxbill.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import org.apache.ibatis.reflection.property.PropertyNamer;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 提供根据属性名获取数据库字段名方法
 *
 * @author chenhuazhu@vv.cn
 * @since 2020-10-09
 */
public class MPLambdaWrapperUtil {
    static class CCLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {
        @Override
        public String columnToString(SFunction<T, ?> column) {
            return super.columnToString(column, false);
        }

        @Override
        public String columnToString(SFunction<T, ?> column, boolean onlyColumn) {
            return super.columnToString(column, onlyColumn);
        }
    }

    /**
     * classLoader.className + clazzName 为key，CCLambdaQueryWrapper的软引用value
     * 这里使用软引用防止内存溢出，因为软引用关联的对象只有在内存不足时才会被回收
     */
    private static Map<String, SoftReference<CCLambdaQueryWrapper>> lambdaQueryWrapperCache = new HashMap<>();

    /**
     * 获取数据库的字段名
     *
     * @param column
     * @param <T>
     * @return
     */
    public static <T> String getColumn(SFunction<T, ?> column) {
        return getColumn(column, false, null);
    }

    /**
     * 获取数据库的字段名
     *
     * @param column
     * @param onlyColumn
     * @param <T>
     * @return
     */
    public static <T> String getColumn(SFunction<T, ?> column, boolean onlyColumn) {
        return getColumn(column, onlyColumn, null);
    }

    public static <T> String getColumn(SFunction<T, ?> column, Class<T> clazz) {
        return getColumn(column, false, clazz);
    }

    /**
     * 获取数据库的字段名
     *
     * @param column
     * @param onlyColumn
     * @param <T>
     * @return
     */
    public static <T> String getColumn(SFunction<T, ?> column, boolean onlyColumn, Class<T> clazz) {
        CCLambdaQueryWrapper<T> lambdaQueryWrapper;
        if (clazz != null) {
            String clazzKey = genClazzKey(clazz);
            SoftReference<CCLambdaQueryWrapper> softLambdaQueryWrapper = lambdaQueryWrapperCache.get(clazzKey);
            // 判断是否存在软引用
            if (softLambdaQueryWrapper == null) {
                lambdaQueryWrapper = new CCLambdaQueryWrapper<>();
                softLambdaQueryWrapper = new SoftReference<>(lambdaQueryWrapper);
                lambdaQueryWrapperCache.put(clazzKey, softLambdaQueryWrapper);
            } else {
                lambdaQueryWrapper = softLambdaQueryWrapper.get();
            }
        } else {
            lambdaQueryWrapper = new CCLambdaQueryWrapper<>();
        }
        return lambdaQueryWrapper.columnToString(column, onlyColumn);
    }

    private static String genClazzKey(Class clazz) {
        return clazz.getClassLoader().getClass().getName() + "_" + clazz.getName();
    }

    /**
     * 获取vo的字段名称
     *
     * @param column
     * @param <T>
     * @return
     */
/*    public static <T> String getFieldName(SFunction<T, ?> column) {
        SerializedLambda lambda = LambdaUtils.resolve(column);
        String fieldName = PropertyNamer.methodToProperty(lambda.getImplMethodName());
        return fieldName;
    }*/
}