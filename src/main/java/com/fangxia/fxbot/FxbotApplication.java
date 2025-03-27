package com.fangxia.fxbot;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fangxia.fxbot.mapper")
public class FxbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxbotApplication.class, args);
	}

}
