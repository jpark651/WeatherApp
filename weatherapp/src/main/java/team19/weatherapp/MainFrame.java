package team19.weatherapp;

/*
 * REST IN PEACE MAINFRAME 2015-2015
 */



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
	TestPanel mp = null;
	TestPanel n = null;
	String[] empty = {"","","","true","true","true","true","true","true","true","true","true","true","0"};

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
			if (str.length > 13){
				mp = new TestPanel(str);
			}else{
				mp = new TestPanel(empty);
		 		System.out.println("Previous Save Invalid");
			}
	      }catch(IOException i)
	      {
	 		mp = new TestPanel(empty);
	 		System.out.println("Previous Save Not Found");
	      }catch(ClassNotFoundException c)
	      {
	 		mp = new TestPanel(empty);
	 		System.out.println("Previous Save Not Found");
	      }
		
	}
	
}
