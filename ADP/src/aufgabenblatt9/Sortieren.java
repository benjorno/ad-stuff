package aufgabenblatt9;

import java.util.List;

import aufgabenblatt4.Element;

/**
 * Klasse fuer die Implementation von Quicksort.
 * 
 * @author Bennet und Leon
 *
 */
public class Sortieren {

	long counter = 0;

	public long getCounter() {
		return this.counter;
	}
	public void setCounter(int count) {
		this.counter = count;
	}
	public synchronized void increaseCounter() {
		this.counter++;
	}

	/**
	 * Sortiert die Liste nach dem Algorithmus Quicksort.
	 * 
	 * @param array
	 *            Feld
	 * @param links
	 *            Bereichsgrenze
	 * @param rechts
	 *            Bereichsgrenze
	 * @param v
	 *            Pivotsuchverfahren
	 * @throws Exception
	 */
	public void quicksort(Integer[] array, int links, int rechts, Pivotsuchverfahren v) throws Exception {

		if (array == null) {
			throw new Exception();
		}
		// Abbruch bei weniger als zwei Elementen
		if (links < rechts && rechts >= 0 && links >= 0) {

			// Init
			int[] pq = new int[2];
			int p, q;

			// Sortiere grob in zwei Partitionen
			pq = partitioniere(array, links, rechts, v);
			p = pq[0];
			q = pq[1];

			// sortiere die Partitionen rekursiv
			quicksort(array, links, p, v);
			quicksort(array, q, rechts, v);
		}
	}

	/**
	 * Sortiert grob in zwei Partionen.
	 * 
	 * @param array
	 *            Feld
	 * @param links
	 *            Bereichsgrenze
	 * @param rechts
	 *            Bereichsgrenze
	 * @param v
	 *            Pivotsuchverfahren
	 * @return Partionsgrenzen
	 */
	private int[] partitioniere(Integer[] array, int links, int rechts, Pivotsuchverfahren v) {

		int[] ji = new int[2];
		int i = links;
		int j = rechts;

		// Pivotelement
		int p = pivotauswahl(array, links, rechts, v);

		while (i <= j) {
			increaseCounter();
			// suche Tauschkandidaten von links
			while (array[i] < p) {
				i++;
			}
			// suche Tauschkandidaten von rechts
			while (array[j] > p) {
				j--;
			}
			// tausche, falls noch nicht fertig sortiert
			if (i <= j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
				j--;
			}

		}

		ji[0] = j;
		ji[1] = i;
		return ji;
	}

	/**
	 * 
	 * @param array
	 *            Feld
	 * @param links
	 *            Bereichgrenze
	 * @param rechts
	 *            Bereichgrenze
	 * @param v
	 *            Pivotsuchverfahren
	 * @return pivotelement
	 */
	private int pivotauswahl(Integer[] array, int links, int rechts, Pivotsuchverfahren v) {
		int pivot = 0;
		switch (v) {
		case RECHTS:
			pivot = array[rechts];
			break;
		case MEDIAN:
			pivot = median(array[links], array[(links + rechts) / 2], array[rechts]);
			break;
		case ZUFAELLIG:
			pivot = array[(int) (Math.random() * (rechts - links + 1) + links)];
			break;
		default:
			// nicht moeglich
			break;
		}
		return pivot;
	}

	/**
	 * 
	 * @param links
	 *            Bereichsgrenze
	 * @param mitte
	 *            Mittelwert im Bereich
	 * @param rechts
	 *            Bereichsgrenze
	 * @return den Median der drei Werte
	 */
	private int median(int links, int mitte, int rechts) {
		// ueberprueft, ob mitte der Median ist
		if (mitte > rechts ^ mitte > links) {
			return mitte;
		}

		// ueberprueft, ob rechts der Median ist
		if (rechts > mitte ^ rechts > links) {
			return rechts;
		}
		// sonst muss es links sein
		return links;
	}
	
	public Integer[] insert(int pos, Integer zahl, Integer[] array) {
		if (pos >= 0 && array.length >= pos && zahl != null) {
			Integer[] newArray = new Integer[array.length + 1];
			int verschiebung = 0;
			for (int i = 0; i < newArray.length; i++) {
				if (pos == i) {
					verschiebung = 1;
					newArray[i] = zahl;
				} else {
					newArray[i + verschiebung] = array[i];
				}
			}
			array = newArray;
		}
		return array;
		// throw new Exception();
	}
	
	public Integer[] listeMitZufallszahlen(int n) {
		Integer[] liste = new Integer[0];
		for (int i = 0; liste.length < n; i++) {
			// this.insert(i, new Element(random.nextInt(n)));
			liste = insert(i, new Integer((int) (Math.random() * n * n)),liste);
			// System.out.println(this.elemente[i].wert);
		}
		return liste;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		int anzahl = 10;
		Integer[] array = new Integer[anzahl];
		Integer[] array2 = new Integer[anzahl];
		for (int i = 0; i < anzahl; i++) {
			array[i] = (int) (Math.random() * (1000 * anzahl) + (7000 * anzahl));
		}

		for (int i = 0; i < anzahl; i++) {
			array2[i] = array[i];
		}
//		System.out.println("Yeah " + array[9] + "  " + array2[9]);
//		 for (int zahl : array) {
//		 System.out.print(zahl + " ");
//		 }

		Sortieren sort = new Sortieren();
		// long time = System.currentTimeMillis();
		long time = System.nanoTime();
		sort.quicksort(array2, 0, array2.length - 1, Pivotsuchverfahren.MEDIAN);
		long time2 = System.nanoTime() - time;
		System.out.println("Die vergangene Zeit ist " + time2);
	}
	


}
