package com.sample.integration.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.integration.annotation.Payload;

import com.sample.integration.domain.Countries;

public interface ExternalCountryService {
	
	/**
	 * List of country names with their local currencies.
	 *This list is cached in Hazelcast due to its static non changing nature for all user.
	 * @return List of countries.
	 */
	@Payload("new java.util.Date()")
	@Cacheable("countries")
	Countries getCountryNamesAndCurriencies();

}
