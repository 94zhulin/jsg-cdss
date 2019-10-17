package com.jsg.dao.mysql;

import com.jsg.entity.Baseinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/14 15:48
 */
@Repository
public interface BaseinfoMapper {
    List<Baseinfo> list(@Param("queryKey") String queryKey, @Param("sex") Integer sex, @Param("ksCode") String ksCode, @Param("position") Integer position, @Param("zzName") String zzName);
}
