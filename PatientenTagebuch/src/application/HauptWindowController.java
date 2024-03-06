package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HauptWindowController {
	
	@FXML
	private TextField bzWert;
	
	@FXML
	private TextField iMenge;
	
	@FXML
	private TextField uhrZeit;
	
	@FXML
	private DatePicker datum;
	
	@FXML
	private Label gruesse;

	public MainWindowController mwc;
	
	public Main main;
		
	public void setMain(Main main){
		this.main = main;
	}
	
	public void senden() {
		
	}
	public void goBack() {
		main.startWindow();
	}
	
//	public void bgruesse() {
//		gruesse.setText("Wilkommen Zurück" + mwc.bName);
//	}
}
