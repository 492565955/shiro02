package cn.juechuang.controller;

import cn.juechuang.util.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
//   登陆跳转
    @GetMapping("/login")
    public  String index(){
        return "login";
    }
//
    @PostMapping("/login")
    @ResponseBody
    public ResultMap login(String username,String password){

        System.out.println(username + password);
//        SecurityUtils.getSubject()在一个会话中是全局生效的
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        if (subject.isAuthenticated()){
            return  ResultMap.ok();
        }
        return ResultMap.fail();
    }

//    登出
    @RequestMapping("/logout")
    public  String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        重定向到登陆页面
        return "redirect:/login";
    }

//    进入首页
    @RequestMapping("/index")
    public String index2(){
        return "index";
    }


}
