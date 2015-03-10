package team19.weatherapp;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TestPanel extends JFrame {
	private JTextField textField;
	public TestPanel() {
		
		JMenuBar menu = new JMenuBar();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mnFile.add(mntmRefresh);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnPreferences = new JMenu("Preferences");
		menuBar.add(mnPreferences);
		
		JMenu mnTemperatureUnits = new JMenu("Temperature Units");
		mnPreferences.add(mnTemperatureUnits);
		
		JRadioButtonMenuItem rdbtnmntmCelsius = new JRadioButtonMenuItem("Celsius");
		rdbtnmntmCelsius.setSelected(true);
		mnTemperatureUnits.add(rdbtnmntmCelsius);
		
		JRadioButtonMenuItem rdbtnmntmFahrenheit = new JRadioButtonMenuItem("Fahrenheit");
		mnTemperatureUnits.add(rdbtnmntmFahrenheit);
		
		JMenu mnWindSpeedUnits = new JMenu("Wind Speed Units");
		mnPreferences.add(mnWindSpeedUnits);
		
		JRadioButtonMenuItem rdbtnmntmKilometers = new JRadioButtonMenuItem("Kilometers");
		rdbtnmntmKilometers.setSelected(true);
		mnWindSpeedUnits.add(rdbtnmntmKilometers);
		
		JRadioButtonMenuItem rdbtnmntmMiles = new JRadioButtonMenuItem("Miles");
		mnWindSpeedUnits.add(rdbtnmntmMiles);
		
		JMenu mnWeatherData = new JMenu("Weather Data Displayed");
		mnPreferences.add(mnWeatherData);
		
		JCheckBoxMenuItem chckbxmntmTemperature = new JCheckBoxMenuItem("Temperature");
		chckbxmntmTemperature.setSelected(true);
		mnWeatherData.add(chckbxmntmTemperature);
		
		JCheckBoxMenuItem chckbxmntmExpectedMinmax = new JCheckBoxMenuItem("Expected Min/Max");
		chckbxmntmExpectedMinmax.setSelected(true);
		mnWeatherData.add(chckbxmntmExpectedMinmax);
		
		JCheckBoxMenuItem chckbxmntmSunrisesunsetTimes = new JCheckBoxMenuItem("Sunrise/Sunset Times");
		chckbxmntmSunrisesunsetTimes.setSelected(true);
		mnWeatherData.add(chckbxmntmSunrisesunsetTimes);
		
		JCheckBoxMenuItem chckbxmntmWindSpeed = new JCheckBoxMenuItem("Wind Speed & Direction");
		chckbxmntmWindSpeed.setSelected(true);
		mnWeatherData.add(chckbxmntmWindSpeed);
		
		JCheckBoxMenuItem chckbxmntmAirPressure = new JCheckBoxMenuItem("Air Pressure");
		chckbxmntmAirPressure.setSelected(true);
		mnWeatherData.add(chckbxmntmAirPressure);
		
		JCheckBoxMenuItem chckbxmntmHumidity = new JCheckBoxMenuItem("Humidity");
		chckbxmntmHumidity.setSelected(true);
		mnWeatherData.add(chckbxmntmHumidity);
		
		JCheckBoxMenuItem chckbxmntmSkyCondition = new JCheckBoxMenuItem("Sky Condition");
		chckbxmntmSkyCondition.setSelected(true);
		mnWeatherData.add(chckbxmntmSkyCondition);
		
		JCheckBoxMenuItem chckbxmntmPrecipitation = new JCheckBoxMenuItem("Precipitation");
		chckbxmntmPrecipitation.setSelected(true);
		mnWeatherData.add(chckbxmntmPrecipitation);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 697, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 496, Short.MAX_VALUE)
		);
		
		JToolBar toolBar_1 = new JToolBar();
		getContentPane().add(toolBar_1, BorderLayout.SOUTH);
		
		JButton AddCityBtn = new JButton("Add City");
		toolBar_1.add(AddCityBtn);
		
		JButton RemoveCityBtn = new JButton("Remove City");
		toolBar_1.add(RemoveCityBtn);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar_1.add(horizontalStrut);
		
		JLabel lblTimeRefreshed = new JLabel("Last refreshed: MM/DD/YY hh:mm a");
		toolBar_1.add(lblTimeRefreshed);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar_1.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar_1.add(horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar_1.add(horizontalStrut_3);
		
		JButton tempUnitsBtn = new JButton("C/F");
		toolBar_1.add(tempUnitsBtn);
		
		JButton windUnitsBtn = new JButton("Miles/KM");
		toolBar_1.add(windUnitsBtn);
		
		JButton RefreshBtn = new JButton("Refresh");
		toolBar_1.add(RefreshBtn);
		
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		JPanel pnlCurrentWeather = new JPanel();
		tabbedPane.addTab("Current", null, pnlCurrentWeather, null);
		
		JLabel lblSkyicon = new JLabel("*** SKY ICON ***");
		
		JLabel lblTemp = new JLabel("XX C");
		lblTemp.setFont(new Font("Helvetica Neue", Font.BOLD, 50));
		
		JLabel lblCityname = new JLabel("CITY NAME, COUNTRY");
		lblCityname.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		
		JLabel lblExpectedmin = new JLabel("ExpectedMin:");
		
		JLabel lblExpectedmax = new JLabel("ExpectedMax");
		
		JLabel lblWind = new JLabel("Wind:");
		
		JLabel lblSunrise = new JLabel("Sunrise:");
		
		JLabel lblSunset = new JLabel("Sunset:");
		
		JLabel lblAirPressure = new JLabel("Air Pressure:");
		
		JLabel lblHumidity = new JLabel("Humidity:");
		
		JLabel lblPop = new JLabel("P.O.P.:");
		
		JLabel lblSkycondition = new JLabel("-- PUT SKY CONDITION HERE--");
		
		JLabel lblExpmin = new JLabel("XX C");
		
		JLabel lblExpmax = new JLabel("XX C");
		
		JLabel lblSunrisetime = new JLabel("MM/DD/YY hh:mm a");
		
		JLabel lblSunsettime = new JLabel("MM/DD/YY hh:mm a");
		
		JLabel lblPressure = new JLabel("XX hPa");
		
		JLabel lblPrecip = new JLabel("XX%");
		
		JLabel lblWindspddir = new JLabel("XXX km/h XXX D");
		
		JLabel lblHumid = new JLabel("XX%");
		GroupLayout gl_pnlCurrentWeather = new GroupLayout(pnlCurrentWeather);
		gl_pnlCurrentWeather.setHorizontalGroup(
			gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
									.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSunset)
										.addComponent(lblSunrise)
										.addComponent(lblExpectedmax)
										.addComponent(lblExpectedmin))
									.addGap(18)
									.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
										.addComponent(lblExpmax)
										.addComponent(lblExpmin)
										.addComponent(lblSunrisetime)
										.addComponent(lblSunsettime))
									.addGap(24)
									.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAirPressure)
										.addComponent(lblPop)
										.addComponent(lblWind)
										.addComponent(lblHumidity))
									.addGap(18)
									.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHumid)
										.addComponent(lblWindspddir)
										.addComponent(lblPrecip)
										.addComponent(lblPressure)))
								.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSkycondition)
										.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
											.addComponent(lblSkyicon, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblTemp))))))
						.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
							.addGap(14)
							.addComponent(lblCityname)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_pnlCurrentWeather.setVerticalGroup(
			gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCityname)
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
							.addGap(18)
							.addComponent(lblSkyicon, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlCurrentWeather.createSequentialGroup()
							.addGap(45)
							.addComponent(lblTemp)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSkycondition)
					.addGap(21)
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExpectedmin)
						.addComponent(lblPop)
						.addComponent(lblExpmin)
						.addComponent(lblPrecip))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExpectedmax)
						.addComponent(lblWind)
						.addComponent(lblExpmax)
						.addComponent(lblWindspddir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSunrise)
						.addComponent(lblAirPressure)
						.addComponent(lblSunrisetime)
						.addComponent(lblPressure))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCurrentWeather.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSunset)
						.addComponent(lblHumidity)
						.addComponent(lblSunsettime)
						.addComponent(lblHumid))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		pnlCurrentWeather.setLayout(gl_pnlCurrentWeather);
		
		JPanel pnlShortTerm = new JPanel();
		tabbedPane.addTab("Short-Term", null, pnlShortTerm, null);
		GridBagLayout gbl_pnlShortTerm = new GridBagLayout();
		gbl_pnlShortTerm.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlShortTerm.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlShortTerm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlShortTerm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlShortTerm.setLayout(gbl_pnlShortTerm);
		
		JLabel lblSTCityName = new JLabel("City Name, Country");
		lblSTCityName.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		GridBagConstraints gbc_lblSTCityName = new GridBagConstraints();
		gbc_lblSTCityName.anchor = GridBagConstraints.WEST;
		gbc_lblSTCityName.gridwidth = 6;
		gbc_lblSTCityName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTCityName.gridx = 1;
		gbc_lblSTCityName.gridy = 1;
		pnlShortTerm.add(lblSTCityName, gbc_lblSTCityName);
		
		JLabel lblFirsthour = new JLabel("FirstHour");
		GridBagConstraints gbc_lblFirsthour = new GridBagConstraints();
		gbc_lblFirsthour.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirsthour.anchor = GridBagConstraints.WEST;
		gbc_lblFirsthour.gridx = 1;
		gbc_lblFirsthour.gridy = 2;
		pnlShortTerm.add(lblFirsthour, gbc_lblFirsthour);
		
		JLabel lblFifthhour = new JLabel("FifthHour");
		GridBagConstraints gbc_lblFifthhour = new GridBagConstraints();
		gbc_lblFifthhour.anchor = GridBagConstraints.WEST;
		gbc_lblFifthhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblFifthhour.gridx = 6;
		gbc_lblFifthhour.gridy = 2;
		pnlShortTerm.add(lblFifthhour, gbc_lblFifthhour);
		
		JLabel lbl1stHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl1stHrSkyIcon = new GridBagConstraints();
		gbc_lbl1stHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1stHrSkyIcon.gridx = 1;
		gbc_lbl1stHrSkyIcon.gridy = 3;
		pnlShortTerm.add(lbl1stHrSkyIcon, gbc_lbl1stHrSkyIcon);
		
		JLabel lbl1stHrTemp = new JLabel("XX C");
		lbl1stHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl1stHrTemp = new GridBagConstraints();
		gbc_lbl1stHrTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1stHrTemp.gridx = 2;
		gbc_lbl1stHrTemp.gridy = 3;
		pnlShortTerm.add(lbl1stHrTemp, gbc_lbl1stHrTemp);
		
		JLabel lbl5thHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl5thHrSkyIcon = new GridBagConstraints();
		gbc_lbl5thHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl5thHrSkyIcon.gridx = 6;
		gbc_lbl5thHrSkyIcon.gridy = 3;
		pnlShortTerm.add(lbl5thHrSkyIcon, gbc_lbl5thHrSkyIcon);
		
		JLabel lbl5thHrTemp = new JLabel("XX C");
		lbl5thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl5thHrTemp = new GridBagConstraints();
		gbc_lbl5thHrTemp.insets = new Insets(0, 0, 5, 0);
		gbc_lbl5thHrTemp.gridx = 7;
		gbc_lbl5thHrTemp.gridy = 3;
		pnlShortTerm.add(lbl5thHrTemp, gbc_lbl5thHrTemp);
		
		JLabel lblSecondhour = new JLabel("SecondHour");
		GridBagConstraints gbc_lblSecondhour = new GridBagConstraints();
		gbc_lblSecondhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecondhour.anchor = GridBagConstraints.WEST;
		gbc_lblSecondhour.gridx = 1;
		gbc_lblSecondhour.gridy = 4;
		pnlShortTerm.add(lblSecondhour, gbc_lblSecondhour);
		
		JLabel lblSixthhour = new JLabel("SixthHour");
		GridBagConstraints gbc_lblSixthhour = new GridBagConstraints();
		gbc_lblSixthhour.anchor = GridBagConstraints.WEST;
		gbc_lblSixthhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblSixthhour.gridx = 6;
		gbc_lblSixthhour.gridy = 4;
		pnlShortTerm.add(lblSixthhour, gbc_lblSixthhour);
		
		JLabel lbl2ndHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl2ndHrSkyIcon = new GridBagConstraints();
		gbc_lbl2ndHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ndHrSkyIcon.gridx = 1;
		gbc_lbl2ndHrSkyIcon.gridy = 5;
		pnlShortTerm.add(lbl2ndHrSkyIcon, gbc_lbl2ndHrSkyIcon);
		
		JLabel lbl2ndHrTemp = new JLabel("XX C");
		lbl2ndHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl2ndHrTemp = new GridBagConstraints();
		gbc_lbl2ndHrTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ndHrTemp.gridx = 2;
		gbc_lbl2ndHrTemp.gridy = 5;
		pnlShortTerm.add(lbl2ndHrTemp, gbc_lbl2ndHrTemp);
		
		JLabel lbl6thHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl6thHrSkyIcon = new GridBagConstraints();
		gbc_lbl6thHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl6thHrSkyIcon.gridx = 6;
		gbc_lbl6thHrSkyIcon.gridy = 5;
		pnlShortTerm.add(lbl6thHrSkyIcon, gbc_lbl6thHrSkyIcon);
		
		JLabel lbl6thHrTemp = new JLabel("XX C");
		lbl6thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl6thHrTemp = new GridBagConstraints();
		gbc_lbl6thHrTemp.insets = new Insets(0, 0, 5, 0);
		gbc_lbl6thHrTemp.gridx = 7;
		gbc_lbl6thHrTemp.gridy = 5;
		pnlShortTerm.add(lbl6thHrTemp, gbc_lbl6thHrTemp);
		
		JLabel lblThirdhour = new JLabel("ThirdHour");
		GridBagConstraints gbc_lblThirdhour = new GridBagConstraints();
		gbc_lblThirdhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblThirdhour.anchor = GridBagConstraints.WEST;
		gbc_lblThirdhour.gridx = 1;
		gbc_lblThirdhour.gridy = 6;
		pnlShortTerm.add(lblThirdhour, gbc_lblThirdhour);
		
		JLabel lblSeventhhour = new JLabel("SeventhHour");
		GridBagConstraints gbc_lblSeventhhour = new GridBagConstraints();
		gbc_lblSeventhhour.anchor = GridBagConstraints.WEST;
		gbc_lblSeventhhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeventhhour.gridx = 6;
		gbc_lblSeventhhour.gridy = 6;
		pnlShortTerm.add(lblSeventhhour, gbc_lblSeventhhour);
		
		JLabel lbl3rdHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl3rdHrSkyIcon = new GridBagConstraints();
		gbc_lbl3rdHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3rdHrSkyIcon.gridx = 1;
		gbc_lbl3rdHrSkyIcon.gridy = 7;
		pnlShortTerm.add(lbl3rdHrSkyIcon, gbc_lbl3rdHrSkyIcon);
		
		JLabel lbl3rdHrTemp = new JLabel("XX C");
		lbl3rdHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl3rdHrTemp = new GridBagConstraints();
		gbc_lbl3rdHrTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3rdHrTemp.gridx = 2;
		gbc_lbl3rdHrTemp.gridy = 7;
		pnlShortTerm.add(lbl3rdHrTemp, gbc_lbl3rdHrTemp);
		
		JLabel lbl7thHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl7thHrSkyIcon = new GridBagConstraints();
		gbc_lbl7thHrSkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl7thHrSkyIcon.gridx = 6;
		gbc_lbl7thHrSkyIcon.gridy = 7;
		pnlShortTerm.add(lbl7thHrSkyIcon, gbc_lbl7thHrSkyIcon);
		
		JLabel lbl7thHrTemp = new JLabel("XX C");
		lbl7thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl7thHrTemp = new GridBagConstraints();
		gbc_lbl7thHrTemp.insets = new Insets(0, 0, 5, 0);
		gbc_lbl7thHrTemp.gridx = 7;
		gbc_lbl7thHrTemp.gridy = 7;
		pnlShortTerm.add(lbl7thHrTemp, gbc_lbl7thHrTemp);
		
		JLabel lblFourthhour = new JLabel("FourthHour");
		GridBagConstraints gbc_lblFourthhour = new GridBagConstraints();
		gbc_lblFourthhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblFourthhour.anchor = GridBagConstraints.WEST;
		gbc_lblFourthhour.gridx = 1;
		gbc_lblFourthhour.gridy = 8;
		pnlShortTerm.add(lblFourthhour, gbc_lblFourthhour);
		
		JLabel lblEighthhour = new JLabel("EighthHour");
		GridBagConstraints gbc_lblEighthhour = new GridBagConstraints();
		gbc_lblEighthhour.anchor = GridBagConstraints.WEST;
		gbc_lblEighthhour.insets = new Insets(0, 0, 5, 5);
		gbc_lblEighthhour.gridx = 6;
		gbc_lblEighthhour.gridy = 8;
		pnlShortTerm.add(lblEighthhour, gbc_lblEighthhour);
		
		JLabel lbl4thHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl4thHrSkyIcon = new GridBagConstraints();
		gbc_lbl4thHrSkyIcon.insets = new Insets(0, 0, 0, 5);
		gbc_lbl4thHrSkyIcon.gridx = 1;
		gbc_lbl4thHrSkyIcon.gridy = 9;
		pnlShortTerm.add(lbl4thHrSkyIcon, gbc_lbl4thHrSkyIcon);
		
		JLabel lbl4thHrTemp = new JLabel("XX C");
		lbl4thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl4thHrTemp = new GridBagConstraints();
		gbc_lbl4thHrTemp.insets = new Insets(0, 0, 0, 5);
		gbc_lbl4thHrTemp.gridx = 2;
		gbc_lbl4thHrTemp.gridy = 9;
		pnlShortTerm.add(lbl4thHrTemp, gbc_lbl4thHrTemp);
		
		JLabel lbl8thHrSkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl8thHrSkyIcon = new GridBagConstraints();
		gbc_lbl8thHrSkyIcon.insets = new Insets(0, 0, 0, 5);
		gbc_lbl8thHrSkyIcon.gridx = 6;
		gbc_lbl8thHrSkyIcon.gridy = 9;
		pnlShortTerm.add(lbl8thHrSkyIcon, gbc_lbl8thHrSkyIcon);
		
		JLabel lbl8thHrTemp = new JLabel("XX C");
		lbl8thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl8thHrTemp = new GridBagConstraints();
		gbc_lbl8thHrTemp.gridx = 7;
		gbc_lbl8thHrTemp.gridy = 9;
		pnlShortTerm.add(lbl8thHrTemp, gbc_lbl8thHrTemp);
		
		JPanel pnlLongTerm = new JPanel();
		tabbedPane.addTab("Long-Term", null, pnlLongTerm, null);
		GridBagLayout gbl_pnlLongTerm = new GridBagLayout();
		gbl_pnlLongTerm.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlLongTerm.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlLongTerm.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLongTerm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLongTerm.setLayout(gbl_pnlLongTerm);
		
		JLabel lblLTCityName = new JLabel("City Name, Country");
		lblLTCityName.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		GridBagConstraints gbc_lblLTCityName = new GridBagConstraints();
		gbc_lblLTCityName.gridwidth = 7;
		gbc_lblLTCityName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLTCityName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLTCityName.gridx = 1;
		gbc_lblLTCityName.gridy = 1;
		pnlLongTerm.add(lblLTCityName, gbc_lblLTCityName);
		
		JLabel lblFirstday = new JLabel("FirstDay");
		GridBagConstraints gbc_lblFirstday = new GridBagConstraints();
		gbc_lblFirstday.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstday.gridx = 1;
		gbc_lblFirstday.gridy = 4;
		pnlLongTerm.add(lblFirstday, gbc_lblFirstday);
		
		JLabel lblSecondday = new JLabel("SecondDay");
		GridBagConstraints gbc_lblSecondday = new GridBagConstraints();
		gbc_lblSecondday.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecondday.gridx = 3;
		gbc_lblSecondday.gridy = 4;
		pnlLongTerm.add(lblSecondday, gbc_lblSecondday);
		
		JLabel lblThirdday = new JLabel("ThirdDay");
		GridBagConstraints gbc_lblThirdday = new GridBagConstraints();
		gbc_lblThirdday.insets = new Insets(0, 0, 5, 5);
		gbc_lblThirdday.gridx = 5;
		gbc_lblThirdday.gridy = 4;
		pnlLongTerm.add(lblThirdday, gbc_lblThirdday);
		
		JLabel lblFourthday = new JLabel("FourthDay");
		GridBagConstraints gbc_lblFourthday = new GridBagConstraints();
		gbc_lblFourthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblFourthday.gridx = 7;
		gbc_lblFourthday.gridy = 4;
		pnlLongTerm.add(lblFourthday, gbc_lblFourthday);
		
		JLabel lblFifthday = new JLabel("FifthDay");
		GridBagConstraints gbc_lblFifthday = new GridBagConstraints();
		gbc_lblFifthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblFifthday.gridx = 9;
		gbc_lblFifthday.gridy = 4;
		pnlLongTerm.add(lblFifthday, gbc_lblFifthday);
		
		JLabel lbl1stDaySkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl1stDaySkyIcon = new GridBagConstraints();
		gbc_lbl1stDaySkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1stDaySkyIcon.gridx = 1;
		gbc_lbl1stDaySkyIcon.gridy = 6;
		pnlLongTerm.add(lbl1stDaySkyIcon, gbc_lbl1stDaySkyIcon);
		
		JLabel lbl2ndDaySkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl2ndDaySkyIcon = new GridBagConstraints();
		gbc_lbl2ndDaySkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ndDaySkyIcon.gridx = 3;
		gbc_lbl2ndDaySkyIcon.gridy = 6;
		pnlLongTerm.add(lbl2ndDaySkyIcon, gbc_lbl2ndDaySkyIcon);
		
		JLabel lbl3rdDaySkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl3rdDaySkyIcon = new GridBagConstraints();
		gbc_lbl3rdDaySkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3rdDaySkyIcon.gridx = 5;
		gbc_lbl3rdDaySkyIcon.gridy = 6;
		pnlLongTerm.add(lbl3rdDaySkyIcon, gbc_lbl3rdDaySkyIcon);
		
		JLabel lbl4thDaySkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl4thDaySkyIcon = new GridBagConstraints();
		gbc_lbl4thDaySkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl4thDaySkyIcon.gridx = 7;
		gbc_lbl4thDaySkyIcon.gridy = 6;
		pnlLongTerm.add(lbl4thDaySkyIcon, gbc_lbl4thDaySkyIcon);
		
		JLabel lbl5thDaySkyIcon = new JLabel("SKY ICON");
		GridBagConstraints gbc_lbl5thDaySkyIcon = new GridBagConstraints();
		gbc_lbl5thDaySkyIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lbl5thDaySkyIcon.gridx = 9;
		gbc_lbl5thDaySkyIcon.gridy = 6;
		pnlLongTerm.add(lbl5thDaySkyIcon, gbc_lbl5thDaySkyIcon);
		
		JLabel lbl1stDayTemp = new JLabel("XX C");
		lbl1stDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl1stDayTemp = new GridBagConstraints();
		gbc_lbl1stDayTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1stDayTemp.gridx = 1;
		gbc_lbl1stDayTemp.gridy = 7;
		pnlLongTerm.add(lbl1stDayTemp, gbc_lbl1stDayTemp);
		
		JLabel lbl2ndDayTemp = new JLabel("XX C");
		lbl2ndDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl2ndDayTemp = new GridBagConstraints();
		gbc_lbl2ndDayTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ndDayTemp.gridx = 3;
		gbc_lbl2ndDayTemp.gridy = 7;
		pnlLongTerm.add(lbl2ndDayTemp, gbc_lbl2ndDayTemp);
		
		JLabel lbl3rdDayTemp = new JLabel("XX C");
		lbl3rdDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl3rdDayTemp = new GridBagConstraints();
		gbc_lbl3rdDayTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3rdDayTemp.gridx = 5;
		gbc_lbl3rdDayTemp.gridy = 7;
		pnlLongTerm.add(lbl3rdDayTemp, gbc_lbl3rdDayTemp);
		
		JLabel lbl4thDayTemp = new JLabel("XX C");
		lbl4thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl4thDayTemp = new GridBagConstraints();
		gbc_lbl4thDayTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl4thDayTemp.gridx = 7;
		gbc_lbl4thDayTemp.gridy = 7;
		pnlLongTerm.add(lbl4thDayTemp, gbc_lbl4thDayTemp);
		
		JLabel lbl5thDayTemp = new JLabel("XX C");
		lbl5thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		GridBagConstraints gbc_lbl5thDayTemp = new GridBagConstraints();
		gbc_lbl5thDayTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lbl5thDayTemp.gridx = 9;
		gbc_lbl5thDayTemp.gridy = 7;
		pnlLongTerm.add(lbl5thDayTemp, gbc_lbl5thDayTemp);
		
		JLabel lbl1stDayMin = new JLabel("Min: XX C");
		GridBagConstraints gbc_lbl1stDayMin = new GridBagConstraints();
		gbc_lbl1stDayMin.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1stDayMin.gridx = 1;
		gbc_lbl1stDayMin.gridy = 9;
		pnlLongTerm.add(lbl1stDayMin, gbc_lbl1stDayMin);
		
		JLabel lbl2ndDayMin = new JLabel("Min: XX C");
		GridBagConstraints gbc_lbl2ndDayMin = new GridBagConstraints();
		gbc_lbl2ndDayMin.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ndDayMin.gridx = 3;
		gbc_lbl2ndDayMin.gridy = 9;
		pnlLongTerm.add(lbl2ndDayMin, gbc_lbl2ndDayMin);
		
		JLabel lbl3rdDayMin = new JLabel("Min: XX C");
		GridBagConstraints gbc_lbl3rdDayMin = new GridBagConstraints();
		gbc_lbl3rdDayMin.insets = new Insets(0, 0, 5, 5);
		gbc_lbl3rdDayMin.gridx = 5;
		gbc_lbl3rdDayMin.gridy = 9;
		pnlLongTerm.add(lbl3rdDayMin, gbc_lbl3rdDayMin);
		
		JLabel lbl4thDayMin = new JLabel("Min: XX C");
		GridBagConstraints gbc_lbl4thDayMin = new GridBagConstraints();
		gbc_lbl4thDayMin.insets = new Insets(0, 0, 5, 5);
		gbc_lbl4thDayMin.gridx = 7;
		gbc_lbl4thDayMin.gridy = 9;
		pnlLongTerm.add(lbl4thDayMin, gbc_lbl4thDayMin);
		
		JLabel lbl5thDayMin = new JLabel("Min: XX C");
		GridBagConstraints gbc_lbl5thDayMin = new GridBagConstraints();
		gbc_lbl5thDayMin.insets = new Insets(0, 0, 5, 5);
		gbc_lbl5thDayMin.gridx = 9;
		gbc_lbl5thDayMin.gridy = 9;
		pnlLongTerm.add(lbl5thDayMin, gbc_lbl5thDayMin);
		
		JLabel lbl1stDayMax = new JLabel("Max: XX C");
		GridBagConstraints gbc_lbl1stDayMax = new GridBagConstraints();
		gbc_lbl1stDayMax.insets = new Insets(0, 0, 0, 5);
		gbc_lbl1stDayMax.gridx = 1;
		gbc_lbl1stDayMax.gridy = 10;
		pnlLongTerm.add(lbl1stDayMax, gbc_lbl1stDayMax);
		
		JLabel lbl2ndDayMax = new JLabel("Max: XX C");
		GridBagConstraints gbc_lbl2ndDayMax = new GridBagConstraints();
		gbc_lbl2ndDayMax.insets = new Insets(0, 0, 0, 5);
		gbc_lbl2ndDayMax.gridx = 3;
		gbc_lbl2ndDayMax.gridy = 10;
		pnlLongTerm.add(lbl2ndDayMax, gbc_lbl2ndDayMax);
		
		JLabel lbl3rdDayMax = new JLabel("Max: XX C");
		GridBagConstraints gbc_lbl3rdDayMax = new GridBagConstraints();
		gbc_lbl3rdDayMax.insets = new Insets(0, 0, 0, 5);
		gbc_lbl3rdDayMax.gridx = 5;
		gbc_lbl3rdDayMax.gridy = 10;
		pnlLongTerm.add(lbl3rdDayMax, gbc_lbl3rdDayMax);
		
		JLabel lbl4thDayMax = new JLabel("Max: XX C");
		GridBagConstraints gbc_lbl4thDayMax = new GridBagConstraints();
		gbc_lbl4thDayMax.insets = new Insets(0, 0, 0, 5);
		gbc_lbl4thDayMax.gridx = 7;
		gbc_lbl4thDayMax.gridy = 10;
		pnlLongTerm.add(lbl4thDayMax, gbc_lbl4thDayMax);
		
		JLabel lbl5thDayMax = new JLabel("Max: XX C");
		GridBagConstraints gbc_lbl5thDayMax = new GridBagConstraints();
		gbc_lbl5thDayMax.insets = new Insets(0, 0, 0, 5);
		gbc_lbl5thDayMax.gridx = 9;
		gbc_lbl5thDayMax.gridy = 10;
		pnlLongTerm.add(lbl5thDayMax, gbc_lbl5thDayMax);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JButton btnNewButton = new JButton("New button");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		
		

}	

