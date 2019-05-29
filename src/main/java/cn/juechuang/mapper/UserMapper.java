package cn.juechuang.mapper;

import cn.juechuang.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.Set;

public interface UserMapper extends Mapper<User> {
    public Set<String> getUserRoleSet(Integer userId);
    public Set<String> getUserPermissionSet(Integer userId);
}