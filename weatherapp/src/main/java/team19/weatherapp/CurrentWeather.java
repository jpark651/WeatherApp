package team19.weatherapp;

import org.json.JSONArray;
import org.json.JSONObject;

//Current Weather Class
public class CurrentWeather {
	
//Current Weather JSON variables
private JSONObject jCoord;
private JSONObject jSys;
private JSONObject jWeather;
private JSONObject jMain;
private JSONObject jWind;
private JSONObject jClouds;
private JSONArray jWeatherArray;

//Current Weather attributes
String temperature;
String minTemp, maxTemp;
String sunrise, sunset;
String windSpeed, windDirection;
String airPressure;
String skyCondition;
	
	//Current Weather Constructor - sets all variable values
	public CurrentWeather(JSONObject j){
	this.jCoord = j.getJSONObject("coord");
	this.jSys = j.getJSONObject("sys");
	this.jWeatherArray = j.getJSONArray("weather");
	this.jWeather = jWeatherArray.getJSONObject(0);
	this.jMain = j.getJSONObject("main");
	this.jWind = j.getJSONObject("wind");
	this.jClouds = j.getJSONObject("clouds");
	
	this.temperature = getTemperature(jMain);
	
	}
	
	//Temperature getter
	public String getTemperature(JSONObject j){
		return j.getDouble("temp") + "";
	}
	
}
