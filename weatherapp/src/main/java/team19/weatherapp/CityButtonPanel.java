package team19.weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JButton;
/**
 * CityButtonPanel is the class that implements the "favourites" list for the user.
 * The user can add their favourite cities to the list for easy future searching
 * @author Team19
 */
public class CityButtonPanel extends Panel {
	int citySize;
	CityButtonPanel() {
		citySize = 0;
	}
	
	/**
	 * addButton method adds the specified city button to the panel
	 * @param c the city button to be added to the panel
	 */
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

	/**
	 * removeButton method removes the button for the current city
	 */
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
	
	/**
	 * buttonList method returns a string to be stored for serialization
	 * at the termination of the program
	 * @return String to be stored
	 */
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
