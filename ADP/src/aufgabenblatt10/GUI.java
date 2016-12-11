package aufgabenblatt10;

import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {

	public static HashTable hashTable;

	public static void show(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("IP-Adressen-Liste");

		ObservableList<String> data = FXCollections.observableArrayList();

		final Label label = new Label();
		// label.setAlignment(Pos.BASELINE_RIGHT);
		
		//erstellen einer ViewList mit den IP's 
		final ListView<String> listView = new ListView<String>(data);
		//erstellen der IP-Liste
		Set<IPAddress> ips = hashTable.getIPs();
		for (IPAddress ip : ips) {
			data.add(ip.toString());
		}
		listView.setOnMouseClicked(new GUIEventHandler() {

			@Override
			public void handle(MouseEvent arg0) {

				IPAddress ip = IPAddress.fromString(listView
						.getSelectionModel().getSelectedItem());
				hashTable.resetCounter();
				List<Integer> lines = hashTable.get(ip.getValue());
				System.out.println("Counter: " + hashTable.getCounter());

				String text = "";
				for (int line : lines) {
					text += LineLoader.loadLine("list", line) + "\n";
				}
				//System.out.println(text);
				label.setText(text);
			}

		});

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(label);

		// scrollPane.setPrefWidth(500);
		// scrollPane.setMaxWidth(Double.MAX_VALUE);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		// scrollPane.setFitToWidth(true);

		HBox hbox = new HBox();
		// hbox.getChildren().add(listView);
		// hbox.getChildren().add(scrollPane);
		hbox.getChildren().addAll(listView, scrollPane);
		HBox.setHgrow(scrollPane, Priority.ALWAYS);

		StackPane root = new StackPane();
		root.getChildren().add(hbox);
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}

	private static class GUIEventHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			System.out.println("IP-Adresse ausgew�hlt.");
		}

	}
}
