package aufgabenblatt1;

public interface IList {
  public IList insert(int pos,Element element) throws Exception;

  public IList delete(int pos)  throws Exception;

  public int find(Element element);

  public Element retrieve(int pos) throws Exception;

  public IList concat(IList list) throws Exception;

  public int size();
}
