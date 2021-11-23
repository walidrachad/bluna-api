package com.vaibhav.sec;

import com.vaibhav.sec.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SSecApplication {
	public static void main(String[] args) {
		SpringApplication.run(SSecApplication.class, args);
	}
}
