package team19.weatherapp;


public class Utilities {

	/**
	 * convertTemp converts a temperature value from Kelvin to Celsius or Fahrenheit
	 * @param unit to be converted to (F for Fahrenheit, C for Celsius)
	 * @param temp temperature value to be converted
	 * @return converted temperature
	 */
	public static int convertTemp(char unit, double temp){
		if (unit == 'C')
			return (int) Math.round(temp - 273.15);
		else if (unit == 'F')
			return (int) Math.round((temp - 273.15)*1.8 + 32);
		else
			return -1000000;
	}
	
	public static double convertSpeed(double speed){
		return 0;
	}

}
