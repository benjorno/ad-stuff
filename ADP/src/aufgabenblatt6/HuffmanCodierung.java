package aufgabenblatt6;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HuffmanCodierung {

	public static final int BYTE_LAENGE = 8;

	public static final boolean DEBUG = false;

	/**
	 * speichert den HuffmanBaum
	 */
	private HuffmanBaum baum = null;

	/**
	 * Verschlüsselt eine Zeichenkette in code
	 * 
	 * @param text
	 * @return code
	 * @throws Exception
	 */
	public byte[] verschluesseln(String text) throws Exception {

		if (text == null || text.length() < 2) {
			throw new IllegalArgumentException("Die Zeichenkette ist null oder Leerstring");
		}

		text = text + "#";
		LinkedList<HuffmanKnoten> liste = new LinkedList<HuffmanKnoten>();

		// alle Zeichen in Knoten mit ihrer Haeufigkeit speichern
		for (int i = 0; i < text.length(); i++) {
			char buchstabe = text.charAt(i);
			HuffmanKnoten knoten = new HuffmanKnoten(buchstabe);
			if (liste.contains(knoten)) {
				// Knoten ist schon bekannt
				knoten = liste.get(liste.indexOf(knoten));
				knoten.haufigkeitErhoehen();
			} else {
				// Knoten aufnehmen
				liste.add(knoten);
			}
		}

		HuffmanBaumErstellen(liste);

		// speichert den Code in einem String
		String code = "";
		for (int i = 0; i < text.length(); i++) {
			char buchstabe = text.charAt(i);
			code = code + baum.sucheCodewort(buchstabe);

		}
		int laenge;
		// das letzte byte mit 0 auffuellen wenn nötig
		while (code.length() % BYTE_LAENGE != 0) {
			code = code + 0;
		}
		laenge = (code.length() / BYTE_LAENGE);

		if (DEBUG) {
			System.out.println(code);
		}

		// übertraegt die 0en und 1en in ein byte Array
		byte[] array = new byte[laenge];
		for (int i = 0; i < laenge; i++) {
			for (int j = 0; j < BYTE_LAENGE; j++) {
				char buchstabe = code.charAt((7 - j) + i * BYTE_LAENGE);
				if (buchstabe == '1') {
					array[i] = (byte) (array[i] + zweierpotenz(j));
				}
			}
		}
		if (DEBUG) {
			System.out.println("Ausgabe Byte Array: ");
			for (Byte zahl : array) {
				System.out.print(Byte.toUnsignedInt(zahl) + " ");
			}
			System.out.println("\nAnzahl verwendeter Bytes: " + laenge);
		}

		return array;
	}

	/**
	 * berechnet die Zweierpotenz
	 * 
	 * @param exponent
	 * @return
	 */
	public int zweierpotenz(int exponent) {
		if (exponent != 0) {
			int ergebnis = 1;
			for (int i = 1; i <= exponent; i++) {
				ergebnis = ergebnis * 2;
			}

			return ergebnis;
		}
		return 1;
	}

	/**
	 * Baut einen Huffmanbaum aus Huffmanknoten zusammen.
	 * 
	 * @param liste
	 *            aus Huffmanknoten
	 */
	public void HuffmanBaumErstellen(List<HuffmanKnoten> liste) {
		// sortiert die Liste nach Haeufigkeit
		Collections.sort(liste);
		// die beiden Knoten mit der Kleinsten Haeufigkeit werden zusammengefasst
		while (liste.size() > 1) {
			HuffmanKnoten linkerKnoten = liste.get(0);
			HuffmanKnoten rechterKnoten = liste.get(1);
			int summe = linkerKnoten.getHaeufigkeit() + rechterKnoten.getHaeufigkeit();
			HuffmanKnoten knoten = new HuffmanKnoten(null, rechterKnoten, linkerKnoten, summe);
			liste.remove(1);
			liste.remove(0);
			liste.add(knoten);
			Collections.sort(liste);
		}
		// der letzte Knoten in der Liste ist der Wurzelknoten des Baumes
		baum = new HuffmanBaum(liste.get(0));
	}

	public String entschluesseln(byte[] code) {
		String text = "";

		if (DEBUG) {
			for (Byte zahl : code) {
				System.out.print(Byte.toUnsignedInt(zahl) + " ");
			}
		}

		// konvertiert ein byte Array in einen string
		for (byte zahl : code) {
			for (int i = BYTE_LAENGE - 1; i >= 0; i--) {
				if (Byte.toUnsignedInt(zahl) / zweierpotenz(i) == 1) {
					text = text + "1";
					zahl = (byte) (zahl - zweierpotenz(i));
				} else {
					text = text + "0";
				}

			}
		}
		if (DEBUG) {
			System.out.println(text);
		}

		// sucht die passenden Zeichen für den Code im Baum
		String zeichenkette = baum.zeichenSuchen(text);
		return zeichenkette;

	}

	public static void main(String[] args) {
		HuffmanCodierung code = new HuffmanCodierung();
		try {
			byte[] array = code.verschluesseln(
			        "If you give someone a program you will frustrate them for a day? If you teach them how to"
			                + " program, you will frustrate them for a lifetime. The computing scientist?s main challenge is not to"
			                + " get confused by the complexities of his own making. Beauty is more important in computing than"
			                + " anywhere else in technology because software is so complicated. Beauty is the ultimate defence"
			                + " against complexity");
			//erstellt binären Code
			String codeBin = "";
			for (Byte zahl : array) {
				codeBin += Integer.toBinaryString((int) zahl);
			}
			System.out.println("Zeichenkette: " + codeBin + "\n" + code.entschluesseln(array));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
