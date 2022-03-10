package com.sunny.cm.service.system;

import com.sunny.cm.entity.system.User;

import java.util.List;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 15:25:52
 **/
public interface UserService {

    User selectUserByUsername(String username);

    List<User> selectAllUser();
}
