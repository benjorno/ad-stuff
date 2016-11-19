package aufgabenblatt4;

public interface IList {
  public void insert(int pos,Element element);

  public IList delete(int pos)  throws Exception;

  public int find(Element element);

  public Element retrieve(int pos) throws Exception;

  public IList concat(IList list) throws Exception;

  public int size();
  
  public void bubbleSort();
  
  public long insertionSort();
  
  public IList listeMitZufallszahlen(int n );
  //public Element getElemente(int i);
}
