package com.jk.service;

import com.jk.bean.Catalog;
import com.jk.bean.Kecheng;

import java.util.HashMap;
import java.util.List;

public interface CatalogService {
    HashMap<String, Object> queryCatalog(int page, int rows, Catalog catalog);

    List<Kecheng> queryRole();

    void addCatalog(Catalog catalog);

    Catalog queryEvaluateById(Integer id);

    void updateCatalog(Catalog catalog);

    void deleteAll(String id);
}
