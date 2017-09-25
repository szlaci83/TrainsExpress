package com.laszlo.szoboszlai.trainsexpress.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * Class to enable the graph to be filled using a CSV file.
 * The CSV file is created by a Python script scraping the  
 * nationalrail.co.uk website for real route durations between stations.
 * 
 * CSV file structure:
 * from_station,to_station,duration
 * 
 * @author Laszlo Szoboszlai
 */
public class CSVRouteDAO implements RouteDAO{
	
	/**
	 * The getRoute method, which must be implemented by any 
	 * class implementing the RouteDAO interface in order to return a List 
	 * of Route objects.
	 *  
	 * @return The List of route objects created from CSV file.
	 */
	public static List getRoutes(){
	 List<Route> list = new ArrayList<Route>();	
	 
	 URL urlToCSV = CSVRouteDAO.class.getResource("durations.csv");
     BufferedReader br = null;
     String line = "";
  
     try {
         br = new BufferedReader(new FileReader(urlToCSV.getPath()));
         line = br.readLine(); 
         while ((line = br.readLine()) != null) {
             String[] entry = line.split(",");
             list.add(new Route(entry[0], entry[1], Integer.parseInt(entry[2])));
         }

     } catch (FileNotFoundException e) {
    	 System.out.println("CSV file not found!");
     } catch (IOException e) {
         System.out.println("IO exception during file read!");;
     } finally {
         if (br != null) {
             try {
                 br.close();
             } catch (IOException e) {
                 System.out.println("Error accured during closing the file!");;
             }
         }
     }
	return list;
	}
}
