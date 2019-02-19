package com.jk.controller;

import com.jk.bean.Dept;
import com.jk.bean.Role;
import com.jk.bean.UserBean;
import com.jk.service.UserBeanService;
import com.jk.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserBeanController {

    @Autowired
    private UserBeanService userBeanService;

    //查询用户表
    @RequestMapping("queryUserBean")
    @ResponseBody
    public HashMap<String,Object> queryUserBean(int page, int rows, UserBean userBean){


        return userBeanService.queryUserBean(page,rows,userBean);
    }

    //修改进入后的 用户密码
    @RequestMapping("updatpwd")
    @ResponseBody
    public  void  updatPwd(UserBean userBean, HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        userBean.setUid(uid);
        userBeanService.updatPwd(userBean);
    }

    //查询角色
    @RequestMapping("queryUserRole")
    @ResponseBody
    public List<Role> queryUserRole(){
        return userBeanService.queryUserRole();
    }

    //查询部门
    @RequestMapping("queryUserDeptid")
    @ResponseBody
    public List<Dept> queryUserDeptid(){
        return userBeanService.queryUserDeptid();
    }



    //上传图片
    @RequestMapping("uploadUserImgww")
    @ResponseBody
    public String uploadUserImg(MultipartFile image, HttpServletRequest request){
        return FileUtil.FileUpload(image, request);
    }


    //修改 ： 新增
    @RequestMapping("addUser")
    @ResponseBody
    public void  addAnswer(UserBean userbean){

        Integer id = userbean.getId();
        if (id!=null){
            //修改
            userbean.setUserimg("uuuuu");
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            userbean.setRegistration_date(sdf.format(data));
            userBeanService.updateUserBean(userbean);
        }else {
            //新增
            userbean.setUserimg("uuuuu");
            Date data = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            userbean.setRegistration_date(sdf.format(data));
            userBeanService.addUserBean(userbean);
        }

    }

    //修改回显
    @RequestMapping("queryUserById")
    @ResponseBody
    public UserBean queryEvaluateById(Integer id){

        UserBean  userbean   = userBeanService.queryUserById(id);
        return userbean;
    }


    //批量删除
    @RequestMapping("deleteUserAll")
    @ResponseBody
    public  void  deleteUserAll(String id){
        userBeanService.deleteAll(id);
    }

}
