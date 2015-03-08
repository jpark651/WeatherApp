package team19.weatherapp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 
 * The Utilities class contains methods that allow us to
 * convert between units. This is useful for allowing other
 * classes to quickly change Temperature Units, Speed
 * Units, etc.
 * 
 * @author Scott Mackie
 *
 */
public class Utilities {

	/**
	 * The convertTemp method converts a temperature value from 
	 * Kelvin to Celsius or Fahrenheit. If the unit variable is
	 * invalid, it returns error temperature -99999.
	 * 
	 * @param unit 		Unit to be converted to (F for Fahrenheit, C for Celsius)
	 * @param temp		The value which will be converted
	 * @return 			Returns the converted temperature
	 */
	public static int convertTemp(char unit, double temp){
		if (unit == 'C')
			return (int) Math.round(temp - 273.15);
		else if (unit == 'F')
			return (int) Math.round((temp - 273.15)*1.8 + 32);
		else
			return -99999;
	}
	
	/**
	 * The convertSpeed method converts a temperature value to
	 * Kilometers or Miles. If the unit variable is
	 * invalid, it returns error speed -99999.
	 * 
	 * @param unit 		Unit to be converted to (K for Kilometers, M for Miles)
	 * @param speed		The value which will be converted
	 * @return 			Returns the converted speed
	 */
	public static double convertSpeed(char unit, double speed){
		if (unit == 'M')
			return (speed);
		else if (unit == 'K')
			return (speed*1.61);
		else
			return -99999;
	}
	
	/**
	 * The getImage method allows us to safely load image files as bufferedimages.
	 * This makes it much easier to package our final product as a runnable jar file.
	 * 
	 * @param pathAndFileName		Location that the image should be loaded from
	 * @return						The requested bufferedImage file
	 * @throws IOException			If the file could not be found, throws an error
	 */
	public static BufferedImage getImage(final String pathAndFileName) throws IOException {
	    final java.net.URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    BufferedImage img = ImageIO.read(url);
	    return img; 
	}

}
