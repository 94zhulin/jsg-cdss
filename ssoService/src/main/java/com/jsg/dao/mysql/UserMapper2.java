package com.jsg.dao.mysql;

import com.jsg.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper2 {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByName(@Param("username") String username);

    User selectOnebyId(@Param("userId") Integer userId);

    List<User> selectByNameAndPhone(User user);


    int add(User user);
}