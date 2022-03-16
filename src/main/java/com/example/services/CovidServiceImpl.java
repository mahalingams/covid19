package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.controllers.CovidController;
import com.example.dto.Covid19StatsDto;
import com.example.dto.CovidDataDto;
import com.example.model.Covid19Stats;
import com.example.repositories.CovidRepository;

@Service
public class CovidServiceImpl implements CovidService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	HttpHeaders headers;
	@Autowired
	CovidRepository covidRepository;

	public List<Covid19StatsDto> getAllCountries() {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=All", HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		return data.getBody().getData().getCovid19Stats();
	}

	public List<Covid19StatsDto> getUsa(String country) {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=" + country, HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		return data.getBody().getData().getCovid19Stats();
	}

	public List<Covid19StatsDto> getUsa(int page, int size) {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=US", HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		int start = page * size;
		int end = (int) ((start + size) > data.getBody().getData().getCovid19Stats().size()
				? data.getBody().getData().getCovid19Stats().size()
				: (start + size));

		return data.getBody().getData().getCovid19Stats().subList(start, end);
	}

	public void saveDetails() {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA", HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		//List<Covid19Stats> covid19Stats = data.getBody().getData().getCovid19Stats();
		//covidRepository.saveAll(covid19Stats);
	}
}
