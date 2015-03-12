package team19.weatherapp;

import java.io.IOException;
import java.util.Arrays;

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
				TestPanel window = null;	
				//Attempt to load previous user data
				try
			      {
					String[] str =  Serialize.restore();
					System.out.println("Loaded: " + Arrays.toString(str));
					/* If previous save is valid, load the JPanel with
					 * the specified information. If not, create a new
					 * JPanel
					 */
					if (str.length == 3){
						window = new TestPanel(str[0],str[1],str[2]);
					}else{
						window = new TestPanel("","","");
				 		System.out.println("Previous Save Invalid");
					}
			      }catch(IOException i)
			      {
			 		window = new TestPanel("","","");
			 		System.out.println("Previous Save Not Found");
			      }catch(ClassNotFoundException c)
			      {
			 		window = new TestPanel("","","");
			 		System.out.println("Previous Save Not Found");
			      }
				
				
				//Set window preferences
				window.setSize(750, 550);
				window.setVisible(true);
				window.setLocationRelativeTo(null);
				
			}
		});
	}
}
