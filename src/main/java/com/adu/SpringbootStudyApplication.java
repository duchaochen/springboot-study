package com.adu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages={
//		"com.adu.springboot.mapper",
//		"com.adu.testdatasource.test01.mapper",
//		"com.adu.testdatasource.test02.mapper"
//})

public class SpringbootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}
}
