package aufgabenblatt7;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphWrapper implements Graph {

	private long counter;
	private Graph graph;

	public GraphWrapper(Graph graph) {
		this.graph = graph;
	}

	public void resetCounter() {
		counter = 0;
	}

	public long getCounter() {
		return counter;
	}

	@Override
	public void addKnot(int vertexId, Map<Integer, Integer> neighbors) {
		graph.addKnot(vertexId, neighbors);
			// O(1)
			counter++;
	}

	@Override
	public void addKnot(int vertexId) {
		graph.addKnot(vertexId);
			// O(1)
			counter++;
	}

	@Override
	public boolean hasKnot(int vertexId) {
			// O(1)
			counter++;
		return graph.hasKnot(vertexId);
	}

	@Override
	public Set<Integer> getKnots() {
			// O(1)
			counter++;
		return graph.getKnots();
	}

	@Override
	public void removeKnot(int vertexId) {
		graph.removeKnot(vertexId);

	}

	@Override
	public void addConnection(int vertexId1, int vertexId2, int weight) {
			// O(1)
			counter++;
		graph.addConnection(vertexId1, vertexId2, weight);

	}

	@Override
	public boolean hasConnection(int vertexId1, int vertexId2) {
			// O(1)
			counter++;
		return graph.hasConnection(vertexId1, vertexId2);

	}

	@Override
	public void removeConnection(int vertexId1, int vertexId2) {
			// O(1)
			counter++;
		graph.removeConnection(vertexId1, vertexId2);

	}

	@Override
	public List<Integer> getNeighborsOf(int vertexId) {
			// O(1)
			counter += graph.getKnots().size();
		return graph.getNeighborsOf(vertexId);

	}

	@Override
	public int getWeightBetween(int vertexId1, int vertexId2) {
			// O(1)
			counter++;
		return graph.getWeightBetween(vertexId1, vertexId2);

	}


}
