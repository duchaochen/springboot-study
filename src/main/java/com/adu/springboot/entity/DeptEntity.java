package com.adu.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptEntity {
    private Long deptno;
    private String dname;
    private String db_source;

//    public static void main(String[] args) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName("zhangsan");
//        userEntity.setAge(20);
//        System.out.println(userEntity.toString());
//        log.info("####我是日志##########");
//    }

}