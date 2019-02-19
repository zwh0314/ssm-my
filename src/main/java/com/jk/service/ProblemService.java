package com.jk.service;


import com.jk.bean.ProblemBean;

import java.util.HashMap;

public interface ProblemService {


    HashMap<String, Object> queryProblem2(int page, int rows, ProblemBean problemBean);

    void deleteAll(String id);

    void addProblemBean(ProblemBean problemBean);
}
