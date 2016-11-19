package aufgabenblatt2;

public class ErrorException extends Exception {
	private static final long serialVersionUID =  -2237562890601173518L;

	public ErrorException(String fault) {
		super(fault);
	}
}
