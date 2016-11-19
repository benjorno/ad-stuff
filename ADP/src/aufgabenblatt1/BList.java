package aufgabenblatt1;


public class BList implements IList {

	private Element[] elemente;

	public BList() {
		elemente = new Element[0];
	}

	@Override
	public IList insert(int pos, Element element) throws Exception {

		if (pos >= 0 && this.size() >= pos && element != null) {
     
			Element[] newElemente = elemente;
			int aktuelleGroesse = this.size();
			//Das Array wird vergr��ert, wenn es zu klein ist
			if (elemente.length - aktuelleGroesse < aktuelleGroesse + 1) {
				newElemente = new Element[aktuelleGroesse + 10];
				// elemente wird in das neue Array eingef�gt
				for (int i = 0; i < elemente.length; i++) {
					newElemente[i] = elemente[i];
				}
			}
			
			//Startelement suchen
			Element startElement = null;
			for (int i = 0; i < newElemente.length; i++) {
				if (newElemente[i] != null && newElemente[i].getPrevious() == null) {
					startElement = newElemente[i];
					break;
				}
			}
			
			//Das Element kommt an den ersten freien Platz im Array
			for (int i = 0; i < newElemente.length; i++) {
				if (newElemente[i] == null) {
					newElemente[i] = element;
					break;
				}
			}
			


			if(startElement!=null){
			  if(pos==0){
	        element.setNext(startElement);
	        startElement.setPrevious(element);
	        startElement = element;
			  }else{
	        int counter = 1;
	         Element current = startElement;

	         do{
	           if (counter == pos) {

             Element next = current.getNext();
             if (next != null) {
               element.setNext(next);
               next.setPrevious(element);
             }else{
               element.setNext(null);
             }
             element.setPrevious(current);
             current.setNext(element);
	           }
	           counter++;
	           current = current.getNext();
	         }while(current != null);
			  }
 
//		      for (Element currentElement = startElement; currentElement != null; currentElement = currentElement
//		          .getNext()) {
//		        if (counter == (pos - 1)) {
//		          Element next = currentElement.getNext();
//		          if (next != null) {
//		            element.setNext(next);
//		            next.setPrevious(element);
//		          }else{
//		            element.setNext(null);
//		          }
//		          element.setPrevious(currentElement);
//		          currentElement.setNext(element);
//		          break;
//		        }
//		        counter++;
//		      }
			}

			this.elemente = newElemente;
			return this;
		}
		throw new Exception();
	}

	public Element[] getElemente() {
		return elemente;
	}

	public void setElemente(Element[] elemente) {
		this.elemente = elemente;
	}

	/**
	 * L�scht das Element an dem Index.
	 * @param index
	 * @return die Liste
	 */
	@Override
	public IList delete(int pos) throws Exception {
		if (pos >= 0 && this.size() > pos) {
			Element startElement = null;

			//startelement suchen
			for (int i = 0; i < elemente.length; i++) {
				if (elemente[i] != null && elemente[i].getPrevious() == null) {
					startElement = elemente[i];
					break;
				}
			}

			if(startElement == null){
				throw new Exception();
			}
			
			int counter = 0;
			for (Element currentElement = startElement; currentElement != null; currentElement = currentElement
					.getNext()) {
				if (counter == pos) {
					Element next = currentElement.getNext();
					Element previous = currentElement.getPrevious();
					if (next == null && previous == null) {
					  elemente=new Element[0];
					}else{
					  if (next == null ){
					    previous.setNext(null);
					  }
		        if (previous == null) {
		            next.setPrevious(null);
		          }
		        if(next != null && previous != null){
		          previous.setNext(next);
		          next.setPrevious(previous);
		        }
					}
					// wieder auf null zur�cksetzen
					currentElement.setNext(null);
					currentElement.setPrevious(null);
					break;
				}
				counter++;
			}

			return this;
		}
		throw new Exception();
	}

	/**
	 * Gib den index des gefundenen Elementes zur�ck.
	 * @param Element2
	 * @return index
	 */
	@Override
	public int find(Element element) {
		if (element != null) {
			Element startElement = null;

			//start suchen
			for (int i = 0; i < elemente.length; i++) {
				if (elemente[i] != null && elemente[i].getPrevious() == null) {
					startElement = elemente[i];
					break;
				}
			}
			int counter = 0;
			for (Element currentElement = startElement; currentElement != null; currentElement = currentElement
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
	 * 
	 */
	@Override
	public Element retrieve(int pos) throws Exception {
		if (pos >= 0 && this.size() > pos) {

			Element startElement = null;

			//suche nach startElement
			for (int i = 0; i < elemente.length; i++) {
				if (elemente[i] != null && elemente[i].getPrevious() == null) {
					startElement = elemente[i];
					break;
				}
			}

			int counter = 0;
			for (Element currentElement = startElement; currentElement != null; currentElement = currentElement
					.getNext()) {
				if (counter == pos) {
					return currentElement;
				}
				counter++;
			}
		}
		throw new Exception();
	}

	/**
	 * Die beiden Listen werden verbunden.
	 * @param die zweite Liste
	 * @return Liste
	 */
	@Override
	public IList concat(IList list) throws Exception {
        int listSize = list.size();
		if ( listSize == 0) {
			return this;
		}
		
		Element[] newElement = this.elemente;
		if (elemente.length - this.size() <  listSize) {
			newElement = new Element[this.size() +  listSize + 10];
			// elemente wird in das neue Array eingef�gt
			for (int i = 0; i < elemente.length; i++) {
				newElement[i] = elemente[i];
			}
			this.elemente = newElement;
		}	
		// die zweite Liste wird dem neuen Array hinzugef�gt
		for (int i = listSize-1; i >=  0; i--) {
			Element concactElement =new Element(list.retrieve(i));
			this.insert(this.size(),concactElement);
		}
		
		return this;
	}

	/**
	 * Gib die Anzahl  der Elemente zur�ck.
	 * @return die Anzahl der Elemente
	 */
	@Override
	public int size() {
		int counter = 0;
		Element startElement = null;

		//sucht das Startelement
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] != null && elemente[i].getPrevious() == null) {
				startElement = elemente[i];
				break;
			}
		}

		//Z�hlt die Elemente
		if (startElement != null) {
			for (Element currentElement = startElement; currentElement != null; currentElement = currentElement
					.getNext()) {
				counter++;
			}
		}
		return counter;
	}
	
	
	public static void main(String[] args){
	  BList list= new BList();
	  try {
	    Element a=new Element();
	    Element b=new Element();
	    Element c=new Element();
	    Element d=new Element();
	    
	    
      list.insert(0, a);
      System.out.println(list.size());
      if(list.retrieve(0)==a){
        System.out.println("a");
      }
      list.insert(0, b);
      if(list.retrieve(0)==b){
        System.out.println("b");
      }
      list.insert(0, c);
      System.out.println(list.size());
      if(list.retrieve(0)==c){
        System.out.println("c");
      }
      list.delete(0);
      if(list.retrieve(0)==b){
        System.out.println("d");
      }
      System.out.println(list.size());
      list.delete(1);
      System.out.println(list.size());
      if(list.retrieve(0)==b){
        System.out.println("e");
      }
      list.delete(0);
      System.out.println(list.size());
      list.insert(0,d);
      System.out.println(list.size());
      if(list.retrieve(0)==d){
        System.out.println("f");
      }

      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}
}
