package aufgabenblatt10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class FileGenerator {

	/**
	 * Erstellen des IP-Files
	 * @param nlines anzahl der vorhandenen Lines
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public static void generate(int nlines, String filename)
			throws FileNotFoundException {

		PrintWriter printer = new PrintWriter(new File(filename));

		for (int i = 0; i < nlines; ++i) {
			String line = randomIP() + " - - " + randomTime() + " " + randomText();
			//System.out.println(line.length());
			while (line.length() < 70) {
				line += " ";
			}
			printer.println(line);
		}

		printer.close();

	}

	private static String randomIP() {
		String ret = "";
		//ret += "" + ThreadLocalRandom.current().nextInt(0, 255);
		//ret += "." + ThreadLocalRandom.current().nextInt(0, 255);
		ret += "1.1";
		ret += "." + ThreadLocalRandom.current().nextInt(0, 255);
		ret += "." + ThreadLocalRandom.current().nextInt(0, 255);
		return ret;
	}
	
	private static String randomTime() {
		String ret = "[" + ThreadLocalRandom.current().nextInt(0, 30);
		ret += "/" + ThreadLocalRandom.current().nextInt(0, 12);
		ret += "/" + ThreadLocalRandom.current().nextInt(2000, 2015);
		ret += ":" + ThreadLocalRandom.current().nextInt(0, 24);
		ret += ":" + ThreadLocalRandom.current().nextInt(0, 60);
		ret += ":" + ThreadLocalRandom.current().nextInt(0, 60);
		ret += " +0200]";
		return ret;
	}
	
	private static String randomText() {
		String options[] = {
			"GET /pics.html HTTP/1.0",
			"GET / HTTP/1.0 200 1105",
			"GET /~abc/iks_home.html",
			"GET /trenner_lila.html"
		};
		return options[ThreadLocalRandom.current().nextInt(0, 4)];
	}

}











