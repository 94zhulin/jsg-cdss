package com.jsg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jsg.entity.UserInfo;
import com.jsg.entity.sqlserver.User;
import javafx.scene.control.Pagination;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：zhuLin
 * 日期：2020-06-24 14:49:49
 * 备注：数据库接口
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

    public UserInfo getUser();

}
