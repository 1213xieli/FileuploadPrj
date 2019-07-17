package com.xieli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xieli.mapper")
public class ShangchuanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShangchuanApplication.class, args);
		System.out.print("视频上传项目启动类1.==="+"\n");
	}

}
//@SpringBootApplication
//public class ShangchuanApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
//
//	//	打包war需要这个启动类，发布到服务器上
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
//		System.out.print("视频上传项目启动类2.==="+"\n");
//		return application.sources(ShangchuanApplication.class);
//	}
//
//	public static void main(String[] args) {
//		System.out.print("视频上传项目启动类1.==="+"\n");
//		SpringApplication.run(ShangchuanApplication.class, args);
//	}
//
//}
