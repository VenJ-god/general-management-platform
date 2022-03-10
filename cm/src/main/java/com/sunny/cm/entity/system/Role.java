package com.sunny.cm.entity.system;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 15:19:44
 **/
@Data
@NoArgsConstructor
public class Role {

    private String id;

    private String name;

    private Set<Permission> permissionSet;
}
