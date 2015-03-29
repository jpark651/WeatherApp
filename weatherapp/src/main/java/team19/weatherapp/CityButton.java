package team19.weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CityButton extends JButton{
private CityButton currentbutton;
private CityButtonPanel cbp;
String cityid;

	public CityButton(final String c, CityButtonPanel cp, String ctid){
		this.setText(c);
		this.currentbutton = this;
		this.cbp = cp;
		this.cityid=ctid;
	
	this.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			Component[] cb = cbp.getComponents();
			for(int i=0;i<cb.length;i++){
				cb[i].setBackground(new Color(240,240,240));
			}
			currentbutton.setBackground(new Color(240,150,150));
			TestPanel.updateScreenWithCity(c);
		}});
	
	}
}
