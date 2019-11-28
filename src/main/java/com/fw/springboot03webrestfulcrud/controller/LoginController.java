package com.fw.springboot03webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes(value = "message",types=String.class)
public class LoginController {


    /**
     * rest风格的请求方式
     */
    //@RequestMapping("/user/login")
    //@PutMapping
    //@DeleteMapping
    //@GetMapping
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            // 登录成功，重定向到 success
            session.setAttribute("loginUser",username);
            return "redirect:/success.html";
        }else {
            map.put("message","账号或密码错误！");
            return "redirect:/";
        }
    }
}
