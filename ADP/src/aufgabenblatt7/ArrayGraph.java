package aufgabenblatt7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class ArrayGraph implements Graph {

	// private int[] knotenliste;
	private Map<Integer, Integer> knotenliste;
	private int[][] adjazenzmatrix;
	private int maxAnzahl;
	private int anzahl;

	public ArrayGraph() {
		int groesse = 100;
		maxAnzahl = groesse;
		anzahl = 0;
		// knotenliste = new int[groesse];
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
	public void addKnot(int knotId, Map<Integer, Integer> neighbors) {

		assert !hasKnot(knotId) : "Vorbedingung verletzt: !hasKnot(knotId)";

		addKnot(knotId);
		for (int i : neighbors.keySet()) {
			addConnection(knotId, i, neighbors.get(i));
		}
	}

	@Override
	public void addKnot(int knotId) {

		if (anzahl >= maxAnzahl) {
			resizeArray(maxAnzahl * 2);
		}

		// knotenliste[anzahl] = knotId;
		knotenliste.put(knotId, anzahl);
		anzahl++;

	}

	@Override
	public boolean hasKnot(int knotId) {
		return knotenliste.containsKey(knotId);
	}

	@Override
	public Set<Integer> getKnots() {
		// Array --> Set
		/*
		 * Set<Integer> ret = new HashSet<>(); for (int i : knotenliste) {
		 * ret.add(i); }
		 * 
		 * return ret;
		 */
		return knotenliste.keySet();
	}

	@Override
	public void removeKnot(int knotId) {

		assert hasKnot(knotId) : "Vorbedingung verletzt: hasKnot(knotId)";

		// not implemented
	}

	@Override
	public void addConnection(int knotId1, int knotId2, int weight) {

		assert hasKnot(knotId1)
				&& hasKnot(knotId2) : "Vorbedingung verletzt: hasKnot(knotId1) && hasKnot(knotId2)";
		assert weight >= 0 : "Vorbedingung verletzt: weight >= 0";
		assert !hasConnection(knotId1, knotId2);

		int i = knotenliste.get(knotId1);
		int j = knotenliste.get(knotId2);
		if (i != -1 && j != -1) {
			adjazenzmatrix[i][j] = weight;
			adjazenzmatrix[j][i] = weight;
		}
	}

	@Override
	public boolean hasConnection(int knotId1, int knotId2) {
		assert hasKnot(knotId1)
				&& hasKnot(knotId2) : "Vorbedingung verletzt: hasKnot(knotId1) && hasKnot(knotId2)";
		boolean hasConnection = false;
		int i = knotenliste.get(knotId1);
		int j = knotenliste.get(knotId2);
		if (adjazenzmatrix[i][j] != 0) {
			hasConnection = true;
		}
		return hasConnection;
	}

	@Override
	public void removeConnection(int knotId1, int knotId2) {
		assert hasConnection(knotId1, knotId2);
		int i = knotenliste.get(knotId1);
		int j = knotenliste.get(knotId2);
		adjazenzmatrix[i][j] = 0;
		adjazenzmatrix[j][i] = 0;
	}

	@Override
	public List<Integer> getNeighborsOf(int knotId) {

		assert hasKnot(knotId) : "Vorbedingung verletzt: hasKnot(knotId)";

		List<Integer> neighbors = new ArrayList<Integer>();

		int i = knotenliste.get(knotId);
		for (int j = 0; j < anzahl; j++) {
			if (adjazenzmatrix[i][j] != 0) {
				// neighbors.add(knotenliste.);
				for (Map.Entry<Integer, Integer> e : knotenliste.entrySet()) {
					// if (Object.equals(new Integer(j), e.getValue()));
					if (e.getValue().equals(new Integer(j))) {
						neighbors.add(e.getKey());
					}
				}
			}
		}
		return neighbors;
	}

	@Override
	public int getWeightBetween(int knotId1, int knotId2) {

		assert hasConnection(knotId1, knotId2) : "Vorbedingung verletzt: hasEdge(knotId1, knotId2)";
		int i = knotenliste.get(knotId1);
		int j = knotenliste.get(knotId2);
		return adjazenzmatrix[i][j];
	}

}