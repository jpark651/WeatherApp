package team19.weatherapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Serialize class saves user data into a serialized file.
 * This allows the program to retrieve data the next time the
 * program is run.
 * 
 * Data is saved into a delimited string that is split by
 * underscore characters. (IE. London_C_K) would represent
 * London, Celcius, Kilometers/Hour.
 * 
 * Currently, two types of data our saved.
 * <ul>
 * <li> Most Recent Location Search </li>
 * <li> Unit Settings (C/F, K/M) </li>
 * </ul>
 * 
 * In the future, this will also be used to save data such
 * as "MyLocations".
 * 
 * @author Scott Mackie
 *
 */
public class Serialize {

	/**
	 * The saveOnExit method is called before the program closes.
	 * This takes a string "snap" and saves it into a snapshot file.
	 * 
	 * @param snap		The string that should be saved into the file
	 */
	public static void saveOnExit(String snap){
		try
        {
           FileOutputStream fileOut =
           new FileOutputStream("snapshot.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(snap);
           out.close();
           fileOut.close();
           System.out.println("Serialized data is saved in snapshot.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
	}
	
	/**
	 * The restore method is called when the program starts. It will attempt
	 * to load data from a snapshot file. If data is found, it is split into
	 * data pieces (Split by underscore characters). These pieces are
	 * returned as an array of string characters.
	 * 
	 * The array is organized as follows:
	 * <ul>
	 * <li> A[0] Most Recent Location Search </li>
	 * <li> A[1] Temperature Units </li>
	 * <li> A[2] Speed Units </li>
	 * </ul>
	 * 
	 * @return		Returns the string array containing the saved data pieces
	 * @throws IOException				Throws an error if the data cannot be
	 * 									read/retrieved	
	 * @throws ClassNotFoundException	Throws an error if specified file
	 * 									cannot be found. (No Previous Save Found) 
	 */
	public static String[] restore() throws IOException, ClassNotFoundException{
        System.out.println("Loading Data from snapshot.ser");
		String snap;
		FileInputStream fileIn = new FileInputStream("snapshot.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        snap = (String) in.readObject();
        in.close();
        fileIn.close();
        return (snap.split("_"));
	}
	
}
