package com.imooc.o2o.SpringIOC;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: BlueMelancholy
 * 2019/7/22 8:01
 * @desc:
 */
@Slf4j
public class InvocationHandlerImpl implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getReturnType());
        log.info("query db :" + method.getAnnotation(Select.class).value()[0]);
        return null;
    }
}
