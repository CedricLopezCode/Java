package blog_article;

import java.sql.Connection;
import java.sql.DriverManager;

public class SeConnecter {
	
	public static Connection avoirConnection() {
		
		//Preparation
		String url = "jdbc:mysql://localhost/";
		String nomDB = "blog";
		String user = "root";
		String passeword = "";
		Connection connect = null;
		
		//Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url+nomDB, user, passeword);
			System.out.println("je suis bien connect�");
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return connect;
	}//Fin avoirConnection
	
}//Fin SeConnecter