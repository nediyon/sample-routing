package com.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.integration.domain.Countries;
import com.sample.integration.service.ExternalCountryService;


public class ExternalCountryServiceIntegrationTest {

	private final Log logger = LogFactory.getLog(ExternalCountryServiceIntegrationTest.class);

	@Test
	public void countryNameCurriences() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/applicationContext-int.xml");
		ExternalCountryService service = context.getBean(ExternalCountryService.class);		
		logger.info("Get ExternalCountryService Instance");
		Countries countries = service.getCountryNamesAndCurriencies();		
		logger.info("Countries total: " + countries.getTotalNum());		
		context.close();
	}

}
