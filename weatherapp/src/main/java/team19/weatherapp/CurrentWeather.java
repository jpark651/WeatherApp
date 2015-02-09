package team19.weatherapp;

import org.json.JSONObject;

public class CurrentWeather {
JSONObject jCoord;
JSONObject jSys;
JSONObject jWeather;
JSONObject jMain;
JSONObject jWind;
JSONObject jClouds;

	
	public CurrentWeather(JSONObject j){
	this.jCoord = new JSONObject(j);
	}
	
	public String temperature(JSONObject j){
		return j.getDouble("temp") + "";
	}
	
}
