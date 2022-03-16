package com.example.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Covid19StatsDto;
import com.example.dto.CovidDataDto;
import com.example.model.Covid19Stats;
import com.example.model.CovidData;
import com.example.repositories.CovidRepository;

@Service
public class CovidServiceImpl implements CovidService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private CovidRepository covidRepository;

	@Autowired
	public CovidServiceImpl(RestTemplate restTemplate, HttpHeaders headers, CovidRepository covidRepository) {
		this.restTemplate = restTemplate;
		this.headers = headers;
		this.covidRepository = covidRepository;
	}

	/**
	 * This method is used to get the all countries covid 19 details.
	 * 
	 * @return list This returns list of covid 19 details.
	 */
	public List<Covid19StatsDto> getAllCountries() {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=All", HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		return data.getBody().getData().getCovid19Stats();
	}

	/**
	 * this method is used to get the covid 19 details based on country.
	 * 
	 * @param country
	 * @return list This returns list of covid 19 details.
	 */
	public List<Covid19StatsDto> getUsa(String country) {
		ResponseEntity<CovidDataDto> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=" + country, HttpMethod.GET,
				new HttpEntity<>(headers), CovidDataDto.class);
		return data.getBody().getData().getCovid19Stats();
	}

	/**
	 * This method is used to get the USA country covid 19 details.
	 * 
	 * @param page this used which page records need to fetch
	 * @param size this used to how many records need to fetch
	 * @return list This returns list of covid 19 details.
	 */

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

	/**
	 * This method is used to save the USA country covid 19 details in table.
	 * 
	 * @return string .
	 */
	public String saveDetails() {
		ResponseEntity<CovidData> data = restTemplate.exchange(
				"https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=USA", HttpMethod.GET,
				new HttpEntity<>(headers), CovidData.class);
		List<Covid19Stats> covid19Stats = data.getBody().getData().getCovid19Stats();
		covidRepository.saveAll(covid19Stats);
		return "Saved Successfully...";
	}

	/**
	 * This method is used to get the USA country covid 19 details from table.
	 *
	 * @param page this used which page records need to fetch
	 * @param size this used to how many records need to fetch
	 * @return list This returns list of covid 19 details.
	 */

	@Override
	public List<Covid19StatsDto> getUsaDetailsWithTable(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Covid19Stats> covid19Stats = covidRepository.findAll(paging);
		List<Covid19StatsDto> covid19StatsDto = covid19Stats.stream()
				.map(new Function<Covid19Stats, Covid19StatsDto>() {
					@Override
					public Covid19StatsDto apply(Covid19Stats s) {
						// a simple mapping from domain to dto
						return new Covid19StatsDto(s.getId(), s.getCity(), s.getProvince(), s.getCountry(),
								s.getLastUpdate(), s.getKeyId(), s.getConfirmed(), s.getDeaths(), s.getRecovered());
					}
				}).collect(Collectors.toList());
		return covid19StatsDto;
	}
}
