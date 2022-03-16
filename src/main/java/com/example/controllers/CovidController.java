package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Covid19StatsDto;
import com.example.services.CovidService;

@RestController
@RequestMapping("api/covid")
public class CovidController {

	@Autowired
	CovidService covidService;

	/**
	 * This method is used to get the all countries covid 19 details.
	 * 
	 * @return list This returns list of covid 19 details.
	 */
	@GetMapping("/get-all-countries")
	public List<Covid19StatsDto> getAllCountries() {
		return covidService.getAllCountries();
	}

	/**
	 * this method is used to get the covid 19 details based on country.
	 * 
	 * @param country
	 * @return list This returns list of covid 19 details.
	 */
	@GetMapping("/get-usa/{country}")
	public List<Covid19StatsDto> getUsa(@PathVariable(name = "country") String country) {
		return covidService.getUsa(country);
	}

	/**
	 * This method is used to get the USA country covid 19 details.
	 * 
	 * @param page this used which page records need to fetch
	 * @param size this used to how many records need to fetch
	 * @return list This returns list of covid 19 details.
	 */
	@GetMapping("/get-usa-with-limit/{page}/{size}")
	public List<Covid19StatsDto> getUsa(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {

		return covidService.getUsa(page, size);
	}
	@PostMapping("/SaveDetails")
	public void saveDetails() {
		covidService.saveDetails();
	}
	}
}