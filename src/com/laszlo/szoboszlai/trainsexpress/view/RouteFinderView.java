package com.laszlo.szoboszlai.trainsexpress.view;
/**
 * Interface to be implemented by the View classes of the route finder application.
 * 
 * @author Laszlo Szoboszlai
 */
public interface RouteFinderView {
	/**
	 * Method to get the starting station from the view.
	 * @return name of the station as a String of the start station of the path.
	 */
	public String getFromStation();
	
	/**
	 * Method to get the end station from the view.
	 * @return name of the station as a String of the end station of the path.
	 */
	public String getToStation();

	/**
	 * Method to set the path in the view.
	 * @param response The response received to the query. 
	 */
	public void setTheRoute(String response);
	
	/**
	 * Method to display any error occured during processing the query.
	 * @param errorMsg The String representation of the error message.
	 */
	public void displayErrorMsg(String errorMsg);
	
}
