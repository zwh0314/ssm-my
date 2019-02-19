package com.jk.controller;




import com.jk.bean.ProblemBean;
import com.jk.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class ProblemController {

    @Autowired
    private ProblemService problemService;



    //查询用户表
    @RequestMapping("queryProblem2")
    @ResponseBody
        public  HashMap<String,Object> queryProblem2(int page, int rows, ProblemBean problemBean){
            HashMap<String,Object> list = problemService.queryProblem2(page,rows, problemBean);

            return list;
        }


    //批量删除
    @RequestMapping("deleteProblemAll")
    @ResponseBody
    public  void  deleteAll(String id){

        problemService.deleteAll(id);
    }

    //修改回显
  /*  @RequestMapping("queryProblemById")
    @ResponseBody
    public ProblemBean queryEvaluateById(Integer id){

        ProblemBean  problem   = problemService.queryEvaluateById(id);
        return problem;
    }*/

    //修改 ： 新增
    @RequestMapping("addProblemBean")
    @ResponseBody
    public void  addAnswer(ProblemBean problemBean){

        Integer id = problemBean.getid();
        if (id!=null){
            //修改
            // answerService.updateAnsweranswer);
        }else {
            //新增
            problemService.addProblemBean(problemBean);
        }

    }

}
