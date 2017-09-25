package com.laszlo.szoboszlai.trainsexpress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.laszlo.szoboszlai.trainsexpress.model.GraphRouteBuilder;
import com.laszlo.szoboszlai.trainsexpress.model.Station;
import com.laszlo.szoboszlai.trainsexpress.view.RouteFinderGUI;
import com.laszlo.szoboszlai.trainsexpress.view.RouteFinderView;

/**
 * Controller class for the route finder application to handle bussiness logic.
 * @author Laszlo Szoboszlai
 */
public class RouteFinderGUIController {
	
	private RouteFinderGUI theView;
	private GraphRouteBuilder theModel;
	
	public RouteFinderGUIController(RouteFinderView theView, GraphRouteBuilder theModel){
		try{
		   this.theView = (RouteFinderGUI) theView;
		   this.theModel = (GraphRouteBuilder) theModel;
		   this.theView.findRouteListener(new FindRouteListener());
		}
		catch(ClassCastException ex){
		this.theView.displayErrorMsg("Exception : Wrong model or view used!");
		}
	};
	
	/**
	 * Inner class to implement the find button actionlistener. Talks to the model to find the path
	 * and passes it back to the view. 
	 * @author Laszlo Szoboszlai
	 *
	 */
	class FindRouteListener implements ActionListener{
		String fromStation;
		String toStation;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				fromStation = theView.getFromStation();
				toStation = theView.getToStation();
				List<Station> response = theModel.findPath(fromStation, toStation);
				theView.setTheRoute(response.toString());
			}
			catch(Exception e){
				//Error displayed in the view if any error occures durig finding the path
				theView.displayErrorMsg("Error occured during finding route!");
			}	
		}
	}
}
