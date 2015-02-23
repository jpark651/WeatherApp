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
           new FileOutputStream("snap.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(snap);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in snap.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
	}
	
	public static String restore() throws IOException, ClassNotFoundException{
        System.out.printf("Loading Data from snap.ser");
		String snap;
		FileInputStream fileIn = new FileInputStream("snap.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        snap = (String) in.readObject();
        in.close();
        fileIn.close();
        System.out.printf("Data Retrieved");
        return snap;
	}
	
}
