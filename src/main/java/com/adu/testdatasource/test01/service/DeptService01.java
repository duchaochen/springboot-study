package com.adu.testdatasource.test01.service;

import com.adu.springboot.entity.DeptEntity;
import com.adu.testdatasource.test01.mapper.DeptMapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptService01 {

    @Autowired
    private DeptMapper01 deptMapper01;

    /**
     * 指定事物为test1TransactionManager
     * @return
     */
    @Transactional(transactionManager="test1TransactionManager")
    public List<DeptEntity> getAll() {
        List<DeptEntity> deptAll = deptMapper01.getAll();
        return deptAll;
    }
}
