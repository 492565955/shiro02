package cn.juechuang.service.impl;

import cn.juechuang.service.UserSevice;
import cn.juechuang.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class UserSeviceimplTest {

    @Autowired
    UserSevice userSevice;
    @Test
    public void login() {
//        System.out.println(userSevice.login("admin", "123"));
//        System.out.println("1111");
//        System.out.println( MD5Util.md5( "123", "123" ) );
    }

    @Test
    public void getUserRoleSet() {
    }

    @Test
    public void getUserPermissionSet() {
    }
}