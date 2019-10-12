package com.jsg.dao.mysql;

import com.jsg.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:52
 */
@Repository
public interface UserMapper {
    List<User> selectUserByRoleId(@Param("queryKey") String queryKey, @Param("roleId") Integer roleId);

    List<User> search(User user);

    int add(User user);

    List<User> list(@Param("queryKey") String queryKey);

    int edi(User user);

    int del(@Param("userId") Integer userId);

    User selectUserRoleByUserId(@Param("userId") Integer userId);


}
