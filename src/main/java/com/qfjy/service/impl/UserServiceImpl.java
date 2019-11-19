package com.qfjy.service.impl;


import com.qfjy.mapper.UserMapper;
import com.qfjy.po.User;
import com.qfjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUname(String uname) {
        return userMapper.selectByUname(uname);
    }

    @Override
    public Set<String> selectRolesByUname(String uname) {
        return userMapper.selectRolesByUname(uname);
    }

    @Override
    public Set<String> selectAllRoles() {
        return userMapper.selectAllRoles();
    }
}
