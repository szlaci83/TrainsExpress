package com.laszlo.szoboszlai.trainsexpress;

import com.laszlo.szoboszlai.trainsexpress.model.CSVRouteDAO;
import com.laszlo.szoboszlai.trainsexpress.model.GraphRouteBuilder;
import com.laszlo.szoboszlai.trainsexpress.view.RouteFinderGUI;

/**
 * Orchestrating class for the route finder application.
 * 
 * (JGraphT module under LGPL licence used for this solution.
 * http://jgrapht.org/)
 * 
 * @author Laszlo Szoboszlai
 */

public class TrainsExpressApp {
	public static void main(String[] args) {
	GraphRouteBuilder theModel = new GraphRouteBuilder();
	theModel.buildGraph(CSVRouteDAO.getRoutes());
    RouteFinderGUI theView = new RouteFinderGUI();
    //Pass the View and Model objects to the controller
    RouteFinderGUIController theController = new RouteFinderGUIController(theView, theModel);
    theView.setVisible(true);
	}
}
