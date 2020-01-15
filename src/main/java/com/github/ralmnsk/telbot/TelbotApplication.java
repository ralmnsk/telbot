package com.github.ralmnsk.telbot;

import com.github.ralmnsk.telbot.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication

public class TelbotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(TelbotApplication.class, args);
	}
}
