package team19.weatherapp;

import org.json.JSONObject;

public class City {
	CurrentWeather currentWeather;
	LongTermForecast longTermForecast;
	ShortTermForecast shortTermForecast;

	public City(String name){
		JSONObject j = JSONRetriever.retrieveJSON(name);
		if (!j.has("Error")){
			currentWeather = new CurrentWeather(j);
			
			
		}
		
	}
	
}
