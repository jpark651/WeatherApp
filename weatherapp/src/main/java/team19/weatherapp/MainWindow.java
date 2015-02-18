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
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;


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
		getContentPane().add(this.createForm(), BorderLayout.CENTER);
	}

	
	//JPanel Form
	private JPanel createForm() {
		
		//Initialize Panel Objects
		panel = new JPanel();
		lblName = new JLabel("Enter City Name:");
		txtLocation = new JTextField();
		txtLocation.setPreferredSize(new Dimension(75, 25));
		lblTemp = new JLabel();
		btnCompute = new JButton("");
		btnCompute.setBorderPainted(false);
		btnCompute.setFocusPainted(false);
		btnCompute.setContentAreaFilled(false);
		btnCompute.setIcon(new ImageIcon("C:\\git\\team19\\weatherapp\\src\\resources\\getWeather.png"));
		btnCompute.setRolloverIcon(new ImageIcon("C:\\git\\team19\\weatherapp\\src\\resources\\getWeatherRoll.png"));
		btnCompute.setPressedIcon(new ImageIcon("C:\\git\\team19\\weatherapp\\src\\resources\\getWeatherPress.png"));
		
		

		
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
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lblName)
					.addComponent(txtLocation, 328, 328, 328))
				.addGroup(layout.createSequentialGroup()
					.addGap(487)
					.addComponent(lblTemp))
				.addComponent(btnCompute, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCompute)
						.addComponent(lblTemp)))
		);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//Set layout and return panel
		panel.setLayout(layout);
		return panel;

	}
}