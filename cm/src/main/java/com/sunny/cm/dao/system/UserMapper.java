package com.sunny.cm.dao.system;

import com.sunny.cm.entity.system.Permission;
import com.sunny.cm.entity.system.Role;
import com.sunny.cm.entity.system.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

@Repository
public interface UserMapper extends Mapper<User> {

    @Select("<script>" +
            "select * from t_sys_user where username = #{username}" +
            "</script>")
    User selectUserByUsername(@Param("username") String username);

    @Select("<script>" +
            "select r.* from t_sys_user u\n" +
            "inner join t_sys_user_role ur on u.id=ur.user_id\n" +
            "inner join t_sys_role r on ur.role_id=r.id\n" +
            "where u.id = #{userId}" +
            "</script>")
    Set<Role> selectRoleSetByUserId(@Param("userId") String userId);

    @Select("<script>" +
            "select p.* from t_sys_role r\n" +
            "inner join t_sys_role_permission rp on r.id=rp.role_id\n" +
            "inner join t_sys_permission p on rp.permission_id=p.id\n" +
            "where r.id = #{roleId}" +
            "</script>")
    Set<Permission> selectPermissionSetByRoleId(@Param("roleId") String roleId);
}
