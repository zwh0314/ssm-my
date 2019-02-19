package com.jk.service;

import com.jk.bean.WebUser;

import java.util.HashMap;

public interface WebUserService {
    HashMap<String, Object> queryWebUser(int page, int rows, WebUser webuser);

    WebUser queryWebUserById(Integer id);

    void updateWebUser(WebUser webuser);

    void addWebUser(WebUser webuser);

    void deleteAll(String id);
}
