package aufgabenblatt4;

import java.util.Random;

/**
 * 
 * Die Klasse stellt eine Liste da,in die Elemente hinzugef�t werden k�nnen
 * 
 * 
 *
 */
public class AList2 implements IList {

	private Element[] elemente;

	Random random = new Random(9999999);

	public AList2() {
		elemente = new Element[0];
	}

	/**
	 * Ein Element wird der Liste an der Stelle pos hinzugef�gt. Die
	 * nachfolgenden Elemente werden um 1 nach hinten verschoben.
	 * 
	 * @param Position
	 *            und Element
	 * @return
	 * @return die Liste
	 */
	@Override
	public void insert(int pos, Element element) {
		if (pos >= 0 && elemente.length >= pos && element != null) {
			Element[] newElement = new Element[elemente.length + 1];
			int verschiebung = 0;
			for (int i = 0; i < newElement.length; i++) {
				if (pos == i) {
					verschiebung = 1;
					newElement[i] = element;
				} else {
					newElement[i + verschiebung] = elemente[i];
				}
			}
			elemente = newElement;
			// return this;
		}
		// return this;
		// throw new Exception();
	}

	/**
	 * Ein Element wird aus der Liste entefernt und die Liste wird um 1
	 * verkleinert.
	 * 
	 * @param die
	 *            Position
	 * @return die Liste
	 */
	@Override
	public IList delete(int pos) throws Exception {
		if (pos >= 0 && elemente.length > pos) {

			Element[] newElement = new Element[elemente.length - 1];

			int verschiebung = 0;
			for (int i = 0; i < newElement.length; i++) {
				if (pos == i) {
					verschiebung = -1;
				} else {
					newElement[i + verschiebung] = elemente[i];
				}
			}
			elemente = newElement;
			return this;
		}
		throw new Exception();
	}

	/**
	 * Ein Element wird in der Liste gesucht und das erste Vorkommen wird
	 * zur�ckgegeben.
	 * 
	 * @param das
	 *            zufindende Element
	 * @return -1, wenn das Element nicht gefunden wurde und wenn das Element
	 *         gefunden wurde den Index des Elementes.
	 * 
	 */
	@Override
	public int find(Element element) {
		if (element != null) {
			for (int i = 0; i < elemente.length; i++) {
				if (element.equals(elemente[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/***
	 * Gib das Element an dem Index zur�ck
	 * 
	 * @param index
	 * @return das Element
	 */
	@Override
	public Element retrieve(int pos) throws Exception {
		if (pos >= 0 && elemente.length > pos) {
			return elemente[pos];
		}
		throw new Exception();
	}

	/**
	 * Verbindet zwei Listen zu einer.
	 * 
	 * @param eine
	 *            Liste
	 * @return die verbundene Liste
	 */
	@Override
	public IList concat(IList list) throws Exception {
		if (list.size() == 0) {
			return this;
		}
		// pre cond
		Element[] newElement = new Element[elemente.length + list.size()];

		// elemente wird in das neue Array eingef�gt
		for (int i = 0; i < elemente.length; i++) {
			newElement[i] = elemente[i];
		}

		// die zweite Liste wird dem neuen Array hinzugef�gt
		for (int i = 0; i < list.size(); i++) {
			newElement[i + elemente.length] = new Element(list.retrieve(i));
		}

		elemente = newElement;
		return this;
	}

	/**
	 * Gibt die L�nge der Liste zur�ck
	 * 
	 * @return L�nge der Liste
	 */
	@Override
	public int size() {
		return elemente.length;
	}

	/*********************************************************************************************/
	@Override
	public IList listeMitZufallszahlen(int n) {
		for (int i = 0; this.size() < n; i++) {
			// this.insert(i, new Element(random.nextInt(n)));
			this.insert(i, new Element((int) (Math.random() * n * n)));
			// System.out.println(this.elemente[i].wert);
		}
		return this;
	}

	@Override
	public void bubbleSort() {
		for (int n = elemente.length; n > 1; n = n - 1) {
			for (int i = 0; i < n - 1; i = i + 1) {
				if (elemente[i].wert > elemente[i + 1].wert) {
					Element linkerWert = elemente[i];
					Element rechterWert = elemente[i + 1];
					elemente[i] = rechterWert;
					elemente[i + 1] = linkerWert;
				}
			}
		}
	}

	@Override
	public void insertionSort() {
		int temp;
		for (int i = 1; i < elemente.length; i++) {
			temp = this.elemente[i].wert;
			int j = i - 1;
			while (j >= 0 && this.elemente[j].wert > temp) {
				this.elemente[j + 1].wert = this.elemente[j].wert;
				j = j - 1;
			}
			this.elemente[j + 1].wert = temp;

		}

	}

}
