package com.sample.integration.domain;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<Currency> currencies;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
	

}
