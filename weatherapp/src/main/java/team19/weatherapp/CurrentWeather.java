package team19.weatherapp;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The CurrrentWeather class holds all of the current weather data
 * for the specified city. When the json is parsed, it is passed into
 * the CurrentWeather constructor, which retrieves the data from the
 * JSONObject and saves it into multiple variables.
 * 
 * Once saved, a user can easy access any of these variables by
 * referencing them through the city object.
 * 
 * @author Scott Mackie
 *
 */
public class CurrentWeather {

	//Initialize JSON Variables
	private JSONObject jCoord;
	private JSONObject jSys;
	private JSONObject jWeather;
	private JSONObject jMain;
	private JSONObject jWind;
	private JSONObject jClouds;
	private JSONArray jWeatherArray;
	private char tempUnits;
	private char windUnits;

	//Initialize data strings
	//These can be accessed by the City Class
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
	String id;
	public double kelvin;

	/**
	 * The CurrentWeather constructor retrieves the JSONObject data, and saves
	 * the data into variable fields. The data is saved in the format specified
	 * by tempUnits and windUnits.
	 * 
	 * @param j				This is the JSONObject that the city data is
	 * 						retrieved from
	 * @param tempUnits		The temperature units shows which units the
	 * 						temperature data should be stored in
	 * @param windUnits		The wind units show which units the wind data
	 * 						should be stored in
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public CurrentWeather(JSONObject j, char tempUnits, char windUnits) throws JSONException{
		
		/*Set sub-JSONObjects
		 *OpenWeatherMap returns a large JSONObject that contains multiple
		 *smaller JSONObjects; we get these during this step
		 */
		this.jCoord = j.getJSONObject("coord");
		this.jSys = j.getJSONObject("sys");
		this.jWeatherArray = j.getJSONArray("weather");
		this.jWeather = jWeatherArray.getJSONObject(0);
		this.jMain = j.getJSONObject("main");
		this.jWind = j.getJSONObject("wind");
		this.jClouds = j.getJSONObject("clouds");
		this.tempUnits = tempUnits;
		this.windUnits = windUnits;

		
		//Set the variable values based on the JSON data
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

