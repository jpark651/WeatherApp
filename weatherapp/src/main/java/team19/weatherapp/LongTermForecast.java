package team19.weatherapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 * The LongTermForecast class holds all of the long term weather data
 * for the specified city. When the json is parsed, it is passed into
 * the LongTermForecast constructor, which retrieves the data from the
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
public class LongTermForecast {
	
	private JSONArray jListArray;
	private char tempUnits;
	
	public String days[];
	public String temperatures[];
	public String minTemps[];
	public String maxTemps[];
	public String skyIcons[];
	public String skyConditions[];

	public LongTermForecast(JSONObject j, char tempUnits) {
		
		this.jListArray = j.getJSONArray("list");
		this.tempUnits = tempUnits;
		
		this.days = getDays();
		this.temperatures = getTemperatures(jListArray);
		this.minTemps = getMinTemps(jListArray);
		this.maxTemps = getMaxTemps(jListArray);
		this.skyIcons = getSkyIcons(jListArray);
		this.skyConditions = getSkyConditions(jListArray);

	}
	
	public String[] getDays(){
		String[] days = new String[5];
		Date today = new Date();
		for(int i = 0; i < 5; i++){
			long newDayTime = today.getTime() + i*86400;
			days[i] = new SimpleDateFormat("MMM/dd").format(new Date(newDayTime*1000));
		}
		return days;
	}
	
	public String[] getTemperatures(JSONArray j){
		String temps[] = new String[5];
		for(int i = 0; i < 5; i++){
			temps[i] = Utilities.convertTemp(tempUnits,j.getJSONObject(i).getJSONObject("main").getJSONObject("temp").getDouble("day")) + "";
		}
		return temps;
	}
	
	public String[] getMinTemps(JSONArray j){
		String minTemps[] = new String[5];
		for(int i = 0; i < 5; i++){
			minTemps[i] = Utilities.convertTemp(tempUnits,j.getJSONObject(i).getJSONObject("main").getJSONObject("temp").getDouble("min")) + "";
		}
		return minTemps;
	}
	
	public String[] getMaxTemps(JSONArray j){
		String maxTemps[] = new String[5];
		for(int i = 0; i < 5; i++){
			maxTemps[i] = Utilities.convertTemp(tempUnits,j.getJSONObject(i).getJSONObject("main").getJSONObject("temp").getDouble("max")) + "";
		}
		return maxTemps;
	}
	
	public String[] getSkyIcons(JSONArray j){
		String icons[] = new String[5];
		for(int i = 0; i < 5; i++){
			icons[i] = j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icons") + ".png";
		}
		return icons;
	}
	
	public String[] getSkyConditions(JSONArray j){
		String conditions[] = new String[5];
		for(int i = 0; i < 5; i++){
			conditions[i] = j.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
		}
		return conditions;
	}
}
