package aufgabenblatt7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class ArrayGraph implements Graph {

	//private int[] knotenliste;
	private Map<Integer, Integer> knotenliste;
	private int[][] adjazenzmatrix;
	private int maxAnzahl;
	private int anzahl;

	public ArrayGraph() {
		int groesse = 100;
		maxAnzahl = groesse;
		anzahl = 0;
		//knotenliste = new int[groesse];
		knotenliste = new HashMap<Integer, Integer>();
		adjazenzmatrix = new int[groesse][groesse];
		for (int i = 0; i < groesse; i++) {
			for (int j = 0; j < groesse; j++) {
				adjazenzmatrix[i][j] = 0;
			}
		}
	}

	private void resizeArray(int size) {
		int[][] tmp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i < anzahl && j < anzahl) {
					tmp[i][j] = adjazenzmatrix[i][j];
				} else {
					tmp[i][j] = 0;
				}
			}
		}
		
		maxAnzahl = size;
		adjazenzmatrix = tmp;
	}

	@Override
	public void addVertex(int vertexId, Map<Integer, Integer> neighbors) {

		assert !hasVertex(vertexId) : "Vorbedingung verletzt: !hasVertex(vertexId)";

		addVertex(vertexId);
		for (int i : neighbors.keySet()) {
			addEdge(vertexId, i, neighbors.get(i));
		}
	}

	@Override
	public void addVertex(int vertexId) {

		if (anzahl >= maxAnzahl) {
			resizeArray(maxAnzahl * 2);
		}

		//knotenliste[anzahl] = vertexId;
		knotenliste.put(vertexId, anzahl);
		anzahl++;

	}

	@Override
	public boolean hasVertex(int vertexId) {
		/*boolean hasVertex = false;
		for (int i = 0; i < anzahl; i++) {
			if (knotenliste[i] == vertexId) {
				hasVertex = true;
			}
		}
		return hasVertex;*/
		return knotenliste.containsKey(vertexId);
	}

	@Override
	public Set<Integer> getVertices() {
		// Array --> Set
		/*Set<Integer> ret = new HashSet<>();
		for (int i : knotenliste) {
			ret.add(i);
		}

		return ret;*/
		return knotenliste.keySet();
	}

	@Override
	public void removeVertex(int vertexId) {

		assert hasVertex(vertexId) : "Vorbedingung verletzt: hasVertex(vertexId)";

		// not implemented
	}

	@Override
	public void addEdge(int vertexId1, int vertexId2, int weight) {

		assert hasVertex(vertexId1) && hasVertex(vertexId2) : "Vorbedingung verletzt: hasVertex(vertexId1) && hasVertex(vertexId2)";
		assert weight >= 0 : "Vorbedingung verletzt: weight >= 0";
		assert !hasEdge(vertexId1, vertexId2);

		int i = knotenliste.get(vertexId1);
		int j = knotenliste.get(vertexId2);
		if (i != -1 && j != -1) {
			adjazenzmatrix[i][j] = weight;
			adjazenzmatrix[j][i] = weight;
		}
	}

	@Override
	public boolean hasEdge(int vertexId1, int vertexId2) {

		assert hasVertex(vertexId1) && hasVertex(vertexId2) : "Vorbedingung verletzt: hasVertex(vertexId1) && hasVertex(vertexId2)";

		boolean hasEdge = false;
		int i = knotenliste.get(vertexId1);
		int j = knotenliste.get(vertexId2);
		if (adjazenzmatrix[i][j] != 0) {
			hasEdge = true;
		}
		return hasEdge;
	}

	@Override
	public void removeEdge(int vertexId1, int vertexId2) {

		assert hasEdge(vertexId1, vertexId2);

		int i = knotenliste.get(vertexId1);
		int j = knotenliste.get(vertexId2);
		adjazenzmatrix[i][j] = 0;
		adjazenzmatrix[j][i] = 0;
	}

	@Override
	public List<Integer> getNeighborsOf(int vertexId) {

		assert hasVertex(vertexId) : "Vorbedingung verletzt: hasVertex(vertexId)";

		List<Integer> neighbors = new ArrayList<Integer>();

		int i = knotenliste.get(vertexId);
		for (int j = 0; j < anzahl; j++) {
			if (adjazenzmatrix[i][j] != 0) {
				//neighbors.add(knotenliste.);
				for (Map.Entry<Integer, Integer> e : knotenliste.entrySet()) {
					//if (Object.equals(new Integer(j), e.getValue()));
					if (e.getValue().equals(new Integer(j))) {
						neighbors.add(e.getKey());
					}
				}
			}
		}
		return neighbors;
	}

	@Override
	public int getWeightBetween(int vertexId1, int vertexId2) {

		assert hasEdge(vertexId1, vertexId2) : "Vorbedingung verletzt: hasEdge(vertexId1, vertexId2)";

		//int i = findIndex(vertexId1);
		//int j = findIndex(vertexId2);
		int i = knotenliste.get(vertexId1);
		int j = knotenliste.get(vertexId2);
		return adjazenzmatrix[i][j];
	}

	//private int findIndex(int vertexId) {
		//int index = -1;
		//int i = 0;
		/*while (index < 0 && i < knotenliste.length) {
			if (knotenliste[i] == vertexId) {
				index = i;
			}
			i++;
		}*/
		//return knotenliste
		//return index;
	//}

}