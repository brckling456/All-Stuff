package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MainWindowController {
	private String bUName;
	private String bPW;

	
	
	
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
		bUName = bBenutzername.getText();
		bPW = bPassword.getText();
		Main.dbc.selectLogin(bUName, bPW);
		if (bUName.equals(Main.dbc.getdUName()) && bPW.equals(Main.dbc.getdPW())) {
			main.mainWindow();
		} else {
			System.out.println("Benutzername und Passowt stimmen nicht überein oder sind nicht vorhanden.");
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
