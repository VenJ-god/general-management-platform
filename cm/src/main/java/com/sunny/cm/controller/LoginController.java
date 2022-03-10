package com.sunny.cm.controller;

import com.sunny.cm.common.ResultCode;
import com.sunny.cm.utils.ResultJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: Ven.J
 * @Date: 2022-03-04 18:15:40
 **/
@Controller
public class LoginController {

    @RequestMapping("login")
    @ResponseBody
    public ResultJson login(String username, String password) {
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //3.执行登陆方法
            subject.login(token);
            // 设置session的过期时间
//            subject.getSession().setTimeout(10000);
            //登陆成功
            return new ResultJson(ResultCode.SUCCESS_CODE, "登录成功");
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登陆失败：用户名不存在
            return new ResultJson(ResultCode.FAILURE_CODE, "登录失败，用户名不存在");
        } catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登陆失败：密码输入有误
            return new ResultJson(ResultCode.FAILURE_CODE, "登录失败，密码输入有误");
        }
    }
    @RequestMapping("loginOut")
    @ResponseBody
    public ResultJson loginOut(String username) {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return new ResultJson(ResultCode.SUCCESS_CODE, "退出成功");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResultJson unauth() {
        return new ResultJson(ResultCode.UNAUTH, "用户未登录");
    }
}
