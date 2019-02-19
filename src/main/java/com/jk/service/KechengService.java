package com.jk.service;

import com.jk.bean.Kecheng;

import java.util.HashMap;

public interface KechengService {
    HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng);

    void deleteAll(String id);

    void addKecheng(Kecheng kecheng);

    void updateKecheng(Kecheng kecheng);

    Kecheng queryKechengById(Integer id);
}
