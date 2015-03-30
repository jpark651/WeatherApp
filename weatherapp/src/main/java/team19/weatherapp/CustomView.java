package team19.weatherapp;

import java.awt.Frame;
import java.awt.Panel;
/**
 * MenuView is a class that creates the user's "custom view" depending on
 * their previous settings
 * @author Team19
 */
public class CustomView {
	/**
	 * initCustomView method implements the custom view on the main frame of the app
	 * @param tp the main frame of the app on which the custom view will be implemented
	 */
	public static void initCustomView(MainFrame tp){
		boolean selected = tp.showTempMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalTemperature.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalTemperature.setVisible(false);
		}
		selected = tp.showMinTempMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalMinTemp.setVisible(true);
			tp.pnlLocal.minTempTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalMinTemp.setVisible(false);
			tp.pnlLocal.minTempTitle.setVisible(false);
		}		
		selected = tp.showMaxTempMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalMaxTemp.setVisible(true);
			tp.pnlLocal.maxTempTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalMaxTemp.setVisible(false);
			tp.pnlLocal.maxTempTitle.setVisible(false);
		}		
		selected = tp.showSunriseMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalSunrise.setVisible(true);
			tp.pnlLocal.sunrTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalSunrise.setVisible(false);
			tp.pnlLocal.sunrTitle.setVisible(false);
		}
		selected = tp.showSunsetMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalSunset.setVisible(true);
			tp.pnlLocal.sunsTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalSunset.setVisible(false);
			tp.pnlLocal.sunsTitle.setVisible(false);
		}
		selected = tp.showAirPMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalAirPressure.setVisible(true);
			tp.pnlLocal.airTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalAirPressure.setVisible(false);
			tp.pnlLocal.airTitle.setVisible(false);
		}
		selected = tp.showHumidityMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalHumidity.setVisible(true);
			tp.pnlLocal.humidTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalHumidity.setVisible(false);
			tp.pnlLocal.humidTitle.setVisible(false);
		}
		selected = tp.showWindSpdMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalWindSpeed.setVisible(true);
			tp.pnlLocal.windSpdTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalWindSpeed.setVisible(false);
			tp.pnlLocal.windSpdTitle.setVisible(false);
		}
		selected = tp.showWindDirMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalWindDirection.setVisible(true);
			tp.pnlLocal.windDirTitle.setVisible(true);
		}else{
			tp.pnlLocal.lblLocalWindDirection.setVisible(false);
			tp.pnlLocal.windDirTitle.setVisible(false);
		}
		selected = tp.showSkyCondMenuBtn.getModel().isSelected();
		if(selected){
			tp.pnlLocal.lblLocalSkyCondition.setVisible(true);
			tp.pnlLocal.lblLocalSkyIcon.setVisible(true);        	
		}else{
			tp.pnlLocal.lblLocalSkyCondition.setVisible(false);
			tp.pnlLocal.lblLocalSkyIcon.setVisible(false);
		}
	}
	
}
