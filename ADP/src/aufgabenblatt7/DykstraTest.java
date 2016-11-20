package aufgabenblatt7;

import static org.junit.Assert.*;

import org.junit.Test;

public class DykstraTest {

	@Test
	public void testDykstra() {
		Graph g = new GraphWrapper(new ArrayGraph());
		g.addKnot('A');
		g.addKnot('B');
		g.addKnot('C');
		g.addKnot('D');
		g.addKnot('E');
		g.addKnot('F');
		g.addKnot('G');
		g.addConnection('A', 'B', 4);
		g.addConnection('A', 'G', 5);
		g.addConnection('A', 'F', 10);
		g.addConnection('B', 'G', 2);
		g.addConnection('G', 'F', 4);
		g.addConnection('B', 'C', 7);
		g.addConnection('C', 'G', 1);
		g.addConnection('G', 'E', 8);
		g.addConnection('F', 'E', 3);
		g.addConnection('C', 'D', 12);
		g.addConnection('D', 'E', 4);
		
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
