package io.app.SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.app.SpringBootApp.Config.SwaggerConfig;
import io.app.SpringBootApp.Config.WebConfig;
import io.swagger.models.Swagger;

@SpringBootApplication
@Import({WebConfig.class, SwaggerConfig.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
