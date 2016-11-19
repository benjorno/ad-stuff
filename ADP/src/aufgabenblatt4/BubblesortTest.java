package aufgabenblatt4;

import org.junit.Test;

public class BubblesortTest {

	public IList createListe() {
		return new AList2();
	}

	int listSize = 10000;

	@Test
	public void testeBubblesort() {
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
}
