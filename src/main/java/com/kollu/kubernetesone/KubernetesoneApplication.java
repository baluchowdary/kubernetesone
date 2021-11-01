package com.kollu.kubernetesone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.kollu.kubernetesone")
public class KubernetesoneApplication {

	private static Logger logger = LoggerFactory.getLogger(KubernetesoneApplication.class);
	public static void main(String[] args) {
		System.out.println("Console:: i am from 1KubernetesoneApplication main");
		logger.info("i am from 1KubernetesoneApplication main");
		SpringApplication.run(KubernetesoneApplication.class, args);
	}

}
