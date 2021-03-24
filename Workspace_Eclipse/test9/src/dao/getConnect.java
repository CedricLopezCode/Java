package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Couche persistence
public class GetConnect {
	
	public static Connection getConnection() {
		//preparation
		String url = "jdbc:mysql://localhost/";
		String nomDB = "dao";
		String user = "root";
		String passeword = "";
		Connection connect = null;
		
		//Connection
		try { //Exception si pas de probleme
			//connection
			Class.forName("com.mysql.jdbc.Driver");//Récuperer nom classe
			connect = DriverManager.getConnection(url+nomDB, user, passeword);
			System.out.println("je suis bien connecté");
			
			//requete sql	
			//PreparedStatement sql = connect.prepareStatement("SELECT * FROM agence");//pas besoin de ; a la fin de la requete
			//ResultSet rs /*convention*/ = sql.executeQuery();
			//while(rs.next()) {
			//	System.out.println(rs.getString("idAgence")+ "\t" + rs.getString("nom") +"\t"+ rs.getString("adresse"));
			//}
		}catch(Exception e){//Exception si probleme
			System.out.println(e);// == numero d'erreur
			e.printStackTrace();//pour evoir les logs
		}
		return connect;
	}//Fin getConnection
	
	public static void XXXX() {}
}//Fin getConnect
