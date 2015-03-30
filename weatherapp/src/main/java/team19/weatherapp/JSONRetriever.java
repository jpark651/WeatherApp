package team19.weatherapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * The JSONRetriever class handles the process of retrieving and converting
 * the openweathermap data.
 * 
 * It has a single method that is used for the retrieval of city data.
 * 
 * @author Scott Mackie
 *
 */
public class JSONRetriever{

	static String appid = "&APPID=5e8db379b2d24bbfec1e845dfd19270d";
	/**
	 * The retrieveCurrent method retrieves the openweathermap data
	 * in JSONObject format.
	 * 
	 * First, we set up the url string using the name of the city that we want
	 * to locate.
	 * 
	 * Next, we attempt to parse the JSON data from the specified URL.
	 * 
 	 * If the process is successful, we save this JSON data into a 
 	 * JSONObject, and return the object.
 	 * 
 	 * If the Data is not successfully retrieved, we return an "Error"
 	 * JSONObject.
 	 * 
	 * @param location		The location for which we want to retrieve
	 * 						data for
	 * @return				Returns the JSONObject containing the data
	 * 						for the specified location
	 */
	public static JSONObject retrieveCurrent(String location)  throws JSONException{
		
		//Initialize Empty String
		String str = "";

		//Attempt to parse data
		try {
			
			//Get name parameter and combine this to form the URL
			String urlstring = "http://api.openweathermap.org/data/2.5/weather?q=";
			String fullurl = urlstring + location + appid;
			fullurl = fullurl.replaceAll("\\s+","%20");
			URL url = new URL(fullurl);
			//Send GET request to retrieve JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			//Throw error if connection failed
			if (conn.getResponseCode() != 200) {
				System.out.println("Error parsing data, please try again! HTTP Error Code: "+ conn.getResponseCode());
				return retrieveCurrent(location);
				//return new JSONObject("{\"Error\": \"5\"}");
			}
			
			//If success, retrieve data, and save to str
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			System.out.println("Output from Server:");
			while ((output = br.readLine()) != null) {
				System.out.println(output+"\n");
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
		} catch (Exception e){
			return new JSONObject("{\"Error\": \"6\"}");
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

	/**
     * The retrieveShort method retrieves the openweathermap data
     * in JSONObject format.
     * 
     * First, we set up the url string using the name of the city that we want
     * to locate.
     * 
     * Next, we attempt to parse the JSON data from the specified URL.
     * 
     * If the process is successful, we save this JSON data into a 
     * JSONObject, and return the object.
     * 
     * If the Data is not successfully retrieved, we return an "Error"
     * JSONObject.
     * 
     * @param location      The location for which we want to retrieve
     *                      data for
     * @return              Returns the JSONObject containing the data
     *                      for the specified location
     */
    public static JSONObject retrieveShort(String location)  throws JSONException{
        
        //Initialize Empty String
        String str = "";

        //Attempt to parse data
        try {
                  	
            //Get name parameter and combine this to form the URL
            String urlstring = "http://api.openweathermap.org/data/2.5/forecast?q=";
            String fullurl = urlstring + location + appid;
			fullurl = fullurl.replaceAll("\\s+","%20");
            URL url = new URL(fullurl);

            
            //Send GET request to retrieve JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            //Throw error if connection failed
            if (conn.getResponseCode() != 200) {
                System.out.println("Error parsing data, please try again! HTTP Error Code: "+ conn.getResponseCode());
				return retrieveShort(location);
                //return new JSONObject("{\"Error\": \"5\"}");
            }
            
            //If success, retrieve data, and save to str
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("ST: Output from Server:");
            while ((output = br.readLine()) != null) {
                System.out.println(output+"\n");
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
	
    
    /**
     * The retrieveLong method retrieves the openweathermap data
     * in JSONObject format.
     * 
     * First, we set up the url string using the name of the city that we want
     * to locate.
     * 
     * Next, we attempt to parse the JSON data from the specified URL.
     * 
     * If the process is successful, we save this JSON data into a 
     * JSONObject, and return the object.
     * 
     * If the Data is not successfully retrieved, we return an "Error"
     * JSONObject.
     * 
     * @param location      The location for which we want to retrieve
     *                      data for
     * @return              Returns the JSONObject containing the data
     *                      for the specified location
     */
    public static JSONObject retrieveLong(String location)  throws JSONException{
        //Initialize Empty String
        String str = "";

        //Attempt to parse data
        try {
            
            //Get name parameter and combine this to form the URL
            String urlstring = "http://api.openweathermap.org/data/2.5/forecast/daily?q=";
            String fullurl = urlstring + location + "&cnt=5"  + appid;
			fullurl = fullurl.replaceAll("\\s+","%20");
            URL url = new URL(fullurl);
			
            //Send GET request to retrieve JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            //Throw error if connection failed
            if (conn.getResponseCode() != 200) {
                System.out.println("Error parsing data, please try again! HTTP Error Code: "+ conn.getResponseCode());
                return retrieveLong(location);
                //return new JSONObject("{\"Error\": \"5\"}");
            }
            
            //If success, retrieve data, and save to str
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("LT: Output from Server:");
            while ((output = br.readLine()) != null) {
                System.out.println(output+"\n");
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
