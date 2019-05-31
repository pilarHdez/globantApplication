package com.globant.globant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.globant.globant.model.Weather;

import java.net.URI;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	private RestTemplate restTemplate;
	
	private static final String api = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}";
	private static final String apiKey = "af3402c5d4d3e2f91a90c5b216465d1b";
	
	@Override
	public Weather getWeather(String city) {
		URI url = new UriTemplate(this.api).expand(city, this.apiKey);
		return invoke(url, Weather.class);
	}
	
	private <T> T invoke(URI url, Class<T> responseType){
		T weather = null;
		this.restTemplate = new RestTemplate();
		try {
			RequestEntity<?> request = RequestEntity.get(url)
					.accept(MediaType.APPLICATION_JSON).build();
			ResponseEntity<T> exchange = this.restTemplate
					.exchange(request, responseType);
			weather = exchange.getStatusCode() == HttpStatus.OK ? exchange.getBody() : null;
		} catch(Exception e){
				logger.error("Error(WeatherServiceImpl):" + e.getMessage());
		}

		return weather;
	}

}
