package aufgabenblatt7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {
	
	
	public static void generateRandomGraph(int nVertices, Graph graph) {
		
		assert nVertices >= 10 : "Vorbedingung verletzt: nVertices >= 10";
		
		for (int i = 0; i < nVertices; ++i) {
			graph.addVertex(i);
		}
		
		int[] nEdgesPerElem = new int[nVertices];
		List<Integer> remainingVertices = new ArrayList<Integer>();
		
		for (int i = 0; i < nVertices; ++i) {
			nEdgesPerElem[i] = ThreadLocalRandom.current().nextInt(20) + 1;
			remainingVertices.add(i);
		}
		
		for (int i = 0; i < nVertices; ++i) {
			for (int j = 0; j < nEdgesPerElem[i]; ++j) {
				if (remainingVertices.isEmpty()) {
					break;
				}
				int e = i;
				while (e == i || nEdgesPerElem[e] <= 0) {
					e = remainingVertices.get(ThreadLocalRandom.current().nextInt(remainingVertices.size()));
				}
				int weight = ThreadLocalRandom.current().nextInt(99) + 1;
				graph.addEdge(i, e, weight);
				nEdgesPerElem[e]--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int n = 10; n <= 10000; n *= 10) {
			System.out.println("N = " + n + ": LinkedGraph:");
			Graph g = new LinkedGraph();
			generateRandomGraph(n, g);
			
			
			//GraphWrapper gw = new GraphWrapper(g);
			
			Dykstra dyk = new Dykstra(g);
			long time = System.nanoTime();
			dyk.doDykstra(0);
			long dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
			
			System.out.println("N = " + n + ": ArrayGraph:");
			g = new ArrayGraph();
			generateRandomGraph(n, g);
			
			//gw = new GraphWrapper(g);
			dyk = new Dykstra(g);
			time = System.nanoTime();
			dyk.doDykstra(0);
			dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
		}
		for (int n = 10; n <= 100000; n *= 10) {
			System.out.println("N = " + n + ": LinkedGraph:");
			Graph g = new LinkedGraph();
			generateRandomGraph(n, g);
			
			
			//GraphWrapper gw = new GraphWrapper(g);
			
			Dykstra dyk = new Dykstra(g);
			long time = System.nanoTime();
			dyk.doDykstra(0);
			long dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
			
			System.out.println("N = " + n + ": ArrayGraph:");
			g = new ArrayGraph();
			generateRandomGraph(n, g);
			
			//gw = new GraphWrapper(g);
			dyk = new Dykstra(g);
			time = System.nanoTime();
			dyk.doDykstra(0);
			dtime = System.nanoTime() - time;
			System.out.println("Aufwand: " + dtime);
		}
		/*for (int n = 10; n <= 10000; n *= 10) {
			System.out.println("N = " + n + ":");
			Graph lg = new LinkedGraph();
			Graph ag = new ArrayGraph();
			
			try {
				GraphParser.parseFromFile("graph" + n + ".xml", lg);
				GraphParser.parseFromFile("graph" + n + ".xml", ag);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			GraphWrapper gw = new GraphWrapper(lg);
			System.out.println("LinkedGraph: N=" + n);
			Dykstra dyk = new Dykstra(gw);
			dyk.doDykstra(0);
			
			gw = new GraphWrapper(ag);
			System.out.println("ArrayGraph: N=" + n);
			dyk = new Dykstra(gw);
			dyk.doDykstra(0);
		}*/
		
	}
	

}
