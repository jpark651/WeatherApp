package team19.weatherapp;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LocalWeatherPanel extends JPanel{
	public static JLabel lblCity;
	public static JLabel lblLocalTemperature;
	public static JLabel lblLocalSkyCondition, lblLocalSkyIcon;
	public static JLabel minTempTitle, lblLocalMinTemp;
	public static JLabel maxTempTitle, lblLocalMaxTemp;
	public static JLabel sunrTitle, lblLocalSunrise;
	public static JLabel sunsTitle, lblLocalSunset;
	public static JLabel airTitle, lblLocalAirPressure;
	public static JLabel humidTitle, lblLocalHumidity;
	public static JLabel windSpdTitle, lblLocalWindSpeed;
	public static JLabel windDirTitle, lblLocalWindDirection;
	
	public LocalWeatherPanel(){
		initLabels();
		this.initUI();
	}
	
	public void update(City city, char tempUnits, char windUnits){
		if (city.validate != true) {
			lblCity.setText("City Not Found");

		} else {
			lblCity.setText(city.currentWeather.fullCityName);
			lblLocalSkyIcon.setIcon(city.currentWeather.skyIcon);
			lblLocalTemperature.setText(city.currentWeather.temperature + " " + tempUnits);
			lblLocalMinTemp.setText(city.currentWeather.minTemp + " " + tempUnits);
			lblLocalMaxTemp.setText(city.currentWeather.maxTemp + " " + tempUnits);
			lblLocalSunrise.setText(city.currentWeather.sunrise);
			lblLocalSunset.setText(city.currentWeather.sunset);
			lblLocalWindSpeed.setText(city.currentWeather.windSpeed + " " + windUnits + "PH");
			lblLocalWindDirection.setText(city.currentWeather.windDirection);
			lblLocalAirPressure.setText(city.currentWeather.airPressure);
			lblLocalHumidity.setText(city.currentWeather.humidity);
			lblLocalSkyCondition.setText(city.currentWeather.skyCondition);
			//lblRefreshTime.setText("Last Refreshed:   " + lastRefresh);
		}
		
	}
	
	private static void initLabels(){
		lblCity = new JLabel("Enter the name of a city");
		lblCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		lblLocalTemperature = new JLabel();
		lblLocalMinTemp = new JLabel();
		lblLocalMaxTemp = new JLabel();
		lblLocalSunrise = new JLabel();
		lblLocalSunset = new JLabel();
		lblLocalWindSpeed = new JLabel();
		lblLocalWindDirection = new JLabel();
		lblLocalAirPressure = new JLabel();
		lblLocalHumidity = new JLabel();
		lblLocalSkyCondition = new JLabel();
		lblLocalSkyIcon = new JLabel();
		

		minTempTitle = new JLabel("Expected Min.:");
		maxTempTitle = new JLabel("Expected Max.:");
		sunrTitle = new JLabel("Sunrise: ");
		sunsTitle = new JLabel("Sunset: ");
		airTitle = new JLabel("Air Pressure: ");
		humidTitle = new JLabel("Humidity: ");
		windSpdTitle = new JLabel("Wind Speed: ");
		windDirTitle = new JLabel("Wind Direction: ");
	}
	
	private void initUI(){
		GridBagLayout gbl= new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		this.setLayout(gbl);
		
		insertStrut('V', 20, 0, 0, 5, 5, 1, 0);
		insertStrut('H', 20, 0, 0, 5, 5, 0, 1);
		insertJLabelIntoGrid(lblCity, 6, 0, 0, 5, 5, 1, 1, true);
		insertJLabelIntoGrid(lblLocalSkyIcon, 0, 0, 0, 5, 5, 1, 3, false);
		insertJLabelIntoGrid(lblLocalTemperature, 0, 0, 0, 5, 5, 3, 3, true);
		lblLocalTemperature.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid(lblLocalSkyCondition, 3, 0, 0, 5, 5, 1, 4, true);
		insertStrut('V', 20, 0, 0, 5, 5, 1, 5);
		insertJLabelIntoGrid(minTempTitle, 0, 0, 0, 5, 5, 1, 6, true);
		insertStrut('H', 20, 0, 0, 5, 5, 2, 6);
		insertJLabelIntoGrid(lblLocalMinTemp, 0, 0, 0, 5, 5, 3, 6, true);
		insertJLabelIntoGrid(maxTempTitle, 0, 0, 0, 5, 5, 1, 7, true);
		insertJLabelIntoGrid(lblLocalMaxTemp, 0, 0, 0, 5, 5, 3, 7, true);
		insertJLabelIntoGrid(sunrTitle, 0, 0, 0, 5, 5, 1, 8, true);
		insertJLabelIntoGrid(lblLocalSunrise, 0, 0, 0, 5, 5, 3, 8, true);
		insertJLabelIntoGrid(sunsTitle, 0, 0, 0, 5, 5, 1, 9, true);
		insertJLabelIntoGrid(lblLocalSunset, 0, 0, 0, 5, 5, 3, 9, true);
		//insertStrut('H', 20, 0, 0, 5, 5, 4, 6);
		//insertStrut('H', 20, 0, 0, 5, 5, 5, 6);
		insertJLabelIntoGrid(airTitle, 0, 0, 0, 5, 5, 1, 10, true);
		//insertStrut('H', 20, 0, 0, 5, 5, 7, 6);
		insertJLabelIntoGrid(lblLocalAirPressure, 0, 0, 0, 5, 5, 3, 10, true);
		insertJLabelIntoGrid(humidTitle, 0, 0, 0, 5, 5, 1, 11, true);
		insertJLabelIntoGrid(lblLocalHumidity, 0, 0, 0, 5, 5, 3, 11, true);
		insertJLabelIntoGrid(windSpdTitle, 0, 0, 0, 5, 5, 1, 12, true);
		insertJLabelIntoGrid(lblLocalWindSpeed, 0, 0, 0, 5, 5, 3, 12, true);
		insertJLabelIntoGrid(windDirTitle, 0, 0, 0, 5, 5, 1, 13, true);
		insertJLabelIntoGrid(lblLocalWindDirection, 0, 0, 0, 5, 5, 3, 13, true);
	}
	
	private void insertJLabelIntoGrid(JLabel label, int gridwidth, 
			int inset1, int inset2, int inset3, int inset4, int gridx, 
			int gridy, boolean anchor){
		GridBagConstraints gbc = new GridBagConstraints();
		if(anchor)
			gbc.anchor = GridBagConstraints.WEST;
		if(gridwidth != 0)
			gbc.gridwidth = gridwidth;
		gbc.insets = new Insets(inset1, inset2, inset3, inset4);
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		this.add(label, gbc);
	}
	
	private void insertStrut(char strutType, int strutSize,
			int inset1, int inset2, int inset3, int inset4, 
			int gridx, int gridy){
		Component strut;
		if(strutType == 'H')
			strut = Box.createHorizontalStrut(strutSize);
		else
			strut = Box.createVerticalStrut(strutSize);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(inset1, inset2, inset3, inset4);
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		this.add(strut, gbc);
	}
}
