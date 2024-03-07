package application;
	
import java.io.IOException;

import database.DBConnect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
	static DBConnect dbc = new DBConnect();
	static HauptWindowController hwc = new HauptWindowController();
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		startWindow();
	}
	
	public void startWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Start.fxml"));
			Pane pane = loader.load();
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			Scene scene = new Scene(pane);			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void regWindow() {
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Registrierung.fxml"));
			Pane pane = loader.load();
			RegWindowController regWindowController = loader.getController();
			regWindowController.setMain(this);
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Hauptseite.fxml"));
			TabPane pane = loader.load();
			HauptWindowController hauptWindowController = loader.getController();
			hauptWindowController.setMain(this);
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		try {
			dbc.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		launch(args);
	}
}
