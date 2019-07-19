package com.xieli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xieli.mapper")
public class ShangchuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShangchuanApplication.class, args);
	}

}