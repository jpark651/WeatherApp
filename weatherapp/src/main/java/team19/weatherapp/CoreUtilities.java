package team19.weatherapp;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CoreUtilities {
	public static ImageIcon getImage(final String pathAndFileName) throws IOException {
	    final java.net.URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    BufferedImage img = ImageIO.read(url);
		ImageIcon icon = new ImageIcon(img);
	    return icon; 
	}
}
