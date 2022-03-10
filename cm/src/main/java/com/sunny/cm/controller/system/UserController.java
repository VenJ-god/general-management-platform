package com.sunny.cm.controller.system;

import com.sunny.cm.common.ResultCode;
import com.sunny.cm.entity.system.User;
import com.sunny.cm.service.system.UserService;
import com.sunny.cm.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 15:32:37
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public ResultJson getAllUser() {
        List<User> userList = userService.selectAllUser();
        return new ResultJson(ResultCode.SUCCESS_CODE, "获取成功", userList);
    }
}
