package com.jsg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jsg.entity.UserInfo;

/**
 * 作者：zhuLin
 * 日期：2020-06-24 12:07:07
 * 备注：用户接口
 */
public interface UserService extends IService<UserInfo> {
    UserInfo getUser ();
}
