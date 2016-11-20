package aufgabenblatt6;

public class HuffmanBaum {

	/**
	 * Wurzelknoten
	 */
	private HuffmanKnoten wurzel;

	/**
	 * 
	 */
	private String codeWort;

	/**
	 * 
	 */
	private boolean codeGefunden;

	/**
	 * Konstruktor
	 * 
	 * @param wurzel
	 */
	public HuffmanBaum(HuffmanKnoten wurzel) {
		this.wurzel = wurzel;
		codeGefunden = false;
	}

	/**
	 * Durchsucht den Baum nach dem Code für den Buchstaben.
	 * 
	 * @param knoten
	 * @param buchstabe
	 * @param code
	 */
	public void sucheCodewortRek(HuffmanKnoten knoten, Character buchstabe, String code) {

		if (knoten != null && !(codeGefunden)) {
			sucheCodewortRek(knoten.getLinks(), buchstabe, code + "0");
			if (buchstabe.equals(knoten.getBuchstabe())) {
				codeGefunden = true;
				// globale Klassenvariable
				codeWort = code;
			}
			sucheCodewortRek(knoten.getRechts(), buchstabe, code + "1");
		}
	}

	/**
	 * Durchsucht den Baum nach dem Code für den Buchstaben.
	 * 
	 * @param knoten
	 * @param buchstabe
	 * @param code
	 */
	public String sucheCodewort(Character buchstabe) {
		codeGefunden = false;
		sucheCodewortRek(wurzel, buchstabe, "");
		return codeWort;
	}

	/**
	 * Die Methode sucht für eine Codefolge die entsprechenden Zeichen.
	 * 
	 * @param text
	 *            codefolge aus 0 und 1
	 * @return der entschlüsselte text
	 */
	public String zeichenSuchen(String text) {
		String ergebnis = "";
		int textPointer = 0;
		HuffmanKnoten suchKnoten;
		// durchläuft den Baum nach den Code und fängt wieder von vorne an wenn
		// ein Blatt erreicht wurde
		while (textPointer < text.length()) {
			suchKnoten = wurzel;
			while (suchKnoten.getBuchstabe() == null && textPointer < text.length()) {
				char buchstabe = text.charAt(textPointer);
				textPointer++;
				if (buchstabe == '1') {
					suchKnoten = suchKnoten.getRechts();
				} else {
					suchKnoten = suchKnoten.getLinks();
				}
			}
			// letztes Zeichen
			if (suchKnoten.getBuchstabe() == '#') {
				return ergebnis;
			}
			ergebnis = ergebnis + suchKnoten.getBuchstabe();
		}
		return ergebnis;

	}

	/**
	 * Gibt alle Elemente des Baumes in Inorder aus.
	 */
	public void ausgabeInOrder() {
		ausgabeGanzerBaumInOrder(wurzel);
	}

	/**
	 * interne Methode zum Ausgeben der Knoten.
	 * 
	 * @param element
	 */
	private void ausgabeGanzerBaumInOrder(HuffmanKnoten knoten) {
		if (knoten != null) {
			ausgabeGanzerBaumInOrder(knoten.getLinks());
			System.out.println("Knoten:" + knoten.getBuchstabe() + " " + knoten.getHaeufigkeit());
			ausgabeGanzerBaumInOrder(knoten.getRechts());
		}
	}

}
