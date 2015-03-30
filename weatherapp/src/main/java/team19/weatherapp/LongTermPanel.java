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

public class LongTermPanel extends JPanel{
	public static JLabel lblLTCity;
	public static ArrayList<JLabel> longTermDays;
	public static JLabel lbl1stDay, lbl2ndDay, lbl3rdDay, lbl4thDay, lbl5thDay;
	public static JLabel lbl1stDayTemp, lbl2ndDayTemp, lbl3rdDayTemp, lbl4thDayTemp, lbl5thDayTemp;
	public static JLabel lbl1stDayMinTemp,lbl2ndDayMinTemp, lbl3rdDayMinTemp, lbl4thDayMinTemp, lbl5thDayMinTemp;
	public static JLabel lbl1stDayMaxTemp, lbl2ndDayMaxTemp, lbl3rdDayMaxTemp, lbl4thDayMaxTemp, lbl5thDayMaxTemp;
	public static JLabel lbl1stDaySkyIcon, lbl2ndDaySkyIcon, lbl3rdDaySkyIcon, lbl4thDaySkyIcon, lbl5thDaySkyIcon;
	public static JLabel lbl1stDaySkyCondition, lbl2ndDaySkyCondition, lbl3rdDaySkyCondition, lbl4thDaySkyCondition, lbl5thDaySkyCondition;
	
	public LongTermPanel(){
		initLabels();
		this.initUI();
	}
	
