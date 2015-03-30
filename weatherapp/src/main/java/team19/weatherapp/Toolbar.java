package team19.weatherapp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class Toolbar {
	static void initToolbar(final TestPanel tp){
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

		tp.btnTempUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tp.tempUnits=='C'){
					tp.tempUnits = 'F';
				}else{
					tp.tempUnits = 'C';
				}
				City city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
				tp.updateScreen(city);
			}});

		tp.btnWindUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(tp.windUnits=='M'){
					tp.windUnits = 'K';
				}else{
					tp.windUnits = 'M';
				}
				City city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
				tp.updateScreen(city);
			}});

		tp.btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				City city = new City(tp.city.currentWeather.fullCityName, tp.tempUnits, tp.windUnits);
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
