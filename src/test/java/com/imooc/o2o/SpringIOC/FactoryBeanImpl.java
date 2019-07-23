package com.imooc.o2o.SpringIOC;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author: BlueMelancholy
 * 2019/7/22 8:27
 * @desc:
 */
public class FactoryBeanImpl implements FactoryBean {
    Class mapperInterface;

    public FactoryBeanImpl(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
        System.out.println(2);
    }

    public FactoryBeanImpl() {
        System.out.println(0);
    }

    @Override
    public Object getObject() throws Exception {
        Class[] clazzs = new Class[]{mapperInterface};
        Object object = Proxy.newProxyInstance(Test.class.getClassLoader(),clazzs,new InvocationHandlerImpl());
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
