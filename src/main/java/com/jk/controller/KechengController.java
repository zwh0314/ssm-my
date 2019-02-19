package com.jk.controller;

import com.jk.bean.Kecheng;
import com.jk.service.KechengService;
import com.jk.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class KechengController {

    @Autowired
    private KechengService kechengService;




    //查询用户表
    @RequestMapping("querykechen")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Kecheng kecheng){
        HashMap<String,Object> list = kechengService.querykechen(page,rows, kecheng);

        return list;
    }


    //批量删除
    @RequestMapping("deleteKechenAll")
    @ResponseBody
    public  void  deleteAll(String id){

        kechengService.deleteAll(id);
    }

    //修改回显
   @RequestMapping("queryKechengById")
    @ResponseBody
    public Kecheng queryKechengById(Integer id){

       Kecheng  kecheng   = kechengService.queryKechengById(id);
        return kecheng;
    }


    //上传图片
    @RequestMapping("uploadUserImg")
    @ResponseBody
    public String uploadUserImg(MultipartFile image, HttpServletRequest request){
        return FileUtil.FileUpload(image, request);
    }


    //修改 ： 新增
    @RequestMapping("addKechen")
    @ResponseBody
    public void  addAnswer(Kecheng kecheng){

        Integer id = kecheng.getId();
        if (id!=null){
            //修改
            kecheng.setKurl("uuuuu");
            kechengService.updateKecheng(kecheng);
        }else {
            //新增
            kecheng.setKurl("uuuuu");
            kecheng.setLls(0);
            kechengService.addKecheng(kecheng);
        }

    }

}
