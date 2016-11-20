package aufgabenblatt7;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph {

	/**
	 * Fügt einen Knoten in den Graphen ein.
	 * @param knotId die Id des Knotens. Darf noch nicht im Graphen existieren
	 * @param neighbors Eine Menge aller Nachbarknoten und deren Gewichte, 
	 * 					diese müssen bereits im Graphen existieren
	 * @require !hasknot(knotId)
	 * @ensure hasknot(knotId)
	 */
	void addKnot(int knotId, Map<Integer, Integer> neighbors);
	
	/**
	 * Fügt einen Knoten in den Graphen ein.
	 * @param knotId die Id des Knotens. Darf noch nicht im Graphen existieren
	 * @require !hasknot(knotId)
	 * @ensure hasknot(knotId)
	 */
	void addKnot(int knotId);
	
	/**
	 * Gibt an, ob ein Knoten mit dieser Id im Graphen existiert.
	 * @param knotId der Knoten
	 * @return true wenn der Knoten existiert, sonst false
	 */
	boolean hasKnot(int knotId);
	
	/**
	 * Gibt die Menge aller Knoten zurück.
	 * @return die Menge aller Knoten
	 */
	Set<Integer> getKnots();
	
	/**
	 * Entfernt einen Knoten aus diesem Graphen
	 * @param knotId der zu entfernende Knoten
	 * @require hasknot(knotId)
	 * @ensure !hasknot(knotId)
	 */
	void removeKnot(int knotId);
	
	/**
	 * Fügt eine Kante zum Graphen hinzu. Die Reihenfolge spielt keine Rolle.
	 * @param knotId1 der erste Knoten
	 * @param knotd2 der zweite Knoten
	 * @param weight das Gewicht der Kante
	 * @require hasknot(knotId1) && hasknot(knotId2)
	 * @require weight >= 0
	 * @require !hasEdge(knotId1, knotId2)
	 * @ensure getWeightBetween(knotId1, knotId2) == weight
	 */
	void addConnection(int knotId1, int knotd2, int weight);
	
	/**
	 * Gibt an, ob eine Kante zwischen zwei Knoten im Graphen existiert. Die Reihenfolge spielt keine Rolle.
	 * @param knotId1 der erste Knoten
	 * @param knotId2 der zweite Knoten
	 * @return true wenn die Kante existiert, sonst false
	 * @require hasknot(knotId1) && hasknot(knotId2)
	 */
	boolean hasConnection(int knotId1, int knotId2);
	
	/**
	 * Entfernt eine Kante vom Graphen. Die Reihenfolge spielt keine Rolle.
	 * @param knotId1 der erste Knoten
	 * @param knotId2 der zweite Knoten
	 * @require hasEdge(knotId1, knotId2)
	 * @ensure !hasEdge(knotId1, knotId2)
	 */
	void removeConnection(int knotId1, int knotId2);
	
	/**
	 * Gibt eine Liste aller Nachbarknoten eines Knotens zurück.
	 * @param knotId der Knoten
	 * @return Liste der Ids der Nachbarknoten
	 * @require hasknot(knotId)
	 */
	List<Integer> getNeighborsOf(int knotId);
	
	/**
	 * Gibt das Gewicht zwischen zwei Knoten zurück.
	 * @param knotId1 der erste Knoten
	 * @param knotId2 der zweite Knoten
	 * @return das Gewicht der Kante zwischen den Knoten
	 * @require hasEdga(knotId1, knotId2)
	 */
	int getWeightBetween(int knotId1, int knotId2);
}

