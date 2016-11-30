package aufgabenblatt10;

public class IPAddress implements Comparable<IPAddress> {
	
	
	private int ip;
	
	public IPAddress(int ip) {
		this.ip = ip;
	}
	
	public int getValue() {
		return ip;
	}
	
	public String toString() {
		String ret = "";
		ret += "" + ((ip >> 24) & 0xFF);
		ret += "." + ((ip >> 16) & 0xFF);
		ret += "." + ((ip >> 8) & 0xFF);
		ret += "." + (ip & 0xFF);
		return ret;
	}
	
	
	public static IPAddress fromString(String ipS) {
		String[] bytes = ipS.split("\\.");
		
		int ip = 1 << 24;
		ip |= 1 << 16;
		ip |= Integer.parseInt(bytes[2]) << 8;
		ip |= Integer.parseInt(bytes[3]);
		
		return new IPAddress(ip);
	}
	
	
	public boolean equals(Object other) {
		if (other != null) {
			if (other instanceof IPAddress) {
				return ((IPAddress)other).ip == ip;
			}
		}
		return false;
	}
	
	
	public int hashCode() {
		return ip;
	}

	@Override
	public int compareTo(IPAddress o) {
		if (ip < o.ip) {
			return -1;
		} else if (ip > o.ip) {
			return 1;
		}
		return 0;
	}
	

}
