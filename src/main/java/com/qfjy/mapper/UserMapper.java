package com.qfjy.mapper;

import com.qfjy.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where uname=#{uname}")
    User selectByUname(String uname);

    @Select("SELECT r.rname FROM user u\n" +
            "LEFT JOIN user_role ur ON  u.id=ur.uid\n" +
            "LEFT JOIN role r ON r.id=ur.rid\n" +
            "WHERE u.uname=#{uname} AND u.status=1")
    Set<String> selectRolesByUname(String uname);

    @Select("SELECT rname FROM role where status=1")
    Set<String> selectAllRoles();
}