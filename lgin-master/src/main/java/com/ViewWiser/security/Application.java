package com.ViewWiser.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication /** to say it is spring boot application */
@EnableJpaRepositories(basePackageClasses = AssetUserRepository.class) /**
																	 * To recogranise user repository to create user
																	 * table to store login data
																	 */
 
public class Application {

	public static void main(String[] args) /** main class */
	{
		SpringApplication.run(Application.class, args);
	}

}
