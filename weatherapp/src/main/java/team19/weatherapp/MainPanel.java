package team19.weatherapp;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;

import org.json.JSONObject;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

//MainWindow Class
public class MainPanel extends JPanel{
	
	// Panel Objects
	static JTextField txtLocation;
	private static JLabel lblCity;
	private static JLabel lblTemperature;
	private static JLabel lblMinTemp;
	private static JLabel lblMaxTemp;
	private static JLabel lblSunrise;
	private static JLabel lblSunset;
	private static JLabel lblWindSpeed;
	private static JLabel lblWindDirection;
	private static JLabel lblAirPressure;
	private static JLabel lblHumidity;
	private static JLabel lblSkyCondition;
	private static JLabel skyIcon;
	private static JLabel lblUpdateTime;
	private JButton btnCompute;
	final BufferedImage image;
	
	// JPanel Form
	public MainPanel(String cityName) throws IOException{
		image = ImageIO.read(new File("./src/resources/gui.png"));
		
		BufferedImage defaultIconImg = ImageIO.read(new File("./src/resources/error.png"));
		ImageIcon defaultIcon = new ImageIcon(defaultIconImg);
		skyIcon = new JLabel(defaultIcon);

		// Initialize Panel Objects
		txtLocation =  new JTextField() {
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtLocation.setOpaque(false);
		txtLocation.setPreferredSize(new Dimension(75, 25));
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		txtLocation.setFont(font1);
		
		lblCity = new JLabel();
		lblTemperature = new JLabel();
		lblMinTemp = new JLabel();
		lblMaxTemp = new JLabel();
		lblSunrise = new JLabel();
		lblSunset = new JLabel();
		lblWindSpeed = new JLabel();
		lblWindDirection = new JLabel();
		lblAirPressure = new JLabel();
		lblHumidity = new JLabel();
		lblSkyCondition = new JLabel();
		lblUpdateTime = new JLabel();
		
		Font font2 = new Font("SansSerif", Font.BOLD, 16);
		Font font3 = new Font("SansSerif", Font.BOLD, 30);
		
		lblCity.setFont(font3);
		lblTemperature.setFont(font2);
		lblMinTemp.setFont(font2);
		lblMaxTemp.setFont(font2);
		lblSunrise.setFont(font2);
		lblSunset.setFont(font2);
		lblWindSpeed.setFont(font2);
		lblWindDirection.setFont(font2);
		lblAirPressure.setFont(font2);
		lblHumidity.setFont(font2);
		lblSkyCondition.setFont(font2);
		lblUpdateTime.setFont(font2);
		
		lblCity.setForeground(Color.white);
		lblTemperature.setForeground(Color.white);
		lblMinTemp.setForeground(Color.white);
		lblMaxTemp.setForeground(Color.white);
		lblSunrise.setForeground(Color.white);
		lblSunset.setForeground(Color.white);
		lblWindSpeed.setForeground(Color.white);
		lblWindDirection.setForeground(Color.white);
		lblAirPressure.setForeground(Color.white);
		lblHumidity.setForeground(Color.white);
		lblSkyCondition.setForeground(Color.white);
		lblUpdateTime.setForeground(Color.white);
		
		if(cityName.length() > 0){
			txtLocation.setText(cityName);
			screenUpdate();
		}
		
		/*
		btnCompute = new JButton("");
		btnCompute.setBorderPainted(false);
		btnCompute.setFocusPainted(false);
		btnCompute.setContentAreaFilled(false);
		btnCompute.setIcon(new ImageIcon("./src/resources/getWeather.png"));
		btnCompute.setRolloverIcon(new ImageIcon(
				"./src/resources/getWeatherRoll.png"));
		btnCompute.setPressedIcon(new ImageIcon(
				"./src/resources/getWeatherPress.png"));*/

		// ActionListener for the JButton
		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				screenUpdate();
			}

		});

		// Layout Design
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(31)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(4)
							.addComponent(txtLocation, 328, 328, 328)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
						.addComponent(lblCity, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(50)
						.addComponent(skyIcon, 138, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTemperature, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMinTemp, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxTemp, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSunrise, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSunset, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWindSpeed, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWindDirection, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAirPressure, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHumidity, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSkyCondition, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpdateTime, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(30)
							.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(lblCity)
							.addComponent(skyIcon)
							.addComponent(lblTemperature)
							.addComponent(lblMinTemp)
							.addComponent(lblMaxTemp)
							.addComponent(lblSunrise)
							.addComponent(lblSunset)
							.addComponent(lblWindSpeed)
							.addComponent(lblWindDirection)
							.addComponent(lblAirPressure)
							.addComponent(lblHumidity)
							.addComponent(lblSkyCondition))
							.addGap(300)
							.addComponent(lblUpdateTime)
						.addGroup(layout.createSequentialGroup()
							.addGap(59)
							))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		
		// Set layout and return panel
		this.setLayout(layout);
	}
	
	private static void screenUpdate(){
		// Parse Data
		City myCity = new City(txtLocation.getText());

		// If Error, Respond Accordingly
		if (myCity.validate != true) {
			lblCity.setText("City Not Found");
			lblTemperature.setText("");
			lblMinTemp.setText("");
			lblMaxTemp.setText("");
			lblSunrise.setText("");
			lblSunset.setText("");
			lblWindSpeed.setText("");
			lblWindDirection.setText("");
			lblAirPressure.setText("");
			lblHumidity.setText("");
			lblSkyCondition.setText("");
			lblUpdateTime.setText("");
			
			// If Valid, Display Data on Screen
		} else {
			lblCity.setText(myCity.currentWeather.fullCityName);
			skyIcon.setIcon(myCity.currentWeather.skyIcon);
			lblTemperature.setText("Current Temperature: "
					+ myCity.currentWeather.temperature);
			lblMinTemp.setText("Minimum Temperature: "
					+ myCity.currentWeather.minTemp);
			lblMaxTemp.setText("Maximum Temperature: "
					+ myCity.currentWeather.maxTemp);
			lblSunrise.setText("Sunrise Today: "
					+ myCity.currentWeather.sunrise);
			lblSunset.setText("Sunset Today: "
					+ myCity.currentWeather.sunset);
			lblWindSpeed.setText("Wind Speed: "
					+ myCity.currentWeather.windSpeed);
			lblWindDirection.setText("Wind Direction: "
					+ myCity.currentWeather.windDirection);
			lblAirPressure.setText("Air Pressure: "
					+ myCity.currentWeather.airPressure);
			lblHumidity.setText("Humidity: "
					+ myCity.currentWeather.humidity);
			lblSkyCondition.setText("Sky Condition: "
					+ myCity.currentWeather.skyCondition);
			lblUpdateTime.setText("Last Updated: " 
					+ myCity.currentWeather.timeUpdated);
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
	
}