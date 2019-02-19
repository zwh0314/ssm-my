package com.jk.service.impl;

import com.jk.bean.PowerMenu;
import com.jk.bean.Tree;
import com.jk.bean.UserBean;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl  implements TreeService {

    @Autowired
    private TreeMapper treeMapper;
//查询数
    @Override
    public List<Tree> queryTree(Integer uid) {
        return treeMapper.queryTree(uid);
    }
//登陆
    @Override
    public UserBean queryUserByLoginNumber(String username) {
        return treeMapper.queryUserByLoginNumber(username);
    }
//查询中间树
    @Override
    public List<Tree> authTree2(String id) {

        List<Tree>  RoleId = treeMapper.queryByRoleId(id);

        List<Tree> list = treeMapper.authTree2();
        for (Tree tree :list) {
            for ( Tree role: RoleId) {
                if (tree.getId()==role.getId()){
                    tree.setChecked(true);
                }
            }
        }

        return list;
    }
    //新增权限列表
    @Override
    public void saveRolePower(Integer roleId, String powerIds) {

        // 新增前删除 新增重复的
        treeMapper.deleteRolePowerById(roleId);
        //新增权限列表
        String[] split = powerIds.split(",");

        for (int i=0;i<split.length;i++){
            treeMapper.saveRolePower(roleId,split[i]);
        }
    }

    @Override
    public List<PowerMenu> querypowerMenu(String powerId) {

        return treeMapper.querypowerMenu(powerId);
    }

    //新权限详情
    @Override
    public String savePowerMenu(PowerMenu powerMenu) {
        return treeMapper.savePowerMenu(powerMenu);
    }


    //删除权限
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            treeMapper.deleteAll(sid[i]);
        }
    }


}
