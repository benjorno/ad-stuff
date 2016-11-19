package aufgabenblatt7;

import static org.junit.Assert.*;

import org.junit.Test;

public class DykstraTest {

	@Test
	public void testDykstra() {
		Graph g = new GraphWrapper(new LinkedGraph());
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addEdge('A', 'B', 4);
		g.addEdge('A', 'G', 5);
		g.addEdge('A', 'F', 10);
		g.addEdge('B', 'G', 2);
		g.addEdge('G', 'F', 4);
		g.addEdge('B', 'C', 7);
		g.addEdge('C', 'G', 1);
		g.addEdge('G', 'E', 8);
		g.addEdge('F', 'E', 3);
		g.addEdge('C', 'D', 12);
		g.addEdge('D', 'E', 4);
		
		Dykstra dykstra = new Dykstra(g);
		dykstra.doDykstra('A');
		
		assertEquals("", dykstra.getDistanceFrom('A'), 0);
		assertEquals("", dykstra.getDistanceFrom('B'), 4);
		assertEquals("", dykstra.getDistanceFrom('C'), 6);
		assertEquals("", dykstra.getDistanceFrom('D'), 16);
		assertEquals("", dykstra.getDistanceFrom('E'), 12);
		assertEquals("", dykstra.getDistanceFrom('F'), 9);
		assertEquals("", dykstra.getDistanceFrom('G'), 5);
		
		assertEquals("", dykstra.getNextStep('A'), 'A');
		assertEquals("", dykstra.getNextStep('B'), 'A');
		assertEquals("", dykstra.getNextStep('C'), 'G');
		assertEquals("", dykstra.getNextStep('D'), 'E');
		assertEquals("", dykstra.getNextStep('E'), 'F');
		assertEquals("", dykstra.getNextStep('F'), 'G');
		assertEquals("", dykstra.getNextStep('G'), 'A');
	}

}
