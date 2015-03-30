package team19.weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JButton;

public class CityButtonPanel extends Panel {
	int citySize;
	CityButtonPanel() {
		citySize = 0;
	}

	public void addButton(CityButton c) {
		c.setPreferredSize(new Dimension(140, 20));
		boolean flag = false;
		Component[] components = this.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (((JButton) components[i]).getText().equals(c.getText())) {
				flag = true;
			}
		}
		if (flag == false && !c.getText().equals("City Not Found") && citySize < 20) {
			c.setSize(50, 100);
			
			
			
			
			this.add(c);
			this.revalidate();
			this.repaint();
			citySize += 1;
		}
	}

	public void removeButton() {
		Component[] components = this.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (((CityButton) components[i]).selectMarker == true) {
				this.remove(components[i]);
				citySize -= 1;
			}

		}
		this.revalidate();
		this.repaint();
	}
	
	public String buttonList() {
		String s = "_" + citySize;
		Component[] components = this.getComponents();
		for (int i = 0; i < components.length; i++) {
				s += "_" + ((CityButton)components[i]).getText();
				s += "_" + ((CityButton)components[i]).cityid;
		}
		return s;
	}

}
