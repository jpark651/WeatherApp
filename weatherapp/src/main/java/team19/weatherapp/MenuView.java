package team19.weatherapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
/**
 * MenuView is a class that creates the View Menu that will be used
 * by the user to specify what weather data to be displayed on the local
 * current weather screen
 * @author Team19
 */
public class MenuView {
	/**
	 * initViewMenu initializes the view menu and menubar and adds it to the main frame
	 * @param tp the JFrame on which this menubar will be added
	 */
	public static void initViewMenu(final MainFrame tp){
		tp.menubar = new JMenuBar();
		tp.viewMenu = new JMenu("View");
		tp.menubar.add(tp.viewMenu);

		tp.showTempMenuBtn = new JCheckBoxMenuItem("Temperature");
		tp.showMinTempMenuBtn = new JCheckBoxMenuItem("Min. Temperature");
		tp.showMaxTempMenuBtn = new JCheckBoxMenuItem("Max. Temperature");
		tp.showSunriseMenuBtn = new JCheckBoxMenuItem("Sunrise");
		tp.showSunsetMenuBtn = new JCheckBoxMenuItem("Sunset");
		tp.showAirPMenuBtn = new JCheckBoxMenuItem("Air Pressure");
		tp.showHumidityMenuBtn = new JCheckBoxMenuItem("Humidity");
		tp.showWindSpdMenuBtn = new JCheckBoxMenuItem("Wind Speed");
		tp.showWindDirMenuBtn = new JCheckBoxMenuItem("Wind Direction");
		tp.showSkyCondMenuBtn = new JCheckBoxMenuItem("Sky Condition");
		
		tp.viewMenu.add(tp.showTempMenuBtn);
		tp.viewMenu.add(tp.showMinTempMenuBtn);
		tp.viewMenu.add(tp.showMaxTempMenuBtn);
		tp.viewMenu.add(tp.showSunriseMenuBtn);
		tp.viewMenu.add(tp.showSunsetMenuBtn);
		tp.viewMenu.add(tp.showAirPMenuBtn);
		tp.viewMenu.add(tp.showHumidityMenuBtn);
		tp.viewMenu.add(tp.showWindSpdMenuBtn);
		tp.viewMenu.add(tp.showWindDirMenuBtn);
		tp.viewMenu.add(tp.showSkyCondMenuBtn);

		tp.showTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalTemperature.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalTemperature.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showMinTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalMinTemp.setVisible(true);
					tp.pnlLocal.minTempTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalMinTemp.setVisible(false);
					tp.pnlLocal.minTempTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showMaxTempMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalMaxTemp.setVisible(true);
					tp.pnlLocal.maxTempTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalMaxTemp.setVisible(false);
					tp.pnlLocal.maxTempTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showSunriseMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalSunrise.setVisible(true);
					tp.pnlLocal.sunrTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalSunrise.setVisible(false);
					tp.pnlLocal.sunrTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showSunsetMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalSunset.setVisible(true);
					tp.pnlLocal.sunsTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalSunset.setVisible(false);
					tp.pnlLocal.sunsTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showAirPMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalAirPressure.setVisible(true);
					tp.pnlLocal.airTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalAirPressure.setVisible(false);
					tp.pnlLocal.airTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showHumidityMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalHumidity.setVisible(true);
					tp.pnlLocal.humidTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalHumidity.setVisible(false);
					tp.pnlLocal.humidTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showWindSpdMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalWindSpeed.setVisible(true);
					tp.pnlLocal.windSpdTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalWindSpeed.setVisible(false);
					tp.pnlLocal.windSpdTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showWindDirMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalWindDirection.setVisible(true);
					tp.pnlLocal.windDirTitle.setVisible(true);
				}else{
					tp.pnlLocal.lblLocalWindDirection.setVisible(false);
					tp.pnlLocal.windDirTitle.setVisible(false);
				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

		tp.showSkyCondMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton abstractButton = (AbstractButton) event.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				if(selected){
					tp.pnlLocal.lblLocalSkyCondition.setVisible(true);
					tp.pnlLocal.lblLocalSkyIcon.setVisible(true);

				}else{
					tp.pnlLocal.lblLocalSkyCondition.setVisible(false);
					tp.pnlLocal.lblLocalSkyIcon.setVisible(false);

				}
				tp.menubar.revalidate();
				tp.menubar.repaint();
			}});

	}
}
