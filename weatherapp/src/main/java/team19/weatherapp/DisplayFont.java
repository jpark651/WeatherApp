package team19.weatherapp;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DisplayFont {
		public static void main(String[] args) throws Exception {
	    	InputStream myStream = new BufferedInputStream(new FileInputStream("src/resources/Roboto-Medium.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);;
	        font = font.deriveFont(Font.PLAIN,20);
	        GraphicsEnvironment ge =
	            GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(font);

	        JLabel l = new JLabel(
	            "The quick brown fox jumped over the lazy dog. 0123456789");
	        l.setFont(font);
	        JOptionPane.showMessageDialog(null, l);
	    }
	
}
