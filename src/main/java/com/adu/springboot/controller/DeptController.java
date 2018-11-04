package com.adu.springboot.controller;

import com.adu.springboot.entity.DeptEntity;
import com.adu.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

//    @GetMapping("/getAll")
//    public List<DeptEntity> getAll() {
//        List<DeptEntity> deptAll = deptService.getAll();
//        return deptAll;
//    }
}
