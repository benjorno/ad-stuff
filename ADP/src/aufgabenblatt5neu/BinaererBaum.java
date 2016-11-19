package aufgabenblatt5neu;
import java.util.NoSuchElementException;
public class BinaererBaum {

	  /**
	   * Start des Baumes
	   */
	  private Knoten anker;

	  /**
	   * Gibt an ob die Summe für alle Knoten berechnet worden ist.
	   */
	  private boolean baumIstVorbereitet;

	  /**
	   * Konstruktor
	   * 
	   * @param anker
	   *          Wurzelknoten des Baumes
	   */
	  public BinaererBaum(Knoten anker) {
	    this.anker = anker;
	    baumIstVorbereitet = false;
	  }

	  /**
	   * Fügt ein Element in dem Baum ein.
	   * @param daten
	   *          eine Zahl, die in den Baum eingefügt werden soll
	   * @throws Exception
	   *           Wenn das Element bereits vorhanden ist.
	   */
	  public void elementEinfuegen(Integer daten) throws IllegalArgumentException {
	    if(daten==null || daten < 1){
	      throw new IllegalArgumentException("Null kann nicht eingefügt werden");
	    }
	    anker = elementEinfuegenRek(daten, anker);
	    baumIstVorbereitet = false;
	  }

	  /**
	   * Interne Methode
	   * 
	   * @param daten
	   *          eine Zahl
	   * @param element
	   * @return neues erstes Element
	   * @throws Exception
	   */
	  private Knoten elementEinfuegenRek(Integer daten, Knoten element) throws IllegalArgumentException {
	    // neues Blatt erzeugen
	    if (element == null) {
	      return new Knoten(daten, null, null);
	    }
	    // Element schon enthalten
	    if (daten == element.getDaten()) {
	      throw new IllegalArgumentException("Das Element ist schon vorhanden!");
	    }
	    // im linken Unterbaum suchen bzw. im rechten
	    if (daten < element.getDaten()) {
	      Knoten el = elementEinfuegenRek(daten, element.getLinks());
	      element.setLinks(el);
	      return element;
	    } else {
	      Knoten el = elementEinfuegenRek(daten, element.getRechts());
	      element.setRechts(el);
	      return element;
	    }
	  }

	  /**
	   * Löscht ein Element aus dem Baum.
	   * 
	   * @param daten
	   *          element das gelöscht werden soll
	   * @throws wirft
	   *           eine Exception, wenn das Element nicht gefunden wurde
	   */
	  public void elementLoeschen(Integer daten) throws NoSuchElementException {
	    baumIstVorbereitet = false;
	    anker = elementLoeschenRek(daten, anker);
	  }

	  /**
	   * 
	   * @param daten
	   *          element das gelöscht werden soll
	   * @param knoten
	   *          aktueller Knoten
	   * @return neues erstes Element
	   * @throws NoSuchElementException
	   */
	  private Knoten elementLoeschenRek(Integer daten, Knoten knoten) throws NoSuchElementException {
	    // rekursive Suche nach dem Element
	    if (knoten == null) {
	      throw new NoSuchElementException("Element nicht gefunden!");
	    }
	    if (knoten.getDaten() > daten) {
	      Knoten element = elementLoeschenRek(daten, knoten.getLinks());
	      knoten.setLinks(element);
	      return knoten;
	    }
	    if (knoten.getDaten() < daten) {
	      Knoten element = elementLoeschenRek(daten, knoten.getRechts());
	      knoten.setRechts(element);
	      return knoten;
	    } else {
	      // einfache Fälle mit leeren Unterbaum
	      if (knoten.getLinks() == null) {
	        return knoten.getRechts();
	      } else {
	        if (knoten.getRechts() == null) {
	          return knoten.getLinks();
	        } else {
	          // Knoten durch den Inordernachfolger ersetzen
	          Knoten ersatz = sucheNachfolger(knoten);
	          ersatz.setLinks(knoten.getLinks());
	          ersatz.setRechts(knoten.getRechts());
	          return ersatz;
	        }
	      }
	    }

	  }

