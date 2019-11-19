package com.qfjy.web.shiro;



import com.qfjy.po.User;
import com.qfjy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Set<String> roles=new HashSet<>();
        String uname= (String) principalCollection.getPrimaryPrincipal();
        roles=userService.selectRolesByUname(uname);
        if (roles.contains("admin")){
            roles=userService.selectAllRoles();
        }

        AuthorizationInfo info =new SimpleAuthorizationInfo(roles);
        return info;
    }

    /*
    token是前台传过来的信息
    */
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String uname = upToken.getUsername();
        //根据用户查询用户名是否存在
        User user = userService.selectByUname(uname);
        if (user==null){
            throw new UnknownAccountException("用户名不存在");
        }
        //检查用户是否可用
        if(user.getStatus()==0){
            throw new LockedAccountException("改账户因异常,暂时无法访问");
        }
        //密码的比较是由Shiro完成的
        //用户名唯一标识
        Object principal = uname;
        //数据库中的用户密码
        Object credentials = user.getUpass();
        //realm
        String realmName = super.getName();
        //盐
        ByteSource salt= ByteSource.Util.bytes(((UsernamePasswordToken) token).getUsername());
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
        return info;
    }
}
