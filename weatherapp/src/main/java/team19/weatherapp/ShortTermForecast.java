package team19.weatherapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

//Initialize JSON Variables
public class ShortTermForecast{
	private JSONObject jCity;
	private JSONArray jListArray;
	private ArrayList<JSONObject> jMainList;
	private ArrayList<JSONObject> jWeatherList;
	private char tempUnits;
	String id;

	//Initialize data strings
	//These can be accessed by the City Class
	String fullCityName;
	ArrayList<String> temperatureList;
	ArrayList<String> skyConditionList;
	ArrayList<ImageIcon> skyIconList;
	ArrayList<String> timeList;

	/**
	 * The ShortTermForecast constructor retrieves the JSONObject data, and saves
	 * the data into variable fields. The data is saved in the format specified
	 * by tempUnits and windUnits.
	 * 
	 * @param j             This is the JSONObject that the city data is
	 *                      retrieved from
	 * @param tempUnits     The temperature units shows which units the
	 *                      temperature data should be stored in
	 */
	public ShortTermForecast(JSONObject j, char tempUnits){

		/*Set sub-JSONObjects
		 *OpenWeatherMap returns a large JSONObject that contains multiple
		 *smaller JSONObjects; we get these during this step
		 */
		try{
		this.jMainList = new ArrayList<JSONObject>();
		this.jWeatherList = new ArrayList<JSONObject>();
		this.jCity = j.getJSONObject("city");
		
		this.jListArray = j.getJSONArray("list");
		
		this.id = jCity.get("id") +"";
		
		for (int i = 0; i < 8; i++)
		{
			JSONObject nextObject = jListArray.getJSONObject(i);
			this.jMainList.add(nextObject.getJSONObject("main"));
			this.jWeatherList.add(nextObject.getJSONArray("weather").getJSONObject(0));
		}
		this.tempUnits = tempUnits;


		//Set the variable values based on the JSON data
		this.fullCityName = getFullCityName(jCity);
		this.temperatureList = new ArrayList<String>();
		this.skyConditionList = new ArrayList<String>();
		this.skyIconList = new ArrayList<ImageIcon>();
		this.timeList = new ArrayList<String>();
		for (int i = 0; i < 8; i++)
		{
			JSONObject nextMain = jMainList.get(i);
			JSONObject nextWeather = jWeatherList.get(i);
			this.temperatureList.add(getTemperature(nextMain));
			this.skyConditionList.add(getSkyCondition(nextWeather));
			try{
				this.skyIconList.add(getSkyIcon(nextWeather));
			}
			catch(IOException e){
				System.out.println("Error: Can't obtain sky icon");
			}
			this.timeList.add(getTime(jListArray, i));
		}
		} catch (Exception e){
			this.temperatureList = new ArrayList<String>();
			this.skyConditionList = new ArrayList<String>();
			this.skyIconList = new ArrayList<ImageIcon>();
			this.timeList = new ArrayList<String>();
			for (int i = 0; i < 8; i++)
			{
				this.timeList.add("No Data ");
				this.temperatureList.add("No Data ");
				try {
					this.skyIconList.add(getSkyIcon(new JSONObject("{icon:01d}")));
				} catch (JSONException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.skyConditionList.add("No Data ");
			} 
		}

	}

	/**
	 * This is a getter method for the name of the city. It takes a
	 * JSONObject, and returns the name of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j     The JSONObject that contains the City Name
	 * @return      Returns the name of the city in String Format
	 */
	public String getFullCityName(JSONObject j){
		String fullCityName = j.getString("name") + ", " + j.getString("country");
		return fullCityName;
	}
	
	public String getCityid(){
		return id;
	}

	/**
	 * This is a getter method for the temperature of the city. It takes a
	 * JSONObject, and returns the temperature of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j     The JSONObject that contains the city temperature
	 * @return      Returns the temperature of the city in String Format
	 */
	public String getTemperature(JSONObject j){
		return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("temp"))) + "";
	}

	/**
	 * This is a getter method for the sky condition of the city. It takes a
	 * JSONObject, and returns the sky condition of the city that is located
	 * within that JSON Object.
	 * 
	 * @param j     The JSONObject that contains the city sky condition
	 * @return      Returns the sky condition of the city in String Format
	 */
	public String getSkyCondition(JSONObject j){
		return j.getString("description");
	}

	/**
	 * This is a getter method for the Sky Icon of the city. It takes a
	 * JSONObject, and returns the Sky Icon of the city that is located
	 * within that JSON Object. It does this by retrieving the specified
	 * file name (located within the JSON Object), then returns the icon
	 * that matches this file name
	 * 
	 * @param j     The JSONObject that contains the city Sky Icon
	 * @return      Returns the Sky Icon of the city in ImageIcon Format
	 * @throws IOException      If the image cannot be found, throws an error
	 */
	public ImageIcon getSkyIcon(JSONObject j) throws IOException{
		BufferedImage img = Utilities.getImage(j.getString("icon") + "-small.png");
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}



	/**
	 * This is a getter method for the time of the forecast. It takes a
	 * JSONArray and an index, and returns the time of the forecast that is located
	 * at that index within the JSONArray.
	 * 
	 * @param j     The JSONArray that contains the forecast data
	 * @param index The index of the forecast within the JSONArray
	 * @return      Returns the time of the given forecast in String Format
	 */
	public String getTime(JSONArray j, int index){
		String time = j.getJSONObject(index).getString("dt_txt");
		
		String ok = time;
		java.util.Date date = null;
		
		try {
			date = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").parse(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String formattedDate = new SimpleDateFormat("EEEE  hh:mm a").format(date);
		
		
		
		return formattedDate;
	}



	/**
	 * This method converts a double into a double with
	 * two decimal places. Essentially, it rounds off the 
	 * remaining decimal places, and returns a formatted double
	 * 
	 * @param d         The double that should be converted
	 * @return          Returns the same double in two-decimal format
	 */
	double roundTwoDecimals(double d) { 
		DecimalFormat twoDForm = new DecimalFormat("#.##"); 
		return Double.valueOf(twoDForm.format(d));
	}  
	

}
