package cn.juechuang.service;

import cn.juechuang.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface UserSevice {
    public User login(String username, String password);

    public Set<String> getUserRoleSet(Integer userId);

    public Set<String> getUserPermissionSet(Integer userId);

    public List<User> getlist();
}
