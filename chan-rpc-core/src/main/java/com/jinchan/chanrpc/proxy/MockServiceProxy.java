package com.jinchan.chanrpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName: MockServiceProxy
 * Package: com.jinchan.chanrpc.proxy
 * Description:
 *  Mock服务代理（JDK动态代理）
 * @Author yijinchan
 * @Create 2024/3/6 13:43
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {
    /**
     *  调用代理对象的方法，执行invoke方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据方法的返回值类型，生成特定的默认值对象
        Class<?> methodReturnType = method.getReturnType();
        log.info("mock invoke :{}", method.getName());
        return getDefaultObject(methodReturnType);
    }

    /**
     * 生成指定类型的默认值对象
     * @param type
     * @return
     */
    private Object getDefaultObject(Class<?> type) {
        //基本类型
        if (type.isPrimitive()) {
            if(type == int.class) {
                return 0;
            } else if (type == long.class) {
                return 0L;
            } else if (type == boolean.class) {
                return false;
            } else if (type == short.class) {
                return (short) 0;
            }
        }
        //对象类型
        return null;
    }
}