	  /**
	   * Sucht den InorderNachfolger im Baum.
	   * 
	   * @param knoten
	   *          Knoten zu dem der Inorder-Nachfolger gesucht wird
	   * @return Verweis auf Ersatzknoten
	   */
	  private Knoten sucheNachfolger(Knoten knoten) {
	    Knoten ersatz;
	    // Wurzel des Unterbaums ist Nachfolger
	    if (knoten.getRechts().getLinks() == null) {
	      ersatz = knoten.getRechts();
	      knoten.setRechts(knoten.getRechts().getRechts());
	    } else {
	      // Im Unterbaum ganz nach links gehen
	      knoten = knoten.getRechts();
	      while (knoten.getLinks().getLinks() != null) {
	        knoten = knoten.getLinks();
	      }
	      // Inorder-Nachfolger aushängen
	      ersatz = knoten.getLinks();
	      knoten.setLinks(knoten.getLinks().getRechts());
	    }
	    return ersatz;
	  }

	  /**
	   * Gibt alle Elemente des Baumes in Inorder aus.
	   */
	  public void ausgabeInorder() {
	    ausgabeGanzerBaumInorder(anker);
	  }

	  /**
	   * interne Methode zum Ausgeben der Knoten.
	   * 
	   * @param element
	   */
	  private void ausgabeGanzerBaumInorder(Knoten element) {
	    if (element != null) {
	      ausgabeGanzerBaumInorder(element.getLinks());
	      System.out.println("Daten:" + element.getDaten());
	      ausgabeGanzerBaumInorder(element.getRechts());
	    }
	  }

	  /**
	   * Sucht den Knoten zu einem Inetger.
	   * 
	   * @param daten
	   *          der Schlüssel
	   * @return den Knoten zum Integer
	   * @throws NoSuchElementException
	   *           wenn das Element nicht im Baum vorhanden ist.
	   */
	  public Knoten sucheKnoten(Integer daten) throws NoSuchElementException {
	    Knoten suchKnoten = anker;
	    // beim richtigen Unterbaum fortfahren bis Knoten gefunden
	    while (suchKnoten != null && suchKnoten.getDaten() != daten) {
	      if (daten < suchKnoten.getDaten()) {
	        suchKnoten = suchKnoten.getLinks();
	      } else {
	        suchKnoten = suchKnoten.getRechts();
	      }
	    }
	    // Element nicht vorhanden
	    if (suchKnoten == null) {
	      throw new NoSuchElementException("Element nicht vorhanden!:Suchen");
	    }
	    return suchKnoten;
	  }

	  /**
	   * Sucht den Knoten mit dem größten Wert, der noch größer gleich daten ist.
	   * 
	   * @param daten
	   * @return den Knoten oder null
	   */
	  public Knoten sucheKnotenKleinerGleich(Integer daten) throws NoSuchElementException {
	    Knoten suchKnoten = anker;
	    Knoten element = null;
	    // beim richtigen Unterbaum fortfahren bis Knoten gefunden und die Knoten im
	    // rechten teilbaum merken.
	    while (suchKnoten != null && suchKnoten.getDaten() != daten) {
	      if (daten < suchKnoten.getDaten()) {
	        suchKnoten = suchKnoten.getLinks();
	      } else {
	        // immer das nächst größere Element,dass noch kleiner als daten ist,
	        // speichern
	        element = suchKnoten;
	        suchKnoten = suchKnoten.getRechts();
	      }
	    }
	    // Element nicht vorhanden
	    if (suchKnoten == null && element == null) {
	      element = null;
	    }

	    //// Element wurde gefunden.
	    if (suchKnoten != null && suchKnoten.getDaten() == daten) {
	      element = suchKnoten;
	    }
	    return element;
	  }

