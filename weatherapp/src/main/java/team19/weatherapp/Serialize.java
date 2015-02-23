package team19.weatherapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Serialize {

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
	
	public static String restore() throws IOException, ClassNotFoundException{
        System.out.println("Loading Data from snapshot.ser");
		String snap;
		FileInputStream fileIn = new FileInputStream("snapshot.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        snap = (String) in.readObject();
        in.close();
        fileIn.close();
        return snap;
	}
	
}
