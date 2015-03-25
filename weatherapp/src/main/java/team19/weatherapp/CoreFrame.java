package team19.weatherapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class CoreFrame extends JFrame{

	public CoreFrame() throws Exception {

		JLabel coreMotionComponent = new JLabel();
		
		CoreMotionPanel coreMotionPanel = new CoreMotionPanel(coreMotionComponent);
		coreMotionComponent.addMouseListener(coreMotionPanel);
		coreMotionComponent.addMouseMotionListener(coreMotionPanel);
		
		final JPanel corePanel = new JPanel();
		corePanel.setLayout(null);
		
		ImageIcon icnBg = CoreUtilities.getImage("bgImageBevel.png");
		final ImageIcon icnSearchBar = CoreUtilities.getImage("searchBar.png");
		final ImageIcon icnSearchBarPressed = CoreUtilities.getImage("searchBarPressed.png");
		final ImageIcon icnSearchButton = CoreUtilities.getImage("searchButton.png");
		final ImageIcon icnSearchButtonBlue = CoreUtilities.getImage("searchButtonBlue.png");
		final ImageIcon icnSearchButtonHover = CoreUtilities.getImage("searchButtonHover.png");
		final ImageIcon icnSearchButtonPressed = CoreUtilities.getImage("searchButtonPressed.png");
		final ImageIcon icnDrawerButton = CoreUtilities.getImage("drawerButton.png");
		final ImageIcon icnDrawerButtonHover = CoreUtilities.getImage("drawerButtonHover.png");
		final ImageIcon icnDrawerButtonPressed = CoreUtilities.getImage("drawerButtonPressed.png");
		final ImageIcon icnDrawerButtonExit = CoreUtilities.getImage("drawerButtonExit.png");
		final ImageIcon icnDrawerButtonExitHover = CoreUtilities.getImage("drawerButtonExitHover.png");
		final ImageIcon icnDrawerButtonExitPressed = CoreUtilities.getImage("drawerButtonExitPressed.png");
		ImageIcon icnExitButton = CoreUtilities.getImage("exitButton.png");
		ImageIcon icnExitButtonHover = CoreUtilities.getImage("exitButtonHover.png");
		ImageIcon icnExitButtonPressed = CoreUtilities.getImage("exitButtonPressed.png");
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
		final JLabel lblSearchBar = new JLabel();
		final JPanel pnlSidePanel = new JPanel();
		final JLabel lblDimmer = new JLabel();
		JLabel lblCurrentBg = new JLabel();
		ButtonGroup grpTabs = new ButtonGroup();
		final JToggleButton btnCurrentTab = new JToggleButton();
		final JToggleButton btnShortTermTab = new JToggleButton();
		final JToggleButton btnLongTermTab = new JToggleButton();
		final JButton btnSearchButton = new JButton();
		final JButton btnExitButton = new JButton();
		final JButton btnDrawerButton = new JButton();


		
		
		Font txtSearchFont = CoreUtilities.importFont("Roboto-Medium", 20);
		JTextField txtSearchBar = new JTextField();
		txtSearchBar.setBorder(new LineBorder(Color.BLACK, 0));
		txtSearchBar.setOpaque(false);
		txtSearchBar.setPreferredSize(new Dimension(60, 25));
		txtSearchBar.setFont(txtSearchFont);
		txtSearchBar.setForeground(new Color(80,80,80));

		
		txtSearchBar.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
               lblSearchBar.setIcon(icnSearchBarPressed);
               btnSearchButton.setIcon(icnSearchButtonBlue);
            }

            public void focusLost(FocusEvent e) {
                lblSearchBar.setIcon(icnSearchBar);
                btnSearchButton.setIcon(icnSearchButton);
            }
        });
		
		txtSearchBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Searched Text");
			}});	
		
		btnDrawerButton.addActionListener(new ActionListener() {
			boolean drawerOpen = false;
			public void actionPerformed(ActionEvent event) {
				if(drawerOpen){
	                btnDrawerButton.setIcon(icnDrawerButton);
	                btnDrawerButton.setRolloverIcon(icnDrawerButtonHover);
	                btnDrawerButton.setPressedIcon(icnDrawerButtonPressed);
	                pnlSidePanel.setVisible(false);
	                lblDimmer.setVisible(false);
	                btnCurrentTab.setEnabled(true);
		            btnShortTermTab.setEnabled(true);
		            btnLongTermTab.setEnabled(true);
		            btnSearchButton.setEnabled(true);
	                drawerOpen = false;
				}else{
					btnDrawerButton.setIcon(icnDrawerButtonExit);
		            btnDrawerButton.setRolloverIcon(icnDrawerButtonExitHover);
		            btnDrawerButton.setPressedIcon(icnDrawerButtonExitPressed);
		            pnlSidePanel.setVisible(true);
	                lblDimmer.setVisible(true);
		            btnCurrentTab.setEnabled(false);
		            btnShortTermTab.setEnabled(false);
		            btnLongTermTab.setEnabled(false);
		            btnSearchButton.setEnabled(false);
		            drawerOpen = true;
	               }
			}});
		
        pnlSidePanel.setVisible(false);
        lblDimmer.setVisible(false);

		
		btnSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Searched Button");
			}});	
		
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				 int confirm = JOptionPane.showOptionDialog(corePanel.getParent(),
	                        "Are You Sure to Close this Application?",
	                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE, null, null, null);
	                if (confirm == JOptionPane.YES_OPTION) {
	                		dispose();	     
	                		}
			
				}});	
		
		
		
		
		grpTabs.add(btnCurrentTab);
		grpTabs.add(btnShortTermTab);
		grpTabs.add(btnLongTermTab);

		btnCurrentTab.doClick();
		
		btnDrawerButton.setBorderPainted(false);
		btnExitButton.setBorderPainted(false);
		btnSearchButton.setBorderPainted(false);
		btnCurrentTab.setBorderPainted(false);
		btnShortTermTab.setBorderPainted(false);
		btnLongTermTab.setBorderPainted(false);

		
		
		
		btnDrawerButton.setIcon(icnDrawerButton);
		btnDrawerButton.setRolloverIcon(icnDrawerButtonHover);
		btnDrawerButton.setPressedIcon(icnDrawerButtonPressed);
		lblBg.setIcon(icnBg);
		btnExitButton.setIcon(icnExitButton);
		btnExitButton.setRolloverIcon(icnExitButtonHover);
		btnExitButton.setPressedIcon(icnExitButtonPressed);
		lblSearchBar.setIcon(icnSearchBar);
		lblCurrentBg.setOpaque(true);
		lblCurrentBg.setBackground(new Color(220,220,220));
		btnCurrentTab.setIcon(icnCurrentTab);
		btnCurrentTab.setDisabledIcon(icnCurrentTab);
		btnCurrentTab.setRolloverIcon(icnCurrentTabHover);
		btnCurrentTab.setPressedIcon(icnCurrentTabPressed);
		btnCurrentTab.setSelectedIcon(icnCurrentTabPressed);
		btnShortTermTab.setIcon(icnShortTermTab);
		btnShortTermTab.setDisabledIcon(icnShortTermTab);
		btnShortTermTab.setRolloverIcon(icnShortTermTabHover);
		btnShortTermTab.setPressedIcon(icnShortTermTabPressed);
		btnShortTermTab.setSelectedIcon(icnShortTermTabPressed);
		btnLongTermTab.setIcon(icnLongTermTab);
		btnLongTermTab.setDisabledIcon(icnLongTermTab);
		btnLongTermTab.setRolloverIcon(icnLongTermTabHover);
		btnLongTermTab.setPressedIcon(icnLongTermTabPressed);
		btnLongTermTab.setSelectedIcon(icnLongTermTabPressed);
		btnSearchButton.setIcon(icnSearchButton);
		btnSearchButton.setDisabledIcon(icnSearchButton);
		btnSearchButton.setRolloverIcon(icnSearchButtonHover);
		btnSearchButton.setPressedIcon(icnSearchButtonPressed);
		
		pnlSidePanel.setOpaque(true);
		pnlSidePanel.setBackground(new Color(180,180,180));
		lblDimmer.setOpaque(true);
		lblDimmer.setBackground(new Color(0,0,0,100));
		
		corePanel.add(lblBg);
		corePanel.add(coreMotionComponent);
		corePanel.add(lblSearchBar);
		corePanel.add(btnSearchButton);
		corePanel.add(txtSearchBar);
		corePanel.add(btnExitButton);
		corePanel.add(lblCurrentBg);
		corePanel.add(btnCurrentTab);
		corePanel.add(btnShortTermTab);
		corePanel.add(btnLongTermTab);
		corePanel.add(btnDrawerButton);
		corePanel.add(lblDimmer);
		corePanel.add(pnlSidePanel);


		
		coreMotionComponent.setBounds(0,0,500,68);
		lblBg.setBounds(0, 0, 500, 800);
		lblSearchBar.setBounds(16,742,472,44);
		btnSearchButton.setBounds(16,743,45,42);
		btnExitButton.setBounds(443,12,43,43);
		txtSearchBar.setBounds(70,742,406,44);
		lblCurrentBg.setBounds(5, 135, 490, 597);
		btnCurrentTab.setBounds(5, 68, 158, 66);
		btnShortTermTab.setBounds(163, 68, 174, 66);
		btnLongTermTab.setBounds(337, 68, 158, 66);
		btnDrawerButton.setBounds(17,20,30,28);
		pnlSidePanel.setBounds(5,67,380,728);
		lblDimmer.setBounds(5,67,490,728);
		
		corePanel.setComponentZOrder(btnDrawerButton,0);
		corePanel.setComponentZOrder(pnlSidePanel,1);
		corePanel.setComponentZOrder(lblDimmer,2);
		corePanel.setComponentZOrder(btnExitButton,3);
		corePanel.setComponentZOrder(coreMotionComponent,4);
		corePanel.setComponentZOrder(btnCurrentTab,5);
		corePanel.setComponentZOrder(btnShortTermTab,6);
		corePanel.setComponentZOrder(btnLongTermTab,7);
		corePanel.setComponentZOrder(btnSearchButton,8);
		corePanel.setComponentZOrder(txtSearchBar,9);
		corePanel.setComponentZOrder(lblSearchBar,10);
		corePanel.setComponentZOrder(lblCurrentBg,11);
		corePanel.setComponentZOrder(lblBg,12);


		
		
		

		this.add(corePanel);
		this.setUndecorated(true);

		
        this.pack();
        
	}
}
