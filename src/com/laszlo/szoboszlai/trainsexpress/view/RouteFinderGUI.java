package com.laszlo.szoboszlai.trainsexpress.view;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Simple GUI for the route finder application.
 * @author Laszlo Szoboszlai
 *
 */
public class RouteFinderGUI extends JFrame implements RouteFinderView{
	private static final long serialVersionUID = 1L;
	private JLabel fromLabel = new JLabel("From:");
	private JTextField fromStation = new JTextField(30);
	private JLabel toLabel = new JLabel("To:");
	private JTextField toStation = new JTextField(30);
	private JButton findButton = new JButton("Find route");
	private JLabel routeLabel = new JLabel("The Route:");
	private JTextField theRoute = new JTextField(10);
	private JLabel lblImageplaceholder = new JLabel("");
	private Image img = new ImageIcon(this.getClass().getResource("/trainSmall.jpg")).getImage();
	
	public RouteFinderGUI(){
		this.pack();
		this.setSize(550,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Trains Express route finder application");
		
		JPanel routeFinderPanel = new JPanel();
		routeFinderPanel.setLayout(null);
	
		lblImageplaceholder.setBounds(20, 10, 500, 210);
		lblImageplaceholder.setIcon(new ImageIcon(img));
		routeFinderPanel.add(lblImageplaceholder);
		
		fromLabel.setBounds(120, 260, 50, 15);
		routeFinderPanel.add(fromLabel);
		
		fromStation.setBounds(330, 260, 85, 20);
		routeFinderPanel.add(fromStation);
		
		toLabel.setBounds(120, 300, 50, 15);
		routeFinderPanel.add(toLabel);
		
		toStation.setBounds(330, 290, 85, 20);
		routeFinderPanel.add(toStation);
		
		findButton.setBounds(200, 330, 130, 25);
		routeFinderPanel.add(findButton);
		 
		routeLabel.setBounds(120, 390, 80, 15);
		routeFinderPanel.add(routeLabel);
		
		theRoute.setBounds(330, 380, 85, 20);
		routeFinderPanel.add(theRoute);
		
		this.add(routeFinderPanel);
	}
	
	public String getFromStation(){
		return fromStation.getText().toUpperCase();
	}
	
	public String getToStation(){
		return toStation.getText().toUpperCase();
	}
	
	public String getTheRoute(){
		return theRoute.getText();
	}
	
	public void setTheRoute(String response){
		theRoute.setText(response);
	}
	
	public void findRouteListener(ActionListener listenForFindRoute) {
		findButton.addActionListener(listenForFindRoute);
	}
	
	public void displayErrorMsg(String errorMsg){
		JOptionPane.showMessageDialog(this, errorMsg);
	}	
}
