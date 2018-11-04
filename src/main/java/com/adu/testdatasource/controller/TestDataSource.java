package com.adu.testdatasource.controller;

import com.adu.springboot.entity.DeptEntity;
import com.adu.testdatasource.test01.service.DeptService01;
import com.adu.testdatasource.test02.service.DeptService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestDataSource {

    @Autowired
    private DeptService01 deptService01;

    @Autowired
    private DeptService02 deptService02;

    @RequestMapping("/deptService01")
    public List<DeptEntity> findAll1() {
        List<DeptEntity> all = deptService01.getAll();
        return all;
    }

    @RequestMapping("/deptService02")
    public List<DeptEntity> findAll2() {
        List<DeptEntity> all = deptService02.getAll();
        return all;
    }

}
