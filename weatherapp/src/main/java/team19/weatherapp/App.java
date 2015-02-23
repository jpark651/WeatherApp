package team19.weatherapp;

import java.io.IOException;

import javax.swing.SwingUtilities;

//Initialize App
public class App {
	
	//Main Method
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				//Display window, set size and properties
				MainFrame window = null;
				try {
					window = new MainFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.setSize(465, 815);
				window.setVisible(true);
				window.setLocationRelativeTo(null);

				
				
			}
		});
	}
}
