package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HauptWindowController {
	String text =(String) "Hallo " + Main.dbc.getdVorname() + " " + Main.dbc.getdNachname() +  ".";

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

	public Main main;
		
	public void setMain(Main main){
		this.main = main;
	}
	
	public void senden() {
		bgruesse();
	}
	public void goBack() {
		main.startWindow();
	}
	@FXML
	public void bgruesse() {
		gruesse.setText(text);
	}
	
}
