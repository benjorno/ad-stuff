package aufgabenblatt5neu;

public class Knoten {
	  
	  /**
	   * Enthält die Daten des Knotens.
	   */
	  private Integer daten;
	  
	  /**
	   * Linker Unterbaum
	   */
	  private Knoten links;
	  
	  /**
	   * Rechter Unterbaum
	   */
	  private Knoten rechts;

	  /**
	   *Die Summe aller bisherigen Knoten im Baum in der Reihenfolge inorder 
	   */
	  private int summe;
	  
	  /**
	   * Konstruktor für einen Knoten
	   * @param daten Enthält die Daten des Knotens
	   * @param links Linker Unterbaum
	   * @param rechts Rechter Unterbaum
	   */
	  public Knoten(Integer daten,Knoten links,Knoten rechts){
	    this.daten=daten;
	    this.links=links;
	    this.rechts=rechts;
	  }

	  /**
	   * Getter
	   * @return
	   */
	  public Integer getDaten() {
	    return daten;
	  }

	  /**
	   * Setter
	   * @param daten
	   */
	  public void setDaten(Integer daten) {
	    this.daten = daten;
	  }

	  /**
	   * Getter
	   * @return
	   */
	  public Knoten getLinks() {
	    return links;
	  }

	  /**
	   * Setter
	   * @param links
	   */
	  public void setLinks(Knoten links) {
	    this.links = links;
	  }

	  /**
	   * Getter
	   * @return
	   */
	  public Knoten getRechts() {
	    return rechts;
	  }

	  /**
	   * Setter
	   * @param rechts
	   */
	  public void setRechts(Knoten rechts) {
	    this.rechts = rechts;
	  }

	  /**
	   * Getter
	   * @return
	   */
	  public int getSumme() {
	    return summe;
	  }

	  /**
	   * Setter
	   * @param summe
	   */
	  public void setSumme(int summe) {
	    this.summe = summe;
	  }

	  /**
	   * 
	   */
	  @Override
	  public String toString(){
	    return "Knoten "+daten;
	  }

	}
