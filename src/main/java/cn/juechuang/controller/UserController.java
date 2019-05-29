package cn.juechuang.controller;

import cn.juechuang.service.UserSevice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

//    需要service
    @Autowired
    UserSevice userSevice;

    @RequestMapping("/list")
//    @RequiresPermissions( "user:list" )
    public  String list (Model model){
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.isPermitted( "user:list" )) {
            Model list = model.addAttribute( "list", userSevice.getlist() );
//        }
        return "user/user_list";
    }

}
