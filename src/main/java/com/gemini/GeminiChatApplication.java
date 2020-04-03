package com.gemini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gemini.chat.mapper")
@SpringBootApplication
public class GeminiChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiChatApplication.class, args);
	}

}
