package com.jsg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.UserMapper;
import com.jsg.entity.Pageable;
import com.jsg.entity.User;
import com.jsg.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/9 15:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase add(User user) {
        List<User> list = userMapper.search(user);
        ResultBase resultBase = ResultUtil.success(null, user);
        if (list != null && list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("用户名或者手机号重复");
        } else {
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), null, 2);
            user.setPassword(md5Hash.toString());
            userMapper.add(user);
        }
        return resultBase;
    }

    @Override
    public ResultBase list(String queryKey, Integer status, Pageable pageable) {

        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<User> list = userMapper.list(queryKey, status);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return ResultUtil.success(null, pageInfo);
    }

    @Override
    public ResultBase edi(User user) {
        List<User> list = userMapper.search(user);
        ResultBase resultBase = ResultUtil.success(null, user);
        if (list != null && list.size() > 1) {
            resultBase.setStatus(failure);
            resultBase.setMsg("用户名或者手机号重复");
        } else {
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), null, 2);
            user.setPassword(md5Hash.toString());
            userMapper.edi(user);
        }
        return resultBase;
    }


    @Override
    public ResultBase del(Integer userId) {
        //查询是否为系统管理员
        User user = userMapper.selectUserRoleByUserId(userId);
        ResultBase resultBase = ResultUtil.success(null, userId);
        if (user != null) {
            resultBase.setStatus(failure);
            resultBase.setMsg("系统管理员不能删除");
        } else {
            int i = userMapper.del(userId);
        }
        return resultBase;
    }
}
