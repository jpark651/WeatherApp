package team19.weatherapp;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * The MainFrame class is the JFrame that holds the GUI.
 * The MainFrame attempts to initialize a JPanel using
 * previous save data. If that is unsuccessful, it creates
 * a new empty JPanel.
 * 
 * When the MainFrame is closed by the user, it calls the
 * Serialization class and attempts to save user data, so
 * that it can be used next time.
 * 
 * @author Scott Mackie
 *
 */
public class MainFrame extends JFrame {
	
	//Initialize null panel
	MainPanel mp = null;
	MainPanel n = null;

	/**
	 * The MainFrame Constructor attempts to create a JPanel
	 * by using previous user data. If previous user data cannot
	 * be found, or if the program runs into issues when attempting
	 * to load from the serialization file, it creates a new 
	 * empty JPanel.
	 * 
	 * The constructor also sets up the windowListener
	 * that will be called before the window can close.
	 * This ensures that user data will be saved before
	 * the user exits the program.
	 * 
	 * @throws IOException   	If the image cannot be found, throws an error
	 */
	public MainFrame() throws IOException {
		
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
				mp = new MainPanel(str[0],str[1],str[2]);
			}else{
				mp = new MainPanel("","","");
		 		System.out.println("Previous Save Invalid");
			}
	      }catch(IOException i)
	      {
	 		mp = new MainPanel("","","");
	 		System.out.println("Previous Save Not Found");
	      }catch(ClassNotFoundException c)
	      {
	 		mp = new MainPanel("","","");
	 		System.out.println("Previous Save Not Found");
	      }
		
		//Set content pane and properties
		getContentPane().add(mp, BorderLayout.CENTER);
		this.setTitle("WeatherApp");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
		/* The windowListener saves the user data before the user closes
		 * the application.
		 */
		this.addWindowListener( new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        JFrame frame = (JFrame)e.getSource();
		 
		        int result = JOptionPane.showConfirmDialog(
		            frame,
		            "Are you sure you want to exit the application?",
		            "Exit Application",
		            JOptionPane.YES_NO_OPTION);
		 
		        if (result == JOptionPane.YES_OPTION){
		        	if(mp.txtLocation.getText().length() > 0){
		        		
		        		/* Write the save data here, delimited by underscore characters
		        		 * 
		        		 * Format is as follows:
		        		 * 
		        		 * A[0] Most Recent Location Search
		        		 * A[1] Temperature Units
		        		 * A[2] Speed Units
		        		 */
		        		String saveFile = (mp.txtLocation.getText() + "_" + mp.tempUnits + "_" + mp.windUnits);
		        		Serialize.saveOnExit(saveFile);
		        		System.out.println("Saved: " + Arrays.toString(saveFile.split("_")));
		        	}
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        }
		    }
		});
	}
	
}
