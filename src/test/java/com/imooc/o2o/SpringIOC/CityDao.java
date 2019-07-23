package com.imooc.o2o.SpringIOC;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: BlueMelancholy
 * 2019/7/22 7:58
 * @desc:
 */
public interface CityDao {
    @Select("select * from city")
    List<Map<String,Object>> query();
}
