package aufgabenblatt7;

import java.util.HashMap;
import java.util.Map;

public class Dykstra {
	
	private Graph graph;
	private Map<Integer, Node> nodes; // For each knot in graph there should be one Node
	
	public Dykstra(Graph graph) {
		this.graph = graph;
		nodes = new HashMap<Integer, Node>();
	}
	
	public void doDykstra(int destinationknot) {
		
		assert graph.hasKnot(destinationknot) : "Vorbedingung verletzt: graph.hasknot(destinationknot)";
		
		if (graph instanceof GraphWrapper) {
			((GraphWrapper)graph).resetCounter();
		}
		
		Node activeNode = new Node(destinationknot, destinationknot, 0, true);
		//	initialize Nodes
		nodes.clear();
		nodes.put(activeNode.getId(), activeNode);
		
		Map<Integer, Node> randknoten = new HashMap<Integer, Node>();
		
		while (true) {
			//	Füge randknoten hinzu
			for (int rk : graph.getNeighborsOf(activeNode.getId())) {
				if (!nodes.containsKey(rk) && !randknoten.containsKey(rk)) {
					randknoten.put(rk, new Node(rk, activeNode.getId(),
							activeNode.getDistance() + graph.getWeightBetween(rk, activeNode.getId()),
							false));
				}
			}
			
			//	Alle Randknoten über activeNode neu bewerten
			for (Node node : randknoten.values()) {
				if (graph.hasConnection(activeNode.getId(), node.getId())) {
					int distanceByActiveNode = activeNode.getDistance() + 
							graph.getWeightBetween(node.getId(), activeNode.getId());
					if (node.getDistance() > distanceByActiveNode) {
						node.setNextStep(activeNode.getId());
						node.setDistance(distanceByActiveNode);
					}
				}
			}
			
			//	Der beste Knoten ist der neue activeNode
			activeNode = null;
			for (Node node : randknoten.values()) {
				if (activeNode == null) {
					activeNode = node;
				} else if (activeNode.getDistance() > node.getDistance()) {
					activeNode = node;
				}
			}
			
			if (activeNode == null) {
				//	Keine Randknoten mehr. Abbrechen
				break;
			}
			
			activeNode.setMarked(true);
			nodes.put(activeNode.getId(), activeNode);
			randknoten.remove(activeNode.getId());
			
			//System.out.print("\rDykstra Progress: " + (100 * nodes.size() / graph.getVertices().size()) + "%");
			
		}
		
		//System.out.print("\r");
		
		if (graph instanceof GraphWrapper) {
			System.out.println("Dyktra complexity: " + ((GraphWrapper)graph).getCounter());
		}
	}
	
	public int getDistanceFrom(int startknot) {
		if (nodes.containsKey(startknot)) {
			return nodes.get(startknot).getDistance();
		}
		return -1;
	}
	
	public int getNextStep(int fromknot) {
		if (nodes.containsKey(fromknot)) {
			return nodes.get(fromknot).getNextStep();
		}
		return -1;
	}
	
	private static class Node {
		private int id;
		private int nextStep;
		private int distance;
		private boolean marked;
		
		public Node(int id, int nextStep, int distance, boolean marked) {
			this.id = id;
			this.nextStep = nextStep;
			this.distance = distance;
			this.marked = marked;
		}
		
		public int getId() {
			return id;
		}
		
		public int getNextStep() {
			return nextStep;
		}
		
		public int getDistance() {
			return distance;
		}
		
		public boolean isMarked() {
			return marked;
		}
		
		public void setNextStep(int ns) {
			nextStep = ns;
		}
		
		public void setDistance(int d) {
			distance = d;
		}
		
		public void setMarked(boolean m) {
			marked = m;
		}
		
		public int hashCode() {
			return id;
		}
		
		public boolean equals(Object other) {
			if (other != null) {
				if (other instanceof Node) {
					if (((Node)other).getId() == id) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
