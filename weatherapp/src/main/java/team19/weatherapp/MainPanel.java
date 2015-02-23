package team19.weatherapp;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;

import org.json.JSONObject;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

//MainWindow Class
public class MainPanel extends JPanel{
	
	
	
	


	// Panel Objects
	static JTextField txtLocation;
	private static JLabel lblTemp;
	private JButton btnCompute;
	final BufferedImage image;
	


	// JPanel Form
	public MainPanel(String cityName) throws IOException{
		image = ImageIO.read(new File(".\\src\\resources\\gui.png"));

		// Initialize Panel Objects
		txtLocation =  new JTextField() {
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtLocation.setOpaque(false);
		txtLocation.setPreferredSize(new Dimension(75, 25));
		Font font = new Font("SansSerif", Font.BOLD, 18);
		txtLocation.setFont(font);
		
		
		lblTemp = new JLabel();
		
		if(cityName.length() > 0){
			txtLocation.setText(cityName);
			screenUpdate();
		}
		
		/*
		btnCompute = new JButton("");
		btnCompute.setBorderPainted(false);
		btnCompute.setFocusPainted(false);
		btnCompute.setContentAreaFilled(false);
		btnCompute.setIcon(new ImageIcon(".\\src\\resources\\getWeather.png"));
		btnCompute.setRolloverIcon(new ImageIcon(
				".\\src\\resources\\getWeatherRoll.png"));
		btnCompute.setPressedIcon(new ImageIcon(
				".\\src\\resources\\getWeatherPress.png"));*/

		// ActionListener for the JButton
		txtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				screenUpdate();
			}

		});

		// Layout Design
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(31)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(4)
							.addComponent(txtLocation, 328, 328, 328)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
						.addComponent(lblTemp, 50, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(30)
							.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTemp))
						.addGroup(layout.createSequentialGroup()
							.addGap(59)
							))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		
		// Set layout and return panel
		this.setLayout(layout);
	}
	
	private static void screenUpdate(){
		// Parse Data
		City myCity = new City(txtLocation.getText());

		// If Error, Respond Accordingly
		if (myCity.validate != true) {
			lblTemp.setText("City Not Found");

			// If Valid, Display Data on Screen
		} else {
			lblTemp.setText("It is "
					+ myCity.currentWeather.temperature
					+ " degrees in " + txtLocation.getText());
		}
	}
	
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
	
}