package com.adu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan(basePackages={
//		"com.adu.springboot.mapper",
//		"com.adu.testdatasource.test01.mapper",
//		"com.adu.testdatasource.test02.mapper"
//})
/**
 * @ComponentScan+@EnableAutoConfiguration=@SpringBootApplication
 */
//@ComponentScan(basePackages = "")
//@EnableAutoConfiguration
public class SpringbootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}
}
