package com.jk.mapper;


import com.jk.bean.Catalog;
import com.jk.bean.Kecheng;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatalogMaper {
    //查询总条数
    @Select("select count(*)  FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id")
    long queryTota(@Param("catalog") Catalog catalog);
    //查询
    @Select("SELECT * FROM t_catalog c LEFT JOIN t_kecheng k on  c.kid=k.id  LIMIT #{start},#{rows}")
    List<Catalog> queryPageCatalog(@Param("start") int start, @Param("rows") int rows, @Param("catalog") Catalog catalog);


    //查询角色
    @Select("SELECT k.id ,k.kname from t_kecheng k")
    List<Kecheng> queryRole();


    //新增
    @Insert("INSERT into t_catalog(mlname,kid) VALUES(#{mlname},#{kid})")
    void addCatalog(Catalog catalog);


    //修改回显
    @Select("SELECT * FROM t_catalog c where c.id=#{id}")
    Catalog queryEvaluateById(Integer id);

    //修改
    @Update("UPDATE t_catalog c SET c.mlname=#{mlname} ,c.kid=#{kid} where c.id=#{id}")
    void updateCatalog(Catalog catalog);

    @Delete("delete from t_catalog where id=#{s}")
    void deleteAll(String s);
}
