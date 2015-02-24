package team19.weatherapp;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Date;

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
		this.minTemp = getMinTemp(jMain);
		this.maxTemp = getMaxTemp(jMain);
		this.sunrise = getSunrise(jSys);
		this.sunset = getSunset(jSys);
		this.windSpeed = getWindSpeed(jWind);
		this.windDirection = getWindDirection(jWind);
		this.airPressure = getAirPressure(jMain);
		this.skyCondition = getSkyCondition(jWeather);

	}

	//Temperature getter
	public String getTemperature(JSONObject j){
		return (int) Math.round(((j.getDouble("temp")*100)/(double)100)-272.15) + "";
	}

	public String getMinTemp(JSONObject j){
		return (int) Math.round(((j.getDouble("temp_min")*100)/(double)100)-272.15) + "";
	}

	public String getMaxTemp(JSONObject j){
		return (int) Math.round(((j.getDouble("temp_max")*100)/(double)100)-272.15) + "";
	}

	public String getSunrise(JSONObject j){
		long sunriseDate = j.getLong("sunrise");
		String date = new java.text.SimpleDateFormat("MM/dd/yyyy hh:mm a").format(new Date(sunriseDate*1000));
		
		return date;
	}

	public String getSunset(JSONObject j){
		long sunsetDate = j.getLong("sunset");
		String date = new java.text.SimpleDateFormat("MM/dd/yyyy hh:mm a").format(new Date(sunsetDate*1000));
	    
		return date;
	}

	public String getWindSpeed(JSONObject j){
		return jWind.getDouble("speed") + " m/s";
	}

	public String getWindDirection(JSONObject j){
		return jWind.getDouble("deg") + "";
	}

	public String getAirPressure(JSONObject j){
		return j.getDouble("pressure")+ " kPa";
	}

	public String getSkyCondition(JSONObject j){
		return jWeather.getString("main");
	}
}
