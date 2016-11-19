package aufgabenblatt7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkedGraph implements Graph {
	
	private Map<Integer, Vertex> vertices;
	
	
	public LinkedGraph() {
		vertices = new HashMap<Integer, LinkedGraph.Vertex>();
	}
	

	@Override
	public void addVertex(int vertexId, Map<Integer, Integer> neighbors) {
		
		assert !hasVertex(vertexId) : "Vorbedingung verletzt: !hasVertex(vertexId)";
		
		Vertex vertex = new Vertex(vertexId, neighbors);
		vertices.put(vertexId, vertex);
		
	}
	
	@Override
	public void addVertex(int vertexId) {
		
		addVertex(vertexId, new HashMap<Integer, Integer>());
	}

	@Override
	public boolean hasVertex(int vertexId) {
		return vertices.containsKey(vertexId);
	}

	@Override
	public void removeVertex(int vertexId) {
		
		assert hasVertex(vertexId) : "Vorbedingung verletzt: hasVertex(vertexId)";
		
		for (int n : vertices.get(vertexId).getNeighbors().keySet()) {
			removeEdge(vertexId, n);
		}
		
		vertices.remove(vertexId);
		
	}
	
	@Override
	public Set<Integer> getVertices() {
		return vertices.keySet();
	}

	@Override
	public void addEdge(int vertexId1, int vertexId2, int weight) {
		
		assert hasVertex(vertexId1) && hasVertex(vertexId2) : "Vorbedingung verletzt: hasVertex(vertexId1) && hasVertex(vertexId2)";
		assert weight >= 0 : "Vorbedingung verletzt: weight >= 0";
		assert !hasEdge(vertexId1, vertexId2);
		
		vertices.get(vertexId1).addNeighbor(vertexId2, weight);
		vertices.get(vertexId2).addNeighbor(vertexId1, weight);
		
	}

	@Override
	public boolean hasEdge(int vertexId1, int vertexId2) {
		
		assert hasVertex(vertexId1) && hasVertex(vertexId2) : "Vorbedingung verletzt: hasVertex(vertexId1) && hasVertex(vertexId2)";

		return vertices.get(vertexId1).getNeighbors().containsKey(vertexId2);
		
	}

	@Override
	public void removeEdge(int vertexId1, int vertexId2) {
		
		assert hasEdge(vertexId1, vertexId2);
		
		vertices.get(vertexId1).getNeighbors().remove(vertexId2);
		vertices.get(vertexId2).getNeighbors().remove(vertexId1);
		
	}

	@Override
	public List<Integer> getNeighborsOf(int vertexId) {
		
		assert hasVertex(vertexId) : "Vorbedingung verletzt: hasVertex(vertexId)";
		
		return new ArrayList<Integer>(vertices.get(vertexId).getNeighbors().keySet());
	}

	@Override
	public int getWeightBetween(int vertexId1, int vertexId2) {
		
		assert hasEdge(vertexId1, vertexId2) : "Vorbedingung verletzt: hasEdge(vertexId1, vertexId2)";
		
		return vertices.get(vertexId1).getWeightTo(vertexId2);
		
	}
	
	private static class Vertex {
		private int id;
		private Map<Integer, Integer> neighbors;
		//private List<Integer> neighbors;
		//private List<Integer> weights;
		
		public Vertex(int id, Map<Integer, Integer> neighbors) {
			
			this.id = id;
			this.neighbors = neighbors;
		}
		
		
		public int getId() {
			return id;
		}
		
		public Map<Integer, Integer> getNeighbors() {
			return neighbors;
		}
		
		public int getWeightTo(int other) {
			assert neighbors.containsKey(other) : "Vorbedingung verletzt: neighbors.contains(other)";
			return neighbors.get(other);
		}
		
		
		public void addNeighbor(int neighbor, int weight) {
			assert !neighbors.containsKey(neighbor);
			neighbors.put(neighbor, weight);
		}
		
		
		public int hashCode() {
			return id;
		}
		
		public boolean equals(Object other) {
			if (other != null) {
				if (other instanceof Vertex) {
					if (((Vertex)other).getId() == id) {
						return true;
					}
				}
			}
			return false;
		}
	}

	

	

}

