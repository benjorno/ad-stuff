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
	public void addVertex(int vertexId, Map<Integer, Integer> neighbors) {
		graph.addVertex(vertexId, neighbors);

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// TODO: inkrement counter
		}
	}

	@Override
	public void addVertex(int vertexId) {
		graph.addVertex(vertexId);

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}
	}

	@Override
	public boolean hasVertex(int vertexId) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		return graph.hasVertex(vertexId);
	}

	@Override
	public Set<Integer> getVertices() {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		return graph.getVertices();
	}

	@Override
	public void removeVertex(int vertexId) {

		if (graph instanceof LinkedGraph) {
			// O(N) mit N = Anzahl Nachbarn von vertexId
			counter += 1 + graph.getNeighborsOf(vertexId).size();
		} else if (graph instanceof ArrayGraph) {
			// TODO: inkrement counter
		}

		graph.removeVertex(vertexId);

	}

	@Override
	public void addEdge(int vertexId1, int vertexId2, int weight) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		graph.addEdge(vertexId1, vertexId2, weight);

	}

	@Override
	public boolean hasEdge(int vertexId1, int vertexId2) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		return graph.hasEdge(vertexId1, vertexId2);

	}

	@Override
	public void removeEdge(int vertexId1, int vertexId2) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		graph.removeEdge(vertexId1, vertexId2);

	}

	@Override
	public List<Integer> getNeighborsOf(int vertexId) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(N)
			counter += graph.getVertices().size();
		}

		return graph.getNeighborsOf(vertexId);

	}

	@Override
	public int getWeightBetween(int vertexId1, int vertexId2) {

		if (graph instanceof LinkedGraph) {
			// O(1)
			counter++;
		} else if (graph instanceof ArrayGraph) {
			// O(1)
			counter++;
		}

		return graph.getWeightBetween(vertexId1, vertexId2);

	}


}
