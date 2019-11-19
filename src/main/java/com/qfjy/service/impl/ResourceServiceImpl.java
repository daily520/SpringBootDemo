package com.qfjy.service.impl;

import com.qfjy.mapper.ResourcesMapper;
import com.qfjy.po.Resources;
import com.qfjy.service.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Resource
    private ResourcesMapper resourcesMapper;
    @Override
    public List<Resources> selectAllResource() {
        return resourcesMapper.selectAllResource();
    }
}
