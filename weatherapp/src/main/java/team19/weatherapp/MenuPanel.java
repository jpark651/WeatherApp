package team19.weatherapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import org.json.JSONException;
/**
 * MenuPanel creates the panel for the "menu"
 * This menu includes the search box and the user's favourites list
 * @author Team19
 */
public class MenuPanel {

	/**
	 * initMenuPanel initializes the menu panel and adds it to the main frame of the app
	 * it also initializes the separate components to be included on it
	 * @param tp the main frame of the app on which the menu panel will be added
	 */
	public static void initMenuPanel(final MainFrame tp){
		JLabel searchbar = new JLabel();
		searchbar.setText(" Search for a City");
		JLabel favoritesbar = new JLabel();
		favoritesbar.setText(" Favorites");


		tp.txtLocation = new JTextField();
		tp.txtLocation.setColumns(13);
		GroupLayout gl_panel = new GroupLayout(tp.menuPanel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(searchbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tp.txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(favoritesbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tp.pnlCityButtons, 150, 150, 150))
								.addContainerGap(15, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tp.txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(29)
						.addComponent(favoritesbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tp.pnlCityButtons, 500, 500, 500)
						.addContainerGap(50, Short.MAX_VALUE))
				);
		tp.menuPanel.setLayout(gl_panel);
		tp.txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					tp.newCityUpdateScreen();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

	}
	
	
}
