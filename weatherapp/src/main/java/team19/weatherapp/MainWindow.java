package team19.weatherapp;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import org.json.JSONObject;


//MainWindow Class
public class MainWindow extends JFrame {
	
	//Panel Objects
	private JTextField txtLocation;
	private JLabel lblTemp;
	private JLabel lblName;
	private JPanel panel;
	private JButton btnCompute;


	//MainWindow Constructor
	public MainWindow() {
		this.initUI();
	}

	
	//Initialize UI
	private void initUI() {
		this.add(this.createForm(), BorderLayout.CENTER);
	}

	
	//JPanel Form
	private JPanel createForm() {
		
		//Initialize Panel Objects
		panel = new JPanel();
		lblName = new JLabel("Enter City Name:");
		txtLocation = new JTextField();
		txtLocation.setPreferredSize(new Dimension(75, 25));
		lblTemp = new JLabel();
		btnCompute = new JButton("Look Up Temperature");
		
		//ActionListener for the JButton
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//Parse Data
				City myCity = new City(txtLocation.getText());
				
				//If Error, Respond Accordingly
				if(myCity.validate!=true){
					lblTemp.setText("City Not Found");
					
				//If Valid, Display Data on Screen
				} else {
					lblTemp.setText("It is " + myCity.currentWeather.temperature + " degrees in " + txtLocation.getText());
				}
			}

		});
		
		//Layout Design
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//Horizontal Group
		layout.setHorizontalGroup(layout
		.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addComponent(lblName)
				.addComponent(txtLocation))
				.addGroup(layout.createSequentialGroup()
				.addComponent(btnCompute)
				.addComponent(lblTemp)));
		
		//Vertical Group
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(lblName).addComponent(txtLocation))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(btnCompute)
								.addComponent(lblTemp)));
		
		//Set layout and return panel
		panel.setLayout(layout);
		return panel;

	}
}