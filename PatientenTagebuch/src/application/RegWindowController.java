package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegWindowController {
	private String bPW2;
	private String bPW;
	private String beMail;
	private String bUsername;
	private String bNachname;
	private String bVorname;
	
	public String getbPW2() {
		return bPW2;
	}

	public void setbPW2(String bPW2) {
		this.bPW2 = bPW2;
	}

	public String getbPW() {
		return bPW;
	}

	public void setbPW(String bPW) {
		this.bPW = bPW;
	}

	public String getBeMail() {
		return beMail;
	}

	public void setBeMail(String beMail) {
		this.beMail = beMail;
	}

	public String getbUsername() {
		return bUsername;
	}

	public void setbUsername(String bUsername) {
		this.bUsername = bUsername;
	}

	public String getbNachname() {
		return bNachname;
	}

	public void setbNachname(String bNachname) {
		this.bNachname = bNachname;
	}

	public String getbVorname() {
		return bVorname;
	}

	public void setbVorname(String bVorname) {
		this.bVorname = bVorname;
	}

	@FXML
	private TextField vorName;
	@FXML
	private TextField nachName;
	@FXML
	private TextField userName;
	@FXML
	private TextField eMail;
	@FXML
	private TextField firstPW;
	@FXML
	private TextField secondPW;
	
	public Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public void datenSenden() {
//		bVorname = vorName.getText();
//		bNachname = nachName.getText();
//		bUsername = userName.getText();
//		beMail = eMail.getText();
//		bPW = firstPW.getText();
//		bPW2 = secondPW.getText();
//		
//		System.out.printf("Du wurdest erfolgreich mit dem Benutzernamen: %s und der E-Mail: %s registriert.\n", bUsername, beMail);
		Main.dbc.register();
	}
	
	public void abbrechen() {
		main.startWindow();
	}

}
