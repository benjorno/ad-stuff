package aufgabenblatt10;

import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) {
		//erstellen einer Weblog Datei
		try {
			FileGenerator.generate(4, "list");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Erstellen einer Hashtabelle
		HashTable hashTable = new HashTable();
		//einlesen der Datei
		hashTable.loadHashTable("list");
		
		
		long sum = 0;
		long min = -1, max = -1;
		for (IPAddress i : hashTable.getIPs()) {
			
			hashTable.resetCounter();
			hashTable.get(i.getValue());
			sum += hashTable.getCounter();
			
			if (min == -1) {
				min = hashTable.getCounter();
			}
			if (max == -1) {
				max = hashTable.getCounter();
			}
			if (min > hashTable.getCounter()) {
				min = hashTable.getCounter();
			}
			if (max < hashTable.getCounter()) {
				max = hashTable.getCounter();
			}
		}
		
		double avg = (double) sum / hashTable.getIPs().size();
		
		System.out.println("Counter avg: " + avg);
		System.out.println("Worst: " + max);
		System.out.println("Best: " + min);
		
//		GUI.hashTable = hashTable;
//		GUI.show(args);
		
	}

}
