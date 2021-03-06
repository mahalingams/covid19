package com.example.dto;

import java.util.Date;

public class Covid19StatsDto {

	private Long id;
	private String city;
	private String province;
	private String country;
	private Date lastUpdate;
	private String keyId;
	private Long confirmed;
	private Long deaths;
	private Long recovered;

	public Covid19StatsDto() {
		super();
	}

	public Covid19StatsDto(Long id, String city, String province, String country, Date lastUpdate, String keyId,
			Long confirmed, Long deaths, Long recovered) {
		super();
		this.id = id;
		this.city = city;
		this.province = province;
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.keyId = keyId;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public Long getDeaths() {
		return deaths;
	}

	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}

	public Long getRecovered() {
		return recovered;
	}

	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}

	@Override
	public String toString() {
		return "Covid19StatsDto [id=" + id + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", lastUpdate=" + lastUpdate + ", keyId=" + keyId + ", confirmed=" + confirmed + ", deaths=" + deaths
				+ ", recovered=" + recovered + "]";
	}

}
