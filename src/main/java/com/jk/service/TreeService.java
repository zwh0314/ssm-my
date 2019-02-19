package com.jk.service;

import com.jk.bean.PowerMenu;
import com.jk.bean.Tree;
import com.jk.bean.UserBean;

import java.util.List;

public interface TreeService {
    List<Tree> queryTree(Integer uid);

    UserBean queryUserByLoginNumber(String username);


    List<Tree> authTree2(String id);

    void saveRolePower(Integer roleId, String powerIds);

    List<PowerMenu> querypowerMenu(String powerId);

    String savePowerMenu(PowerMenu powerMenu);

    void deleteAll(String id);
}
