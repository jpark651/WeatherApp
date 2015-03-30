package team19.weatherapp;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShortTermPanel extends JPanel {
	private static JLabel lblSTCity;
	private static ArrayList<JLabel> shortTermHours, shortTermLabels, shortTermIcons;
	private static JLabel lbl1stHr, lbl2ndHr, lbl3rdHr, lbl4thHr, lbl5thHr, lbl6thHr, lbl7thHr, lbl8thHr;
	private static JLabel lbl1stHrTemp, lbl2ndHrTemp, lbl3rdHrTemp, lbl4thHrTemp, lbl5thHrTemp, lbl6thHrTemp, 
							lbl7thHrTemp, lbl8thHrTemp;
	private static JLabel lbl1stHrSkyIcon, lbl2ndHrSkyIcon, lbl3rdHrSkyIcon, lbl4thHrSkyIcon, lbl5thHrSkyIcon, 
							lbl6thHrSkyIcon, lbl7thHrSkyIcon, lbl8thHrSkyIcon;
	private static JLabel lbl1stHrSkyCondition, lbl2ndHrSkyCondition, lbl3rdHrSkyCondition, lbl4thHrSkyCondition,
							lbl5thHrSkyCondition, lbl6thHrSkyCondition, lbl7thHrSkyCondition, lbl8thHrSkyCondition;
	String cityid;

	public ShortTermPanel(){
		initLabels();
		this.initUI();
	}
	
	public void update(City city, char tempUnits){
		if (city.validate != true) {
			lblSTCity.setText("City Not Found");
			for(JLabel l : shortTermLabels){
				l.setText("");
			}
			for(JLabel l : shortTermIcons){
				l.setVisible(false);
			}
		} else {
			this.cityid = city.shortTermForecast.getCityid();
			lblSTCity.setText(city.shortTermForecast.fullCityName);
			lbl1stHr.setText(city.shortTermForecast.timeList.get(0));
			lbl2ndHr.setText(city.shortTermForecast.timeList.get(1));
			lbl3rdHr.setText(city.shortTermForecast.timeList.get(2));
			lbl4thHr.setText(city.shortTermForecast.timeList.get(3));
			lbl5thHr.setText(city.shortTermForecast.timeList.get(4));
			lbl6thHr.setText(city.shortTermForecast.timeList.get(5));
			lbl7thHr.setText(city.shortTermForecast.timeList.get(6));
			lbl8thHr.setText(city.shortTermForecast.timeList.get(7));
			lbl1stHrTemp.setText(city.shortTermForecast.temperatureList.get(0)+"°"+tempUnits);
			lbl2ndHrTemp.setText(city.shortTermForecast.temperatureList.get(1)+"°"+tempUnits);
			lbl3rdHrTemp.setText(city.shortTermForecast.temperatureList.get(2)+"°"+tempUnits);
			lbl4thHrTemp.setText(city.shortTermForecast.temperatureList.get(3)+"°"+tempUnits);
			lbl5thHrTemp.setText(city.shortTermForecast.temperatureList.get(4)+"°"+tempUnits);
			lbl6thHrTemp.setText(city.shortTermForecast.temperatureList.get(5)+"°"+tempUnits);
			lbl7thHrTemp.setText(city.shortTermForecast.temperatureList.get(6)+"°"+tempUnits);
			lbl8thHrTemp.setText(city.shortTermForecast.temperatureList.get(7)+"°"+tempUnits);
			lbl1stHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(0));
			lbl2ndHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(1));
			lbl3rdHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(2));
			lbl4thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(3));
			lbl5thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(4));
			lbl6thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(5));
			lbl7thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(6));
			lbl8thHrSkyIcon.setIcon(city.shortTermForecast.skyIconList.get(7));
			for(JLabel l : shortTermIcons){
				l.setVisible(true);
			}
			lbl1stHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(0));
			lbl2ndHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(1));
			lbl3rdHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(2));
			lbl4thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(3));
			lbl5thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(4));
			lbl6thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(5));
			lbl7thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(6));
			lbl8thHrSkyCondition.setText(city.shortTermForecast.skyConditionList.get(7));
		}
	}
	
	private void initUI(){
		GridBagLayout gbl= new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		this.setLayout(gbl);
		
		this.insertStrut('V', 20, 0, 0, 5, 5, 2, 0);
		this.insertJLabelIntoGrid(lblSTCity, 6, 0, 0, 5, 5, 2, 1, true);
		this.insertStrut('H', 20, 0, 0, 5, 5, 0, 2);
		this.insertStrut('H', 20, 0, 0, 5, 5, 4, 3);
		this.insertStrut('H', 20, 0, 0, 5, 5, 5, 3);
		this.insertStrut('H', 20, 0, 0, 5, 5, 6, 3);
		
		this.insertJLabelIntoGrid(lbl1stHr, 0, 0, 0, 5, 5, 2, 2, true);
		this.insertJLabelIntoGrid(lbl1stHrSkyIcon, 0, 0, 0, 5, 5, 2, 3, false);
		this.insertJLabelIntoGrid(lbl1stHrSkyCondition, 2, 0, 0, 5, 5, 2, 4, true);
		lbl1stHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl1stHrTemp, 0, 0, 0, 5, 5, 3, 3, false);
		
		this.insertJLabelIntoGrid(lbl2ndHr, 0, 0, 0, 5, 5, 2, 5, true);
		this.insertJLabelIntoGrid(lbl2ndHrSkyIcon, 0, 0, 0, 5, 5, 2, 6, false);
		this.insertJLabelIntoGrid(lbl2ndHrSkyCondition, 2, 0, 0, 5, 5, 2, 7, true);
		lbl2ndHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl2ndHrTemp, 0, 0, 0, 5, 5, 3, 6, false);
		
		this.insertJLabelIntoGrid(lbl3rdHr, 0, 0, 0, 5, 5, 2, 8, true);
		this.insertJLabelIntoGrid(lbl3rdHrSkyIcon, 0, 0, 0, 5, 5, 2, 9, false);
		this.insertJLabelIntoGrid(lbl3rdHrSkyCondition, 2, 0, 0, 5, 5, 2, 10, true);
		lbl3rdHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl3rdHrTemp, 0, 0, 0, 5, 5, 3, 9, false);

		this.insertJLabelIntoGrid(lbl4thHr, 0, 0, 0, 5, 5, 2, 11, true);
		this.insertJLabelIntoGrid(lbl4thHrSkyIcon, 0, 0, 0, 0, 5, 2, 12, false);
		this.insertJLabelIntoGrid(lbl4thHrSkyCondition, 2, 0, 0, 5, 5, 2, 13, true);
		lbl4thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl4thHrTemp, 0, 0, 0, 5, 5, 3, 12, false);
		
		this.insertJLabelIntoGrid(lbl5thHr, 0, 0, 0, 5, 5, 7, 2, true);
		this.insertJLabelIntoGrid(lbl5thHrSkyIcon, 0, 0, 0, 5, 5, 7, 3, false);
		this.insertJLabelIntoGrid(lbl5thHrSkyCondition, 2, 0, 0, 5, 5, 7, 4, true);
		lbl5thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl5thHrTemp, 0, 0, 0, 5, 5, 8, 3, false);
		
		this.insertJLabelIntoGrid(lbl6thHr, 0, 0, 0, 5, 5, 7, 5, true);
		this.insertJLabelIntoGrid(lbl6thHrSkyIcon, 0, 0, 0, 5, 5, 7, 6, false);
		this.insertJLabelIntoGrid(lbl6thHrSkyCondition, 2, 0, 0, 5, 5, 7, 7, true);
		lbl6thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl6thHrTemp, 0, 0, 0, 5, 0, 8, 6, false);

		this.insertJLabelIntoGrid(lbl7thHr, 0, 0, 0, 5, 5, 7, 8, true);
		this.insertJLabelIntoGrid(lbl7thHrSkyIcon, 0, 0, 0, 5, 5, 7, 9, false);
		this.insertJLabelIntoGrid(lbl7thHrSkyCondition, 2, 0, 0, 5, 5, 7, 10, true);
		lbl7thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl7thHrTemp, 0, 0, 0, 5, 5, 8, 9, false);
		
		this.insertJLabelIntoGrid(lbl8thHr, 0, 0, 0, 5, 5, 7, 11, true);
		this.insertJLabelIntoGrid(lbl8thHrSkyIcon, 0, 0, 0, 5, 5, 7, 12, false);
		this.insertJLabelIntoGrid(lbl8thHrSkyCondition, 2, 0, 0, 5, 5, 7, 13, true);
		lbl8thHrTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl8thHrTemp, 0, 0, 0, 5, 5, 8, 12, false);
	}
	
	private static void initLabels(){
		lblSTCity = new JLabel("Enter the name of a city");
		lblSTCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		shortTermLabels = new ArrayList<JLabel>();
		shortTermIcons = new ArrayList<JLabel>();
		shortTermHours = new ArrayList<JLabel>();
		shortTermHours.add(lbl1stHr = new JLabel());
		shortTermHours.add(lbl2ndHr = new JLabel());
		shortTermHours.add(lbl3rdHr = new JLabel());
		shortTermHours.add(lbl4thHr = new JLabel());
		shortTermHours.add(lbl5thHr = new JLabel());
		shortTermHours.add(lbl6thHr = new JLabel());
		shortTermHours.add(lbl7thHr = new JLabel());
		shortTermHours.add(lbl8thHr = new JLabel());
		for(JLabel l : shortTermHours){
			l.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		}
		shortTermLabels.add(lbl1stHr);
		shortTermLabels.add(lbl2ndHr);
		shortTermLabels.add(lbl3rdHr);
		shortTermLabels.add(lbl4thHr);
		shortTermLabels.add(lbl5thHr);
		shortTermLabels.add(lbl6thHr);
		shortTermLabels.add(lbl7thHr);
		shortTermLabels.add(lbl8thHr);
		shortTermLabels.add(lbl1stHrTemp = new JLabel());
		shortTermLabels.add(lbl2ndHrTemp = new JLabel());
		shortTermLabels.add(lbl3rdHrTemp = new JLabel());
		shortTermLabels.add(lbl4thHrTemp = new JLabel());
		shortTermLabels.add(lbl5thHrTemp = new JLabel());
		shortTermLabels.add(lbl6thHrTemp = new JLabel());
		shortTermLabels.add(lbl7thHrTemp = new JLabel());
		shortTermLabels.add(lbl8thHrTemp = new JLabel());
		shortTermIcons.add(lbl1stHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl2ndHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl3rdHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl4thHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl5thHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl6thHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl7thHrSkyIcon = new JLabel());
		shortTermIcons.add(lbl8thHrSkyIcon = new JLabel());
		shortTermLabels.add(lbl1stHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl2ndHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl3rdHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl4thHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl5thHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl6thHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl7thHrSkyCondition = new JLabel());
		shortTermLabels.add(lbl8thHrSkyCondition = new JLabel());
	}
	
	private void insertJLabelIntoGrid(JLabel label, int gridwidth, 
			int inset1, int inset2, int inset3, int inset4, int gridx, 
			int gridy, boolean anchor){
		GridBagConstraints gbc = new GridBagConstraints();
		if(anchor)
			gbc.anchor = GridBagConstraints.WEST;
		if(gridwidth != 0)
			gbc.gridwidth = gridwidth;
		gbc.insets = new Insets(inset1, inset2, inset3, inset4);
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		this.add(label, gbc);
	}
	
	private void insertStrut(char strutType, int strutSize,
			int inset1, int inset2, int inset3, int inset4, 
			int gridx, int gridy){
		Component strut;
		if(strutType == 'H')
			strut = Box.createHorizontalStrut(strutSize);
		else
			strut = Box.createVerticalStrut(strutSize);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(inset1, inset2, inset3, inset4);
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		this.add(strut, gbc);
	}

//	public static void main (String[] args){
//	
//	
//		SwingUtilities.invokeLater(new Runnable() {
//		public void run(){
//			JFrame window = new JFrame();
//			window.setSize(700,550);
//			window.setLocationRelativeTo(null);
//			
//			ShortTermPanel pnl = new ShortTermPanel();
//			window.add(pnl);
//			window.setVisible(true);
//			}
//		});
//	}
}
