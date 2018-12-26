package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2018/12/23.
 */
@RestController
@Api(value = "/",description = "这是我的全部GET方法")
public class MyGetMethod {
    @RequestMapping(value = "getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }
    /***
     * 必须携带cookies的GET请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "必须携带cookies的GET请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies来";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&
                    cookie.getValue().equals("true")){
                return "这是一个必须携带cookies信息才能访问的get请求！";
            }
        }
        return "你必须携带cookies来";
    }
    /***
     * 开发一个需要携带参数才能访问的get请求：url:key=value&key=value
     * 模拟商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求：url:key=value&key=value",httpMethod = "GET")
    public Map<String,Integer>getList(@RequestParam Integer start,
                                      @RequestParam Integer end){
        Map<String,Integer>myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
    /***
     *   开发一个需要携带参数才能访问的get请求：get/with/param/10/20
     * 模拟商品列表
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求：get/with/param/10/20",httpMethod = "GET")
    public Map<String,Integer>myGetList(@PathVariable Integer start,
                                      @PathVariable Integer end){
        Map<String,Integer>myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        myList.put("书包",100);
        return myList;
    }
}
