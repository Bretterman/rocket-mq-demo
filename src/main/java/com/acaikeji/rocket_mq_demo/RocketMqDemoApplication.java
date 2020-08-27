package com.acaikeji.rocket_mq_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// @EnableAsync
@SpringBootApplication
public class RocketMqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketMqDemoApplication.class, args);
	}

}
