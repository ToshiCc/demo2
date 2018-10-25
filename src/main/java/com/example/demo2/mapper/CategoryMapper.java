package com.example.demo2.mapper;

import com.example.demo2.pojo.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category2> findAll();
    List<Category2> findAll2();
}