	/**
	 * This is a getter method for the name of the city. It takes a
	 * JSONObject, and returns the name of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the City Name
	 * @return		Returns the name of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getFullCityName(JSONObject j)  throws JSONException{
		String fullCityName = j.getString("name") + ", " + jSys.getString("country");
		return fullCityName;
	}
	
	/**
	 * This is a getter method for the temperature of the city. It takes a
	 * JSONObject, and returns the temperature of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city temperature
	 * @return		Returns the temperature of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getTemperature(JSONObject j)  throws JSONException{
		return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("temp"))) + "";
	}

	/**
	 * This is a getter method for the min temperature of the city. It takes a
	 * JSONObject, and returns the min temperature of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city min temperature
	 * @return		Returns the min temperature of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getMinTemp(JSONObject j)  throws JSONException{
		this.kelvin = j.getDouble("temp_min");
		return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("temp_min"))) + "";
	}

	/**
	 * This is a getter method for the max temperature of the city. It takes a
	 * JSONObject, and returns the max temperature of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city max temperature
	 * @return		Returns the max temperature of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getMaxTemp(JSONObject j)  throws JSONException{

		return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("temp_max"))) + "";
	}

	/**
	 * This is a getter method for the sunrise of the city. It takes a
	 * JSONObject, and returns the sunrise of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city sunrise
	 * @return		Returns the sunrise of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getSunrise(JSONObject j)  throws JSONException{

		return timeFormat(j.getLong("sunrise")) + "";
	}

	/**
	 * This is a getter method for the sunset of the city. It takes a
	 * JSONObject, and returns the sunset of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city sunset
	 * @return		Returns the sunset of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getSunset(JSONObject j)  throws JSONException{

		return timeFormat(j.getLong("sunset")) + "";
	}

	/**
	 * This is a getter method for the windspeed of the city. It takes a
	 * JSONObject, and returns the windspeed of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city windspeed
	 * @return		Returns the windspeed of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getWindSpeed(JSONObject j)  throws JSONException{
	    
	    return roundTwoDecimals(Utilities.convertSpeed(windUnits,j.getDouble("speed"))) + "";
	}

	/**
	 * This is a getter method for the wind direction of the city. It takes a
	 * JSONObject, and returns the wind direction of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city wind direction
	 * @return		Returns the wind direction of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getWindDirection(JSONObject j)  throws JSONException{
		return windDirectionForDegrees(j.getInt("deg")) + " (" + j.getInt("deg") + ")"; 

	}

	/**
	 * This is a getter method for the air pressure of the city. It takes a
	 * JSONObject, and returns the air pressure of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city air pressure
	 * @return		Returns the v of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getAirPressure(JSONObject j)  throws JSONException{
		return j.getDouble("pressure") + " hPa";
	}
	
	/**
	 * This is a getter method for the humidity of the city. It takes a
	 * JSONObject, and returns the humidity of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city humidity
	 * @return		Returns the humidity of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getHumidity(JSONObject j)  throws JSONException{
		return j.getLong("humidity") + "%";
	}
	
	/**
	 * This is a getter method for the sky condition of the city. It takes a
	 * JSONObject, and returns the sky condition of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the city sky condition
	 * @return		Returns the sky condition of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getSkyCondition(JSONObject j)  throws JSONException{
		return j.getString("description");
	}
	
	/**
	 * This is a getter method for the Sky Icon of the city. It takes a
	 * JSONObject, and returns the Sky Icon of the city that is located
	 * within that JSON Object. It does this by retrieving the specified
	 * file name (located within the JSON Object), then returns the icon
	 * that matches this file name
	 * 
	 * @param j		The JSONObject that contains the city Sky Icon
	 * @return		Returns the Sky Icon of the city in ImageIcon Format
	 * @throws IOException		If the image cannot be found, throws an error
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public ImageIcon getSkyIcon(JSONObject j) throws IOException, JSONException{
		BufferedImage img = Utilities.getImage(j.getString("icon") + ".png");
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	
	
	/**
	 * This is a getter method for the last updated time of the city. It takes a
	 * JSONObject, and returns the last updated time of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j		The JSONObject that contains the last updated time
	 * @return		Returns the last updated time of the city in String Format
	 * @throws JSONException		Throws a JSONExcpetion, required for JSONObjects
	 */
	public String getTimeUpdated(JSONObject j)  throws JSONException{
		long timeUpdated = j.getLong("dt");
		String time = new SimpleDateFormat("MM/dd/yyyy hh:mm a z").format(new Date(timeUpdated*1000));
	    
		return time;
	}

	/**
	 * This is a converter method that changes the direction into
	 * a string, so that it can be easily understood
	 * 
	 * @param degrees		The degrees that should be converted
	 * @return				The string that represents the direction
	 * 						that the wind is blowing
	 */
	String windDirectionForDegrees(int degrees){	
		String directionArray[] = {"North","North East","East","South East","South","South West","West","North West"};		
		int i = (int)((degrees + 22.5)/45);		
	    return directionArray[i % 8];
		
	}
	
	/**
	 * This returns the time based on the current seconds
	 * It adjusts the seconds and returns a string that is
	 * formatted in a date format.
	 * 
	 * @param seconds		The seconds parameter that will
	 * 						be converted to a date and time
	 * @return				Returns the date and time that
	 * 						is specified by the seconds parameter
	 */
	String timeFormat(long seconds){
		
		String time = new java.text.SimpleDateFormat("HH:mm a z").format(new java.util.Date (seconds*1000));
		return time;
	}
	
	/**
	 * This method converts a double into a double with
	 * two decimal places. Essentially, it rounds off the 
	 * remaining decimal places, and returns a formatted double
	 * 
	 * @param d			The double that should be converted
	 * @return			Returns the same double in two-decimal format
	 */
	double roundTwoDecimals(double d) { 
	      DecimalFormat twoDForm = new DecimalFormat("#.##"); 
	      return Double.valueOf(twoDForm.format(d));
	}  
}

