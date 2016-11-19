package aufgabenblatt4;

public class Element {
  
	public int wert;
  /**
   * n�chstes Element
   */
  private Element next;
  
  /**
   * vorheriges Element
   */
  private Element previous;
  
  /**
   * Konstruktor
   */
  public  Element() {
    next=null;
    previous=null;
    wert=0;
  }
  public Element(int i){
	    next=null;
	    previous=null;
	    wert=i; 
  }
  
  public  Element(Element copy) {
	    this.next=copy.getNext();
	    this.previous=copy.getPrevious();
	  }
  public Element getNext() {
    return next;
  }

  public void setNext(Element next) {
    this.next = next;
  }

  public Element getPrevious() {
    return previous;
  }

  public void setPrevious(Element previous) {
    this.previous = previous;
  }

}
