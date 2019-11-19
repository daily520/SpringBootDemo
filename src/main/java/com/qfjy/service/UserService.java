package com.qfjy.service;


import com.qfjy.po.User;

import java.util.Set;

public interface UserService {
    //查询用户是否存在
    User selectByUname(String uname);

    Set<String> selectRolesByUname(String uname);

    Set<String> selectAllRoles();
}
