package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.entity.Pageable;
import com.jsg.entity.User;

/**
 * @author jeanson 进生
 * @date 2019/10/8 19:46
 */
public interface UserService {
    ResultBase add(User user);

    ResultBase list(String queryKey, Pageable pageable);

    ResultBase edi(User user);


    ResultBase del(Integer userId);
}
