package aufgabenblatt4;

import org.junit.Test;

public class BubblesortTest {

	public IList createListe() {
		return new AList2();
	}

	int listSize = 10000;

	@Test
	public void testBubblesort() {
		int numberOfIterations = 100;
		long timerStart, timerStop, timerDifference;
		timerStart = System.nanoTime();
		for (int i = 0; i < numberOfIterations; i++) {
			IList liste = this.createListe();
			liste.listeMitZufallszahlen(listSize);
			liste.bubbleSort();
		}
		timerStop = System.nanoTime();
		timerDifference = (timerStop - timerStart) / 1000000000;
		System.out.println("Count Bubblesort\n");
		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
				+ " itertions.");
	}
	
	@Test
	public void testBubblesortSecond() {
		int numberOfIterations = 100;
		long timerStart, timerStop, timerDifference;
		long timerSecStart, timerSecStop, timerSecDiff;
		long min = 99999999;
		long max = 0;
		long avg = 0;
		timerStart = System.nanoTime();
		for (int i = 0; i < numberOfIterations; i++) {
			IList liste = this.createListe();
			liste.listeMitZufallszahlen(listSize);
			timerSecStart = System.nanoTime();
			liste.bubbleSort();
			timerSecStop = System.nanoTime();
			timerSecDiff = (timerSecStop - timerSecStart) / 1000000;
			avg += timerSecDiff;
			if(timerSecDiff<=min){
				min = timerSecDiff;
			}
			if(timerSecDiff>=max){
				max = timerSecDiff;
			}
			
		}
		timerStop = System.nanoTime();
		timerDifference = (timerStop - timerStart) / 1000000000;
		avg = avg / numberOfIterations;
		System.out.println("Count Bubblesort\n");
		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
				+ " itertions.");
		System.out.println("Min: "+ min);
		System.out.println("Max: "+ max);
		System.out.println("Avg: "+ avg);
	}
}
