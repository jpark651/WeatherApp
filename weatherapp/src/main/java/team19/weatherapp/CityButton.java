package team19.weatherapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CityButton extends JButton{

	public CityButton(final String c){
		this.setText(c);
	
	this.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			TestPanel.updateScreenWithCity(c);
		}});
	
	}
}