	public void update(City city, char tempUnits){
		if (city.validate != true) {
			lblLTCity.setText("City Not Found");

		} else {
			lblLTCity.setText(city.shortTermForecast.fullCityName);
			lbl1stDay.setText(city.longTermForecast.dateList.get(0));
			lbl2ndDay.setText(city.longTermForecast.dateList.get(1));
			lbl3rdDay.setText(city.longTermForecast.dateList.get(2));
			lbl4thDay.setText(city.longTermForecast.dateList.get(3));
			lbl5thDay.setText(city.longTermForecast.dateList.get(4));
			lbl1stDayTemp.setText(city.longTermForecast.temperatureList.get(0)+"°"+tempUnits);
			lbl2ndDayTemp.setText(city.longTermForecast.temperatureList.get(1)+"°"+tempUnits);
			lbl3rdDayTemp.setText(city.longTermForecast.temperatureList.get(2)+"°"+tempUnits);
			lbl4thDayTemp.setText(city.longTermForecast.temperatureList.get(3)+"°"+tempUnits);
			lbl5thDayTemp.setText(city.longTermForecast.temperatureList.get(4)+"°"+tempUnits);
			lbl1stDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(0)+"°"+tempUnits);
			lbl2ndDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(1)+"°"+tempUnits);
			lbl3rdDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(2)+"°"+tempUnits);
			lbl4thDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(3)+"°"+tempUnits);
			lbl5thDayMinTemp.setText("Min: " + city.longTermForecast.minTempList.get(4)+"°"+tempUnits);
			lbl1stDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(0)+"°"+tempUnits);
			lbl2ndDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(1)+"°"+tempUnits);
			lbl3rdDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(2)+"°"+tempUnits);
			lbl4thDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(3)+"°"+tempUnits);
			lbl5thDayMaxTemp.setText("Max: " + city.longTermForecast.maxTempList.get(4)+"°"+tempUnits);
			lbl1stDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(0));
			lbl2ndDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(1));
			lbl3rdDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(2));
			lbl4thDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(3));
			lbl5thDaySkyIcon.setIcon(city.longTermForecast.skyIconList.get(4));
			lbl1stDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(0));
			lbl2ndDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(1));
			lbl3rdDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(2));
			lbl4thDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(3));
			lbl5thDaySkyCondition.setText(city.longTermForecast.skyConditionList.get(4));
		}
	}
	
	private static void initLabels(){
		lblLTCity = new JLabel("Enter the name of a city");
		lblLTCity.setFont(new Font("Helvetica Neue", Font.BOLD, 25));
		longTermDays = new ArrayList<JLabel>();
		longTermDays.add(lbl1stDay = new JLabel());
		longTermDays.add(lbl2ndDay = new JLabel());
		longTermDays.add(lbl3rdDay = new JLabel());
		longTermDays.add(lbl4thDay = new JLabel());
		longTermDays.add(lbl5thDay = new JLabel());
		for(JLabel l : longTermDays){
			l.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		}
		lbl1stDayTemp = new JLabel();
		lbl2ndDayTemp = new JLabel();
		lbl3rdDayTemp = new JLabel();
		lbl4thDayTemp = new JLabel();
		lbl5thDayTemp = new JLabel();
		lbl1stDayMinTemp = new JLabel();
		lbl2ndDayMinTemp = new JLabel();
		lbl3rdDayMinTemp = new JLabel();
		lbl4thDayMinTemp = new JLabel();
		lbl5thDayMinTemp = new JLabel();
		lbl1stDayMaxTemp = new JLabel();
		lbl2ndDayMaxTemp = new JLabel();
		lbl3rdDayMaxTemp = new JLabel();
		lbl4thDayMaxTemp = new JLabel();
		lbl5thDayMaxTemp = new JLabel();
		lbl1stDaySkyIcon = new JLabel();
		lbl2ndDaySkyIcon = new JLabel();
		lbl3rdDaySkyIcon = new JLabel();
		lbl4thDaySkyIcon = new JLabel();
		lbl5thDaySkyIcon = new JLabel();
		lbl1stDaySkyCondition = new JLabel();
		lbl2ndDaySkyCondition = new JLabel();
		lbl3rdDaySkyCondition = new JLabel();
		lbl4thDaySkyCondition = new JLabel();
		lbl5thDaySkyCondition = new JLabel();
	}
	
	private void initUI(){
		GridBagLayout gbl= new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		this.setLayout(gbl);
		
		this.insertJLabelIntoGrid(lblLTCity, 10, 0, 0, 5, 5, 1, 1, true);
		this.insertStrut('V', 20, 0, 0, 5, 5, 1, 0);
		this.insertStrut('V', 20, 0, 0, 5, 5, 1, 2);
		this.insertStrut('V', 20, 0, 0, 5, 5, 1, 4);
		this.insertStrut('V', 20, 0, 0, 5, 5, 1, 8);
		this.insertStrut('H', 20, 0 ,0 ,5, 5, 0, 1);
		this.insertStrut('H', 20, 0 ,0 ,5, 5, 2, 4);
		this.insertStrut('H', 20, 0 ,0 ,5, 5, 4, 4);
		this.insertStrut('H', 20, 0 ,0 ,5, 5, 6, 4);
		this.insertStrut('H', 20, 0 ,0 ,5, 5, 8, 4);
		
		this.insertJLabelIntoGrid(lbl1stDay, 0, 0, 0, 5, 5, 1, 3, false);
		this.insertJLabelIntoGrid(lbl1stDaySkyIcon, 0, 0, 0, 5, 5, 1, 5, false);
		lbl1stDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl1stDayTemp, 0, 0, 0, 5, 5, 1, 6, false);
		this.insertJLabelIntoGrid(lbl1stDaySkyCondition, 0, 0, 0, 5, 5, 1, 7, false);
		this.insertJLabelIntoGrid(lbl1stDayMinTemp, 0, 0, 0, 5, 5, 1, 9, false);
		this.insertJLabelIntoGrid(lbl1stDayMaxTemp, 0, 0, 0, 5, 5, 1, 10, false);
		
		this.insertJLabelIntoGrid(lbl2ndDay, 0, 0, 0, 5, 5, 3, 3, false);
		this.insertJLabelIntoGrid(lbl2ndDaySkyIcon, 0, 0, 0, 5, 5, 3, 5, false);
		lbl2ndDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl2ndDayTemp, 0, 0, 0, 5, 5, 3, 6, false);
		this.insertJLabelIntoGrid(lbl2ndDaySkyCondition, 0, 0, 0, 5, 5, 3, 7, false);
		this.insertJLabelIntoGrid(lbl2ndDayMinTemp, 0, 0, 0, 5, 5, 3, 9, false);
		this.insertJLabelIntoGrid(lbl2ndDayMaxTemp, 0, 0, 0, 5, 5, 3, 10, false);
		
		this.insertJLabelIntoGrid(lbl3rdDay, 0, 0, 0, 5, 5, 5, 3, false);
		this.insertJLabelIntoGrid(lbl3rdDaySkyIcon, 0, 0, 0, 5, 5, 5, 5, false);
		lbl3rdDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl3rdDayTemp, 0, 0, 0, 5, 5, 5, 6, false);
		this.insertJLabelIntoGrid(lbl3rdDaySkyCondition, 0, 0, 0, 5, 5, 5, 7, false);
		this.insertJLabelIntoGrid(lbl3rdDayMinTemp, 0, 0, 0, 5, 5, 5, 9, false);
		this.insertJLabelIntoGrid(lbl3rdDayMaxTemp, 0, 0, 0, 5, 5, 5, 10, false);
		
		this.insertJLabelIntoGrid(lbl4thDay, 0, 0, 0, 5, 5, 7, 3, false);
		this.insertJLabelIntoGrid(lbl4thDaySkyIcon, 0, 0, 0, 5, 5, 7, 5, false);
		lbl4thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl4thDayTemp, 0, 0, 0, 5, 5, 7, 6, false);
		this.insertJLabelIntoGrid(lbl4thDaySkyCondition, 0, 0, 0, 5, 5, 7, 7, false);
		this.insertJLabelIntoGrid(lbl4thDayMinTemp, 0, 0, 0, 5, 5, 7, 9, false);
		this.insertJLabelIntoGrid(lbl4thDayMaxTemp, 0, 0, 0, 5, 5, 7, 10, false);
		
		this.insertJLabelIntoGrid(lbl5thDay, 0, 0, 0, 5, 5, 9, 3, false);
		this.insertJLabelIntoGrid(lbl5thDaySkyIcon, 0, 0, 0, 5, 5, 9, 5, false);
		lbl5thDayTemp.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		this.insertJLabelIntoGrid(lbl5thDayTemp, 0, 0, 0, 5, 5, 9, 6, false);
		this.insertJLabelIntoGrid(lbl5thDaySkyCondition, 0, 0, 0, 5, 5, 9, 7, false);
		this.insertJLabelIntoGrid(lbl5thDayMinTemp, 0, 0, 0, 5, 5, 9, 9, false);
		this.insertJLabelIntoGrid(lbl5thDayMaxTemp, 0, 0, 0, 5, 5, 9, 10, false);
		
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
//			public void run(){
//				JFrame window = new JFrame();
//				window.setSize(700,550);
//				window.setLocationRelativeTo(null);
//				
//				LongTermPanel pnl = new LongTermPanel();
//				window.add(pnl);
//				window.setVisible(true);
//			}
//		});
//	}
	
}
