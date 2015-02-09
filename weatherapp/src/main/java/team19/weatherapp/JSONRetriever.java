package team19.weatherapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class JSONRetriever {

	public static JSONObject retrieveCurrent(String location){
		
		//Initialize Empty String
		String str = "";

		//Attempt to parse data
		try {
			
			//Get name parameter and combine this to form the URL
			String urlstring = "http://api.openweathermap.org/data/2.5/weather?q=";
			String fullurl = urlstring + location;
			URL url = new URL(fullurl);
			
			//Send GET request to retrieve JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			//Throw error if connection failed
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			//If success, retrieve data, and save to str
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				str += output;
			}
			conn.disconnect();
			
		//If retrieved data is invalid, throw an error
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return new JSONObject("{\"Error\": \"3\"}");
		} catch (IOException e) {
			e.printStackTrace();
			return new JSONObject("{\"Error\": \"4\"}");
		}

		//If the city could not be found, throw an error
		if (str.contains("Error")) {
			return new JSONObject("{\"Error\": \"1\"}");
		} else if (str.equals("")) {
			return new JSONObject("{\"Error\": \"2\"}");
			
		//If all data is valid, return the string
		} else {
			return new JSONObject(str);
		}
		
		

	}
	
}
