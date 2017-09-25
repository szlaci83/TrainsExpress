package com.laszlo.szoboszlai.trainsexpress.model;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

/**
 * Singleton class realising connection to the weighted directed graph representation of the routes.
 *
 * @author Laszlo Szoboszlai
 */
public class GraphConnector {
    private DirectedWeightedPseudograph<Station, DefaultWeightedEdge> graph = new  DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
   
	private static GraphConnector instance = new GraphConnector();
	
	private GraphConnector(){	
	}
	
	public DirectedWeightedPseudograph<Station, DefaultWeightedEdge> getGraph() {
		return graph;
	}

	public static GraphConnector getInstance(){
		return instance;
	}
}
