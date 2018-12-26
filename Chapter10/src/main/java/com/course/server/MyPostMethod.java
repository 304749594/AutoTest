package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.invoke.util.VerifyAccess;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/12/24.
 */
@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("v1")
public class MyPostMethod {
    //cookie信息变量
    private static Cookie cookie;

    //用户登录成功获取cookies,然后再访问其他接口获取列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，获取cookie信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true)String userName,
                        @RequestParam(value = "password",required = true)String passWord){
        if(userName.equals("zhangsan")&&passWord.equals("123456")){
            cookie=new Cookie("login","true");
            return "恭喜你登录成功！";
        }
        return "用户名或者密码失败！";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u){
        User user;
        Cookie[] cookies=request.getCookies();
        //验证cookie是否合法
        for (Cookie c:cookies){
            if(c.getName().equals("login")
                    &&c.getValue().equals("true")
                    &&u.getUserName().equals("zhangsan")
                    &&u.getPassWord().equals("123456")){
                user=new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
