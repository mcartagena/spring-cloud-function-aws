package com.mcartagena;

import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudFunctionAwsApplication {

	public static void main(String[] args) {
		FunctionalSpringApplication.run(SpringCloudFunctionAwsApplication.class, args);
	}

	@Bean
	public Function<String, String> uppercase(){
		return (String request) -> request.toUpperCase();
	}
}
