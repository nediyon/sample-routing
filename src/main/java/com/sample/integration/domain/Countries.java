package com.sample.integration.domain;

import java.io.Serializable;


public class Countries implements Serializable {

	private static final long serialVersionUID = 1L;

	private Country[] countries;
	
	private int totalNum;


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
	

}
