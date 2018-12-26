package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2018/12/23.
 */

public class MyHttpClient {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;
    @BeforeTest
    public void setUp(){
        bundle=ResourceBundle.getBundle("application");
    }
    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get=new HttpGet(bundle.getString("test.url"));
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity());
        //获取cookies
        this.cookieStore=client.getCookieStore();
        List<Cookie> cookieList= cookieStore.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+" : "+value);
        }
    }
}
