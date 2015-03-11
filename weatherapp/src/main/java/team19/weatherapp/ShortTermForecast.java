package team19.weatherapp;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The ShortTermForecast class holds all of the long term weather data
 * for the specified city. When the json is parsed, it is passed into
 * the ShortTermForecast constructor, which retrieves the data from the
 * JSONObject and saves it into multiple variables.
 * 
 * Once saved, a user can easy access any of these variables by
 * referencing them through the city object.
 * 
 * Currently, this is a placeholder for future development needs.
 * 
 * @author Scott Mackie
 *
 */
public class ShortTermForecast {
	private JSONArray jListArray;
	private char tempUnits;
	
	public String hours[];
	public String temperatures[];
	public String skyIcons[];
	public String skyConditions[];
	
	public ShortTermForecast(JSONObject j, char tempUnits){
		
		this.jListArray = j.getJSONArray("list");
		this.tempUnits = tempUnits;
		
		this.hours = getHours(jListArray);
		this.temperatures = getTemperatures(jListArray);
		this.skyIcons = getSkyIcons(jListArray);
		this.skyConditions = getSkyConditions(jListArray);
	}
	
	public String[] getHours(JSONArray j){
		String hours[] = new String[8];
		for(int i = 0; i < 8; i++){
			hours[i] = j.getJSONObject(i).getString("dt_txt").substring(11,15);
		}
		return hours;
	}
	
	public String[] getTemperatures(JSONArray j){
		String temps[] = new String[8];
		for(int i = 0; i < 8; i++){
			temps[i] = Utilities.convertTemp(tempUnits,j.getJSONObject(i).getJSONObject("main").getDouble("temp")) + "";
		}
		return temps;

	}
	
	public String[] getSkyIcons(JSONArray j){
		String icons[] = new String[8];
		for(int i = 0; i < 8; i++){
			icons[i] = j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icons") + ".png";
		}
		return icons;
	}
	
	public String[] getSkyConditions(JSONArray j){
		String conditions[] = new String[8];
		for(int i = 0; i < 8; i++){
			conditions[i] = j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
		}
		return conditions;
	}

}
