package com.freezefootball.frzftball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FrzftballApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrzftballApplication.class, args);
	}

	@Bean
	public UserList UserList(){
		return new UserList();
	}


}
