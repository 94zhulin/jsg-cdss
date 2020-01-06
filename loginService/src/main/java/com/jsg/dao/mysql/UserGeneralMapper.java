package com.jsg.dao.mysql;

import com.jsg.entity.Department;
import com.jsg.entity.Dictionary;
import com.jsg.entity.UserGenera;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/26 18:28
 */
@Repository
public interface UserGeneralMapper {


    List<UserGenera> selectByName(@Param("username") String username);

    UserGenera selectOnebyId(@Param("userId") Integer userId);

    List<UserGenera> selectByNameAndPhone(UserGenera user);

    int add(UserGenera user);

    List<Department> department(@Param("queryKey") String queryKey);

    List<Dictionary> dictionary(@Param("queryKey") String queryKey, @Param("catalogId") String catalogId);
}
