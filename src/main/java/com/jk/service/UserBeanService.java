package com.jk.service;

import com.jk.bean.Dept;
import com.jk.bean.Role;
import com.jk.bean.UserBean;

import java.util.HashMap;
import java.util.List;

public interface UserBeanService {
    HashMap<String,Object> queryUserBean(int page, int rows, UserBean userBean);

    void updatPwd(UserBean userBean);

    List<String> queryPowerMenuByUserid(Integer id);

    List<Role> queryUserRole();

    List<Dept> queryUserDeptid();

    void updateUserBean(UserBean userbean);

    void addUserBean(UserBean userbean);

    UserBean queryUserById(Integer id);

    void deleteAll(String id);
}
