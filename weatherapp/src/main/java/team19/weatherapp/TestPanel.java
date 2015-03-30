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
import javax.swing.WindowConstants;

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
	static CityButtonPanel pnlCityButtons;
    static JSplitPane backPanel;
	static JPanel menuPanel;
	static JTabbedPane mainPanel;
	static LocalWeatherPanel pnlLocal;
	static ShortTermPanel pnlShortTerm;
	static LongTermPanel pnlLongTerm;
	static JToolBar toolbar;
	static JLabel lblRefreshTime;
	static JButton btnAddCity;
	static JButton btnRemoveCity;
	static JButton btnTempUnits;
	static JButton btnWindUnits;
	static JButton btnRefresh;
	static String lastRefresh;
	static JMenuBar menubar;
	static JMenu viewMenu;
	static JCheckBoxMenuItem showTempMenuBtn;
	static JCheckBoxMenuItem showMinTempMenuBtn;
	static JCheckBoxMenuItem showMaxTempMenuBtn;
	static JCheckBoxMenuItem showSunriseMenuBtn;
	static JCheckBoxMenuItem showSunsetMenuBtn;
	static JCheckBoxMenuItem showAirPMenuBtn;
	static JCheckBoxMenuItem showHumidityMenuBtn;
	static JCheckBoxMenuItem showWindSpdMenuBtn;
	static JCheckBoxMenuItem showWindDirMenuBtn;
	static JCheckBoxMenuItem showSkyCondMenuBtn;
	static City city;
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
		MenuView.initViewMenu(this);
		setJMenuBar(menubar);
		Toolbar.initToolbar(this);
		getContentPane().add(toolbar, BorderLayout.SOUTH);
		backPanel = new JSplitPane();
		backPanel.setEnabled( false );
		getContentPane().add(backPanel, BorderLayout.NORTH);
		mainPanel = new JTabbedPane(JTabbedPane.TOP);
		backPanel.setRightComponent(mainPanel);
		mainPanel.addTab("Current", null, pnlLocal, null);
		mainPanel.addTab("Short-Term", null, pnlShortTerm, null);
		mainPanel.addTab("Long-Term", null, pnlLongTerm, null);
		mainPanel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				menubar.revalidate();
				menubar.repaint();
				 if (mainPanel.getSelectedIndex() == 0)
					 viewMenu.setEnabled(true);
			     else
			    	 viewMenu.setEnabled(false);
			}
		});
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
			CityButton newButton = new CityButton(inputStr[14+i*2],pnlCityButtons,inputStr[15+i*2]);
			pnlCityButtons.addButton(newButton); 
		}
		CustomView.initCustomView(this);
		menubar.revalidate();
		menubar.repaint();
		menuPanel = new JPanel();
		backPanel.setLeftComponent(menuPanel);
		MenuPanel.initMenuPanel(this);

		pnlLongTerm.setBackground(new Color(200,200,200));
		pnlShortTerm.setBackground(new Color(200,200,200));
		pnlLocal.setBackground(new Color(200,200,200));
		menubar.setBackground(new Color(220,220,220));
		toolbar.setBackground(new Color(220,220,220));
		menuPanel.setBackground(new Color(220,220,220));
		backPanel.setBackground(new Color(220,220,220));

		Component[] cb = pnlCityButtons.getComponents();
		for(int i=0;i<cb.length;i++){
			cb[i].setBackground(new Color(240,240,240));
		}
		
		/*
		 * This sets current information from previous save
		 */
		 if (cityName.length() > 0) {
			 txtLocation.setText(cityName);
			 city = new City(cityName, tempUnits, windUnits);
			 updateScreen(city);
			 txtLocation.setText("");
		 }
		 
		 this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE );

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
					 String saveFile = (pnlLocal.lblCity.getText() + "_" + tempUnits + "_" + windUnits + "_" + showTempMenuBtn.isSelected() + "_" + showMinTempMenuBtn.isSelected() + "_" + showMaxTempMenuBtn.isSelected() + "_" + showSunriseMenuBtn.isSelected() + "_" + showSunsetMenuBtn.isSelected() + "_" + showAirPMenuBtn.isSelected() + "_" + showHumidityMenuBtn.isSelected() + "_" + showWindSpdMenuBtn.isSelected() + "_" + showWindDirMenuBtn.isSelected() + "_" + showSkyCondMenuBtn.isSelected());
					 saveFile += pnlCityButtons.buttonList();
					 Serialize.saveOnExit(saveFile);
					 System.out.println("Saved: " + Arrays.toString(saveFile.split("_")));
					 frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				 }
			 }
		 });

	}


	//////////////////////////////////////////////////////////////////
	
	//HELPER METHODS//////////////

	static void updateScreen(City city){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
		Calendar cal = Calendar.getInstance();
		lblRefreshTime.setText("Last refreshed:" + dateFormat.format(cal.getTime()));
		pnlLocal.update(city, tempUnits, windUnits);
		pnlShortTerm.update(city, tempUnits);
		pnlLongTerm.update(city, tempUnits);
		try{
		int[] colarray = Utilities.convertColor((int)city.currentWeather.kelvin);
		pnlLongTerm.setBackground(new Color(colarray[0],colarray[1],colarray[2]));
		pnlShortTerm.setBackground(new Color(colarray[0],colarray[1],colarray[2]));
		pnlLocal.setBackground(new Color(colarray[0],colarray[1],colarray[2]));
		} catch (Exception e){
			pnlLongTerm.setBackground(new Color(200,200,200));
			pnlShortTerm.setBackground(new Color(200,200,200));
			pnlLocal.setBackground(new Color(200,200,200));
		}
		menubar.revalidate();
		menubar.repaint();
		

		
	}
	
	static void newCityUpdateScreen(){
		city = new City(txtLocation.getText(), tempUnits, windUnits);
		updateScreen(city);

	}

	static void updateScreenWithCity(String c){
		city = new City(c, tempUnits, windUnits);
		updateScreen(city);

	}

}	