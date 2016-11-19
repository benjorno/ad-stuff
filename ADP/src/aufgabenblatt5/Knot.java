package aufgabenblatt5;


public class Knot {
	private int value = 0; // Key
	private int data = 0;
	private Knot rightTree = null;
	private Knot leftTree = null;
	private int sum;

	public int getValue() {
		return value;
	}

	public Knot(int value, Knot rightTree, Knot leftTree) {
		this.value = value;
		this.rightTree = rightTree;
		this.leftTree = leftTree;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Knot getRightTree() {
		return rightTree;
	}

	public void setRightTree(Knot rightTree) {
		this.rightTree = rightTree;
	}

	public Knot getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Knot leftTree) {
		this.leftTree = leftTree;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Knoten " + value;
	}

}
