package aufgabenblatt7;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph {

	/**
	 * Fügt einen Knoten in den Graphen ein.
	 * @param vertexId die Id des Knotens. Darf noch nicht im Graphen existieren
	 * @param neighbors Eine Menge aller Nachbarknoten und deren Gewichte, 
	 * 					diese müssen bereits im Graphen existieren
	 * @require !hasVertex(vertexId)
	 * @ensure hasVertex(vertexId)
	 */
	void addVertex(int vertexId, Map<Integer, Integer> neighbors);
	
	/**
	 * Fügt einen Knoten in den Graphen ein.
	 * @param vertexId die Id des Knotens. Darf noch nicht im Graphen existieren
	 * @require !hasVertex(vertexId)
	 * @ensure hasVertex(vertexId)
	 */
	void addVertex(int vertexId);
	
	/**
	 * Gibt an, ob ein Knoten mit dieser Id im Graphen existiert.
	 * @param vertexId der Knoten
	 * @return true wenn der Knoten existiert, sonst false
	 */
	boolean hasVertex(int vertexId);
	
	/**
	 * Gibt die Menge aller Knoten zurück.
	 * @return die Menge aller Knoten
	 */
	Set<Integer> getVertices();
	
	/**
	 * Entfernt einen Knoten aus diesem Graphen
	 * @param vertexId der zu entfernende Knoten
	 * @require hasVertex(vertexId)
	 * @ensure !hasVertex(vertexId)
	 */
	void removeVertex(int vertexId);
	
	/**
	 * Fügt eine Kante zum Graphen hinzu. Die Reihenfolge spielt keine Rolle.
	 * @param vertexId1 der erste Knoten
	 * @param vertexId2 der zweite Knoten
	 * @param weight das Gewicht der Kante
	 * @require hasVertex(vertexId1) && hasVertex(vertexId2)
	 * @require weight >= 0
	 * @require !hasEdge(vertexId1, vertexId2)
	 * @ensure getWeightBetween(vertexId1, vertexId2) == weight
	 */
	void addEdge(int vertexId1, int vertexId2, int weight);
	
	/**
	 * Gibt an, ob eine Kante zwischen zwei Knoten im Graphen existiert. Die Reihenfolge spielt keine Rolle.
	 * @param vertexId1 der erste Knoten
	 * @param vertexId2 der zweite Knoten
	 * @return true wenn die Kante existiert, sonst false
	 * @require hasVertex(vertexId1) && hasVertex(vertexId2)
	 */
	boolean hasEdge(int vertexId1, int vertexId2);
	
	/**
	 * Entfernt eine Kante vom Graphen. Die Reihenfolge spielt keine Rolle.
	 * @param vertexId1 der erste Knoten
	 * @param vertexId2 der zweite Knoten
	 * @require hasEdge(vertexId1, vertexId2)
	 * @ensure !hasEdge(vertexId1, vertexId2)
	 */
	void removeEdge(int vertexId1, int vertexId2);
	
	/**
	 * Gibt eine Liste aller Nachbarknoten eines Knotens zurück.
	 * @param vertexId der Knoten
	 * @return Liste der Ids der Nachbarknoten
	 * @require hasVertex(vertexId)
	 */
	List<Integer> getNeighborsOf(int vertexId);
	
	/**
	 * Gibt das Gewicht zwischen zwei Knoten zurück.
	 * @param vertexId1 der erste Knoten
	 * @param vertexId2 der zweite Knoten
	 * @return das Gewicht der Kante zwischen den Knoten
	 * @require hasEdga(vertexId1, vertexId2)
	 */
	int getWeightBetween(int vertexId1, int vertexId2);
}

