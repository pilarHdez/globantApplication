package com.globant.globant.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Weather {
	
	private String name;
	private long timestamp;
	private double temperatureC;
	private double temperatureF;
	private String weatherDescription;
	private long sunrise;
	private long sunset;
	
	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("timestamp")
	public long getTimestamp() {
		return this.timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public double getTemperatureC() {
		return temperatureC;
	}

	public void setTemperatureC(double temperatureC) {
		this.temperatureC = temperatureC;
	}

	public double getTemperatureF() {
		return temperatureF;
	}

	public void setTemperatureF(double temperatureF) {
		this.temperatureF = temperatureF;
	}
	
	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		double kelvinTemp = Double.parseDouble(main.get("temp").toString());
	
		setTemperatureC(kelvinTemp - 273.16);
		setTemperatureF(((kelvinTemp - 273) * 9.0/5) + 32);
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}

	@JsonProperty("sunrise")
	public long getSunrise() {
		return this.sunrise;
	}

	@JsonSetter("sunrise")
	public void setSunrise(long timestamp) {
		this.sunrise = timestamp;
	}

	@JsonProperty("sunset")
	public long getSunset() {
		return this.sunset;
	}

	@JsonSetter("sunset")
	public void setSunset(long timestamp) {
		this.sunset = timestamp;
	}

	@JsonProperty("sys")
	public void setSys(Map<String, Object> sys) {
		setSunrise((int)sys.get("sunrise"));
		setSunset((int)sys.get("sunset"));

	}	
}
