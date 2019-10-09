package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.Properties;
import org.apache.ibatis.annotations.Param;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:50
 */
public interface PropertiesService {
    //属性列表
    ResultBase list(String queryKey, Pageable pageable);

    //删除属性
    ResultBase del(String propName);

    //新增属性
    ResultBase add(Properties properties);

    //编辑属性
    ResultBase edi(Properties properties);

    //根据属性名获取属性列表
    ResultBase selectByPropName(@Param("propName") String propName);

}
