package com.sample.rest.domain;

import org.springframework.hateoas.ResourceSupport;

import com.sample.integration.domain.Country;

public class CountriesWithCurrency extends ResourceSupport {
	
	private Country[] countries;
	
	private int totalNum;
	
	private int currentPage;

	public Country[] getCountries() {
		return countries;
	}

	public void setCountries(Country[] countries) {
		this.countries = countries;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
