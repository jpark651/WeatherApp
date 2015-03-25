package team19.weatherapp;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class TestPanel extends JFrame{

	static JTextField txtLocation;
	private static CityButtonPanel pnlCityButtons;

	private static JSplitPane backPanel;
	private static JPanel menuPanel;
	private static JTabbedPane mainPanel;

	/**
	 * JLabels needed for the short-term forecast view
	 */

	private static LocalWeatherPanel pnlLocal;
	private static ShortTermPanel pnlShortTerm;
	private static LongTermPanel pnlLongTerm;

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
	private static String lastRefresh;

	/**
	 * Components needed for menubar
	 */
	private static JMenuBar menubar;
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

		this.setResizable(false);
		pnlLongTerm = new LongTermPanel();
		pnlShortTerm = new ShortTermPanel();
		pnlLocal = new LocalWeatherPanel();

		pnlCityButtons = new CityButtonPanel();

		String cityName = inputStr[0];
		String tUnits = inputStr[1];
		String wUnits = inputStr[2];
		
		city = new City(cityName, tempUnits, windUnits);
		
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

		initViewMenu();
		setJMenuBar(menubar);

		initToolbar();
		getContentPane().add(toolbar, BorderLayout.SOUTH);

		backPanel = new JSplitPane();
		backPanel.setEnabled( false );
		getContentPane().add(backPanel, BorderLayout.NORTH);

		mainPanel = new JTabbedPane(JTabbedPane.TOP);
		backPanel.setRightComponent(mainPanel);

		initMainPanels();

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

		initCustomView();
		menubar.revalidate();
		menubar.repaint();

		menuPanel = new JPanel();
		backPanel.setLeftComponent(menuPanel);

		initMenuPanel();

		pnlLongTerm.setBackground(new Color(100,100,100));
		pnlShortTerm.setBackground(new Color(100,100,100));
		pnlLocal.setBackground(new Color(130,170,255));
		menubar.setBackground(new Color(220,220,220));
		toolbar.setBackground(new Color(220,220,220));
		menuPanel.setBackground(new Color(220,220,220));
		backPanel.setBackground(new Color(220,220,220));


		/*
		 * This sets current information from previous save
		 */
		 if (cityName.length() > 0) {
			 txtLocation.setText(cityName);
			 city = new City(cityName, tempUnits, windUnits);
			 pnlLocal.update(city, tempUnits, windUnits);
			 pnlShortTerm.update(city, tempUnits);
			 pnlLongTerm.update(city, tempUnits);
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
					  * Format is as follows:
					  * A[0] Most Recent Location Search
					  * A[1] Temperature Units
					  * A[2] Speed Units
					  */
					 String saveFile = (pnlLocal.lblCity.getText() + "_" + tempUnits + "_" + windUnits + "_" + showTempMenuBtn.isSelected() + "_" + showMinTempMenuBtn.isSelected() + "_" + showMaxTempMenuBtn.isSelected() + "_" + showSunriseMenuBtn.isSelected() + "_" + showSunsetMenuBtn.isSelected() + "_" + showAirPMenuBtn.isSelected() + "_" + showHumidityMenuBtn.isSelected() + "_" + showWindSpdMenuBtn.isSelected() + "_" + showWindDirMenuBtn.isSelected() + "_" + showSkyCondMenuBtn.isSelected());
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
	 * initViewMenu sets up the view menu that will be used by the 
	 * user to customize their local weather view
	 */
	private static void initViewMenu(){
		menubar = new JMenuBar();
		viewMenu = new JMenu("View");
		menubar.add(viewMenu);

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
					pnlLocal.lblLocalTemperature.setVisible(true);
				}else{
					pnlLocal.lblLocalTemperature.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showMinTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalMinTemp.setVisible(true);
					pnlLocal.minTempTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalMinTemp.setVisible(false);
					pnlLocal.minTempTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showMaxTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalMaxTemp.setVisible(true);
					pnlLocal.maxTempTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalMaxTemp.setVisible(false);
					pnlLocal.maxTempTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showSunriseMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalSunrise.setVisible(true);
					pnlLocal.sunrTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalSunrise.setVisible(false);
					pnlLocal.sunrTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showSunsetMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalSunset.setVisible(true);
					pnlLocal.sunsTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalSunset.setVisible(false);
					pnlLocal.sunsTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showAirPMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalAirPressure.setVisible(true);
					pnlLocal.airTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalAirPressure.setVisible(false);
					pnlLocal.airTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showHumidityMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalHumidity.setVisible(true);
					pnlLocal.humidTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalHumidity.setVisible(false);
					pnlLocal.humidTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showWindSpdMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalWindSpeed.setVisible(true);
					pnlLocal.windSpdTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalWindSpeed.setVisible(false);
					pnlLocal.windSpdTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showWindDirMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalWindDirection.setVisible(true);
					pnlLocal.windDirTitle.setVisible(true);
				}else{
					pnlLocal.lblLocalWindDirection.setVisible(false);
					pnlLocal.windDirTitle.setVisible(false);
				}
				menubar.revalidate();
				menubar.repaint();
			}});

		showSkyCondMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					pnlLocal.lblLocalSkyCondition.setVisible(true);
					pnlLocal.lblLocalSkyIcon.setVisible(true);

				}else{
					pnlLocal.lblLocalSkyCondition.setVisible(false);
					pnlLocal.lblLocalSkyIcon.setVisible(false);

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
		toolbar.setEnabled(false);
		btnAddCity = new JButton("Add City");
		btnRemoveCity = new JButton("Remove City");
		btnTempUnits = new JButton("C/F");
		btnWindUnits = new JButton("Miles/KM");
		btnRefresh = new JButton("Refresh");
		lblRefreshTime = new JLabel("Last refreshed at:                   ");
		toolbar.add(btnAddCity);
		toolbar.add(btnRemoveCity);
		Component horizStrut = Box.createHorizontalStrut(60);
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
				updateScreen(city);
			}});

		btnWindUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(windUnits=='M'){
					windUnits = 'K';
				}else{
					windUnits = 'M';
				}
				updateScreen(city);
			}});

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateScreen(city);
			}});

		btnAddCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton newButton = new CityButton(pnlLocal.lblCity.getText());
				pnlCityButtons.addButton(newButton); 
				menubar.revalidate();
				menubar.repaint();
			}});

		btnRemoveCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton oldButton = new CityButton(pnlLocal.lblCity.getText());
				pnlCityButtons.removeButton(oldButton); 
				menubar.revalidate();
				menubar.repaint();
			}});
	}

	private static void initMainPanels(){
		mainPanel.addTab("Current", null, pnlLocal, null);
		mainPanel.addTab("Short-Term", null, pnlShortTerm, null);
		mainPanel.addTab("Long-Term", null, pnlLongTerm, null);

		mainPanel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				menubar.revalidate();
				menubar.repaint();
			}
		});
	}
	
	private static void initCustomView(){
		boolean selected = showTempMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalTemperature.setVisible(true);
		}else{
			pnlLocal.lblLocalTemperature.setVisible(false);
		}
		selected = showMinTempMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalMinTemp.setVisible(true);
			pnlLocal.minTempTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalMinTemp.setVisible(false);
			pnlLocal.minTempTitle.setVisible(false);
		}		
		selected = showMaxTempMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalMaxTemp.setVisible(true);
			pnlLocal.maxTempTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalMaxTemp.setVisible(false);
			pnlLocal.maxTempTitle.setVisible(false);
		}		
		selected = showSunriseMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalSunrise.setVisible(true);
			pnlLocal.sunrTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalSunrise.setVisible(false);
			pnlLocal.sunrTitle.setVisible(false);
		}
		selected = showSunsetMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalSunset.setVisible(true);
			pnlLocal.sunsTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalSunset.setVisible(false);
			pnlLocal.sunsTitle.setVisible(false);
		}
		selected = showAirPMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalAirPressure.setVisible(true);
			pnlLocal.airTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalAirPressure.setVisible(false);
			pnlLocal.airTitle.setVisible(false);
		}
		selected = showHumidityMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalHumidity.setVisible(true);
			pnlLocal.humidTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalHumidity.setVisible(false);
			pnlLocal.humidTitle.setVisible(false);
		}
		selected = showWindSpdMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalWindSpeed.setVisible(true);
			pnlLocal.windSpdTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalWindSpeed.setVisible(false);
			pnlLocal.windSpdTitle.setVisible(false);
		}
		selected = showWindDirMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalWindDirection.setVisible(true);
			pnlLocal.windDirTitle.setVisible(true);
		}else{
			pnlLocal.lblLocalWindDirection.setVisible(false);
			pnlLocal.windDirTitle.setVisible(false);
		}
		selected = showSkyCondMenuBtn.getModel().isSelected();
		if(selected){
			pnlLocal.lblLocalSkyCondition.setVisible(true);
			pnlLocal.lblLocalSkyIcon.setVisible(true);        	
		}else{
			pnlLocal.lblLocalSkyCondition.setVisible(false);
			pnlLocal.lblLocalSkyIcon.setVisible(false);
		}
	}

	//////////////////////////////////////////////////////////////////
	
	//HELPER METHODS//////////////

	private static void initMenuPanel(){
		txtLocation = new JTextField();
		txtLocation.setColumns(13);
		GroupLayout gl_panel = new GroupLayout(menuPanel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnlCityButtons, 150, 150, 150))
								.addContainerGap(15, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(29)
						.addComponent(pnlCityButtons, 500, 500, 500)
						.addContainerGap(50, Short.MAX_VALUE))
				);
		menuPanel.setLayout(gl_panel);
		

		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				newCityUpdateScreen();
			}});

	}
	

	private static void updateScreen(City city){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lblRefreshTime.setText("Last refreshed:" + dateFormat.format(cal.getTime()));
		pnlLocal.update(city, tempUnits, windUnits);
		pnlShortTerm.update(city, tempUnits);
		pnlLongTerm.update(city, tempUnits);
		
		int temp = (int)city.currentWeather.kelvin;
		
		temp = temp-273;
		temp = 100 + temp*4;
		if(temp > 255)
			temp=255;
		if(temp<0)
			temp=0;
		
		int rval=128;
		int gval=128;
		int bval=128;
		
		if(temp > 100)
			rval = 100+(temp/2);
		
		if(temp < 160)
			bval = 100+((255-temp)/2);
		
		if(temp>50 && temp < 128)
			gval = 80+(temp);
		
		if(temp>128 && temp < 210)
			gval = 340-temp;
		
		
		rval += 20;
		gval += 20;
		bval += 20;
		
		if(rval>255)
			rval = 255;
		if(gval>255)
			gval = 255;
		if(bval>255)
			bval = 255;
		
		System.out.println(rval + " " + gval + " " + bval);
		
		pnlLongTerm.setBackground(new Color(rval,gval,bval));
		pnlShortTerm.setBackground(new Color(rval,gval,bval));
		pnlLocal.setBackground(new Color(rval,gval,bval));
	}
	
	private static void newCityUpdateScreen(){
		city = new City(txtLocation.getText(), tempUnits, windUnits);
		updateScreen(city);
	}

	public static void updateScreenWithCity(String c){
		city = new City(c, tempUnits, windUnits);
		updateScreen(city);

	}


}	