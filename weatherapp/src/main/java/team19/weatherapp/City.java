package team19.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * City class holds the information for the three city properties:
 * 
 * <ul>
 * <li> Current Weather </li>
 * <li> Short Term Forecast </li>
 * <li> Long Term Forecast </li>
 * </ul> 
 * 
 * The city object encapsulates these three objects, and 
 * allows the user to access all of the city data through one object.
 * 
 * @author Scott Mackie
 *
 */
public class City{

	//Properties of the city object: "validate" shows weather the city exists or not
	boolean validate;
	int errorval = 0;
	CurrentWeather currentWeather;
	LongTermForecast longTermForecast;
	ShortTermForecast shortTermForecast;

	/**
	 * The city constructor calls a json retriever to set the current
	 * temp, short term forecast, and long term forecast data.
	 * 
	 * @param name			The name is required in order to look up and
	 * 						parse data for the city
	 * @param tempUnits		The temperature units shows which units the
	 * 						temperature data should be stored in
	 * @param windUnits		The wind units show which units the wind data
	 * 						should be stored in
	 * @throws JSONException JSONException is required for JSONObjects
	 */
	public City(String name, char tempUnits, char windUnits)  throws JSONException{

		//Parses the JSON Data for the specified city
		JSONObject j = JSONRetriever.retrieveCurrent(name);
	    JSONObject js = JSONRetriever.retrieveShort(name);
	    JSONObject jl = JSONRetriever.retrieveLong(name);

		//If the city exists, validate it and save the data values
		//If the city does not exist, mark as invalid
		if (!j.has("Error")) {
			this.validate = true;
			this.currentWeather = new CurrentWeather(j,tempUnits,windUnits);
			this.shortTermForecast = new ShortTermForecast(js,tempUnits);
			this.longTermForecast = new LongTermForecast(jl,tempUnits);
		} else {
			this.validate = false;
			this.errorval = Integer.parseInt(j.get("Error") + "");
			System.out.println("Error creating city: ERROR " + this.errorval);

		}

	}

}
