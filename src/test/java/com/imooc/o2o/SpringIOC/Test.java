package com.imooc.o2o.SpringIOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: BlueMelancholy
 * 2019/7/22 8:02
 * @desc:
 */
public class Test {
    public static void main(String[] args) {
//        Class[] clazzs = new Class[]{CityDao.class};
//        CityDao cityDao = (CityDao) Proxy.newProxyInstance(Test.class.getClassLoader(),clazzs,new InvocationHandlerImpl());
//        cityDao.query();
//        SqlSession sqlSession = null;
//        Object mapper = sqlSession.getMapper(CityDao.class);
        //如何将其交给Spring管理
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean(CityDao.class).query();
    }
}
