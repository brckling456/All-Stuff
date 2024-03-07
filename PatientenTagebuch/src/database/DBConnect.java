package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;

public class DBConnect {
	private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
	private String dUName;
	private String dPW;
	private String dVorname;
	private String dNachname;
    
	public String getdUName() {
		return dUName;
	}

	public String getdPW() {
		return dPW;
	}

	public String getdVorname() {
		return dVorname;
	}

	public String getdNachname() {
		return dNachname;
	}

	public Main main;
		
	public void setMain(Main main) {
		this.main = main;
	}
    
	public void connect() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ptdatabase?" 
							 + "user=PTAdmin&password=q7T92");
			System.out.println("Verbindung Erfolgreich.");

		} catch (SQLException e) {
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
	}
	
	public void register(String bUsername, String beMail, String bPW, String bVorname, String bNachname) {
		try {
			ResultSet resultSet = null;
			String insertSql = "INSERT INTO users (username, email, passwort, vorname, nachname) VALUES ('" + bUsername + "', '" + beMail + "', '" + bPW + "','" + bVorname + "', '" + bNachname + "');";
			preparedStatement = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			
			while (resultSet.next()) {
				System.out.println("Generated: " + resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectLogin(String bBName,String bPW) {
	
		
		try {
			statement= conn.createStatement();
			
			String selectSql = "SELECT * FROM users WHERE username = '" + bBName + "' AND passwort = '" + bPW + "';";
			resultSet = statement.executeQuery(selectSql);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(2) + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6));
				this.dUName = resultSet.getString(2);
				this.dPW = resultSet.getString(4);
				this.dVorname = resultSet.getString(5);
				this.dNachname = resultSet.getString(6);
				System.out.printf("Hallo %s %s dein Benutzername lautet %s und dein Passwort ist %s.\n",dVorname,dNachname,dUName,dPW);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			conn.close();
			System.out.println("Verbindung getrennt.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}