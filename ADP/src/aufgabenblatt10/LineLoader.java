package aufgabenblatt10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LineLoader {

	public static String loadLine(String filename, int line) {
		try {
			RandomAccessFile raf = new RandomAccessFile("list", "r");
			raf.seek(line * 72);
			String ret = raf.readLine();
			raf.close();
			return ret;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
