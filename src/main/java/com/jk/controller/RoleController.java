package com.jk.controller;

import com.jk.bean.Role;
import com.jk.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查询角色
    @RequestMapping("queryRole")
    @ResponseBody
    public List<Role> queryRole(){

        return roleService.queryRole();
    }
}
