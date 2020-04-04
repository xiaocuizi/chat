package com.gemini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *   聊天系统
 * </p>
 *
 * @author xiaocuizi
 * @since 2020-04-03
 */
@MapperScan("com.gemini.chat.mapper")
@SpringBootApplication
public class GeminiChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiChatApplication.class, args);
	}

}
