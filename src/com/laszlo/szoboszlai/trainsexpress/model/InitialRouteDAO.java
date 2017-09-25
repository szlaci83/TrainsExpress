package com.laszlo.szoboszlai.trainsexpress.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data access class to create the initial state of the assessment.
 * @author Laszlo Szoboszlai
 *
 */
public class InitialRouteDAO implements RouteDAO{
	/**
	 * Method to create a list of the initial configuration (abstract set of train stations)
	 * mentioned in the assesment brief.
	 * @return List of Route objects representing the initial state according to assigment brief.
	 */
	public static List<Route> getRoutes(){
		List<Route> list = new ArrayList<Route>();
		list.add(new Route("A", "B", 3));
		list.add(new Route("B", "A", 3));
		list.add(new Route("A", "D", 6));
		list.add(new Route("B", "C", 7));
		list.add(new Route("C", "D", 8));
		list.add(new Route("D", "E", 9));
		list.add(new Route("E", "D", 9));
		list.add(new Route("D", "C", 9));
		list.add(new Route("D", "B", 5));
		list.add(new Route("C", "E", 3));
		return list;
	}
}
