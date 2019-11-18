package com.jsg.service.Impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dao.mysql.UserMapper2;
import com.jsg.entity.Token;
import com.jsg.entity.User;
import com.jsg.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jeanson 进生
 * @date 2019/10/26 22:51
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper2 userMapper2;

    @Value("${apiStatus.failure}")
    private Integer failure;

    @Value("${apiStatus.exc}")
    private Integer exc;

    @Value("${apiStatus.success}")
    private Integer success;


    @Override
    public ResultBase login(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);
        String session = (String) subject.getSession().getId();
        User user = (User) subject.getPrincipal();
        user.setPassword(null);
        Token userToken = new Token(session, System.currentTimeMillis(), user);
        return ResultUtil.success(null, userToken);
    }

    @Override
    public ResultBase edlPassword(Integer userId, String password, String odlPassword) {
        //Subject subject = SecurityUtils.getSubject();
        User user = userMapper2.selectOnebyId(userId);
        ResultBase resultBase = ResultUtil.success(null, null);
        Md5Hash md5Hash = new Md5Hash(odlPassword, null, 2);
        Md5Hash newMd5Hash = new Md5Hash(password, null, 2);
        if (user != null && md5Hash.toString().equals(user.getPassword())) {
            user.setPassword(newMd5Hash.toString());
        } else {
            resultBase.setStatus(failure);
            resultBase.setMsg("密码错误!");
        }
        return resultBase;
    }

    @Override
    public ResultBase add(User user) {

        List<User> list = userMapper2.selectByNameAndPhone(user);
        ResultBase resultBase = ResultUtil.success(null, null);
        if (list != null && list.size() > 0) {
            resultBase.setStatus(failure);
            resultBase.setMsg("用户名或者手机号重复");
        } else {
            Md5Hash md5Hash = new Md5Hash(user.getPassword(), null, 2);
            user.setPassword(md5Hash.toString());
            user.setCreateTime(new Date());
            userMapper2.add(user);
        }
        return resultBase;
    }

    @Override
    public ResultBase findUser(Integer userId) {
        User user = userMapper2.selectOnebyId(userId);
        return ResultUtil.success(null, user);
    }


}
