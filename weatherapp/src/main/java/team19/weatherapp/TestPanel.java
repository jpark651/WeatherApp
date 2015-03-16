package team19.weatherapp;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class TestPanel extends JFrame{
	
	static JTextField txtLocation;
	
	private static JSplitPane backPanel;
	private static JPanel menuPanel;
	private static JTabbedPane mainPanel;
	
	/**
	 * JLabels needed for the local weather view
	 */
	
	private static JPanel pnlLocalWeather;
	private static ArrayList<JLabel> local;
	private static JLabel lblLocalTemperature;
	private static JLabel lblLocalMinTemp;
	private static JLabel lblLocalMaxTemp;
	private static JLabel lblLocalSunrise;
	private static JLabel lblLocalSunset;
	private static JLabel lblLocalWindSpeed;
	private static JLabel lblLocalWindDirection;
	private static JLabel lblLocalAirPressure;
	private static JLabel lblLocalHumidity;
	private static JLabel lblLocalSkyCondition;
	private static JLabel lblLocalSkyIcon;
	/**
	 * JLabels needed for the short-term forecast view
	 */
	private static JPanel pnlShortTerm;
	private static ArrayList<JLabel> shortTerm;
	private static JLabel lbl1stHr;
	private static JLabel lbl2ndHr;
	private static JLabel lbl3rdHr;
	private static JLabel lbl4thHr;
	private static JLabel lbl5thHr;
	private static JLabel lbl6thHr;
	private static JLabel lbl7thHr;
	private static JLabel lbl8thHr;
	private static JLabel lbl1stHrTemp;
	private static JLabel lbl2ndHrTemp;
	private static JLabel lbl3rdHrTemp;
	private static JLabel lbl4thHrTemp;
	private static JLabel lbl5thHrTemp;
	private static JLabel lbl6thHrTemp;
	private static JLabel lbl7thHrTemp;
	private static JLabel lbl8thHrTemp;
	private static JLabel lbl1stHrSkyIcon;
	private static JLabel lbl2ndHrSkyIcon;
	private static JLabel lbl3rdHrSkyIcon;
	private static JLabel lbl4thHrSkyIcon;
	private static JLabel lbl5thHrSkyIcon;
	private static JLabel lbl6thHrSkyIcon;
	private static JLabel lbl7thHrSkyIcon;
	private static JLabel lbl8thHrSkyIcon;
	private static JLabel lbl1stHrSkyCondition;
	private static JLabel lbl2ndHrSkyCondition;
	private static JLabel lbl3rdHrSkyCondition;
	private static JLabel lbl4thHrSkyCondition;
	private static JLabel lbl5thHrSkyCondition;
	private static JLabel lbl6thHrSkyCondition;
	private static JLabel lbl7thHrSkyCondition;
	private static JLabel lbl8thHrSkyCondition;
	/**
	 * JLabels needed for the long-term forecast view
	 */
	private static JPanel pnlLongTerm;
	private static ArrayList<JLabel> longTerm;
	private static JLabel lbl1stDay;
	private static JLabel lbl2ndDay;
	private static JLabel lbl3rdDay;
	private static JLabel lbl4thDay;
	private static JLabel lbl5thDay;
	private static JLabel lbl1stDayTemp;
	private static JLabel lbl2ndDayTemp;
	private static JLabel lbl3rdDayTemp;
	private static JLabel lbl4thDayTemp;
	private static JLabel lbl5thDayTemp;
	private static JLabel lbl1stDayMinTemp;
	private static JLabel lbl2ndDayMinTemp;
	private static JLabel lbl3rdDayMinTemp;
	private static JLabel lbl4thDayMinTemp;
	private static JLabel lbl5thDayMinTemp;
	private static JLabel lbl1stDayMaxTemp;
	private static JLabel lbl2ndDayMaxTemp;
	private static JLabel lbl3rdDayMaxTemp;
	private static JLabel lbl4thDayMaxTemp;
	private static JLabel lbl5thDayMaxTemp;
	private static JLabel lbl1stDaySkyIcon;
	private static JLabel lbl2ndDaySkyIcon;
	private static JLabel lbl3rdDaySkyIcon;
	private static JLabel lbl4thDaySkyIcon;
	private static JLabel lbl5thDaySkyIcon;
	private static JLabel lbl1stDaySkyCondition;
	private static JLabel lbl2ndDaySkyCondition;
	private static JLabel lbl3rdDaySkyCondition;
	private static JLabel lbl4thDaySkyCondition;
	private static JLabel lbl5thDaySkyCondition;
	
	/**
	 * Components needed for toolbar
	 */
	private static JToolBar toolbar;
	private static JLabel lblRefreshTime;
	private static JButton btnAddCity;
	private static JButton btnRemoveCity;
	private static JButton btnTempUnits;
	private static JButton btnWindUnits;
	private static JButton btnRefresh;
	private static JLabel lblCity, lblSTCity, lblLTCity;
	private static String lastRefresh;
	
	/**
	 * Components needed for menubar
	 */
	private static JMenuBar menubar;
	private static JMenu fileMenu;
	private static JMenu preferencesMenu;
	private static JMenuItem refreshMenuBtn;
	private static ButtonGroup tempUnitMenuBtns;
	private static ButtonGroup windUnitMenuBtns;
	private static JRadioButtonMenuItem celsiusMenuBtn;
	private static JRadioButtonMenuItem fahrenMenuBtn;
	private static JRadioButtonMenuItem kmMenuBtn;
	private static JRadioButtonMenuItem milesMenuBtn;
	/**
	 * Components needed for "My Custom View" add-on
	 */
	private static JMenu viewMenu;
	private static JCheckBoxMenuItem showTempMenuBtn;
	private static JCheckBoxMenuItem showMinTempMenuBtn;
	private static JCheckBoxMenuItem showMaxTempMenuBtn;
	private static JCheckBoxMenuItem showSunriseMenuBtn;
	private static JCheckBoxMenuItem showSunsetMenuBtn;
	private static JCheckBoxMenuItem showAirPMenuBtn;
	private static JCheckBoxMenuItem showHumidityMenuBtn;
	private static JCheckBoxMenuItem showWindSpdMenuBtn;
	private static JCheckBoxMenuItem showWindDirMenuBtn;
	private static JCheckBoxMenuItem showSkyCondMenuBtn;
	
	
	static char tempUnits;
	static char windUnits;

	public TestPanel(String cityName, String tUnits, String wUnits) {
		
		lblCity = new JLabel("City Name, Country");
		lblSTCity = new JLabel("City Name, Country");
		lblLTCity = new JLabel("City Name, Country");
		lblCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		lblSTCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		lblLTCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		
		if (tUnits.length() > 0) {
			this.tempUnits = tUnits.charAt(0);
		}else{
			this.tempUnits = 'C';
		}
		if (tUnits.length() > 0) {
			this.windUnits = wUnits.charAt(0);
		}else{
			this.windUnits = 'K';
		}
		
		initMenubar();
		setJMenuBar(menubar);
	
		initToolbar();
		getContentPane().add(toolbar, BorderLayout.SOUTH);
		
		backPanel = new JSplitPane();
		getContentPane().add(backPanel, BorderLayout.NORTH);
		
		mainPanel = new JTabbedPane(JTabbedPane.TOP);
		backPanel.setRightComponent(mainPanel);
		
		initMainPanels();
		
		initializeLocal();
		initLocalWeatherPanel();

		initializeShortTerm();
		initShortTermPanel();
		
		initializeLongTerm();
		initLongTermPanel();
		
		menuPanel = new JPanel();
		backPanel.setLeftComponent(menuPanel);
		
		initMenuPanel();
		
		setSize(775,525);
		setTitle("WeatherApp");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* The windowListener saves the user data before the user closes
		 * the application.
		 */
		this.addWindowListener( new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        JFrame frame = (JFrame)e.getSource();
		 
		        int result = JOptionPane.showConfirmDialog(
		            frame,
		            "Are you sure you want to exit the application?",
		            "Exit Application",
		            JOptionPane.YES_NO_OPTION);
		 
		        if (result == JOptionPane.YES_OPTION){
		        	if(txtLocation.getText().length() > 0){
		        		
		        		/* Write the save data here, delimited by underscore characters
		        		 * 
		        		 * Format is as follows:
		        		 * 
		        		 * A[0] Most Recent Location Search
		        		 * A[1] Temperature Units
		        		 * A[2] Speed Units
		        		 */
		        		String saveFile = (txtLocation.getText() + "_" + tempUnits + "_" + windUnits);
		        		Serialize.saveOnExit(saveFile);
		        		System.out.println("Saved: " + Arrays.toString(saveFile.split("_")));
		        	}
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        }
		    }
		});
		
	}

	// PANEL SETUP
	/**
	 * initMenubar sets up the menu bar at the top of the app
	 */
	private static void initMenubar(){
		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		preferencesMenu = new JMenu("Preferences");
		menubar.add(fileMenu);
		menubar.add(preferencesMenu);
		
		JMenuItem exitMenuBtn = new JMenuItem("Exit");
		fileMenu.add(exitMenuBtn);
		refreshMenuBtn = new JMenuItem("Refresh");
		fileMenu.add(refreshMenuBtn);
		
		JMenu tempUnitsMenu = new JMenu("Temperature Units");
		tempUnitMenuBtns = new ButtonGroup();
		celsiusMenuBtn = new JRadioButtonMenuItem("Celsius");
		celsiusMenuBtn.setSelected(true);
		tempUnitMenuBtns.add(celsiusMenuBtn);
		tempUnitsMenu.add(celsiusMenuBtn);
		fahrenMenuBtn = new JRadioButtonMenuItem("Fahrenheit");
		tempUnitMenuBtns.add(fahrenMenuBtn);
		tempUnitsMenu.add(fahrenMenuBtn);
		preferencesMenu.add(tempUnitsMenu);
		
		JMenu windUnitsMenu = new JMenu("Wind Speed Units");
		windUnitMenuBtns = new ButtonGroup();
		kmMenuBtn = new JRadioButtonMenuItem("Kilometres");
		kmMenuBtn.setSelected(true);
		windUnitMenuBtns.add(kmMenuBtn);
		windUnitsMenu.add(kmMenuBtn);
		milesMenuBtn = new JRadioButtonMenuItem("Miles");
		windUnitMenuBtns.add(milesMenuBtn);
		windUnitsMenu.add(milesMenuBtn);
		preferencesMenu.add(windUnitsMenu);
		
		initViewMenu();
	}
	/**
	 * initViewMenu sets up the view menu that will be used by the 
	 * user to customize their local weather view
	 */
	private static void initViewMenu(){
		viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		showTempMenuBtn = new JCheckBoxMenuItem("Temperature");
		showTempMenuBtn.setSelected(true);
		showMinTempMenuBtn = new JCheckBoxMenuItem("Min. Temperature");
		showMinTempMenuBtn.setSelected(true);
		showMaxTempMenuBtn = new JCheckBoxMenuItem("Max. Temperature");
		showMaxTempMenuBtn.setSelected(true);
		showSunriseMenuBtn = new JCheckBoxMenuItem("Sunrise");
		showSunriseMenuBtn.setSelected(true);
		showSunsetMenuBtn = new JCheckBoxMenuItem("Sunset");
		showSunsetMenuBtn.setSelected(true);
		showAirPMenuBtn = new JCheckBoxMenuItem("Air Pressure");
		showAirPMenuBtn.setSelected(true);
		showHumidityMenuBtn = new JCheckBoxMenuItem("Humidity");
		showHumidityMenuBtn.setSelected(true);
		showWindSpdMenuBtn = new JCheckBoxMenuItem("Wind Speed");
		showWindSpdMenuBtn.setSelected(true);
		showWindDirMenuBtn = new JCheckBoxMenuItem("Wind Direction");
		showWindDirMenuBtn.setSelected(true);
		showSkyCondMenuBtn = new JCheckBoxMenuItem("Sky Condition");
		showSkyCondMenuBtn.setSelected(true);
		viewMenu.add(showTempMenuBtn);
		viewMenu.add(showMinTempMenuBtn);
		viewMenu.add(showMaxTempMenuBtn);
		viewMenu.add(showSunriseMenuBtn);
		viewMenu.add(showSunsetMenuBtn);
		viewMenu.add(showAirPMenuBtn);
		viewMenu.add(showHumidityMenuBtn);
		viewMenu.add(showWindSpdMenuBtn);
		viewMenu.add(showWindDirMenuBtn);
		viewMenu.add(showSkyCondMenuBtn);
	}
	/**
	 * initToolbar sets-up the toolbar for the GUI
	 */
	private static void initToolbar(){
		toolbar = new JToolBar();
		btnAddCity = new JButton("Add City");
		btnRemoveCity = new JButton("Remove City");
		btnTempUnits = new JButton("C/F");
		btnWindUnits = new JButton("Miles/KM");
		btnRefresh = new JButton("Refresh");
		lblRefreshTime = new JLabel("Last refreshed at:                   ");
		toolbar.add(btnAddCity);
		toolbar.add(btnRemoveCity);
		Component horizStrut = Box.createHorizontalStrut(20);
		toolbar.add(horizStrut);
		toolbar.add(lblRefreshTime);
		Component horizStrut2 = Box.createHorizontalStrut(60);
		toolbar.add(horizStrut2);
		toolbar.add(btnTempUnits);
		toolbar.add(btnWindUnits);
		toolbar.add(btnRefresh);
	}
	
	private static void initMainPanels(){
		GridBagLayout gbl= new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		pnlLocalWeather = new JPanel();
		mainPanel.addTab("Current", null, pnlLocalWeather, null);
		pnlLocalWeather.setLayout(gbl);
		
		pnlShortTerm = new JPanel();
		mainPanel.addTab("Short-Term", null, pnlShortTerm, null);
		pnlShortTerm.setLayout(gbl);
		
		pnlLongTerm = new JPanel();
		mainPanel.addTab("Long-Term", null, pnlLongTerm, null);
		pnlLongTerm.setLayout(gbl);
	}
	/**
	 * initLocalWeatherPanel sets up the panel that will display
	 * the local weather forecast data
	 */
	private static void initLocalWeatherPanel(){
		JLabel minTempTitle = new JLabel("Expected Min.:");
		JLabel maxTempTitle = new JLabel("Expected Max.:");
		JLabel sunrTitle = new JLabel("Sunrise: ");
		JLabel sunsTitle = new JLabel("Sunset: ");
		JLabel airTitle = new JLabel("Air Pressure: ");
		JLabel humidTitle = new JLabel("Humidity: ");
		JLabel windSpdTitle = new JLabel("Wind Speed: ");
		JLabel windDirTitle = new JLabel("Wind Direction: ");
		
		insertStrut("Local", 'V', 20, 0, 0, 5, 5, 1, 0);
		insertStrut("Local", 'H', 20, 0, 0, 5, 5, 0, 1);
		insertJLabelIntoGrid("Local", lblCity, 6, 0, 0, 5, 5, 1, 1, true);
		insertJLabelIntoGrid("Local", lblLocalSkyIcon, 0, 0, 0, 5, 5, 1, 3, false);
		insertJLabelIntoGrid("Local", lblLocalTemperature, 0, 0, 0, 5, 5, 3, 3, false);
		lblLocalTemperature.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("Local", lblLocalSkyCondition, 3, 0, 0, 5, 5, 1, 4, true);
		insertStrut("Local", 'V', 20, 0, 0, 5, 5, 1, 5);
		insertJLabelIntoGrid("Local", minTempTitle, 0, 0, 0, 5, 5, 1, 6, true);
		insertStrut("Local", 'H', 20, 0, 0, 5, 5, 2, 6);
		insertJLabelIntoGrid("Local", lblLocalMinTemp, 0, 0, 0, 5, 5, 3, 6, true);
		insertStrut("Local", 'H', 20, 0, 0, 5, 5, 4, 6);
		insertStrut("Local", 'H', 20, 0, 0, 5, 5, 5, 6);
		insertJLabelIntoGrid("Local", airTitle, 0, 0, 0, 5, 5, 6, 6, true);
		insertStrut("Local", 'H', 20, 0, 0, 5, 5, 7, 6);
		insertJLabelIntoGrid("Local", lblLocalAirPressure, 0, 0, 0, 5, 5, 8, 6, true);
		insertJLabelIntoGrid("Local", maxTempTitle, 0, 0, 0, 5, 5, 1, 7, true);
		insertJLabelIntoGrid("Local", lblLocalMaxTemp, 0, 0, 0, 5, 5, 3, 7, true);
		insertJLabelIntoGrid("Local", humidTitle, 0, 0, 0, 5, 5, 6, 7, true);
		insertJLabelIntoGrid("Local", lblLocalHumidity, 0, 0, 0, 5, 0, 8, 7, true);
		insertJLabelIntoGrid("Local", sunrTitle, 0, 0, 0, 5, 5, 1, 8, true);
		insertJLabelIntoGrid("Local", lblLocalSunrise, 0, 0, 0, 5, 5, 3, 8, true);
		insertJLabelIntoGrid("Local", windSpdTitle, 0, 0, 0, 5, 5, 6, 8, true);
		insertJLabelIntoGrid("Local", lblLocalWindSpeed, 0, 0, 0, 5, 0, 8, 8, true);
		insertJLabelIntoGrid("Local", sunsTitle, 0, 0, 0, 0, 5, 1, 9, true);
		insertJLabelIntoGrid("Local", lblLocalSunset, 0, 0, 0, 0, 5, 3, 9, true);
		insertJLabelIntoGrid("Local", windDirTitle, 0, 0, 0, 0, 5, 6, 9, true);
		insertJLabelIntoGrid("Local", lblLocalWindDirection, 0, 0, 0, 5, 5, 8, 9, true);
	}
		
	private static void initShortTermPanel(){
		insertStrut("ST", 'V', 20, 0, 0, 5, 5, 2, 0);
		insertJLabelIntoGrid("ST", lblSTCity, 6, 0, 0, 5, 5, 2, 1, true);
		insertStrut("ST", 'H', 20, 0, 0, 5, 5, 0, 2);
		insertStrut("ST", 'H', 20, 0, 0, 5, 5, 4, 3);
		insertStrut("ST", 'H', 20, 0, 0, 5, 5, 5, 3);
		insertStrut("ST", 'H', 20, 0, 0, 5, 5, 6, 3);
		
		insertJLabelIntoGrid("ST", lbl1stHr, 0, 0, 0, 5, 5, 2, 2, true);
		insertJLabelIntoGrid("ST", lbl1stHrSkyIcon, 0, 0, 0, 5, 5, 2, 3, false);
		insertJLabelIntoGrid("ST", lbl1stHrSkyCondition, 2, 0, 0, 5, 5, 2, 4, true);
		lbl1stHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl1stHrTemp, 0, 0, 0, 5, 5, 3, 3, false);
		
		insertJLabelIntoGrid("ST", lbl2ndHr, 0, 0, 0, 5, 5, 2, 5, true);
		insertJLabelIntoGrid("ST", lbl2ndHrSkyIcon, 0, 0, 0, 5, 5, 2, 6, false);
		insertJLabelIntoGrid("ST", lbl2ndHrSkyCondition, 2, 0, 0, 5, 5, 2, 7, true);
		lbl2ndHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl2ndHrTemp, 0, 0, 0, 5, 5, 3, 6, false);
		
		insertJLabelIntoGrid("ST", lbl3rdHr, 0, 0, 0, 5, 5, 2, 8, true);
		insertJLabelIntoGrid("ST", lbl3rdHrSkyIcon, 0, 0, 0, 5, 5, 2, 9, false);
		insertJLabelIntoGrid("ST", lbl3rdHrSkyCondition, 2, 0, 0, 5, 5, 2, 10, true);
		lbl3rdHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl3rdHrTemp, 0, 0, 0, 5, 5, 3, 9, false);

		insertJLabelIntoGrid("ST", lbl4thHr, 0, 0, 0, 5, 5, 2, 11, true);
		insertJLabelIntoGrid("ST", lbl4thHrSkyIcon, 0, 0, 0, 0, 5, 2, 12, false);
		insertJLabelIntoGrid("ST", lbl4thHrSkyCondition, 2, 0, 0, 5, 5, 2, 13, true);
		lbl4thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl4thHrTemp, 0, 0, 0, 5, 5, 3, 12, false);
		
		insertJLabelIntoGrid("ST", lbl5thHr, 0, 0, 0, 5, 5, 7, 2, true);
		insertJLabelIntoGrid("ST", lbl5thHrSkyIcon, 0, 0, 0, 5, 5, 7, 3, false);
		insertJLabelIntoGrid("ST", lbl5thHrSkyCondition, 2, 0, 0, 5, 5, 7, 4, true);
		lbl5thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl5thHrTemp, 0, 0, 0, 5, 5, 8, 3, false);
		
		insertJLabelIntoGrid("ST", lbl6thHr, 0, 0, 0, 5, 5, 7, 5, true);
		insertJLabelIntoGrid("ST", lbl6thHrSkyIcon, 0, 0, 0, 5, 5, 7, 6, false);
		insertJLabelIntoGrid("ST", lbl6thHrSkyCondition, 2, 0, 0, 5, 5, 7, 7, true);
		lbl6thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl6thHrTemp, 0, 0, 0, 5, 0, 8, 6, false);

		insertJLabelIntoGrid("ST", lbl7thHr, 0, 0, 0, 5, 5, 7, 8, true);
		insertJLabelIntoGrid("ST", lbl7thHrSkyIcon, 0, 0, 0, 5, 5, 7, 9, false);
		insertJLabelIntoGrid("ST", lbl7thHrSkyCondition, 2, 0, 0, 5, 5, 7, 10, true);
		lbl7thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl7thHrTemp, 0, 0, 0, 5, 5, 8, 9, false);
		
		insertJLabelIntoGrid("ST", lbl8thHr, 0, 0, 0, 5, 5, 7, 11, true);
		insertJLabelIntoGrid("ST", lbl8thHrSkyIcon, 0, 0, 0, 5, 5, 7, 12, false);
		insertJLabelIntoGrid("ST", lbl8thHrSkyCondition, 2, 0, 0, 5, 5, 7, 13, true);
		lbl8thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("ST", lbl8thHrTemp, 0, 0, 0, 5, 5, 8, 12, false);

	}
	
	private static void initLongTermPanel(){
		insertJLabelIntoGrid("LT", lblLTCity, 6, 0, 0, 5, 5, 1, 1, true);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 0);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 2);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 4);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1 ,8);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 0 ,1);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 2 ,4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 4 ,4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 6 ,4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 8 ,4);
		
		insertJLabelIntoGrid("LT", lbl1stDay, 0, 0, 0, 5, 5, 1, 3, false);
		insertJLabelIntoGrid("LT", lbl1stDaySkyIcon, 0, 0, 0, 5, 5, 1, 5, false);
		lbl1stDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("LT", lbl1stDayTemp, 0, 0, 0, 5, 5, 1, 6, false);
		insertJLabelIntoGrid("LT", lbl1stDaySkyCondition, 0, 0, 0, 5, 5, 1, 7, false);
		insertJLabelIntoGrid("LT", lbl1stDayMinTemp, 0, 0, 0, 5, 5, 1, 9, false);
		insertJLabelIntoGrid("LT", lbl1stDayMaxTemp, 0, 0, 0, 5, 5, 1, 10, false);
		
		insertJLabelIntoGrid("LT", lbl2ndDay, 0, 0, 0, 5, 5, 3, 3, false);
		insertJLabelIntoGrid("LT", lbl2ndDaySkyIcon, 0, 0, 0, 5, 5, 3, 5, false);
		lbl2ndDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("LT", lbl2ndDayTemp, 0, 0, 0, 5, 5, 3, 6, false);
		insertJLabelIntoGrid("LT", lbl2ndDaySkyCondition, 0, 0, 0, 5, 5, 3, 7, false);
		insertJLabelIntoGrid("LT", lbl2ndDayMinTemp, 0, 0, 0, 5, 5, 3, 9, false);
		insertJLabelIntoGrid("LT", lbl2ndDayMaxTemp, 0, 0, 0, 5, 5, 3, 10, false);
		
		insertJLabelIntoGrid("LT", lbl3rdDay, 0, 0, 0, 5, 5, 5, 3, false);
		insertJLabelIntoGrid("LT", lbl3rdDaySkyIcon, 0, 0, 0, 5, 5, 5, 5, false);
		lbl3rdDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("LT", lbl3rdDayTemp, 0, 0, 0, 5, 5, 5, 6, false);
		insertJLabelIntoGrid("LT", lbl3rdDaySkyCondition, 0, 0, 0, 5, 5, 5, 7, false);
		insertJLabelIntoGrid("LT", lbl3rdDayMinTemp, 0, 0, 0, 5, 5, 5, 9, false);
		insertJLabelIntoGrid("LT", lbl3rdDayMaxTemp, 0, 0, 0, 5, 5, 5, 10, false);
		
		insertJLabelIntoGrid("LT", lbl4thDay, 0, 0, 0, 5, 5, 7, 3, false);
		insertJLabelIntoGrid("LT", lbl4thDaySkyIcon, 0, 0, 0, 5, 5, 7, 5, false);
		lbl4thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("LT", lbl4thDayTemp, 0, 0, 0, 5, 5, 7, 6, false);
		insertJLabelIntoGrid("LT", lbl4thDaySkyCondition, 0, 0, 0, 5, 5, 7, 7, false);
		insertJLabelIntoGrid("LT", lbl4thDayMinTemp, 0, 0, 0, 5, 5, 7, 9, false);
		insertJLabelIntoGrid("LT", lbl4thDayMaxTemp, 0, 0, 0, 5, 5, 7, 10, false);
		
		insertJLabelIntoGrid("LT", lbl5thDay, 0, 0, 0, 5, 5, 9, 3, false);
		insertJLabelIntoGrid("LT", lbl5thDaySkyIcon, 0, 0, 0, 5, 5, 9, 5, false);
		lbl5thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		insertJLabelIntoGrid("LT", lbl5thDayTemp, 0, 0, 0, 5, 5, 9, 6, false);
		insertJLabelIntoGrid("LT", lbl5thDaySkyCondition, 0, 0, 0, 5, 5, 9, 7, false);
		insertJLabelIntoGrid("LT", lbl5thDayMinTemp, 0, 0, 0, 5, 5, 9, 9, false);
		insertJLabelIntoGrid("LT", lbl5thDayMaxTemp, 0, 0, 0, 5, 5, 9, 10, false);
		
	}
	//////////////////////////////////////////////////////////////////
	//HELPER METHODS//////////////
	
	private static void initMenuPanel(){
		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(menuPanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_panel);
		
		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				UpdateLocal();
			}});
		
	}
	/**
	 * UpdateLocal is a helper class to MainPanel
	 * It updates the labels on the screen when the
	 * user requests a refresh, or when they search
	 * for a new city location.
	 */
	
	
	private static void UpdateLocal() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lastRefresh = dateFormat.format(cal.getTime());
		
		City myCity = new City(txtLocation.getText(),tempUnits, windUnits);

		if (myCity.validate != true) {
			lblCity.setText("City Not Found");

		} else {
			lblCity.setText(myCity.currentWeather.fullCityName);
			lblLocalSkyIcon.setIcon(myCity.currentWeather.skyIcon);
			lblLocalSkyIcon.setText("");
			lblLocalTemperature.setText(myCity.currentWeather.temperature + " " + tempUnits);
			lblLocalMinTemp.setText(myCity.currentWeather.minTemp + " " + tempUnits);
			lblLocalMaxTemp.setText(myCity.currentWeather.maxTemp + " " + tempUnits);
			lblLocalSunrise.setText(myCity.currentWeather.sunrise);
			lblLocalSunset.setText(myCity.currentWeather.sunset);
			lblLocalWindSpeed.setText(myCity.currentWeather.windSpeed + " " + windUnits + "PH");
			lblLocalWindDirection.setText(myCity.currentWeather.windDirection);
			lblLocalAirPressure.setText(myCity.currentWeather.airPressure);
			lblLocalHumidity.setText(myCity.currentWeather.humidity);
			lblLocalSkyCondition.setText(myCity.currentWeather.skyCondition);
			lblRefreshTime.setText("Last Refreshed:   "
					+ lastRefresh);
		}
		
	}

	
	
	
	
	
	private static void insertJLabelIntoGrid(String panel, JLabel label, int gridwidth, 
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
		if(panel.equals("Local"))
			pnlLocalWeather.add(label, gbc);	
		else if(panel.equals("ST"))
			pnlShortTerm.add(label, gbc);
		else if(panel.equals("LT"))
			pnlLongTerm.add(label,gbc);
	}
	
	private static void insertStrut(String panel, char strutType, int strutSize,
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
		if(panel.equals("Local"))
			pnlLocalWeather.add(strut, gbc);	
		else if(panel.equals("ST"))
			pnlShortTerm.add(strut, gbc);
		else if(panel.equals("LT"))
			pnlLongTerm.add(strut, gbc);
	}
	/**
	 * initializeDaily is a helper class to MainPanel
	 * When the MainPanel constructor is first used,
	 * initializeDaily sets up the "daily" list with
	 * the relevant labels. This allows us to easily
	 * update all of the labels at once by iterating
	 * over the "daily" list object.
	 */
	private static void initializeLocal() {
		local = new ArrayList<JLabel>();
		local.add(lblLocalTemperature = new JLabel("## C"));
		local.add(lblLocalMinTemp = new JLabel("## C"));
		local.add(lblLocalMaxTemp = new JLabel("## C"));
		local.add(lblLocalSunrise = new JLabel("MM/DD/YY hh:mm a"));
		local.add(lblLocalSunset = new JLabel("MM/DD/YY hh:mm a"));
		local.add(lblLocalWindSpeed = new JLabel("##.# km/h"));
		local.add(lblLocalWindDirection = new JLabel("### X"));
		local.add(lblLocalAirPressure = new JLabel("###.# hPa"));
		local.add(lblLocalHumidity = new JLabel("##%"));
		local.add(lblLocalSkyCondition = new JLabel("--sky condition--"));
		local.add(lblLocalSkyIcon = new JLabel("-- SKY ICON --"));
	}
	
	/**
	 * initializeShortTerm adds all labels needed for the short-term forecast view
	 * to the ShortTerm JLabel ArrayList
	 */
	private static void initializeShortTerm(){
		shortTerm = new ArrayList<JLabel>();
		shortTerm.add(lbl1stHr = new JLabel("First Hour"));
		shortTerm.add(lbl2ndHr = new JLabel("Second Hour"));
		shortTerm.add(lbl3rdHr = new JLabel("Third Hour"));
		shortTerm.add(lbl4thHr = new JLabel("Fourth Hour"));
		shortTerm.add(lbl5thHr = new JLabel("Fifth Hour"));
		shortTerm.add(lbl6thHr = new JLabel("Sixth Hour"));
		shortTerm.add(lbl7thHr = new JLabel("Seventh Hour"));
		shortTerm.add(lbl8thHr = new JLabel("Eighth Hour"));
		shortTerm.add(lbl1stHrTemp = new JLabel("## C"));
		shortTerm.add(lbl2ndHrTemp = new JLabel("## C"));
		shortTerm.add(lbl3rdHrTemp = new JLabel("## C"));
		shortTerm.add(lbl4thHrTemp = new JLabel("## C"));
		shortTerm.add(lbl5thHrTemp = new JLabel("## C"));
		shortTerm.add(lbl6thHrTemp = new JLabel("## C"));
		shortTerm.add(lbl7thHrTemp = new JLabel("## C"));
		shortTerm.add(lbl8thHrTemp = new JLabel("## C"));
		shortTerm.add(lbl1stHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl2ndHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl3rdHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl4thHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl5thHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl6thHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl7thHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl8thHrSkyIcon = new JLabel("SKY ICON"));
		shortTerm.add(lbl1stHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl2ndHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl3rdHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl4thHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl5thHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl6thHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl7thHrSkyCondition = new JLabel("Sky Condition"));
		shortTerm.add(lbl8thHrSkyCondition = new JLabel("Sky Condition"));
	}
	
	/**
	 * initializeShortTerm adds all labels needed for the short-term forecast view
	 * to the ShortTerm JLabel ArrayList
	 */
	private static void initializeLongTerm(){
		longTerm = new ArrayList<JLabel>();
		longTerm.add(lbl1stDay = new JLabel("First Day"));
		longTerm.add(lbl2ndDay = new JLabel("Second Day"));
		longTerm.add(lbl3rdDay = new JLabel("Third Day"));
		longTerm.add(lbl4thDay = new JLabel("Fourth Day"));
		longTerm.add(lbl5thDay = new JLabel("Fifth Day"));
		longTerm.add(lbl1stDayTemp = new JLabel("## C"));
		longTerm.add(lbl2ndDayTemp = new JLabel("## C"));
		longTerm.add(lbl3rdDayTemp = new JLabel("## C"));
		longTerm.add(lbl4thDayTemp = new JLabel("## C"));
		longTerm.add(lbl5thDayTemp = new JLabel("## C"));
		longTerm.add(lbl1stDayMinTemp = new JLabel("Min: ## C"));
		longTerm.add(lbl2ndDayMinTemp = new JLabel("Min: ## C"));
		longTerm.add(lbl3rdDayMinTemp = new JLabel("Min: ## C"));
		longTerm.add(lbl4thDayMinTemp = new JLabel("Min: ## C"));
		longTerm.add(lbl5thDayMinTemp = new JLabel("Min: ## C"));
		longTerm.add(lbl1stDayMaxTemp = new JLabel("Max: ## C"));
		longTerm.add(lbl2ndDayMaxTemp = new JLabel("Max: ## C"));
		longTerm.add(lbl3rdDayMaxTemp = new JLabel("Max: ## C"));
		longTerm.add(lbl4thDayMaxTemp = new JLabel("Max: ## C"));
		longTerm.add(lbl5thDayMaxTemp = new JLabel("Max: ## C"));
		longTerm.add(lbl1stDaySkyIcon = new JLabel("SKY ICON"));
		longTerm.add(lbl2ndDaySkyIcon = new JLabel("SKY ICON"));
		longTerm.add(lbl3rdDaySkyIcon = new JLabel("SKY ICON"));
		longTerm.add(lbl4thDaySkyIcon = new JLabel("SKY ICON"));
		longTerm.add(lbl5thDaySkyIcon = new JLabel("SKY ICON"));
		longTerm.add(lbl1stDaySkyCondition = new JLabel("sky condition"));
		longTerm.add(lbl2ndDaySkyCondition = new JLabel("sky condition"));
		longTerm.add(lbl3rdDaySkyCondition = new JLabel("sky condion"));
		longTerm.add(lbl4thDaySkyCondition = new JLabel("sky condition"));
		longTerm.add(lbl5thDaySkyCondition = new JLabel("sky condition"));
	}
}	

