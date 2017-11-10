package com.sample.integration.handler;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.sample.integration.domain.Country;
import com.sample.integration.domain.Countries;

@Component
public class ExternalCountryServiceResponseHandler {
	
	@ServiceActivator
    public Countries handle(Message<Country[]> msg) {
    	
    	Country[] countries = msg.getPayload();   	
    	Countries countryResponse = new Countries();
    	countryResponse.setCountries(countries);
    	int totalRecords = 0;
    	if(countryResponse!=null) {
    		totalRecords = countries.length;   		
    	}
    	countryResponse.setTotalNum(totalRecords);
        return countryResponse;
    }
	
	

}
