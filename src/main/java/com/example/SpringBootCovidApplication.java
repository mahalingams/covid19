package com.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackageClasses = { com.example.controllers.CovidController.class,
		com.example.services.CovidServiceImpl.class })
public class SpringBootCovidApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootCovidApplication.class, args);
		openHomePage();
	}

	private static void openHomePage() throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		headers.add("x-rapidapi-key", "854ff58740msh8c5ef61494b05acp141142jsnf7a383c5303b");
		return headers;
	}

}
