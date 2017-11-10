package com.sample.rest.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.integration.domain.Countries;
import com.sample.integration.domain.Country;
import com.sample.integration.service.ExternalCountryService;
import com.sample.rest.domain.CountriesWithCurrency;

@Controller
@RequestMapping(value = "/countries")
public class CountriesAndCurrenciesAPI {
	
	@Autowired
	private ExternalCountryService extCountryService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> retrieve(@RequestParam(value="page", required=false) String page) {
		Countries resp = loadCountries();
		int reqestedPage = 0;
		if(page != null && !"".equals(page)){
			try{
				reqestedPage = Integer.parseInt(page);
			} catch(NumberFormatException e){
			}
		}
		
		CountriesWithCurrency response = prepareResponse(reqestedPage,resp.getCountries());
		

		return new ResponseEntity<CountriesWithCurrency>(response, HttpStatus.OK);
	}
	
	private Countries loadCountries(){
		return extCountryService.getCountryNamesAndCurriencies();
	}
	
	private CountriesWithCurrency prepareResponse(int page, Country[] countryNameCurrencies) {
		int length = countryNameCurrencies.length;
		CountriesWithCurrency response = new CountriesWithCurrency();
		response.setCurrentPage(page);
		response.setTotalNum(length);
    	
	    int to = (page + 1) * 5;	    
	    int from = to - 5;
	    
	    if(to > length)
	    	to = length;
	    
	    Country[] paginated = Arrays.copyOfRange(countryNameCurrencies, from, to);
	    response.setCountries(paginated);
	    
	    Link self = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CountriesAndCurrenciesAPI.class).retrieve(String.valueOf(page))).withSelfRel();
	    response.add(self);
	    
	    if(page>0){
	    	Link previous = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CountriesAndCurrenciesAPI.class).retrieve(String.valueOf(page-1))).withRel("previous");
		    response.add(previous);
	    }
	    if(to < length){
	    	Link next = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CountriesAndCurrenciesAPI.class).retrieve(String.valueOf(page+1))).withRel("next");
		    response.add(next);
	    }
	    
    	return response;
    }

}
