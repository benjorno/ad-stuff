package aufgabenblatt10;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GUIEventHandler implements EventHandler<MouseEvent>{
	
	@Override
	public void handle(MouseEvent event) {
		System.out.println("IP-Adresse ausgewaehlt.");
	}

}
