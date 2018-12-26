package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/12/26.
 */
@Log
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class ControllerDemo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    /***
     * 可以获取到用户数
     */
    @RequestMapping(value = "getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }
    /***
     * 插入用户
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        int result=template.insert("addUser",user);
        return result;
    }
    /***
     * 更新用户
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        int result=template.update("updateUser",user);
        return result;
    }
    /***
     * 删除用户
     */
    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    @ApiOperation(value = "删除用户",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        int result=template.delete("deleteUser",id);
        return result;
    }


}
