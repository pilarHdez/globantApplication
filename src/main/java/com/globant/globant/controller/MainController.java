package com.globant.globant.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globant.globant.model.Weather;
import com.globant.globant.service.WeatherService;

@Controller 
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
    public String main() {
		logger.debug("Welcome MPHB App");
        return "main";
    }

	@RequestMapping("/getWeather")
	public String getWeather(@RequestParam String city,Model model) {
		logger.debug("getWeather" + city);
	
		Weather w = weatherService.getWeather(city);
				
		model.addAttribute("city", city);
		model.addAttribute("today", getFormattedDateTime(Instant.ofEpochMilli(w.getTimestamp() * 1000),"yyyy.MM.dd HH:mm"));
		model.addAttribute("description", w.getWeatherDescription());
		model.addAttribute("tempC", w.getTemperatureC());
		model.addAttribute("tempF", w.getTemperatureF());
		model.addAttribute("sunrise", getFormattedDateTime(Instant.ofEpochMilli(w.getSunrise() * 1000), "hh:mm a"));
		model.addAttribute("sunset", getFormattedDateTime(Instant.ofEpochMilli(w.getSunset() * 1000), "hh:mm a"));
		
        return "weather";
    }
	
	private String getFormattedDateTime(Instant timeStamp, String pattern) {
		String formattedString = "";
		if(timeStamp!=null && pattern!=null && !"".equals(pattern)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDateTime ldt = LocalDateTime.ofInstant(timeStamp, ZoneId.systemDefault());
			formattedString = ldt.format(formatter);
		}
		return formattedString;
	}
	

}
