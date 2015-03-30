package team19.weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.json.JSONException;

public class CityButton extends JButton{
private CityButton currentbutton;
private CityButtonPanel cbp;
String cityid;
boolean selectMarker;

	public CityButton(CityButtonPanel cp, String ctid,final String c){
		this.setText(c);
		this.cbp = cp;
		this.cityid=ctid;
	}

	public CityButton(final String c, CityButtonPanel cp, String ctid){
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.selectMarker = true;
		this.setText(c);
		this.currentbutton = this;
		this.cbp = cp;
		this.cityid=ctid;
		
		Component[] cb = cbp.getComponents();
		for(int i=0;i<cb.length;i++){
			((JComponent) cb[i]).setOpaque(true);
			((CityButton)cb[i]).selectMarker = false;
			cb[i].setBackground(new Color(240,240,240));
			
		}
		this.setBackground(new Color(240,150,150));
		
		
	
	this.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			Component[] cb = cbp.getComponents();
			for(int i=0;i<cb.length;i++){
				((JComponent) cb[i]).setOpaque(true);
				((CityButton)cb[i]).selectMarker = false;
				cb[i].setBackground(new Color(240,240,240));
				
			}
			currentbutton.selectMarker = true;
			currentbutton.setBackground(new Color(240,150,150));
			try {
				TestPanel.updateScreenWithCity(c);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}});
	
	}
}
