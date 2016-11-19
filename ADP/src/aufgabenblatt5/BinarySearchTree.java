package aufgabenblatt5;

import aufgabenblatt2.ErrorException;

public class BinarySearchTree {

//	public int sum = 0;
	private Knot anchor = null;
private boolean treeIsReady;
	public BinarySearchTree(Knot anker) {
		this.anchor = anker;
		treeIsReady = false;
	}

	public int searchKnot(int searchValue) throws ErrorException {
		Knot knot = this.anchor;
		while (knot != null && searchValue != knot.getValue()) {
			if (searchValue < knot.getValue()) {
				knot = knot.getLeftTree();
			} else {
				knot = knot.getRightTree();
			}
		}
		if (knot == null) {
			throw new IllegalArgumentException("Error! Element not found!");
		}
		return knot.getData();
	}

	public void insertKnot(int newValue) {
		try {
			anchor = insertRightTree(newValue, anchor);
			treeIsReady  = false;
		} catch (ErrorException e) {
			e.printStackTrace();
		}
	}

	private Knot insertRightTree(int value, Knot knot) throws ErrorException {
		// neues Blatt erzeugen
		if (knot == null) {
			return new Knot(value, null, null);
		}
		// Element schon enthalten
		if (value == knot.getValue()) {
			throw new IllegalArgumentException("Error! Element already exists!");
		}
		// im linken Unterbaum suchen bzw. im rechten
		if (value < knot.getValue()) {
			Knot el = insertRightTree(value, knot.getLeftTree());
			knot.setLeftTree(el);
			return knot;
		} else {
			Knot el = insertRightTree(value, knot.getRightTree());
			knot.setRightTree(el);
			return knot;
		}
	}

	public void deleteKnot(int newValue) {
		try {
			treeIsReady = false;
			anchor = deleteRightTree(newValue, anchor);
		} catch (ErrorException e) {
			e.printStackTrace();
		}
	}

	private Knot deleteRightTree(int value, Knot knot) throws ErrorException {
		// rekursive Suche nach dem Element
		if (knot == null) {
			throw new ErrorException("Error! Element not found!");
		}
		if (knot.getData() > value) {
			Knot element = deleteRightTree(value, knot.getLeftTree());
			knot.setLeftTree(element);
			return knot;
		}
		if (knot.getData() < value) {
			Knot element = deleteRightTree(value, knot.getRightTree());
			knot.setRightTree(element);
			return knot;
		} else {
			// einfache Fälle mit leeren Unterbaum
			if (knot.getLeftTree() == null) {
				return knot.getRightTree();
			} else {
				if (knot.getRightTree() == null) {
					return knot.getLeftTree();
				} else {
					// Knoten durch den Inordernachfolger ersetzen
					Knot ersatz = searchFollower(knot);
					ersatz.setLeftTree(knot.getLeftTree());
					ersatz.setRightTree(knot.getRightTree());
					return ersatz;
				}
			}
		}
	}

	private Knot searchFollower(Knot knot) {
		Knot follower;
		// Wurzel des Unterbaums ist Nachfolger
		if (knot.getRightTree().getLeftTree() == null) {
			follower = knot.getRightTree();
			knot.setRightTree(knot.getRightTree().getRightTree());
		} else {
			// Im Unterbaum ganz nach links gehen
			knot = knot.getRightTree();
			while (knot.getLeftTree().getLeftTree() != null) {
				knot = knot.getLeftTree();
			}
			// Inorder-Nachfolger aushängen
			follower = knot.getLeftTree();
			knot.setLeftTree(knot.getLeftTree().getRightTree());
		}
		return follower;
	}
	
	public void printInOrder() {
		printTreeInOrder(anchor);
	}
	
	private void printTreeInOrder(Knot knot){
		if (knot != null){
			printTreeInOrder(knot.getLeftTree());
			System.out.println("Value:" + knot.getValue());
			printTreeInOrder(knot.getRightTree());
		}
	}
	
	public Knot searchKnotSmallerThen(int value){
		//value zb 12
		Knot searchKnot = anchor;
		Knot knot = null;
		while(searchKnot != null){
			if (value <= searchKnot.getValue()){
				searchKnot = searchKnot.getLeftTree();
			}else {
				knot = searchKnot;
				searchKnot = searchKnot.getRightTree();
			}
		}
		if (searchKnot == null && knot == null){
			knot = null;
		}
		
//		if(searchKnot != null && searchKnot.getValue()  == value){
//			knot = searchKnot;
//		} 
		return knot;
		
	}
	
	public Knot searchKnotGreaterThen(int value){
		Knot searchKnot = anchor;
		Knot knot = null;
		while(searchKnot != null && searchKnot.getValue() != value){
			if (value >= searchKnot.getValue()){
				searchKnot = searchKnot.getRightTree();
			}else {
				knot = searchKnot;
				searchKnot = searchKnot.getLeftTree();
			}
		}
		if (searchKnot == null && knot == null){
			knot = null;
		}
		
//		if(searchKnot != null && searchKnot.getValue()  == value){
//			knot = searchKnot;
//		}
		return knot;
		
	}
	
//	private int sum(Knot knot, int value1, int value2){
//		if ( knot != null ){
//			sum(knot.getLeftTree(),value1, value2);
//			if(knot.getValue() > value1 && knot.getValue() < value2)
//			sum += knot.getValue();
//			sum(knot.getRightTree(),value1,value2);
//		}
//		return sum;
//	}
	
	private void prepare() {
		int array[] = new int[1];
		sum(anchor,array);
		treeIsReady = true;
		
	}
	
	private void sum(Knot knot, int sum[]){
		if ( knot != null ){
			sum(knot.getLeftTree(), sum);
			sum[0] = sum[0] + knot.getValue();
			knot.setSum(sum[0]);
			sum(knot.getRightTree(), sum);
		}
	}
	
	public void sumBetweenKnots(int value1, int value2){
		if(!(treeIsReady)){
			prepare();
			treeIsReady = true;
		}
		Knot knot1 = searchKnotGreaterThen(value1);
		Knot knot2 = searchKnotSmallerThen(value2);
		if(knot1 == null || knot2 == null || value2 < value1){
			System.out.println("Sum between "+ value1 +"and "+ value2 + "is 0!");
		}else {
			System.out.println("Sum of all Knots between " + value1 + " and " + value2 + " is: ");
			System.out.println(knot2.getSum()-knot1.getSum()+knot1.getValue());
		}
	}
	
	
	
	
	public static void main(String args[]) throws Exception {
		BinarySearchTree tree = new BinarySearchTree(null);
		tree.insertKnot(50);
		tree.insertKnot(43);
		tree.insertKnot(12);
		tree.insertKnot(67);
		tree.insertKnot(85);
		tree.insertKnot(44);
		tree.insertKnot(24);
		tree.sumBetweenKnots(24,50);
	}
	
	
	
	

}
