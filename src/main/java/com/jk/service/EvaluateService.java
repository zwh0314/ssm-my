package com.jk.service;

import com.jk.bean.Evaluate;

import java.util.HashMap;

public interface EvaluateService {
    HashMap<String, Object> queryPinLun(int page, int rows, Evaluate evaluate);

    void deleteAll(String id);

    Evaluate queryEvaluateById(Integer id);

    void updateEvaluate(Evaluate evaluate);

    void addEvaluate(Evaluate evaluate);
}
