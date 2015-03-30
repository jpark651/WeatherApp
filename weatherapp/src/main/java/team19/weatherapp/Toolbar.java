package team19.weatherapp;
/**
 * Toolbar is a class that creates the toolbar that contains buttons
 * that the user will use to add/remove cities from their favourites,
 * as well as buttons that will allow them to change their preferences
 * for units
 * @author Team19
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import org.json.JSONException;

public class Toolbar {
	/**
	 * initToolbar initializes the toolbar and it's accompanying buttons
	 * and adds it the main frame of the app
	 * @param tp the main frame on which the toolbar will be added
	 */
	static void initToolbar(final MainFrame tp){
		tp.toolbar = new JToolBar();
		tp.toolbar.setEnabled(false);
		tp.btnAddCity = new JButton("Add To Favorites");
		tp.btnRemoveCity = new JButton("Remove From Favorites");
		tp.btnTempUnits = new JButton("C/F");
		tp.btnWindUnits = new JButton("Miles/KM");
		tp.btnRefresh = new JButton("Refresh");
		tp.lblRefreshTime = new JLabel("Last refreshed at:                   ");
		tp.toolbar.add(tp.btnAddCity);
		tp.toolbar.add(tp.btnRemoveCity);
		Component horizStrut = Box.createHorizontalStrut(60);
		tp.toolbar.add(horizStrut);
		tp.toolbar.add(tp.lblRefreshTime);
		Component horizStrut2 = Box.createHorizontalStrut(60);
		tp.toolbar.add(horizStrut2);
		tp.toolbar.add(tp.btnTempUnits);
		tp.toolbar.add(tp.btnWindUnits);
		tp.toolbar.add(tp.btnRefresh);

		tp.btnTempUnits.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(tp.tempUnits=='C'){
					tp.tempUnits = 'F';
				}else{
					tp.tempUnits = 'C';
				}
				City city = null;
				try {
					city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tp.updateScreen(city);
			}});

		tp.btnWindUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tp.windUnits=='M'){
					tp.windUnits = 'K';
				}else{
					tp.windUnits = 'M';
				}
				City city = null;
				try {
					city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tp.updateScreen(city);
			}});

		tp.btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				City city =null;
				try {
					city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tp.updateScreen(city);
			}});

		tp.btnAddCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton newButton = new CityButton(tp.pnlLocal.lblCity.getText(),tp.pnlCityButtons, tp.pnlShortTerm.cityid);
				tp.pnlCityButtons.addButton(newButton); 
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.btnRemoveCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				CityButton oldButton = new CityButton(tp.pnlCityButtons,tp.pnlLocal.lblCity.getText(),tp.pnlShortTerm.cityid);
				tp.pnlCityButtons.removeButton(); 
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});
	}
}
