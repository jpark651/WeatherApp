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
	private JTextField txtName;
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
		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(75, 25));
		lblTemp = new JLabel();
		btnCompute = new JButton("Look Up Temperature");
		
		//ActionListener for the JButton
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//Parse Data
				String dataStr = CurrentWeatherData.parseData(txtName.getText());
				
				//If Error, Respond Accordingly
				if(dataStr.contains("ERROR")){
					if(dataStr.equals("ERROR_1")){
						lblTemp.setText("City Not Found");
					} else {
						lblTemp.setText(dataStr);
					}
					
				//If Valid, Display Data on Screen
				} else {
					
					//Create JSON Objects from string (There are multiple JSON objects within the string)
					JSONObject jData = new JSONObject(dataStr);
					JSONObject jMain = jData.getJSONObject("main");
					lblTemp.setText("It is " + CurrentWeatherData.getTemp(jMain) + " degrees in " + txtName.getText());
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
				.addComponent(txtName))
				.addGroup(layout.createSequentialGroup()
				.addComponent(btnCompute)
				.addComponent(lblTemp)));
		
		//Vertical Group
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(lblName).addComponent(txtName))
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