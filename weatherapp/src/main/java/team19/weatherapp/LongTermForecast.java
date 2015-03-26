package team19.weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	
	public String days[];
	public String temperatures[];
	public String minTemps[];
	public String maxTemps[];
	public String skyIcons[];
	public String skyConditions[];

    //Initialize JSON Variables
    private JSONObject jCity;
    private JSONArray jListArray;
    private ArrayList<JSONObject> jTempList;
    private ArrayList<JSONObject> jWeatherList;
    private char tempUnits;

    //Initialize data strings
    //These can be accessed by the City Class
    String fullCityName;
    ArrayList<String> temperatureList;
    ArrayList<String> minTempList;
    ArrayList<String> maxTempList;
    ArrayList<String> skyConditionList;
    ArrayList<ImageIcon> skyIconList;
    ArrayList<String> dateList;

    /**
     * The LongTermForecast constructor retrieves the JSONObject data, and saves
     * the data into variable fields. The data is saved in the format specified
     * by tempUnits and windUnits.
     * 
     * @param j             This is the JSONObject that the city data is
     *                      retrieved from
     * @param tempUnits     The temperature units shows which units the
     *                      temperature data should be stored in
     */
    public LongTermForecast(JSONObject j, char tempUnits){
        
        /*Set sub-JSONObjects
         *OpenWeatherMap returns a large JSONObject that contains multiple
         *smaller JSONObjects; we get these during this step
         */
    	try{
        this.jCity = j.getJSONObject("city");
        this.jListArray = j.getJSONArray("list");
        this.jTempList = new ArrayList<JSONObject>();
        this.jWeatherList = new ArrayList<JSONObject>();
        int dateOffset = 0; // <--- To exclude the current day, change this to 1
        for (int i = dateOffset; i < 5 + dateOffset; i++) 
        {
            JSONObject nextObject = jListArray.getJSONObject(i);
            this.jTempList.add(nextObject.getJSONObject("temp"));
            this.jWeatherList.add(nextObject.getJSONArray("weather").getJSONObject(0));
        }
        this.tempUnits = tempUnits;

        
        //Set the variable values based on the JSON data
        this.fullCityName = getFullCityName(jCity);
        this.temperatureList = new ArrayList<String>();
        this.minTempList = new ArrayList<String>();
        this.maxTempList = new ArrayList<String>();
        this.skyConditionList = new ArrayList<String>();
        this.skyIconList = new ArrayList<ImageIcon>();
        this.dateList = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
        {
            JSONObject nextTemp = jTempList.get(i);
            JSONObject nextWeather = jWeatherList.get(i);
            this.temperatureList.add(getTemperature(nextTemp));
            this.minTempList.add(getMinTemp(nextTemp));
            this.maxTempList.add(getMaxTemp(nextTemp));
            this.skyConditionList.add(getSkyCondition(nextWeather));
            try{
                this.skyIconList.add(getSkyIcon(nextWeather));
            }
            catch(IOException e){
                System.out.println("Error: Can't obtain sky icon");
            }
            this.dateList.add(getDate(jListArray, i + dateOffset));
        }
    	} catch (Exception e){
			this.temperatureList = new ArrayList<String>();
			this.skyConditionList = new ArrayList<String>();
			this.skyIconList = new ArrayList<ImageIcon>();
			this.minTempList = new ArrayList<String>();
			this.maxTempList = new ArrayList<String>();
	        this.dateList = new ArrayList<String>();
			for (int i = 0; i < 8; i++)
			{
				this.minTempList.add("No Data ");
				this.maxTempList.add("No Data ");
				this.temperatureList.add("No Data ");
				this.dateList.add("No Data ");
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
    
    /**
     * This is a getter method for the temperature of the city. It takes a
     * JSONObject, and returns the temperature of the city that is located
     * within that JSON Object.
     * 
     * @param j     The JSONObject that contains the city temperature
     * @return      Returns the temperature of the city in String Format
     */
    public String getTemperature(JSONObject j){
        return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("day"))) + "";
    }
    
    /**
     * This is a getter method for the minimum temperature of the city. It takes a
     * JSONObject, and returns the minimum temperature of the city that is located
     * within that JSON Object.
     * 
     * @param j     The JSONObject that contains the minimum city temperature
     * @return      Returns the minimum temperature of the city in String Format
     */
    public String getMinTemp(JSONObject j){
        return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("min"))) + "";
    }

    /**
     * This is a getter method for the maximum temperature of the city. It takes a
     * JSONObject, and returns the maximum temperature of the city that is located
     * within that JSON Object.
     * 
     * @param j     The JSONObject that contains the maximum city temperature
     * @return      Returns the maximum temperature of the city in String Format
     */
    public String getMaxTemp(JSONObject j){
        return roundTwoDecimals(Utilities.convertTemp(tempUnits,j.getDouble("max"))) + "";
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
     * This is a getter method for the date of the forecast. It takes a
     * JSONObject, and returns the date of the forecast that is located
     * within that JSON Object.
     * 
     * @param j     The JSONObject that contains the forecast date
     * @return      Returns the forecast date in String Format
     */
    public String getDate(JSONArray j, int index){
        long time = j.getJSONObject(index).getLong("dt");
        String date = new SimpleDateFormat("EE MMM dd").format(new Date(time*1000));
        
        return date;
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
