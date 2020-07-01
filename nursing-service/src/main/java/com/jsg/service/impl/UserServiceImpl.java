package com.jsg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jsg.entity.UserInfo;
import com.jsg.mapper.UserMapper;
import com.jsg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：zhuLin
 * 日期：2020-06-24 12:07:07
 * 备注：用户接口实现类
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUser() {
        return userMapper.getUser();
    }
}
