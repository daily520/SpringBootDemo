package com.qfjy.web.controller;

import com.qfjy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;


@RequestMapping("user")
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(method = RequestMethod.POST,value="login")
    public String login(@RequestParam("uname") String uname , @RequestParam("upass") String upass,
                        Map<String,Object> map){
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(uname, upass);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                map.put("msg",uae.getMessage());
                return "/login";
            } catch (IncorrectCredentialsException ice) {
                map.put("msg","密码输入错误");
                return "/login";
            } catch (LockedAccountException lae) {
                map.put("msg",lae.getMessage());
                return "/login";
            }
            catch (AuthenticationException ae) {
                System.out.println("用户名或密码错误");
            }
        }
        return "/success";
    }
    @RequestMapping("logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();

        currentUser.logout();
        return "/login";
    }
}
