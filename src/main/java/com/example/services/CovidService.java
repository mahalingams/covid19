package com.example.services;

import java.util.List;

import com.example.dto.Covid19StatsDto;

public interface CovidService {
	public List<Covid19StatsDto> getAllCountries();

	public List<Covid19StatsDto> getUsa(String country);

	public List<Covid19StatsDto> getUsa(int page, int size);
	public void saveDetails();
}
