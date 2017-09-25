package com.laszlo.szoboszlai.trainsexpress.model;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

/**
 * Class to realise connection with the Route objects and the graph representation.
 * 
 * @author Laszlo Szoboszlai
 *
 */
public class GraphRouteBuilder {
	/**
	 * Method to add a single Route object to the graph.
	 * NOTE: made public only to get tests passed.
	 * @param graph The graph we want to add the route to.
	 * @param route The actual route we like to add.
	 */
	public void AddRoute(DirectedWeightedPseudograph<Station, DefaultWeightedEdge> graph, Route route){
		Station fromStation = route.getFromStation();
		Station toStation = route.getToStation();
		String routeName = route.toString();
		double routeTime = route.getTime();
		
		graph.addVertex(fromStation); 
		graph.addVertex(toStation);
		graph.setEdgeWeight(graph.addEdge( fromStation, toStation ), routeTime);
	}	
	
	/**
	 * Method to add a List of Route objects to the graph 
	 * @param routeList List of Route objects.
	 */
	public void buildGraph(List<Route> routeList){
		for(Route routeItem: routeList){
		     AddRoute(GraphConnector.getInstance().getGraph(), routeItem);					
		}
	}
	
	/**
	 * Method to find a path between two given Station objects.
	 * @param fromStation The Station we want the path from.
	 * @param toStation The Station we want the path to.
	 * @return List of Stations between the two given stations.
	 */
	public List<Station> findPath(Station fromStation, Station toStation){
		DijkstraShortestPath<Station, DefaultWeightedEdge> searchAlgorithm = new DijkstraShortestPath<Station, DefaultWeightedEdge>(GraphConnector.getInstance().getGraph());
		GraphPath<Station, DefaultWeightedEdge> path = searchAlgorithm.getPath(fromStation, toStation);		
	 	return path.getVertexList();	
	}
	
	/**
	 * Method to be able to pass only Strings in order to find Stations.
	 * @param fromStation The station's name we want the path from.
	 * @param toStation The station's name we want the path to.
	 * @return List of Stations between the two given stations.
	 */
	public List<Station> findPath(String from, String to){
		return findPath(new Station(from), new Station(to));
	}

}
