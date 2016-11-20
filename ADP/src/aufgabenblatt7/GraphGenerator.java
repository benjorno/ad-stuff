package aufgabenblatt7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {
	
	
	public static void generateRandomGraph(int nVertices, Graph graph) {
		
		assert nVertices >= 10 : "Vorbedingung verletzt: nVertices >= 10";
		
		for (int i = 0; i < nVertices; ++i) {
			graph.addKnot(i);
		}
		
		int[] nConnectionsPerElem = new int[nVertices];
		List<Integer> remainingVertices = new ArrayList<Integer>();
		
		for (int i = 0; i < nVertices; ++i) {
			nConnectionsPerElem[i] = ThreadLocalRandom.current().nextInt(20) + 1;
			remainingVertices.add(i);
		}
		
		for (int i = 0; i < nVertices; ++i) {
			for (int j = 0; j < nConnectionsPerElem[i]; ++j) {
				if (remainingVertices.isEmpty()) {
					break;
				}
				int e = i;
				while (e == i || nConnectionsPerElem[e] <= 0) {
					e = remainingVertices.get(ThreadLocalRandom.current().nextInt(remainingVertices.size()));
				}
				int weight = ThreadLocalRandom.current().nextInt(99) + 1;
				graph.addConnection(i, e, weight);
				nConnectionsPerElem[e]--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int n = 10; n <= 10000; n *= 10) {
			System.out.println("N = " + n + ": ArrayGraph:");
			Graph g = new ArrayGraph();
			generateRandomGraph(n, g);
			Dykstra dyk = new Dykstra(g);
			long time = System.nanoTime();
			dyk.doDykstra(0);
			long dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
			
		}
		for (int n = 10; n <= 100000; n *= 10) {
			System.out.println("N = " + n + ": ArrayGraph:");
			Graph g = new ArrayGraph();
			generateRandomGraph(n, g);
			Dykstra dyk = new Dykstra(g);
			long time = System.nanoTime();
			dyk.doDykstra(0);
			long dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
		}
		
	}
	

}
