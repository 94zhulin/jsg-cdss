package com.jsg.dao.mysql;

import com.jsg.entity.Historyallergy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/17 10:03
 */
@Repository
public interface HistoryallergyMapper {
    List<Historyallergy> selectByCode(@Param("code") String code);

    int add(Historyallergy historyallergy);

    List<Historyallergy> list(@Param("catalogId") Integer catalogId, @Param("queryKey") String queryKey);

    int edi(Historyallergy historyallergy);

    int del(@Param("historyallergyId") Integer historyallergyId);

    List<Historyallergy> listByName(@Param("queryKey")String queryKey);

}
