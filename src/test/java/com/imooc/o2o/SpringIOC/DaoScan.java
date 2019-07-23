package com.imooc.o2o.SpringIOC;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: BlueMelancholy
 * 2019/7/22 9:01
 * @desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportBeanDefintionRegistImpl.class)
public @interface DaoScan {
}
