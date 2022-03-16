package com.example.dto;

import java.util.Date;
import java.util.List;

public class DataDto {

	private Date lastChecked;

	private List<Covid19StatsDto> covid19Stats;

	public Date getLastChecked() {
		return lastChecked;
	}

	public void setLastChecked(Date lastChecked) {
		this.lastChecked = lastChecked;
	}

	public List<Covid19StatsDto> getCovid19Stats() {
		return covid19Stats;
	}

	public void setCovid19Stats(List<Covid19StatsDto> covid19Stats) {
		this.covid19Stats = covid19Stats;
	}

	@Override
	public String toString() {
		return "DataDto [lastChecked=" + lastChecked + ", covid19Stats=" + covid19Stats + "]";
	}
	
}
