package com.jsg.dao.mysql;

import com.jsg.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/11/19 16:48
 */
@Repository
public interface UserRelatedMapper {


    List<User> selectByName(@Param("username") String username);

    User selectOnebyId(@Param("userId") Integer userId);

    List<User> selectByNameAndPhone(User user);

    int add(User user);
}
