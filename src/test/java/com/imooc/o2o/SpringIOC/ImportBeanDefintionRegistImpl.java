package com.imooc.o2o.SpringIOC;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: BlueMelancholy
 * 2019/7/22 8:36
 * @desc:为了实例化FactoryBeanImpl
 */
public class ImportBeanDefintionRegistImpl implements ImportBeanDefinitionRegistrar {
    /**
     * 动态注入类
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //给一个包名 com.zhaodong.dao得到所有的类
        //for
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(FactoryBeanImpl.class);
        //获取beanDefinition
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        //注入beanDefinition
        beanDefinitionRegistry.registerBeanDefinition("cityDao",beanDefinition);
        //传入类
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.imooc.o2o.SpringIOC.CityDao");
        //设置注入方式为构造方法注入
        beanDefinition.setAutowireMode(3);
    }
}
