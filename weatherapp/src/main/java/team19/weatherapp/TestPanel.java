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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
import java.util.List;

public class TestPanel extends JFrame{
	
	static JTextField txtLocation;
	private static CityButtonPanel pnlCityButtons;
	
	private static JSplitPane backPanel;
	private static JPanel menuPanel;
	private static JTabbedPane mainPanel;
	
	/**
	 * JLabels needed for the local weather view
	 */
	
	private static JLabel minTempTitle;
	private static JLabel maxTempTitle;
	private static JLabel sunrTitle;
	private static JLabel sunsTitle;
	private static JLabel airTitle;
	private static JLabel humidTitle;
	private static JLabel windSpdTitle;
	private static JLabel windDirTitle;
	
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
	private static ArrayList<JLabel> shortTermHours;
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
	private static ArrayList<JLabel> longTermHours;
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
	
	
	private static City city;
	
	static char tempUnits;
	static char windUnits;

	public TestPanel(String[] inputStr) {

			showTempMenuBtn = new JCheckBoxMenuItem("Temperature");
			showMinTempMenuBtn = new JCheckBoxMenuItem("Min. Temperature");
			showMaxTempMenuBtn = new JCheckBoxMenuItem("Max. Temperature");
			showSunriseMenuBtn = new JCheckBoxMenuItem("Sunrise");
			showSunsetMenuBtn = new JCheckBoxMenuItem("Sunset");
			showAirPMenuBtn = new JCheckBoxMenuItem("Air Pressure");
			showHumidityMenuBtn = new JCheckBoxMenuItem("Humidity");
			showWindSpdMenuBtn = new JCheckBoxMenuItem("Wind Speed");
			showWindDirMenuBtn = new JCheckBoxMenuItem("Wind Direction");
			showSkyCondMenuBtn = new JCheckBoxMenuItem("Sky Condition");
		 
			pnlCityButtons = new CityButtonPanel();

			String cityName = inputStr[0];
			String tUnits = inputStr[1];
			String wUnits = inputStr[2];
			
			
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


		
		
		
		
		showTempMenuBtn.setSelected(Boolean.parseBoolean(inputStr[3]));
		showMinTempMenuBtn.setSelected(Boolean.parseBoolean(inputStr[4]));
		showMaxTempMenuBtn.setSelected(Boolean.parseBoolean(inputStr[5]));
		showSunriseMenuBtn.setSelected(Boolean.parseBoolean(inputStr[6]));
		showSunsetMenuBtn.setSelected(Boolean.parseBoolean(inputStr[7]));
		showAirPMenuBtn.setSelected(Boolean.parseBoolean(inputStr[8]));
		showHumidityMenuBtn.setSelected(Boolean.parseBoolean(inputStr[9]));
		showWindSpdMenuBtn.setSelected(Boolean.parseBoolean(inputStr[10]));
		showWindDirMenuBtn.setSelected(Boolean.parseBoolean(inputStr[11]));
		showSkyCondMenuBtn.setSelected(Boolean.parseBoolean(inputStr[12]));
		for(int i=0;i < Integer.parseInt(inputStr[13]);i++){
			CityButton newButton = new CityButton(inputStr[14+i]);
			pnlCityButtons.addButton(newButton); 
		}
		
		        boolean selected = showTempMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalTemperature.setVisible(true);
		        }else{
		        	lblLocalTemperature.setVisible(false);
		        }
		        selected = showMinTempMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalMinTemp.setVisible(true);
		        	minTempTitle.setVisible(true);
		        }else{
		        	lblLocalMinTemp.setVisible(false);
		        	minTempTitle.setVisible(false);
		        }		
		        selected = showMaxTempMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalMaxTemp.setVisible(true);
		        	maxTempTitle.setVisible(true);
		        }else{
		        	lblLocalMaxTemp.setVisible(false);
		        	maxTempTitle.setVisible(false);
		        }		
		        selected = showSunriseMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalSunrise.setVisible(true);
		        	sunrTitle.setVisible(true);
		        }else{
		        	lblLocalSunrise.setVisible(false);
		        	sunrTitle.setVisible(false);
		        }
		        selected = showSunsetMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalSunset.setVisible(true);
		        	sunsTitle.setVisible(true);
		        }else{
		        	lblLocalSunset.setVisible(false);
		        	sunsTitle.setVisible(false);
		        }
		        selected = showAirPMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalAirPressure.setVisible(true);
		        	airTitle.setVisible(true);
		        }else{
		        	lblLocalAirPressure.setVisible(false);
		        	airTitle.setVisible(false);
		        }
		        selected = showHumidityMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalHumidity.setVisible(true);
		        	humidTitle.setVisible(true);
		        }else{
		        	lblLocalHumidity.setVisible(false);
		        	humidTitle.setVisible(false);
		        }
		        selected = showWindSpdMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalWindSpeed.setVisible(true);
		        	windSpdTitle.setVisible(true);
		        }else{
		        	lblLocalWindSpeed.setVisible(false);
		        	windSpdTitle.setVisible(false);
		        }
		        selected = showWindDirMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalWindDirection.setVisible(true);
		        	windDirTitle.setVisible(true);
		        }else{
		        	lblLocalWindDirection.setVisible(false);
		        	windDirTitle.setVisible(false);
		        }
		        selected = showSkyCondMenuBtn.getModel().isSelected();
		        if(selected){
		        	lblLocalSkyCondition.setVisible(true);
		        	lblLocalSkyIcon.setVisible(true);        	
		        }else{
		        	lblLocalSkyCondition.setVisible(false);
		        	lblLocalSkyIcon.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
		
		
		
		
		
		
		
		
		
		
		
		
		

		initializeShortTerm();
		initShortTermPanel();
		
		initializeLongTerm();
		initLongTermPanel();
		
		menuPanel = new JPanel();
		backPanel.setLeftComponent(menuPanel);
		
		initMenuPanel();
		
		setSize(775,675);
		setTitle("WeatherApp");
        setLocationRelativeTo(null);
        
        /*
         * This sets current information from previous save
         */
		if (cityName.length() > 0) {
			txtLocation.setText(cityName);
			city = new City(cityName, tempUnits, windUnits);
			UpdateLocal();
			UpdateShortTerm();
			UpdateLongTerm();
			txtLocation.setText("");
		}
		
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
		        		
		        		/* Write the save data here, delimited by underscore characters
		        		 * 
		        		 * Format is as follows:
		        		 * 
		        		 * A[0] Most Recent Location Search
		        		 * A[1] Temperature Units
		        		 * A[2] Speed Units
		        		 */
		        		String saveFile = (lblCity.getText() + "_" + tempUnits + "_" + windUnits + "_" + showTempMenuBtn.isSelected() + "_" + showMinTempMenuBtn.isSelected() + "_" + showMaxTempMenuBtn.isSelected() + "_" + showSunriseMenuBtn.isSelected() + "_" + showSunsetMenuBtn.isSelected() + "_" + showAirPMenuBtn.isSelected() + "_" + showHumidityMenuBtn.isSelected() + "_" + showWindSpdMenuBtn.isSelected() + "_" + showWindDirMenuBtn.isSelected() + "_" + showSkyCondMenuBtn.isSelected());
		        		saveFile += pnlCityButtons.buttonList();
		        		Serialize.saveOnExit(saveFile);
		        		System.out.println("Saved: " + Arrays.toString(saveFile.split("_")));
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
		
		refreshMenuBtn = new JMenuItem("Refresh");
		fileMenu.add(refreshMenuBtn);
		JMenuItem exitMenuBtn = new JMenuItem("Exit");
		fileMenu.add(exitMenuBtn);
		
		refreshMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateScreen();
			}});
		
		exitMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}});
		
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
		
		showTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalTemperature.setVisible(true);
		        }else{
		        	lblLocalTemperature.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showMinTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalMinTemp.setVisible(true);
		        	minTempTitle.setVisible(true);
		        }else{
		        	lblLocalMinTemp.setVisible(false);
		        	minTempTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showMaxTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalMaxTemp.setVisible(true);
		        	maxTempTitle.setVisible(true);
		        }else{
		        	lblLocalMaxTemp.setVisible(false);
		        	maxTempTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showSunriseMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalSunrise.setVisible(true);
		        	sunrTitle.setVisible(true);
		        }else{
		        	lblLocalSunrise.setVisible(false);
		        	sunrTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showSunsetMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalSunset.setVisible(true);
		        	sunsTitle.setVisible(true);
		        }else{
		        	lblLocalSunset.setVisible(false);
		        	sunsTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showAirPMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalAirPressure.setVisible(true);
		        	airTitle.setVisible(true);
		        }else{
		        	lblLocalAirPressure.setVisible(false);
		        	airTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showHumidityMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalHumidity.setVisible(true);
		        	humidTitle.setVisible(true);
		        }else{
		        	lblLocalHumidity.setVisible(false);
		        	humidTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showWindSpdMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalWindSpeed.setVisible(true);
		        	windSpdTitle.setVisible(true);
		        }else{
		        	lblLocalWindSpeed.setVisible(false);
		        	windSpdTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showWindDirMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalWindDirection.setVisible(true);
		        	windDirTitle.setVisible(true);
		        }else{
		        	lblLocalWindDirection.setVisible(false);
		        	windDirTitle.setVisible(false);
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
		showSkyCondMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        AbstractButton abstractButton = (AbstractButton) event.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	lblLocalSkyCondition.setVisible(true);
		        	lblLocalSkyIcon.setVisible(true);
		        	
		        }else{
		        	lblLocalSkyCondition.setVisible(false);
		        	lblLocalSkyIcon.setVisible(false);
		        	
		        }
		        menubar.revalidate();
		        menubar.repaint();
			}});
		
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
		
		btnTempUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tempUnits=='C'){
					tempUnits = 'F';
				}else{
					tempUnits = 'C';
				}
				updateScreen();
			}});
		
		btnWindUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(windUnits=='M'){
					windUnits = 'K';
				}else{
					windUnits = 'M';
				}
				updateScreen();
			}});
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateScreen();
			}});
		
		btnAddCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton newButton = new CityButton(lblCity.getText());
				pnlCityButtons.addButton(newButton); 
			}});
		
		btnRemoveCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton oldButton = new CityButton(lblCity.getText());
				pnlCityButtons.removeButton(oldButton); 
			}});
	}
	
	private static void initMainPanels(){
		GridBagLayout gbl= new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
		
		pnlLocalWeather = new JPanel();
		mainPanel.addTab("Current", null, pnlLocalWeather, null);
		pnlLocalWeather.setLayout(gbl);
		
		pnlShortTerm = new JPanel();
		mainPanel.addTab("Short-Term", null, pnlShortTerm, null);
		pnlShortTerm.setLayout(gbl);
		
		pnlLongTerm = new JPanel();
		mainPanel.addTab("Long-Term", null, pnlLongTerm, null);
		pnlLongTerm.setLayout(gbl);
		
		mainPanel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				menubar.revalidate();
				menubar.repaint();
			}
		    });
	}
	/**
	 * initLocalWeatherPanel sets up the panel that will display
	 * the local weather forecast data
	 */
	private static void initLocalWeatherPanel(){
		minTempTitle = new JLabel("Expected Min.:");
		maxTempTitle = new JLabel("Expected Max.:");
		sunrTitle = new JLabel("Sunrise: ");
		sunsTitle = new JLabel("Sunset: ");
		airTitle = new JLabel("Air Pressure: ");
		humidTitle = new JLabel("Humidity: ");
		windSpdTitle = new JLabel("Wind Speed: ");
		windDirTitle = new JLabel("Wind Direction: ");
		
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
		insertJLabelIntoGrid("LT", lblLTCity, 10, 0, 0, 5, 5, 1, 1, true);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 0);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 2);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 4);
		insertStrut("LT", 'V', 20, 0, 0, 5, 5, 1, 8);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 0, 1);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 2, 4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 4, 4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 6, 4);
		insertStrut("LT", 'H', 20, 0 ,0 ,5, 5, 8, 4);
		
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
						.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlCityButtons, 150, 150, 150))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(pnlCityButtons, 500, 500, 500)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_panel);
		
		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateScreen();
			}});
		
	}
	/**
	 * UpdateLocal is a helper class to MainPanel
	 * It updates the labels on the screen when the
	 * user requests a refresh, or when they search
	 * for a new city location.
	 */
	
	private static void updateScreen(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lastRefresh = dateFormat.format(cal.getTime());
		city = new City(txtLocation.getText(), tempUnits, windUnits);
		UpdateLocal();
		UpdateShortTerm();
		UpdateLongTerm();
	}
	
	public static void updateScreenWithCity(String c){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lastRefresh = dateFormat.format(cal.getTime());
		city = new City(c, tempUnits, windUnits);
		UpdateLocal();
		UpdateShortTerm();
		UpdateLongTerm();
	}
	
	private static void UpdateLocal() {
		
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
			lblRefreshTime.setText("Last Refreshed:   " + lastRefresh);
		}
		
	}
	
	private static void UpdateShortTerm() {


		if (city.validate != true) {
			lblCity.setText("City Not Found");

		} else {
			lblSTCity.setText(city.shortTermForecast.fullCityName);
			lbl1stHr.setText(city.shortTermForecast.timeList.get(0));
			lbl2ndHr.setText(city.shortTermForecast.timeList.get(1));
			lbl3rdHr.setText(city.shortTermForecast.timeList.get(2));
			lbl4thHr.setText(city.shortTermForecast.timeList.get(3));
			lbl5thHr.setText(city.shortTermForecast.timeList.get(4));
			lbl6thHr.setText(city.shortTermForecast.timeList.get(5));
			lbl7thHr.setText(city.shortTermForecast.timeList.get(6));
			lbl8thHr.setText(city.shortTermForecast.timeList.get(7));
			lbl1stHrTemp.setText(city.shortTermForecast.temperatureList.get(0)+tempUnits);
			lbl2ndHrTemp.setText(city.shortTermForecast.temperatureList.get(1)+tempUnits);
			lbl3rdHrTemp.setText(city.shortTermForecast.temperatureList.get(2)+tempUnits);
			lbl4thHrTemp.setText(city.shortTermForecast.temperatureList.get(3)+tempUnits);
			lbl5thHrTemp.setText(city.shortTermForecast.temperatureList.get(4)+tempUnits);
			lbl6thHrTemp.setText(city.shortTermForecast.temperatureList.get(5)+tempUnits);
			lbl7thHrTemp.setText(city.shortTermForecast.temperatureList.get(6)+tempUnits);
			lbl8thHrTemp.setText(city.shortTermForecast.temperatureList.get(7)+tempUnits);
			lbl1stHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(0));
			lbl2ndHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(1));
			lbl3rdHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(2));
			lbl4thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(3));
			lbl5thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(4));
			lbl6thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(5));
			lbl7thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(6));
			lbl8thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(7));
			lbl1stHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(0));
			lbl2ndHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(1));
			lbl3rdHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(2));
			lbl4thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(3));
			lbl5thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(4));
			lbl6thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(5));
			lbl7thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(6));
			lbl8thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(7));
		}
		
	}

	
	private static void UpdateLongTerm() {

		if (city.validate != true) {
			lblCity.setText("City Not Found");

		} else {
			lblLTCity.setText(city.shortTermForecast.fullCityName);
			lbl1stDay.setText(city.longTermForecast.dateList.get(0));
			lbl2ndDay.setText(city.longTermForecast.dateList.get(1));
			lbl3rdDay.setText(city.longTermForecast.dateList.get(2));
			lbl4thDay.setText(city.longTermForecast.dateList.get(3));
			lbl5thDay.setText(city.longTermForecast.dateList.get(4));
			lbl1stDayTemp.setText(city.longTermForecast.temperatureList.get(0)+tempUnits);
			lbl2ndDayTemp.setText(city.longTermForecast.temperatureList.get(1)+tempUnits);
			lbl3rdDayTemp.setText(city.longTermForecast.temperatureList.get(2)+tempUnits);
			lbl4thDayTemp.setText(city.longTermForecast.temperatureList.get(3)+tempUnits);
			lbl5thDayTemp.setText(city.longTermForecast.temperatureList.get(4)+tempUnits);
			lbl1stDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(0)+tempUnits);
			lbl2ndDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(1)+tempUnits);
			lbl3rdDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(2)+tempUnits);
			lbl4thDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(3)+tempUnits);
			lbl5thDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(4)+tempUnits);
			lbl1stDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(0)+tempUnits);
			lbl2ndDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(1)+tempUnits);
			lbl3rdDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(2)+tempUnits);
			lbl4thDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(3)+tempUnits);
			lbl5thDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(4)+tempUnits);
			lbl1stDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(0));
			lbl2ndDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(1));
			lbl3rdDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(2));
			lbl4thDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(3));
			lbl5thDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(4));
			lbl1stDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(0));
			lbl2ndDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(1));
			lbl3rdDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(2));
			lbl4thDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(3));
			lbl5thDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(4));
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
		local.add(lblLocalTemperature = new JLabel());
		local.add(lblLocalMinTemp = new JLabel());
		local.add(lblLocalMaxTemp = new JLabel());
		local.add(lblLocalSunrise = new JLabel());
		local.add(lblLocalSunset = new JLabel());
		local.add(lblLocalWindSpeed = new JLabel());
		local.add(lblLocalWindDirection = new JLabel());
		local.add(lblLocalAirPressure = new JLabel());
		local.add(lblLocalHumidity = new JLabel());
		local.add(lblLocalSkyCondition = new JLabel());
		local.add(lblLocalSkyIcon = new JLabel());
	}
	
	/**
	 * initializeShortTerm adds all labels needed for the short-term forecast view
	 * to the ShortTerm JLabel ArrayList
	 */
	private static void initializeShortTerm(){
		shortTermHours = new ArrayList<JLabel>();
		shortTermHours.add(lbl1stHr = new JLabel());
		shortTermHours.add(lbl2ndHr = new JLabel());
		shortTermHours.add(lbl3rdHr = new JLabel());
		shortTermHours.add(lbl4thHr = new JLabel());
		shortTermHours.add(lbl5thHr = new JLabel());
		shortTermHours.add(lbl6thHr = new JLabel());
		shortTermHours.add(lbl7thHr = new JLabel());
		shortTermHours.add(lbl8thHr = new JLabel());
		for(JLabel l : shortTermHours){
			l.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		}
		lbl1stHrTemp = new JLabel();
		lbl2ndHrTemp = new JLabel();
		lbl3rdHrTemp = new JLabel();
		lbl4thHrTemp = new JLabel();
		lbl5thHrTemp = new JLabel();
		lbl6thHrTemp = new JLabel();
		lbl7thHrTemp = new JLabel();
		lbl8thHrTemp = new JLabel();
		lbl1stHrSkyIcon = new JLabel();
		lbl2ndHrSkyIcon = new JLabel();
		lbl3rdHrSkyIcon = new JLabel();
		lbl4thHrSkyIcon = new JLabel();
		lbl5thHrSkyIcon = new JLabel();
		lbl6thHrSkyIcon = new JLabel();
		lbl7thHrSkyIcon = new JLabel();
		lbl8thHrSkyIcon = new JLabel();
		lbl1stHrSkyCondition = new JLabel();
		lbl2ndHrSkyCondition = new JLabel();
		lbl3rdHrSkyCondition = new JLabel();
		lbl4thHrSkyCondition = new JLabel();
		lbl5thHrSkyCondition = new JLabel();
		lbl6thHrSkyCondition = new JLabel();
		lbl7thHrSkyCondition = new JLabel();
		lbl8thHrSkyCondition = new JLabel();
	}
	
	/**
	 * initializeShortTerm adds all labels needed for the short-term forecast view
	 * to the ShortTerm JLabel ArrayList
	 */
	private static void initializeLongTerm(){
		longTermHours = new ArrayList<JLabel>();
		longTermHours.add(lbl1stDay = new JLabel());
		longTermHours.add(lbl2ndDay = new JLabel());
		longTermHours.add(lbl3rdDay = new JLabel());
		longTermHours.add(lbl4thDay = new JLabel());
		longTermHours.add(lbl5thDay = new JLabel());
		for(JLabel l : longTermHours){
			l.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		}
		lbl1stDayTemp = new JLabel();
		lbl2ndDayTemp = new JLabel();
		lbl3rdDayTemp = new JLabel();
		lbl4thDayTemp = new JLabel();
		lbl5thDayTemp = new JLabel();
		lbl1stDayMinTemp = new JLabel();
		lbl2ndDayMinTemp = new JLabel();
		lbl3rdDayMinTemp = new JLabel();
		lbl4thDayMinTemp = new JLabel();
		lbl5thDayMinTemp = new JLabel();
		lbl1stDayMaxTemp = new JLabel();
		lbl2ndDayMaxTemp = new JLabel();
		lbl3rdDayMaxTemp = new JLabel();
		lbl4thDayMaxTemp = new JLabel();
		lbl5thDayMaxTemp = new JLabel();
		lbl1stDaySkyIcon = new JLabel();
		lbl2ndDaySkyIcon = new JLabel();
		lbl3rdDaySkyIcon = new JLabel();
		lbl4thDaySkyIcon = new JLabel();
		lbl5thDaySkyIcon = new JLabel();
		lbl1stDaySkyCondition = new JLabel();
		lbl2ndDaySkyCondition = new JLabel();
		lbl3rdDaySkyCondition = new JLabel();
		lbl4thDaySkyCondition = new JLabel();
		lbl5thDaySkyCondition = new JLabel();
	}
}	
