package team19.weatherapp;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CoreUtilities {
	public static ImageIcon getImage(final String pathAndFileName) throws IOException {
	    final java.net.URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    BufferedImage img = ImageIO.read(url);
		ImageIcon icon = new ImageIcon(img);
	    return icon; 
	}
	
	public static Font importFont(String fontname, int fontsize) throws Exception{
		InputStream myStream = new BufferedInputStream(new FileInputStream("src/resources/" + fontname + ".ttf"));
        Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);;
        font = font.deriveFont(Font.PLAIN,fontsize);
        return font;
	}
}