	  /**
	   * Sucht den Knoten mit dem kleinsten Wert, der noch größer gleich daten ist.
	   * 
	   * @param daten
	   * @return den Knoten oder null
	   */
	  public Knoten sucheKnotenGroeßerGleich(Integer daten) throws NoSuchElementException {
	    Knoten suchKnoten = anker;
	    Knoten element = null;
	    // beim richtigen Unterbaum fortfahren bis Knoten gefunden und die Knoten im
	    // linken teilbaum merken.
	    while (suchKnoten != null && suchKnoten.getDaten() != daten) {
	      if (daten < suchKnoten.getDaten()) {
	        // immer das nächst kleinere Element,dass noch größer als daten ist,
	        // speichern
	        element = suchKnoten;
	        suchKnoten = suchKnoten.getLinks();
	      } else {
	        suchKnoten = suchKnoten.getRechts();
	      }
	    }
	    // Element nicht vorhanden
	    if (suchKnoten == null && element == null) {
	      element = null;
	    }

	    // Element wurde gefunden.
	    if (suchKnoten != null && suchKnoten.getDaten() == daten) {
	      element = suchKnoten;
	    }

	    return element;
	  }

	  /**
	   * Berechnet für alle Knoten im Baum die Summe.
	   */
	  public void vorbereiten() {
	    int array[] = new int[1];
	    vorbereitenRek(anker, array);
	    baumIstVorbereitet = true;
	  }

	  /**
	   * Durchläuft den Baum rekursiv in aufsteigender Reihenfolge(inorder) und 
	   * setzt für jeden Knoten die aktuelle Summe.
	   * 
	   * @param knoten
	   *          aktueller Knoten
	   * @param summe
	   *          Speicherplatz, der die aktuelle Summe enthält
	   */
	  private void vorbereitenRek(Knoten knoten, int summe[]) {
	    if (knoten != null) {
	      vorbereitenRek(knoten.getLinks(), summe);
	      summe[0] = summe[0] + knoten.getDaten();
	      knoten.setSumme(summe[0]);
	      vorbereitenRek(knoten.getRechts(), summe);
	    }
	  }

	  /**
	   * Gibt die Summe aller Werte aus dem Baum aus, die zwischen m1 und m2 liegen.
	   * @param m1
	   *          Untere Grenze
	   * @param m2
	   *          Obere Grenze
	   */
	  public void summierenZwischenZweiKnoten(Integer m1, Integer m2) {
	    // Wenn notwendig, die Summe für alle Knoten berechnen
	    if (!(baumIstVorbereitet)) {
	      vorbereiten();
	      baumIstVorbereitet = true;
	    }
	    // Suche von m1 und m2
	    Knoten knotenM1 = sucheKnotenGroeßerGleich(m1);
	    Knoten knotenM2 = sucheKnotenKleinerGleich(m2);
	    // Sonderfälle => Summe 0 zwischen den beiden Knoten
	    if (knotenM1 == null || knotenM2 == null || m2 < m1) {
	      System.out.println("Die Summe zwischen " + m1 + " und " + m2 + " ist 0!");
	    } else {

	      System.out.println("Die Summe aller Knoten zwischen " + knotenM1 + 
	          " und " + knotenM2 + " ist:");
	      // Ausgabe der Summe
	      System.out.println(knotenM1.getDaten() + knotenM2.getSumme()
	      - knotenM1.getSumme());
	      System.out.println(knotenM1);
	    }
	  }

	  /**
	   * Tests
	   * 
	   * @param args
	   * @throws Exception
	   */
	  public static void main(String args[]) throws Exception {
	    BinaererBaum baum = new BinaererBaum(null);

	    baum.elementEinfuegen(50);
	    baum.elementEinfuegen(43);
	    baum.elementEinfuegen(12);
	    baum.elementEinfuegen(67);
	    baum.elementEinfuegen(85);
	    baum.elementEinfuegen(44);
	    baum.elementEinfuegen(24);
	    // baum.elementLoeschen(12);
	    baum.summierenZwischenZweiKnoten(12, 68);
	    // System.out.println(baum.sucheKnotenKleinerGleich(26));
	    // System.out.println(baum.sucheKnotenGroeßerGleich(86));

	    // System.out.println(baum.sucheKnotenGroeßerGleich());
	    // System.out.println(baum.sucheKnotenKleinerGleich(9));

	    // baum.ausgabeInorder();

	  }

	}
