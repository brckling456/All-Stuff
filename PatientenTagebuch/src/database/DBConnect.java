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
			PreparedStatement st = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
			
			st.execute();
			resultSet = st.getGeneratedKeys();
			
			while (resultSet.next()) {
				System.out.println("Generated: " + resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectLogin(String statement) {
		try {
			Statement st = conn.createStatement();
			
			String selectSql = statement;
			resultSet = st.executeQuery(selectSql);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			conn.close();
			System.out.println("Verbindung getrennt.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}