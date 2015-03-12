package team19.weatherapp;

import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

/**
 * The MainPanel class handles the GUI and user interface
 * functionality of the program.
 * 
 * The user can search for locations from this panel, and
 * the relevant information is displayed in JLabel Objects.
 * 
 * @author Scott Mackie
 *
 */
public class MainPanel extends JPanel {

	
	/* Initialize variables that will be used by MainPanel
	 * The JLabels are used to hold relevant data
	 * Images are used for display purposes
	 * Fonts will are attached to the JLabels
	 * JButtons allow user interaction
	 */
	private static ArrayList<JLabel> daily = new ArrayList<JLabel>();
	private final BufferedImage backgroundImg, defaultIconImg;
	private final Font font1 = new Font("SansSerif", Font.BOLD, 18);
	private final Font font2 = new Font("SansSerif", Font.BOLD, 16);
	private final Font font3 = new Font("SansSerif", Font.BOLD, 30);
	private static JLabel lblCity = new JLabel();
	private static JLabel lblTemperature = new JLabel();
	private static JLabel lblMinTemp = new JLabel();
	private static JLabel lblMaxTemp = new JLabel();
	private static JLabel lblSunrise = new JLabel();
	private static JLabel lblSunset = new JLabel();
	private static JLabel lblWindSpeed = new JLabel();
	private static JLabel lblWindDirection = new JLabel();
	private static JLabel lblAirPressure = new JLabel();
	private static JLabel lblHumidity = new JLabel();
	private static JLabel lblSkyCondition = new JLabel();
	private static JLabel lblSkyIcon = new JLabel();
	private static JLabel lblUpdateTime = new JLabel();
	private static JLabel lblRefreshTime = new JLabel();
	private static JButton btnTempUnits;
	private static JButton btnWindUnits;
	private static JButton btnRefresh;
	static JTextField txtLocation;
	static char tempUnits;
	static char windUnits;
	private static String lastRefresh;




