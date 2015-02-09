package team19.weatherapp;

import javax.swing.SwingUtilities;

//Initialize App
public class App {
	
	//Maion Method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				//Display window, set size and properties
				MainWindow window = new MainWindow();
				window.setSize(600, 300);
				window.setVisible(true);
				window.setLocationRelativeTo(null);

			}
		});
	}
}
