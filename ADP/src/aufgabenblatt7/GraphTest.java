package aufgabenblatt7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testAddKnot() {
		testAddKnotAbstract(new ArrayGraph());
		testAddKnotAbstract(new ArrayGraph());
	}
	
	private void testAddKnotAbstract(Graph g) {
		g.addKnot(1);
		assertTrue("", g.hasKnot(1));
	}
	
	@Test
	public void testRemoveKnot() {
//		testRemoveKnotAbstract(new ArrayGraph());
	}
	
	private void testRemoveKnotAbstract(Graph g) {
		g.addKnot(1);
		g.removeKnot(1);
		assertFalse("", g.hasKnot(1));
	}
	
	@Test
	public void testAddConnection() {
		testAddConnectionAbstract(new ArrayGraph());
	}
	
	private void testAddConnectionAbstract(Graph g) {
		g.addKnot(1);
		g.addKnot(2);
		g.addConnection(1, 2, 7);
		assertTrue("", g.hasConnection(1, 2));
		assertTrue("", g.hasConnection(2, 1));
		assertEquals("", g.getWeightBetween(1, 2), 7);
		assertEquals("", g.getWeightBetween(2, 1), 7);
	}
	
	@Test
	public void testRemoveConnection() {
		testRemoveConnectionAbstract(new ArrayGraph());
	}
	
	private void testRemoveConnectionAbstract(Graph g) {
		g.addKnot(1);
		g.addKnot(2);
		g.addConnection(1, 2, 7);
		g.removeConnection(1, 2);
		assertFalse("", g.hasConnection(1, 2));
		assertFalse("", g.hasConnection(2, 1));
	}
	
	@Test
	public void testGetNeighborsOf() {
		testGetNeighborsOfAbstract(new ArrayGraph());
	}
	
	private void testGetNeighborsOfAbstract(Graph g) {
		g.addKnot(1);
		g.addKnot(2);
		g.addKnot(3);
		g.addKnot(4);
		g.addKnot(5);
		g.addConnection(1, 2, 7);
		g.addConnection(1, 3, 7);
		g.addConnection(1, 4, 7);
		g.addConnection(1, 5, 7);
		List<Integer> neighbors = g.getNeighborsOf(1);
		assertEquals("", neighbors.size(), 4);
		assertTrue("", neighbors.contains(2));
		assertTrue("", neighbors.contains(3));
		assertTrue("", neighbors.contains(4));
		assertTrue("", neighbors.contains(5));
	}
	
	
	@Test
	public void testGetWeightBetween() {
		testGetWeightBetweenAbstract(new ArrayGraph());
	}
	
	private void testGetWeightBetweenAbstract(Graph g) {
		g.addKnot(1);
		g.addKnot(2);
		g.addConnection(1, 2, 19);
		assertEquals("", g.getWeightBetween(1, 2), 19);
	}

}
