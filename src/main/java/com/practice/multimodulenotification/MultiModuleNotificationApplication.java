package com.practice.multimodulenotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MultiModuleNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleNotificationApplication.class, args);
	}
}
