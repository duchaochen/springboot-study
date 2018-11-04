package com.adu.testdatasource.test02.service;

import com.adu.springboot.entity.DeptEntity;
import com.adu.testdatasource.test02.mapper.DeptMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptService02 {

    @Autowired
    private DeptMapper02 deptMapper02;

    @Transactional(transactionManager="test2TransactionManager")
    public List<DeptEntity> getAll() {
        List<DeptEntity> deptAll = deptMapper02.getAll();
        return deptAll;
    }
}
