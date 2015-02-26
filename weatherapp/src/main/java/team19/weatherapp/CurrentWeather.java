package team19.weatherapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	String fullCityName;
	String temperature;
	String minTemp, maxTemp;
	String sunrise, sunset;
	String windSpeed, windDirection;
	String airPressure;
	String humidity;
	String skyCondition;
	ImageIcon skyIcon;
	String timeUpdated;

	//Current Weather Constructor - sets all variable values
	public CurrentWeather(JSONObject j){
		this.jCoord = j.getJSONObject("coord");
		this.jSys = j.getJSONObject("sys");
		this.jWeatherArray = j.getJSONArray("weather");
		this.jWeather = jWeatherArray.getJSONObject(0);
		this.jMain = j.getJSONObject("main");
		this.jWind = j.getJSONObject("wind");
		this.jClouds = j.getJSONObject("clouds");

		this.fullCityName = getFullCityName(j);
		this.temperature = getTemperature(jMain);
		this.minTemp = getMinTemp(jMain);
		this.maxTemp = getMaxTemp(jMain);
		this.sunrise = getSunrise(jSys);
		this.sunset = getSunset(jSys);
		this.windSpeed = getWindSpeed(jWind);
		this.windDirection = getWindDirection(jWind);
		this.airPressure = getAirPressure(jMain);
		this.humidity = getHumidity(jMain);
		this.skyCondition = getSkyCondition(jWeather);
		try{
			this.skyIcon = getSkyIcon(jWeather);
		}
		catch(IOException e){
			System.out.println("Error: Can't obtain sky icon");
		}
		this.timeUpdated = getTimeUpdated(j);

	}

	//Temperature getter
	public String getFullCityName(JSONObject j){
		String fullCityName = j.getString("name") + ", " + jSys.getString("country");
		return fullCityName;
	}
	
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
		String date = new SimpleDateFormat("MM/dd/yyyy hh:mm a z").format(new Date(sunriseDate*1000));
		
		return date;
	}

	public String getSunset(JSONObject j){
		long sunsetDate = j.getLong("sunset");
		String date = new SimpleDateFormat("MM/dd/yyyy hh:mm a z").format(new Date(sunsetDate*1000));
	    
		return date;
	}

	public String getWindSpeed(JSONObject j){
		return j.getDouble("speed") + " m/s";
	}

	public String getWindDirection(JSONObject j){
		double deg = j.getDouble("deg");
		return deg + " " + windDirection(deg);
	}

	public String getAirPressure(JSONObject j){
		return j.getDouble("pressure") + " kPa";
	}
	
	public String getHumidity(JSONObject j){
		return j.getLong("humidity") + "%";
	}
	
	public String getSkyCondition(JSONObject j){
		return j.getString("description");
	}
	
	public ImageIcon getSkyIcon(JSONObject j) throws IOException{
		String iconPic = "./src/resources/" + j.getString("icon") + ".png";
		BufferedImage img = ImageIO.read(new File(iconPic));
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	public String getTimeUpdated(JSONObject j){
		long timeUpdated = j.getLong("dt");
		String time = new SimpleDateFormat("MM/dd/yyyy hh:mm a z").format(new Date(timeUpdated*1000));
	    
		return time;
	}
	
	private static String windDirection(double deg){
		if(deg>=337.5 && deg < 22.5)
			return "N";
		else if(deg>=22.5 && deg < 67.5)
			return "NE";
		else if(deg>=67.5 && deg < 112.5)
			return "E";
		else if(deg>=112.5 && deg < 157.5)
			return "SE";
		else if(deg>=157.5 && deg < 202.5)
			return "S";
		else if(deg>=202.5 && deg < 247.5)
			return "SW";
		else if(deg>=247.5 && deg < 292.5)
			return "W";
		else
			return "NW";
	}
}
