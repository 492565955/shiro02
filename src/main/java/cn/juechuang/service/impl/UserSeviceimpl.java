package cn.juechuang.service.impl;

import cn.juechuang.mapper.UserMapper;
import cn.juechuang.model.User;
import cn.juechuang.service.UserSevice;
import cn.juechuang.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserSeviceimpl implements UserSevice {


    @Autowired(required = false)
    UserMapper mapper;

    @Override
    public User login(String username, String password) {
        User param = new User();
        param.setUsername( username );
        param.setPassword( MD5Util.md5(password,password));
        return mapper.selectOne(param);
    }

//    获取所有角色
    @Override
    public Set<String> getUserRoleSet(Integer userId) {
        return  mapper.getUserRoleSet( userId );
    }

//    获取用户授权
    @Override
    public Set<String> getUserPermissionSet(Integer userId) {
        return mapper.getUserPermissionSet( userId );
    }

    @Override
    public List<User> getlist() {
        return mapper.selectAll();
    }
}