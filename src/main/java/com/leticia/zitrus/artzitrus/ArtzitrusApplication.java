package com.leticia.zitrus.artzitrus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.leticia.zitrus.artzitrus")
@EntityScan(basePackages = "com.leticia.zitrus.artzitrus.model")
@EnableConfigurationProperties
public class ArtzitrusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtzitrusApplication.class, args);
	}

}
