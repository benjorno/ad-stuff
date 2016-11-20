package aufgabenblatt4;

import org.junit.Test;

public class InsertionsortTest {
	public IList createListe() {
		return new AList2();
	}

	int listSize = 10000;

	@Test
	public void testInsertionsort() {
		int numberOfIterations = 100;
		long timerStart, timerStop, timerDifference;
		timerStart = System.nanoTime();
		for (int i = 0; i < numberOfIterations; i++) {
			IList liste = this.createListe();
			liste.listeMitZufallszahlen(listSize);
			liste.insertionSort();
		}
		timerStop = System.nanoTime();
		timerDifference = (timerStop - timerStart) / 1000000000;
		System.out.println("Count Insertionsort\n");
		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
				+ " itertions.");
	}
	
	@Test
	public void testInsertionsortSecond() {
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
			liste.insertionSort();
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
		System.out.println("Count Insertionsort\n");
		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
				+ " itertions.");
		System.out.println("Min: "+ min);
		System.out.println("Max: "+ max);
		System.out.println("Avg: "+ avg);
	}
}
