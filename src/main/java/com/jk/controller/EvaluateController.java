package com.jk.controller;


import com.jk.bean.Evaluate;
import com.jk.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;


    //查询用户表
    @RequestMapping("queryPinLun")
    @ResponseBody
    public HashMap<String,Object> queryUserBean(int page, int rows, Evaluate evaluate){


        return evaluateService.queryPinLun(page,rows,evaluate);
    }

    //批量删除
    @RequestMapping("deleteAll")
    @ResponseBody
    public  void  deleteAll(String id){
        evaluateService.deleteAll(id);
    }

    //修改回显
    @RequestMapping("queryEvaluateById")
    @ResponseBody
    public Evaluate queryEvaluateById(Integer id){

        Evaluate  evaluate  = evaluateService.queryEvaluateById(id);
        return evaluate;
    }

    //修改 ： 新增
    @RequestMapping("addEvaluate")
    @ResponseBody
    public void  addEvaluate(Evaluate evaluate){

        Integer id = evaluate.getId();
        if (id!=null){
            //修改
            evaluateService.updateEvaluate(evaluate);
        }else {
            //新增
            evaluateService.addEvaluate(evaluate);
        }

    }
}
