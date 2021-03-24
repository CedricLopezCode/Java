package sudoku;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetDB {
	
	public static Connection getConnection() {
	
	//preparation
		String url = "jdbc:mysql://localhost/";
		String DB = "sudoku";
		String user = "root";
		String mdp = "";
		
		Connection connect = null;
		
		//Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url+DB, user, mdp);
			System.out.println("je suis bien connecté");
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return connect;	
	}// fin getConnection
	
}//fin class
