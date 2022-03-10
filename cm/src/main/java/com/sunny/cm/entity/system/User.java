package com.sunny.cm.entity.system;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Set;

/**
 * @Description: 用户
 * @Author: Ven.J
 * @Date: 2022-03-04 14:52:34
 **/
@Data
@NoArgsConstructor
@Table(name = "t_sys_user")
public class User {

    private String id;

    private String username;

    private String password;

    private Set<Role> roleSet;

    private String tel;

    private String address;
}
