package com.globant.globant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import com.globant.globant.model.Weather;
import com.globant.globant.service.WeatherService;
import static org.junit.Assert.assertNull;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobantApplicationTests {
	
	private static final Logger logger = LogManager.getLogger(GlobantApplicationTests.class);
	private RestTemplate restTemplate;
	
	@Autowired
	WeatherService weatherService;
	
	
	@Before
    public void up() {
        restTemplate = new RestTemplate();
    }
	
	 @After
	public void down() {
	    restTemplate = null;
	    this.weatherService = null;
	}
	
	@Test
	public void verifyGetWeatherForEmptyCity() {
		 Weather weather = this.weatherService.getWeather("");
	     assertNull(weather);
	}
	
	@Test
	public void verifyGetWeatherForCity() {
		 String city = "London";
		 Weather weather = this.weatherService.getWeather(city);
		 assertThat(weather.getName()).isEqualTo(city);
	}

}
