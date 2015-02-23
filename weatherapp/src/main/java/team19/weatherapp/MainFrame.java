package team19.weatherapp;

//testing
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;

import org.json.JSONObject;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;


//MainWindow Class
public class MainFrame extends JFrame {
	MainPanel mp = null;
	MainPanel n = null;

	//MainWindow Constructor
	public MainFrame() throws IOException {
		/*
		try
	      {
			mp = new MainPanel(Serialize.restore());
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	 		mp = new MainPanel("");
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("MainPanel Not Found");
	         c.printStackTrace();
	 		 mp = new MainPanel("");
	      }*/
		mp = new MainPanel("");
		
		getContentPane().add(mp, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
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
		        	Serialize.saveOnExit(mp.txtLocation.getText());
		        	System.out.println(mp.txtLocation.getText());
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        }
		    }
		});
	}
	
}
