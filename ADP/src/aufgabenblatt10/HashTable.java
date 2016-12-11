package aufgabenblatt10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashTable {

	Object[] hashtable;
	private int m = 13;

	// wird erhöht wenn ip in die hashtabelle eingefügt wurde
	private int size = 0;

	// counter für die Komplexitätsuntersuchung
	private long counter;

	public HashTable() {
		hashtable = new Object[15];

	}

	/**
	 * Erstellt eine Hashtabelle aus dem übergebenen File
	 * @param filename,
	 *            beinhaltet die IP-Adressen, Zeit und Text.
	 */
	public void loadHashTable(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			int lineNumber = 0;
			while ((line = br.readLine()) != null) {
				// ausfiltern der Ip Adresse aus der readLine
				String sIp = line.substring(0, line.indexOf('-') - 1);

				// aufsplitten der ip adresse in separate teile
				String[] bytes = sIp.split("\\.");
				// umwandeln der IP-Adresse in eine Zahl
				int ip = 1 << 24;
				ip |= 1 << 16;
				ip |= Integer.parseInt(bytes[2]) << 8;
				ip |= Integer.parseInt(bytes[3]);

				// einfügen der ip mit der Zugehörigen line number
				add(ip, lineNumber);

				// neuberechnen der tabellengröße, ggf tabelle vergrößern
				resizeHashtable();

				lineNumber++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Einfuegen der Ip-Adresse und Liniennummer in die Hashtabelle. 
	 * Hier wird der Hashkey berechnet. Wenn an der berechneten Stelle im Array kein Objekt vorhanden ist, wird an der Stelle eine neue Liste erstellt
	 * und die IP-Adresse eingefügt. Danach wird noch die Liniennummer in die Liste angehängt. Ist bereits eine identische IP vorhanden, so wird lediglich die Liniennummer
	 * in die Liste angehängt.
	 * @param ip
	 * @param line
	 */
	private void add(int ip, int line) {
		// berechne Hash-Key
		int hash = hash(ip);
		// Wenn leere Tabellenzeile, dann erstelle neue Liste in die Zeile, füge
		// ip an die erste stelle und erhöhe size
		if (hashtable[hash] == null) {
			hashtable[hash] = new LinkedList<Integer>();
			((List<Integer>) hashtable[hash]).add(ip);
			size++;
		}
		// füge textzeile in die tabelle ein
		((List<Integer>) hashtable[hash]).add(line);
		// System.out.println("Put " + ip + " into " + hash);
	}

	/**
	 * Diese ist für die Übermittlung des Hashkeys verantwortlich. Hier wird geprüft, ob die Tabellenzeile, in welche die IP eingetragen werden soll, leer ist. Wenn sie leer ist, 
	 * wird der Hashkey an die Add-Methode zurückgeliefert.
	 * Desweiteren wird geprüft, ob die gleiche IP bereits in der Tabelle vorhanden ist, wenn ja wird auch hier der Hash-Key zurückgeliefert.
	 * Kommt es zu einer Kollision, so wird der ermittelte Hashkey neu berechnet (Doppel-Hashing).
	 * @param ip
	 * @return
	 */
	private int hash(int ip) {
		// erhöhe counter um 1
		counter++;

		// wenn hash-key kleiner 0 oder hash-key größer gleich länge der Tabelle
		// mache nichts
		if (h(ip) < 0 || h(ip) >= hashtable.length) {

		}
		// wenn Tabellenzeile leer ist return hash-key
		else if (hashtable[h(ip)] == null) {
			// the first one of this ip
			return h(ip);
		}
		// prüfe ob die gleiche ip schon vorhanden ist, wenn ja gebe den hashkey
		// zurück
		else if (((List<Integer>) hashtable[h(ip)]).get(0) == ip) {
			// ip already existed
			return h(ip);
		}
		int i = 1;
		// doppel hashing wenn kollision
		System.out.println("kollision");
		while (true) {
			counter++;
			int hi = hi(ip, i);
			if (hi < 0 || hi >= hashtable.length) {

			} else if (hashtable[hi] == null) {
				// the first one of this ip
				return hi;
			} else if (((List<Integer>) hashtable[hi]).get(0) == ip) {
				// ip already existed
				return hi;
			}
			i++;
		}
	}

	/**
	 * Berechnung des Hash-Keys mit Modulo m=13
	 * @param k, Ip-Adresse
	 * @return
	 */
	private int h(int k) {
		return k % m;
	}

	/**
	 * Hilfsmethode für hi
	 * @param k
	 * @return
	 */
	private int h_(int k) {
		return 1 + (k % (m - 2));
	}

	/**
	 * Berechnung des Doppel-Hashings
	 * @param k, IP-Adresse
	 * @param i, Berechnungsfaktor
	 * @return
	 */
	private int hi(int k, int i) {
		return (h(k) + h_(k) * i * i) % m;
	}

	/**
	 * Neuberechnung der Tabellengröße wenn der Loadfaktor >= 0.8 ist.
	 */
	private void resizeHashtable() {
		// hashtable anfangslänge ist 15
		double loadFactor = (double) size / hashtable.length;
		if (loadFactor >= 0.8) {
			// need to resize
			int newCap = hashtable.length * 16 / 10;

			// erstelle temporaeres Array
			Object[] tmp = new Object[hashtable.length];

			// spiegel belegte plätze auf temporaeres
			for (int i = 0; i < hashtable.length; ++i) {
				if (hashtable[i] != null) {
					tmp[i] = new LinkedList<Integer>(((LinkedList<Integer>) hashtable[i]));
				}
			}

			// alte tabelle gleich neue tabelle
			hashtable = new Object[newCap];

			//errechnung der Primzahl aus der neuen Tabellengröße
			m = closestPrime(newCap);
			size = 0;
			
			// rehashen der neuen Tabelle
			// System.out.println("rehash");
			for (Object l : tmp) {
				if (l != null) {
					int ip = ((List<Integer>) l).get(0);
					for (int i = 1; i < ((List<Integer>) l).size(); ++i) {
						add(ip, ((List<Integer>) l).get(i));
					}
				}
			}
		}
	}

	/**
	 * berechnung der nächst größeren Primzahl
	 * @param cap
	 * @return
	 */
	private int closestPrime(int cap) {
		for (int i = cap; i > 1; --i) {
			if (isPrime(i)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Pruefen ob Zahl eine Primzahl ist
	 * @param n
	 * @return
	 */
	private boolean isPrime(int n) {
		for (int d = 2; d * d < n; ++d) {
			if (n % d == 0) {
				return false;
			}
		}
		return true;
	}

	public void resetCounter() {
		counter = 0;
	}

	public long getCounter() {
		return counter;
	}

	/**
	 * Liefert den Inhalt der gewünschten IP-Adresse an die GUI
	 * @param ip
	 * @return
	 */
	public List<Integer> get(int ip) {
		//berechnen des Hash-Keys
		int hash = hash(ip);
		//liefert Listeninhalt zurück
		if (hashtable[hash] != null) {
			return ((List<Integer>) hashtable[hash]).subList(1, ((List<Integer>) hashtable[hash]).size());
		} else {
			return new LinkedList<Integer>();
		}
	}

	// aufruf in gui
	public Set<IPAddress> getIPs() {
		Set<IPAddress> ips = new TreeSet<IPAddress>();
		for (Object l : hashtable) {
			if (l != null) {
				ips.add(new IPAddress(((List<Integer>) l).get(0)));
			}
		}
		return ips;
	}
}
