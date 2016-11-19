package aufgabenblatt7;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class GraphParser {

	static final String outputEncoding = "UTF-8";
	
	public static void parseFromFile(String filename, Graph graph) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File(filename));
		
		Element root = doc.getDocumentElement();
		
		if (!root.getNodeName().equals("graph")) {
			throw new Exception("root element is not 'graph'.");
		}
		
		for (int i = 0; i < root.getChildNodes().getLength(); ++i) {
			
			Node elem = root.getChildNodes().item(i);
			if (elem.getNodeType() != 1) {
				continue;
			}
			if (!elem.getNodeName().equals("vertex")) {
				throw new Exception("direct child of 'graph' is not a vertex: " + elem.getNodeName());
			}
			
			int vertexId = Integer.parseInt(elem.getAttributes().getNamedItem("id").getNodeValue());
			
			Map<Integer, Integer> neighbors = new HashMap<Integer, Integer>();
			
			for (int j = 0; j < elem.getChildNodes().getLength(); j++) {
				
				Node neighbor = elem.getChildNodes().item(j);
				if (neighbor.getNodeType() != 1) {
					continue;
				}
				if (!neighbor.getNodeName().equals("neighbor")) {
					throw new Exception("direct child of 'vertex' is not a neighbor: " + elem.getNodeName());
				}
				
				int neighborId = Integer.parseInt(neighbor.getAttributes().getNamedItem("id").getNodeValue());
				int distance = Integer.parseInt(neighbor.getAttributes().getNamedItem("weight").getNodeValue());
				
				neighbors.put(neighborId, distance);
				
			}
			
			graph.addVertex(vertexId, neighbors);
			
		}
		
	}
	
	
	public static void saveToFile(Graph graph, String filename) throws Exception {
		//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//DocumentBuilder db = dbf.newDocumentBuilder();
		//Document doc = db.newDocument();
		
		PrintWriter out = new PrintWriter(new File(filename));
		
		out.println("<graph>");
		
		for (int vertexId : graph.getVertices()) {
			out.println("   <vertex id=\"" + vertexId + "\">");
			
			for (int neighbor : graph.getNeighborsOf(vertexId)) {
				int weight = graph.getWeightBetween(vertexId, neighbor);
				out.println("      <neighbor id=\"" + neighbor + "\" weight=\"" + weight + "\"/>");
			}
			
			out.println("   </vertex>");
		}
		
		out.println("</graph>");
		
		out.close();
	}
	
}