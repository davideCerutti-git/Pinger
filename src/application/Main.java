package application;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.fxml.FXMLLoader;
//
//public class Main extends Application {
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//
//			VBox root = new VBox();
//			ListView listView = new ListView();
//			listView.getItems().add("Ping 1");
//			listView.getItems().add("Ping 2");
//			listView.getItems().add("Ping 3");
//			root.getChildren().add(listView);
//
//			String ipStr = "172.21.1.1";
//
//			if (ping3(ipStr)) {
//				System.out.println("ping " + ipStr + " Ok");
//			} else {
//				System.out.println("ping " + ipStr + " Ko");
//			}
//
//			Scene scene = new Scene(root, 400, 400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	private static boolean ping(String host) throws IOException, InterruptedException {
//		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
//
//		ProcessBuilder processBuilder = new ProcessBuilder("ping", isWindows ? "-n" : "-c", "1", host);
//		System.out.println("Sending Ping Request to " + host);
//		Process proc = processBuilder.start();
//
//		int returnVal = proc.waitFor();
//		return returnVal == 0;
//	}
//
//	public static boolean ping2(String ipAddress) throws UnknownHostException, IOException {
//		InetAddress geek = InetAddress.getByName(ipAddress);
//		System.out.println("Sending Ping Request to " + ipAddress);
//		if (geek.isReachable(5000))
//			return true;
//		else
//			return false;
//	}
//	
//	public static boolean ping3(String ipAddress) {
//		String pingCmd = "ping " + ipAddress;
//		String pingResult = "";
//        try {
//            Runtime r = Runtime.getRuntime();
//            Process p = r.exec(pingCmd);
//
//            BufferedReader in = new BufferedReader(new
//            InputStreamReader(p.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//                pingResult += inputLine;
//            }
//            in.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//		
//		
//		return false;
//	}
//}


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
   

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<PingItem> data = FXCollections.observableArrayList();
        data.addAll(new PingItem("IP1", "172.21.1.1"), new PingItem("IP2", "172.21.2.1"), new PingItem("IP3", "172.21.10.1"));

        final ListView<PingItem> listView = new ListView<PingItem>(data);
        listView.setCellFactory(new Callback<ListView<PingItem>, ListCell<PingItem>>() {
            @Override
            public ListCell<PingItem> call(ListView<PingItem> listView) {
                return new PingListCell();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }

   

}
