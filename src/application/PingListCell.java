package application;

import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PingListCell extends ListCell<PingItem> {
	private HBox content;
	private Text name;
	private Text price;
	private ThPinger thPinger;

	public PingListCell() {
		super();
		name = new Text();
		price = new Text();
		VBox vBox = new VBox(name, price);
		content = new HBox(new Label("[Graphic]"), vBox);
		content.setSpacing(10);

	}

	@Override
	protected void updateItem(PingItem item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null && !empty) { // <== test for null item and empty parameter
			name.setText(item.getName());
			price.setText(String.format("%s", item.getPrice()));
			VBox vBox = new VBox(name, price);
			try {
				if (ping(item.getIpAddress())) {

					content = new HBox(new Label("[ok]"), vBox);
				} else {
					content = new HBox(new Label("[ko]"), vBox);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setGraphic(content);

		} else {
			setGraphic(null);
		}
	}

	private static boolean ping(String host) throws IOException, InterruptedException {
		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

		ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
		System.out.println("Sending Ping Request to " + host);
		Process proc = processBuilder.start();

		int returnVal = proc.waitFor();
		return returnVal == 0;
	}
}