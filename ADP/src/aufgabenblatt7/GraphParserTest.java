package aufgabenblatt7;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphParserTest {

	@Test
	public void testParseFromFile() {
		Graph g = new LinkedGraph();
		try {
			GraphParser.parseFromFile("template.xml", g);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	
		assertTrue(g.hasVertex(1));
		assertTrue(g.hasVertex(2));
		assertTrue(g.hasVertex(3));
		assertTrue(g.hasEdge(1, 2));
		assertTrue(g.hasEdge(1, 3));
		assertTrue(g.hasEdge(2, 1));
		assertTrue(g.hasEdge(2, 3));
		assertTrue(g.hasEdge(3, 1));
		assertTrue(g.hasEdge(3, 2));
		assertEquals(g.getWeightBetween(1, 2), 7);
		assertEquals(g.getWeightBetween(2, 3), 6);
		assertEquals(g.getWeightBetween(1, 3), 8);
		
		try {
			GraphParser.saveToFile(g, "template_out.xml");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}