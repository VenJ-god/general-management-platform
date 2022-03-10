package com.sunny.cm.service.system;

import com.sunny.cm.dao.system.UserMapper;
import com.sunny.cm.entity.system.Permission;
import com.sunny.cm.entity.system.Role;
import com.sunny.cm.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 15:26:36
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        User user = userMapper.selectUserByUsername(username);
        if (user != null) {
            Set<Role> roles = userMapper.selectRoleSetByUserId(user.getId());
            for (Role role : roles) {
                Set<Permission> permissions = userMapper.selectPermissionSetByRoleId(role.getId());
                role.setPermissionSet(permissions);
            }
            user.setRoleSet(roles);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
