package com.jsg.dao.mysql;

import com.jsg.entity.Properties;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:54
 */
@Repository
public interface PropertiesMapper {
    //属性列表
    List<Properties> list(@Param("queryKey") String queryKey);

    //删除属性
    int del(@Param("propName") String propName);

    //新增属性
    int add(Properties properties);

    //编辑属性
    int edi(Properties properties);

    List<Properties> selectByPropName(@Param("propName") String propName);

}
