package team19.weatherapp;

import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 * App is the main class that will be loaded. 
 *
 * First, it initializes the SwingUtilities runnable, 
 * and creates a null window.
 * 
 * Next, It creates a MainFrame object, which initializes 
 * the gui for the application.
 * 
 * After intialization, we adjust and resize the window.
 * 
 * @author Scott Mackie
 * @version     %I%, %G%
 * 
 */
public class App {
	
	/**
	 * 
	 * Main method is initialized at startup.
	 * 
	 * It initializes the runnable, and runs until the
	 * application is exited by the user.
	 * 
	 * After window creation, the main method handles window 
	 * preferences (resize, location, etc.)
	 * 
	 * @param args  No arguments are needed to run the application
	 * @throws IOException    An IOException can be thrown if the MainFrame
	 * 						  throws an error during creation
	 */
	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				//Initialize MainWindow object
				TestPanel window = null;
				window = new TestPanel();
				
				
				//Set window preferences
				window.setSize(750, 550);
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				
			}
		});
	}
}
