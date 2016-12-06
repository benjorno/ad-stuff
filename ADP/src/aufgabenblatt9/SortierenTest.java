package aufgabenblatt9;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import aufgabenblatt4.IList;

public class SortierenTest {

	int numberOfIterations = 100;
	int listSize = 10000;
//	@Test
//	public void testQuicksortRight() throws Exception{
////		int numberOfIterations = 1;
//		long timerStart, timerStop, timerDifference;
//		long timerSecStart, timerSecStop, timerSecDiff;
//		long min = 999999999;
//		long max = 0;
//		long avg = 0;
//		Sortieren sort = new Sortieren();
//		timerStart = System.nanoTime();
////		Integer[] liste = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
//		for (int i = 0; i < numberOfIterations; i++) {
//			Integer[] liste = sort.listeMitZufallszahlen(listSize);
//			timerSecStart = System.nanoTime();
//			sort.quicksort(liste, 0, liste.length-1, Pivotsuchverfahren.RECHTS);
//			timerSecStop = System.nanoTime();
//			
//			timerSecDiff = (timerSecStop - timerSecStart);
//			avg += timerSecDiff;
//			if(timerSecDiff<=min){
//				min = timerSecDiff;
//			}
//			if(timerSecDiff>=max){
//				max = timerSecDiff;
//			}
//			
//		}
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		avg = avg / numberOfIterations;
//		System.out.println("Count Quicksort RIGHT\n");
//		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
//				+ " itertions.");
//		System.out.println("Min: "+ min);
//		System.out.println("Max: "+ max);
//		System.out.println("Avg: "+ avg);
//	}
//	
	@Test
	public void testQuicksortMedian() throws Exception{
//		int numberOfIterations = 1;
		long timerStart, timerStop, timerDifference;
		long timerSecStart, timerSecStop, timerSecDiff;
		long min = 999999999;
		long max = 0;
		long avg = 0;
		int avgCount = 0;
		Sortieren sort = new Sortieren();
		timerStart = System.nanoTime();
//		Integer[] liste = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
		for (int i = 0; i < numberOfIterations; i++) {
			Integer[] liste = sort.listeMitZufallszahlen(listSize);
//			timerSecStart = System.nanoTime();
			sort.quicksort(liste, 0, liste.length-1, Pivotsuchverfahren.RECHTS);
//			timerSecStop = System.nanoTime();
//			timerSecDiff = (timerSecStop - timerSecStart);
//			avg += timerSecDiff;
//			System.out.println(sort.getCounter());
			avgCount += sort.getCounter();
			sort.setCounter(0);
//			if(timerSecDiff<=min){
//				min = timerSecDiff;
//			}
//			if(timerSecDiff>=max){
//				max = timerSecDiff;
//			}
			
		}
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		avg = avg / numberOfIterations;
		avgCount = avgCount / numberOfIterations;
//		System.out.println("Count Quicksort MEDIAN\n");
//		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
//				+ " itertions.");
//		System.out.println("Min: "+ min);
//		System.out.println("Max: "+ max);
//		System.out.println("Avg: "+ avg);
		System.out.println(avgCount);
	}
//	
//	@Test
//	public void testQuicksortRandom() throws Exception{
////		int numberOfIterations = 1;
//		long timerStart, timerStop, timerDifference;
//		long timerSecStart, timerSecStop, timerSecDiff;
//		long min = 99999999;
//		long max = 0;
//		long avg = 0;
//		timerStart = System.nanoTime();
////		Integer[] liste = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
//		for (int i = 0; i < numberOfIterations; i++) {
//			Sortieren sort = new Sortieren();
//			Integer[] liste = sort.listeMitZufallszahlen(listSize);
//			System.out.println(liste);
//			timerSecStart = System.nanoTime();
//			sort.quicksort(liste, 0, liste.length-1, Pivotsuchverfahren.ZUFAELLIG);
//			timerSecStop = System.nanoTime();
//			
//			timerSecDiff = (timerSecStop - timerSecStart);
//			avg += timerSecDiff;
//			if(timerSecDiff<=min){
//				min = timerSecDiff;
//			}
//			if(timerSecDiff>=max){
//				max = timerSecDiff;
//			}
//			
//		}
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		avg = avg / numberOfIterations;
//		System.out.println("Count Quicksort RANDOM\n");
//		System.out.println(timerDifference + " Seconds for list with " + listSize + " Elements and " + numberOfIterations
//				+ " itertions.");
//		System.out.println("Min: "+ min);
//		System.out.println("Max: "+ max);
//		System.out.println("Avg: "+ avg);
//	}
	
//	@Test
//	public void pivotRechts() throws Exception {
//		Integer[] a = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
//		Integer[] atest = { 1, 5, 14, 15, 20, 24, 28, 31, 39, 54 };
//		Integer[] sortiert_auf = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		Integer[] sortiert_ab = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//		Integer[] gleich = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//		Integer[] wechsel = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
//		Integer[] dies = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
//		Sortieren sort = new Sortieren();
//		long timerStart, timerStop, timerDifference;
//		timerStart = System.nanoTime();
//		sort.quicksort(dies, 0, dies.length - 1, Pivotsuchverfahren.MEDIAN);
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		System.out.println(sort.getCounter());
//		assertTrue("Pivotrechts Fehler", Arrays.equals(a, atest));

//		Integer[] b = { 54, 20 };
//		Integer[] btest = { 20, 54 };
//		sort.quicksort(b, 0, b.length - 1, Pivotsuchverfahren.RECHTS);
//		assertTrue("Pivotrechts Fehler", Arrays.equals(b, btest));
//
//		Integer[] c = { 6, 20, 65, 100 };
//		Integer[] ctest = { 6, 20, 65, 100 };
//		sort.quicksort(c, 0, c.length - 1, Pivotsuchverfahren.RECHTS);
//		assertTrue("Pivotrechts Fehler", Arrays.equals(c, ctest));

//	}
//
//	@Test
//	public void pivotMedian() throws Exception {
//		Integer[] a = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
//		Integer[] atest = { 1, 5, 14, 15, 20, 24, 28, 31, 39, 54 };
//		Sortieren sort = new Sortieren();
//		long timerStart, timerStop, timerDifference;
//		timerStart = System.nanoTime();
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.MEDIAN);
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		System.out.println(timerDifference);
//		assertTrue("Pivotmdeian Fehler", Arrays.equals(a, atest));
//
//		Integer[] b = { 54, 20 };
//		Integer[] btest = { 20, 54 };
//		sort.quicksort(b, 0, b.length - 1, Pivotsuchverfahren.MEDIAN);
//		assertTrue("Pivotmdeian Fehler", Arrays.equals(b, btest));
//
//		Integer[] c = { 6, 20, 65, 100 };
//		Integer[] ctest = { 6, 20, 65, 100 };
//		sort.quicksort(c, 0, c.length - 1, Pivotsuchverfahren.MEDIAN);
//		assertTrue("Pivotmdeian Fehler", Arrays.equals(c, ctest));
//	}
//
//	@Test
//	public void pivotZufaellig() throws Exception {
//		Integer[] a = { 20, 54, 28, 31, 5, 24, 39, 14, 1, 15 };
//		Integer[] atest = { 1, 5, 14, 15, 20, 24, 28, 31, 39, 54 };
//		Sortieren sort = new Sortieren();
//		long timerStart, timerStop, timerDifference;
//		timerStart = System.nanoTime();
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.ZUFAELLIG);
//		timerStop = System.nanoTime();
//		timerDifference = (timerStop - timerStart);
//		System.out.println(timerDifference);
//		assertTrue("Pivotzufaellig Fehler", Arrays.equals(a, atest));
//
//		Integer[] b = { 54, 20 };
//		Integer[] btest = { 20, 54 };
//		sort.quicksort(b, 0, b.length - 1, Pivotsuchverfahren.ZUFAELLIG);
//		assertTrue("Pivotzufaellig Fehler", Arrays.equals(b, btest));
//
//		Integer[] c = { 6, 20, 65, 100 };
//		Integer[] ctest = { 6, 20, 65, 100 };
//		sort.quicksort(c, 0, c.length - 1, Pivotsuchverfahren.ZUFAELLIG);
//		assertTrue("Pivotzufaellig Fehler", Arrays.equals(c, ctest));
//	}
//
//	@Test
//	public void einElement() throws Exception {
//		Integer[] a = { 20 };
//		Integer[] atest = { 20 };
//		Sortieren sort = new Sortieren();
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.ZUFAELLIG);
//		assertTrue("ein Element Fehler zufall", Arrays.equals(a, atest));
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.MEDIAN);
//		assertTrue("ein Element Fehler median", Arrays.equals(a, atest));
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.RECHTS);
//		assertTrue("ein Element Fehler rechts", Arrays.equals(a, atest));
//	}
//
//	@Test
//	public void keinElement() throws Exception {
//		Integer[] a = {};
//		Integer[] atest = {};
//		Sortieren sort = new Sortieren();
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.ZUFAELLIG);
//		assertTrue("ein Element Fehler zufall", Arrays.equals(a, atest));
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.MEDIAN);
//		assertTrue("ein Element Fehler median", Arrays.equals(a, atest));
//		sort.quicksort(a, 0, a.length - 1, Pivotsuchverfahren.RECHTS);
//		assertTrue("ein Element Fehler rechts", Arrays.equals(a, atest));
//	}
//
//	@Test
//	public void leereListe() {
//		Sortieren sort = new Sortieren();
//		try {
//			sort.quicksort(null, 0, 0, Pivotsuchverfahren.ZUFAELLIG);
//			assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
//		} catch (Exception e) {
//			// Alles richtig
//		}
//	}

}
