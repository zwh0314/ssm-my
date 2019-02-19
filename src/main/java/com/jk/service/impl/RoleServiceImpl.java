package com.jk.service.impl;

import com.jk.bean.Role;
import com.jk.mapper.RoleMapper;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRole() {
        return roleMapper.queryRole();
    }
}
