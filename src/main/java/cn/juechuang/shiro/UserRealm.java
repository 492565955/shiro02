package cn.juechuang.shiro;

import cn.juechuang.mapper.UserMapper;
import cn.juechuang.model.User;
import cn.juechuang.service.UserSevice;
import cn.juechuang.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserSevice userSevice;
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("进入授权");
//        初始化授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        获取认证信息
        User user = (User) principalCollection.getPrimaryPrincipal();
//        初始化角色信息表
//        先模拟
        Set<String> roles =  new HashSet<>();
        roles = userSevice.getUserRoleSet( user.getId());

//        Set<String> roles = userMapper.findall();

//        模拟权限信息
        Set<String> permissions=new HashSet<>();

        permissions = userSevice.getUserPermissionSet( user.getId() );
//        permissions.add("user:create");
//        permissions.add("user:delete");
//        permissions.add("user:update");
//        把角色和权限信息添加到授权对象
        System.out.println(roles);
        System.out.println(permissions);
        //添加到授权信息中
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }
//    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("进入认证");
//        通过令牌去获取用户名
        String usernmae  = (String) authenticationToken.getPrincipal();
        //获取用户输入的密码(因为获取的是二进制需要转换)
        String password = new String ((char[]) authenticationToken.getCredentials());
        //模拟从数据库中获取对应的用户数据
//        User user = new User("admin", MD5Util.md5("123456","123456"),"1");
        User user = userSevice.login( usernmae, password );
        //进行信息比对
//        if (!usernmae.equals(user.getUsername())) {
//            throw new UnknownAccountException("用户不存在");
//        }
//        if (!password.equals(user.getPassword())){
//            throw new IncorrectCredentialsException("密码错误");
//        }
        if(user == null){
            throw  new UnknownAccountException( "账号或密码错误" );
        }


        //如果没有异常则表示认证通过则返回一个简单的认证数据模型
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
