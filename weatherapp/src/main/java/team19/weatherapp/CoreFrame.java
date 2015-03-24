package team19.weatherapp;

import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoreFrame extends JFrame{

	public CoreFrame() throws IOException {

		JPanel corePanel = new JPanel();
		corePanel.setLayout(null);
		
		
		ImageIcon icnBg = CoreUtilities.getImage("bgImageBevel.png");
		ImageIcon icnCurrentTab = CoreUtilities.getImage("currentTab.png");
		ImageIcon icnCurrentTabHover = CoreUtilities.getImage("currentTabHover.png");
		ImageIcon icnCurrentTabPressed = CoreUtilities.getImage("currentTabPressed.png");
		ImageIcon icnShortTermTab = CoreUtilities.getImage("shortTermTab.png");
		ImageIcon icnShortTermTabHover = CoreUtilities.getImage("shortTermTabHover.png");
		ImageIcon icnShortTermTabPressed = CoreUtilities.getImage("shortTermTabPressed.png");
		ImageIcon icnLongTermTab = CoreUtilities.getImage("longTermTab.png");
		ImageIcon icnLongTermTabHover = CoreUtilities.getImage("longTermTabHover.png");
		ImageIcon icnLongTermTabPressed = CoreUtilities.getImage("longTermTabPressed.png");

		
		
		JLabel lblBg = new JLabel();
		JButton lblCurrentTab = new JButton();
		JButton lblShortTermTab = new JButton();
		JButton lblLongTermTab = new JButton();
		
		lblCurrentTab.setBorderPainted(false);
		
		lblBg.setIcon(icnBg);
		lblCurrentTab.setIcon(icnCurrentTab);
		lblCurrentTab.setRolloverIcon(icnCurrentTabHover);
		lblCurrentTab.setPressedIcon(icnCurrentTabPressed);
		lblShortTermTab.setIcon(icnShortTermTab);
		lblLongTermTab.setIcon(icnLongTermTab);
		
		corePanel.add(lblBg);
		corePanel.add(lblCurrentTab);
		corePanel.add(lblShortTermTab);
		corePanel.add(lblLongTermTab);

		
		lblBg.setBounds(0, 0, 500, 800);
		lblCurrentTab.setBounds(5, 68, 158, 66);
		lblShortTermTab.setBounds(224, 86, 50, 30);
		lblLongTermTab.setBounds(391, 86, 50, 30);
		
		
		corePanel.setComponentZOrder(lblCurrentTab,0);
		corePanel.setComponentZOrder(lblShortTermTab,1);
		corePanel.setComponentZOrder(lblLongTermTab,2);
		corePanel.setComponentZOrder(lblBg,3);


		
		
		

		this.add(corePanel);
		this.setUndecorated(true);

		
        this.pack();
        
	}
}
