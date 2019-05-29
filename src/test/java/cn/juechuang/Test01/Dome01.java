package cn.juechuang.Test01;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Dome01 {

    @Autowired
    SecurityManager securityManager;
    @Test
    public void test(){
        //设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        String username = "admin";
        //对密码进行加密
        String password = "123";

        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

//        登陆
//        SecurityUtils.getSubject().login(token);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
//        登陆
        subject.login( token );

        System.out.println(subject.hasRole("系统管理员"));
        System.out.println(subject.isPermitted("sys:user"));

        // 退出登录
        subject.logout();
    }
}
