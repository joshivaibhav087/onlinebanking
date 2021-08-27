
package com.org.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityModuleOauth2Application {

	
	public static void main(String[] args) {
		SpringApplication.run(SecurityModuleOauth2Application.class, args);
		System.out.println("============================================");
		System.out.println("online banking application  | SPRINGBOOT RUNNING ON PORT 8080");

		
		
	}
	


}
