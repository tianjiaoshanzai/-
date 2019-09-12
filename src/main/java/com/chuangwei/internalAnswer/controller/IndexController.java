/**
 * Copyright (C), 2019-2019, 天骄山仔
 * FileName: IndexController
 * Author:   lenovo
 * Date:     2019/9/9 20:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chuangwei.internalAnswer.controller;

//import com.sun.javafx.binding.StringFormatter;

import com.chuangwei.internalAnswer.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lenovo
 * @create 2019/9/9
 * @since 1.0.0
 */
//@Controller
public class IndexController {

    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String index(){
        return "Hello 创伟";
    }

    @RequestMapping(path={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String index(@PathVariable("userId")int userId,
                        @PathVariable("groupId")String groupId,
                        @RequestParam(value="type",defaultValue = "1",required = false)int type,
                        @RequestParam(value="key",defaultValue = "zz",required = false)String key){
        return String.format("访问主页是谁:%s %d t:%d  k:%s",groupId,userId,type,key);
    }

    @RequestMapping(path={"/test"}/*,method = RequestMethod.GET*/)
    public String template(Model model){

        model.addAttribute("value1","testVal1");//读取value值，前台可以调用显示

        List<String>colors= Arrays.asList(new String[]{"RED","BLUE","PINK"});
        model.addAttribute("colors",colors);


        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(String.valueOf(i), String.valueOf(i * i));
        }
        model.addAttribute("map", map);

        model.addAttribute("user", new User("ShanZai"));
        //System.out.println("233");
        return "home";
    }

    @RequestMapping(path={"/request"},method = RequestMethod.GET)
    @ResponseBody
    public String request(Model model, HttpServletRequest request
            , HttpServletResponse response, HttpSession session,
                          @CookieValue("JSESSIONID") String sessionId){
        StringBuilder sb=new StringBuilder();

        sb.append("COOKIEVALUE"+sessionId);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");
        }

        if(request.getCookies()!=null){
            for(Cookie cookie:request.getCookies()){
                sb.append("COOKIES："+cookie.getName()+"value:"+cookie.getValue());
            }
        }
        sb.append(request.getMethod());

        response.addHeader("ChuangweiId","hello");
        response.addCookie(new Cookie("username","Chuangwei"));

        return sb.toString();

    }


    @RequestMapping(path = {"/admin"}, method = {RequestMethod.GET})
    @ResponseBody
    public String admin(@RequestParam("key") String key){
        if("admin".equals(key)){
            return "Hello admin";
        }
        else
            throw new IllegalArgumentException("参数不对");
    }

    @ExceptionHandler
    @ResponseBody
    public String error(Exception e)
    {
        return "error"+e.getMessage();
    }



}