	public MainPanel(String cityName, String tUnits, String wUnits) throws IOException {
		
		backgroundImg = Utilities.getImage("gui.png");
		defaultIconImg = Utilities.getImage("error.png");
		lblSkyIcon = new JLabel(new ImageIcon(defaultIconImg));

		if (tUnits.length() > 0) {
			this.tempUnits = tUnits.charAt(0);
		}else{
			this.tempUnits = 'C';
		}
		if (wUnits.length() > 0) {
			this.windUnits = wUnits.charAt(0);
		}else{
			this.windUnits = 'K';
		}
		
		initializeDaily();
		initializePanelObjects(cityName);
		initializeLayout();

		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				screenUpdate();
			}});		
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				screenUpdate();
			}});
		
		btnTempUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tempUnits=='C'){
					tempUnits = 'F';
					btnTempUnits.setText("Change to Celcius");
				}else{
					tempUnits = 'C';
					btnTempUnits.setText("Change to Farenheit");
				}
				screenUpdate();
			}});
		
		btnWindUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(windUnits=='M'){
					windUnits = 'K';
					btnWindUnits.setText("Change to MPH");
				}else{
					windUnits = 'M';
					btnWindUnits.setText("Change to KPH");
				}
				screenUpdate();
			}});
		
		
	}

	/**
	 * Screenupdate is a helper class to MainPanel
	 * It updates the labels on the screen when the
	 * user requests a refresh, or when they search
	 * for a new city location.
	 */
	private static void screenUpdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lastRefresh = dateFormat.format(cal.getTime());
		
		City myCity = new City(txtLocation.getText(),tempUnits, windUnits);

		if (myCity.validate != true) {
			lblCity.setText("City Not Found");
			for (JLabel l : daily) {
				l.setText("");
			}

		} else {
			lblCity.setText(myCity.currentWeather.fullCityName);
			lblSkyIcon.setIcon(myCity.currentWeather.skyIcon);
			lblTemperature.setText("Current Temperature: "
					+ myCity.currentWeather.temperature + " " + tempUnits);
			lblMinTemp.setText("Minimum Temperature: "
					+ myCity.currentWeather.minTemp + " " + tempUnits);
			lblMaxTemp.setText("Maximum Temperature: "
					+ myCity.currentWeather.maxTemp + " " + tempUnits);
			lblSunrise.setText("Sunrise Today: "
					+ myCity.currentWeather.sunrise);
			lblSunset.setText("Sunset Today: " + myCity.currentWeather.sunset);
			lblWindSpeed.setText("Wind Speed: "
					+ myCity.currentWeather.windSpeed + " " + windUnits + "PH");
			lblWindDirection.setText("Wind Direction: "
					+ myCity.currentWeather.windDirection);
			lblAirPressure.setText("Air Pressure: "
					+ myCity.currentWeather.airPressure);
			lblHumidity.setText("Humidity: " + myCity.currentWeather.humidity);
			lblSkyCondition.setText("Sky Condition: "
					+ myCity.currentWeather.skyCondition);
			lblRefreshTime.setText("Last Refreshed:   "
					+ lastRefresh);
			lblUpdateTime.setText("Last Updated:      "
					+ myCity.currentWeather.timeUpdated);
		}
	}

	/**
	 * initializeDaily is a helper class to MainPanel
	 * When the MainPanel constructor is first used,
	 * initializeDaily sets up the "daily" list with
	 * the relevant labels. This allows us to easily
	 * update all of the labels at once by iterating
	 * over the "daily" list object.
	 */
	private void initializeDaily() {
		daily.add(lblTemperature);
		daily.add(lblMinTemp);
		daily.add(lblMaxTemp);
		daily.add(lblSunrise);
		daily.add(lblSunset);
		daily.add(lblWindSpeed);
		daily.add(lblWindDirection);
		daily.add(lblAirPressure);
		daily.add(lblHumidity);
		daily.add(lblSkyCondition);
		daily.add(lblUpdateTime);
		daily.add(lblRefreshTime);
	}

	/**
	 * initializePanelObjects is a helper class to MainPanel.
	 * When the MainPanel constructor is first used, this
	 * method sets up the buttons and textboxes on the screen. 
	 * 
	 * @param cityName		The name of the city that should
	 * 						be set up for the first time
	 * 						(Empty if no city should be set up)
	 */
	private void initializePanelObjects(String cityName) {
		
		btnTempUnits = new JButton();
		if(tempUnits=='F'){
		    btnTempUnits.setText("Change to Celcius");
        }else{
            btnTempUnits.setText("Change to Farenheit");
        }
		btnWindUnits = new JButton();
		if(windUnits=='M'){
		    btnWindUnits.setText("Change to KPH");
        }else{
            btnWindUnits.setText("Change to MPH");
        }
		btnRefresh = new JButton();
		btnRefresh.setText("Refresh");
		
		txtLocation = new JTextField();
		txtLocation.setBorder(new LineBorder(Color.BLACK, 0));
		txtLocation.setOpaque(false);
		txtLocation.setPreferredSize(new Dimension(75, 25));
		txtLocation.setFont(font1);

		lblCity.setFont(font3);
		lblCity.setForeground(Color.white);

		if (cityName.length() > 0) {
			txtLocation.setText(cityName);
			screenUpdate();
		}

		for (JLabel l : daily) {
			l.setFont(font2);
			l.setForeground(Color.white);
		}

	}

	/**
	 * initializeLayout is a helper class to MainPanel.
	 * When the MainPanel constructor is first used, this
	 * method sets up the grouplayout. By adjusting the
	 * grouplayout, we can adjust where each object is
	 * located within the GUI. 
	 * 
	 * @param cityName			The name of the city that
	 * 							should be shown within the
	 * 							gui
	 */
	private void initializeLayout() {
		GroupLayout layout = new GroupLayout(this);
		
		layout.setHorizontalGroup(
		layout.createParallelGroup(Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
				.addGap(31)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(4)
								.addComponent(txtLocation,328,328,328))
								.addComponent(btnTempUnits)
								.addComponent(btnWindUnits)
								.addComponent(btnRefresh)
								.addComponent(lblCity, 500,	500, 500)
								.addComponent(lblSkyIcon)
								.addComponent(lblTemperature)
								.addComponent(lblMinTemp)
								.addComponent(lblMaxTemp)
								.addComponent(lblSunrise)
								.addComponent(lblSunset)
								.addComponent(lblWindSpeed)
								.addComponent(lblWindDirection)
								.addComponent(lblAirPressure)
								.addComponent(lblHumidity)
								.addComponent(lblSkyCondition)
								.addComponent(lblRefreshTime)
								.addComponent(lblUpdateTime))
								.addContainerGap()));
		
		layout.setVerticalGroup(
		layout.createParallelGroup(Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(30)
								.addComponent(txtLocation,42,42,42)
								.addGap(20)
								.addComponent(btnTempUnits)
								.addComponent(btnWindUnits)
								.addComponent(btnRefresh)
								.addComponent(lblCity)
								.addComponent(lblSkyIcon)
								.addComponent(lblTemperature)
								.addComponent(lblMinTemp)
								.addComponent(lblMaxTemp)
								.addComponent(lblSunrise)
								.addComponent(lblSunset)
								.addComponent(lblWindSpeed)
								.addComponent(lblWindDirection)
								.addComponent(lblAirPressure)
								.addComponent(lblHumidity)
								.addComponent(lblSkyCondition)
								.addGap(50)
								.addComponent(lblRefreshTime)
								.addComponent(lblUpdateTime))
								.addGroup(layout.createSequentialGroup()
										.addGap(59)))
										.addContainerGap(133, Short.MAX_VALUE)));
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		this.setLayout(layout);
	}

	/**
	 * The painComponent is used to draw the background
	 * image on the screen. This allows us to easily adjust
	 * the background by simply editing the background image file.
	 * 
	 * @param g			inherited from super-class
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
	}

}