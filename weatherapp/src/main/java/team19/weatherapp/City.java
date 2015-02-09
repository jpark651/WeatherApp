package team19.weatherapp;

import org.json.JSONObject;

//City Object Class
public class City {

	// City Properties - validate shows whether the city exists
	boolean validate;
	CurrentWeather currentWeather;
	LongTermForecast longTermForecast;
	ShortTermForecast shortTermForecast;

	// City Constructor - Retrieves weather data
	public City(String name) {

		JSONObject j = JSONRetriever.retrieveJSON(name);

		if (!j.has("Error")) {
			this.validate = true;
			this.currentWeather = new CurrentWeather(j);
			this.shortTermForecast = new ShortTermForecast(j);
			this.longTermForecast = new LongTermForecast(j);
		} else {
			this.validate = false;
		}

	}

}
