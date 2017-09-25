package playground;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;
/**
 * Playing around with the Jgraph module
 * @author Laszlo Szoboszlai
 *
 */
public class GraphPlayGround {
	public static void main(String[] args) {
		
	 DirectedWeightedPseudograph<Station, DefaultWeightedEdge> graph = createGraph();
	 System.out.println(graph);
	 DijkstraShortestPath<Station, String> alg = new  DijkstraShortestPath(graph);
	 Station c = new Station("C");
	 Station e = new Station("E");
	 GraphPath path = DijkstraShortestPath.findPathBetween(graph, c, e);
	 //GraphPath path = alg.getPath(b, d);
	 System.out.println(path.getVertexList());
	}
   
   private static DirectedWeightedPseudograph<Station, DefaultWeightedEdge> createGraph(){
	   DirectedWeightedPseudograph<Station, DefaultWeightedEdge> graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);

		   Station a = new Station("A");
		   Station b = new Station("B");
		   Station c = new Station("C");
		   Station d = new Station("D");
		   Station e = new Station("E");
		   
		   graph.addVertex(a);
		   graph.addVertex(b);
		   graph.addVertex(c);
		   graph.addVertex(d);
		   graph.addVertex(e);
		   
		   graph.setEdgeWeight(graph.addEdge(c,b), 2.5);
		   graph.setEdgeWeight(graph.addEdge(b,a), 2);
		   graph.setEdgeWeight(graph.addEdge(a,e), 2);
		   graph.setEdgeWeight(graph.addEdge(b, e),5);
		   /*  graph.addEdge(b, c);
		   graph.addEdge(c, d);
		   graph.addEdge(d, e);
		   graph.addEdge(e, d);
		   graph.addEdge(d, c);
		   graph.addEdge(d, b);
		   graph.addEdge(c, e);
		   
		   
		
		   graph.setEdgeWeight("ab", 3);
		   graph.setEdgeWeight("ba", 3);
		   graph.setEdgeWeight("ad", 6);
		   graph.setEdgeWeight("bc", 7);
		   graph.setEdgeWeight("cd", 8);
		   graph.setEdgeWeight("de", 9);
		   graph.setEdgeWeight("ed", 9);
		   graph.setEdgeWeight("cd", 9);
		   graph.setEdgeWeight("db", 5);
		   graph.setEdgeWeight("ce", 3);
		   */
		  	   
	  return graph;
   }
}
