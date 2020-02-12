package com.jsg.dao.mysql;

import com.jsg.entity.KlgbaseExamineCkfw;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface KlgbaseExamineCkfwMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KlgbaseExamineCkfw record);

    int insertSelective(KlgbaseExamineCkfw record);

    KlgbaseExamineCkfw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KlgbaseExamineCkfw record);

    int updateByPrimaryKey(KlgbaseExamineCkfw record);

    void deleteByJyxmId(Integer id);

}