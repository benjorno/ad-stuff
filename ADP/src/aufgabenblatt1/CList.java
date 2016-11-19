package aufgabenblatt1;


public class CList implements IList {

  /**
   * Startelement
   */
  private Element startElement;

  /**
   * Konstruktor Zu Beginn gibt es noch kein Element.
   */
  public CList() {
    startElement = null;
  }

  public Element getStartElement() {
	return startElement;
}

public void setStartElement(Element startElement) {
	this.startElement = startElement;
}

/**
   * 
   * Das Element wird an der Position in der Liste eingef�gt.
   * 
   * @param pos
   *          Position in der Liste element Element
   * 
   * @retrun die Liste
   */
  @Override
  public IList insert(int pos, Element element) throws Exception {
    // pos nicht kleiner null und nicht kleiner size
    if (pos >= 0 && this.size() >= pos && element != null) {

      if (pos == 0) {
        element.setNext(startElement);
        startElement = element;
      } else {
        int counter = 1;
        Element current = startElement;
        do {
          if (counter == pos) {
            element.setNext(current.getNext());
            current.setNext(element);
          }
          counter++;
          current = current.getNext();
        } while (current != null);
      }
      return this;
    }
    throw new Exception();
  }

  /**
   * L�scht das Element an der Position aus der Liste.
   * 
   * @param Position
   * 
   * @return Liste
   */
  @Override
  public IList delete(int pos) throws Exception {
    if (pos >= 0 && this.size() > pos && this.startElement != null) {
      if (pos == 0) {
        startElement = startElement.getNext();
      } else {
        int counter = 1;
        Element current = startElement;
        do {
          if (pos == counter) {
            current.setNext(current.getNext().getNext());
            break;
          }
          counter++;
          current = current.getNext();
        } while (current != null);
      }
      return this;
    }
    throw new Exception();
  }

  /**
   * Liefert die Position des Elementes.
   * 
   * @param Ein
   *          Element
   * @return Index des Elementes
   */
  @Override
  public int find(Element element) {
    if (element != null) {
      int counter = 0;
      for (Element currentElement = this.startElement; currentElement != null; currentElement = currentElement
          .getNext()) {
        if (currentElement.equals(element)) {
          return counter;
        }
        counter++;
      }
    }
    return -1;
  }

  /**
   * Liefert das Element an der Position.
   * 
   * @param pos
   *          Die Position
   * @return das Element
   */
  @Override
  public Element retrieve(int pos) throws Exception {
    if (pos >= 0 && this.size() > pos) {
      int counter = 0;
      for (Element currentElement = startElement; currentElement != null; currentElement = currentElement.getNext()) {
        if (counter == pos) {
          return currentElement;
        }
        counter++;
      }
    }
    throw new Exception();
  }

  /**
   * F�gt zwei Listen zusammen.
   * 
   * @param eine
   *          Liste
   * @return zusammengesetzte Liste
   */
  @Override
  public IList concat(IList list) throws Exception {
    if (list.size() == 0) {
      return this;
    }
    Element lastElement = null;
    for (Element currentElement = startElement; currentElement != null; currentElement = currentElement.getNext()) {
      lastElement = currentElement;
    }

    for (int i = 0; i < list.size(); i++) {
      Element next = new Element(list.retrieve(i));
      lastElement.setNext(next);
      lastElement = next;
    }
    return this;
  }

  /**
   * Z�hlt die Elemente in der Liste.
   * 
   * @return liefert die Anzahl der Elemente.
   */
  @Override
  public int size() {
    int counter = 0;
    Element currentElement = startElement;

    while (currentElement != null) {
      counter++;
      currentElement = currentElement.getNext();
    }

    // if (this.startElement != null) {
    // for (Element currentElement = this.startElement; currentElement != null;
    // currentElement = currentElement.getNext()) {
    // counter++;
    // }
    // }
    return counter;
  }
}
