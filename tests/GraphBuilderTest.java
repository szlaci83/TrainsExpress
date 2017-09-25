import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.laszlo.szoboszlai.trainsexpress.model.GraphConnector;
import com.laszlo.szoboszlai.trainsexpress.model.GraphRouteBuilder;
import com.laszlo.szoboszlai.trainsexpress.model.Route;
import com.laszlo.szoboszlai.trainsexpress.model.Station;

/**
 * Unit test to test the functionality of the GraphBuilder class.
 * 
 * Functionalities tested:
 *  - create new route in the graph from Route object.
 *  - build the route graph from a List of Route objects.
 *  - find path in the graph
 *  
 * @author Laszlo Szoboszlai
 */
public class GraphBuilderTest {
	@Test
	public void test() {
	}
	
	public List<Route> createRoutes(){
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
	
	
	@Test
	public void testCreate(){
		GraphRouteBuilder dao = new GraphRouteBuilder();
		
		Station A = new Station("A");
		Station B = new Station("B");
		Station C = new Station("C");
		//Station which is not added to graph to check not containing.
		Station G = new Station("G");
		
		Route route1 = new Route(A, B, 3);
		Route route2 = new Route(B, C, 7);
		
		dao.AddRoute(GraphConnector.getInstance().getGraph(), route1);
		dao.AddRoute(GraphConnector.getInstance().getGraph(), route2);
		
		//Check Vertexes
		assertTrue("A should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(A));
		assertTrue("B should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(B));
		assertTrue("C should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(C));
		assertFalse("D should not be in graph.",GraphConnector.getInstance().getGraph().containsVertex(G));
		
		//Check edges 
		assertTrue("Edge A->B should be in graph", GraphConnector.getInstance().getGraph().containsEdge(A, B));
		assertTrue("Edge B->C should be in graph",GraphConnector.getInstance().getGraph().containsEdge(B, C));
		
		//Check weights - Not working with JAR
		//assertTrue("Weight of route A->B should be 3", GraphConnector.getInstance().getGraph().getEdgeWeight(route1.toString()) == 3.0);
		//assertTrue("Weight of route B->C should be 7", GraphConnector.getInstance().getGraph().getEdgeWeight(route2.toString()) == 7.0);
	}
	
	@Test
	public void TestBuildGraph(){
		GraphRouteBuilder dao = new GraphRouteBuilder();
		Route DE = new Route("D", "E", 9);
		Route CE = new Route("C", "E", 3);
		//create list to feed the buildgraph method
		List<Route> list = new ArrayList<Route>();
		list.add(new Route("B", "A", 3));
		list.add(new Route("A", "D", 6));
		list.add(new Route("C", "D", 8));
		list.add(DE);
		list.add(new Route("E", "D", 9));
		list.add(new Route("D", "C", 9));
		list.add(new Route("D", "B", 5));
		list.add(CE);
		
		dao.buildGraph(list);
		Station A = new Station("A");
		Station B = new Station("B");
		Station C = new Station("C");
		
		//Check Vertexes
		assertTrue("A should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(A));
		assertTrue("B should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(B));
		assertTrue("C should be in graph.",GraphConnector.getInstance().getGraph().containsVertex(C));
				
		//Check edges 
		assertTrue("Edge A->B should be in graph", GraphConnector.getInstance().getGraph().containsEdge(A, B));
		assertTrue("Edge B->C should be in graph",GraphConnector.getInstance().getGraph().containsEdge(B, C));

	}
	
	@Test
	public void TestFindPath(){
		GraphRouteBuilder dao = new GraphRouteBuilder();
		dao.buildGraph(createRoutes());
		Station A = new Station("A");
		Station E = new Station("E");
		
		assertEquals("The route from A to E should be [A, B, C, E]",dao.findPath(A, E).toString(),"[A, B, C, E]");
		assertEquals("The route from E to A should be [E, D, B, A]",dao.findPath(E, A).toString(),"[E, D, B, A]");
	}

}
