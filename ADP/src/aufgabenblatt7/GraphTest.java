package aufgabenblatt7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testAddVertex() {
		testAddVertexAbstract(new LinkedGraph());
		testAddVertexAbstract(new ArrayGraph());
	}
	
	private void testAddVertexAbstract(Graph g) {
		g.addVertex(1);
		assertTrue("", g.hasVertex(1));
	}
	
	@Test
	public void testRemoveVertex() {
		testRemoveVertexAbstract(new LinkedGraph());
		//testRemoveVertexAbstract(new ArrayGraph());
	}
	
	private void testRemoveVertexAbstract(Graph g) {
		g.addVertex(1);
		g.removeVertex(1);
		assertFalse("", g.hasVertex(1));
	}
	
	@Test
	public void testAddEdge() {
		testAddEdgeAbstract(new LinkedGraph());
		testAddEdgeAbstract(new ArrayGraph());
	}
	
	private void testAddEdgeAbstract(Graph g) {
		g.addVertex(1);
		g.addVertex(2);
		g.addEdge(1, 2, 7);
		assertTrue("", g.hasEdge(1, 2));
		assertTrue("", g.hasEdge(2, 1));
		assertEquals("", g.getWeightBetween(1, 2), 7);
		assertEquals("", g.getWeightBetween(2, 1), 7);
	}
	
	@Test
	public void testRemoveEdge() {
		testRemoveEdgeAbstract(new LinkedGraph());
		testRemoveEdgeAbstract(new ArrayGraph());
	}
	
	private void testRemoveEdgeAbstract(Graph g) {
		g.addVertex(1);
		g.addVertex(2);
		g.addEdge(1, 2, 7);
		g.removeEdge(1, 2);
		assertFalse("", g.hasEdge(1, 2));
		assertFalse("", g.hasEdge(2, 1));
	}
	
	@Test
	public void testGetNeighborsOf() {
		testGetNeighborsOfAbstract(new LinkedGraph());
		testGetNeighborsOfAbstract(new ArrayGraph());
	}
	
	private void testGetNeighborsOfAbstract(Graph g) {
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(1, 2, 7);
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 7);
		g.addEdge(1, 5, 7);
		List<Integer> neighbors = g.getNeighborsOf(1);
		assertEquals("", neighbors.size(), 4);
		assertTrue("", neighbors.contains(2));
		assertTrue("", neighbors.contains(3));
		assertTrue("", neighbors.contains(4));
		assertTrue("", neighbors.contains(5));
	}
	
	
	@Test
	public void testGetWeightBetween() {
		testGetWeightBetweenAbstract(new LinkedGraph());
		testGetWeightBetweenAbstract(new ArrayGraph());
	}
	
	private void testGetWeightBetweenAbstract(Graph g) {
		g.addVertex(1);
		g.addVertex(2);
		g.addEdge(1, 2, 19);
		assertEquals("", g.getWeightBetween(1, 2), 19);
	}

}
