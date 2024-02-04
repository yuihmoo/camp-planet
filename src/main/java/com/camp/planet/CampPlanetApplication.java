package com.camp.planet;

import com.camp.planet.file.service.BucketService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CampPlanetApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CampPlanetApplication.class);
		ConfigurableApplicationContext context = builder.run(args);

        BucketService bucketService = context.getBean(BucketService.class);
        bucketService.createBucket("public");
		bucketService.createBucket("private");
		bucketService.setWebHookNotificationOfBucket("public");
        bucketService.setWebHookNotificationOfBucket("private");
	}
}
