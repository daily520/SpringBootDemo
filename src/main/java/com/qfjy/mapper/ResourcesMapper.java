package com.qfjy.mapper;

import com.qfjy.po.Resources;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);

    @Select("SELECT * FROM resources WHERE status=1 ORDER BY sortnum")
    List<Resources> selectAllResource();
}