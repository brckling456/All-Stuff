package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MainWindowController {
	String bName;
	String bPW;
	String dName = "Markus";
	String dPW = "q7T92";
	
	// Views
	@FXML
	private TextField bBenutzername;
	@FXML
	private PasswordField bPassword;
	

	
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void klickSenden() {
		bName = bBenutzername.getText();
		bPW = bPassword.getText();
//		main.mainWindow();
		if (bName.equals(dName) && bPW.equals(dPW)) {
//			main.mainWindow();
		} else {
			System.out.println("Die Eingegebenen Daten stimmen nicht mit der Datenbank ueberein.");
		}
		
	}
	
	@FXML
	public void klickRegistrieren() {
		main.regWindow();
	}
	
	@FXML
	public void klickAbbrechen() {
		Main.dbc.disconnect();
		Platform.exit();
		
	}
}
