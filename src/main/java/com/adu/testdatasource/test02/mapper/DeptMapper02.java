package com.adu.testdatasource.test02.mapper;

import com.adu.springboot.entity.DeptEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper02 {

    @Select("select * from dept")
    List<DeptEntity> getAll();
}
