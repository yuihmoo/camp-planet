package com.camp.planet;

import com.camp.planet.file.service.MinioBucketService;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CampPlanetApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CampPlanetApplication.class);
		ConfigurableApplicationContext context = builder.run(args);

        MinioBucketService minioBucketService = context.getBean(MinioBucketService.class);
        minioBucketService.createBucket("public");
		minioBucketService.createBucket("private");
		minioBucketService.setWebHookNotificationOfBucket("public");
        minioBucketService.setWebHookNotificationOfBucket("private");
	}

}
