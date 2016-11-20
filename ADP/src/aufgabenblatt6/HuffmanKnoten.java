package aufgabenblatt6;

public class HuffmanKnoten implements Comparable<HuffmanKnoten> {

	private Character buchstabe;

	private int haeufigkeit;

	private HuffmanKnoten links;

	private HuffmanKnoten rechts;

	public HuffmanKnoten(char buchstabe) {
		this(buchstabe, null, null, 1);
	}

	public Character getBuchstabe() {
		return buchstabe;
	}

	public void setBuchstabe(Character buchstabe) {
		this.buchstabe = buchstabe;
	}

	public HuffmanKnoten getLinks() {
		return links;
	}

	public void setLinks(HuffmanKnoten links) {
		this.links = links;
	}

	public HuffmanKnoten getRechts() {
		return rechts;
	}

	public void setRechts(HuffmanKnoten rechts) {
		this.rechts = rechts;
	}

	public HuffmanKnoten(Character buchstabe, HuffmanKnoten links, HuffmanKnoten rechts, int haeufigkeit) {
		this.buchstabe = buchstabe;
		this.links = links;
		this.rechts = rechts;
		this.haeufigkeit = haeufigkeit;
	}

	public void haufigkeitErhoehen() {
		haeufigkeit++;
	}

	public int getHaeufigkeit() {
		return haeufigkeit;
	}

	public void setHaeufigkeit(int haeufigkeit) {
		this.haeufigkeit = haeufigkeit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HuffmanKnoten other = (HuffmanKnoten) obj;
		if (buchstabe != other.buchstabe) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(HuffmanKnoten o) {
		if (haeufigkeit == o.getHaeufigkeit()) {
			return 0;
		}
		if (haeufigkeit < o.getHaeufigkeit()) {
			return -1;
		}
		return 1;

	}

}
