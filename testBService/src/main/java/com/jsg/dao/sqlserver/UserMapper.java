package com.jsg.dao.sqlserver;

import com.jsg.dto.UserDTO;
import com.jsg.entity.sqlserver.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息Mapper
 *
 * @author weidong
 * @date 2019/6/4
 */
@Repository
public interface UserMapper {

    /**
     * 查询列表
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 查询
     *
     * @return
     */
    User selectById(UserDTO dto);

    /**
     * 修改
     *
     * @return
     */
    int updateById(UserDTO dto);

}
