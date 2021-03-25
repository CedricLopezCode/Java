package dao;

import java.sql.Connection;
import java.sql.DriverManager;


//Couche persistence
public class Connection_DB {
	
	public static Connection seConnecter()  //static = pas besoin d'instancier un objet de cette classe pour l'utiliser
	{
		//preparation
		String url = "jdbc:mysql://localhost/";
		String nomDB = "dao";
		String user = "root";
		String passeword = "";
		Connection connect = null;
		
		//Connection
		try { //Exception si pas de probleme
			Class.forName("com.mysql.jdbc.Driver");//Récuperer nom classe
			connect = DriverManager.getConnection(url+nomDB, user, passeword);//Information de connection
			System.out.println("je suis bien connecté");
		}catch(Exception e){//Exception si probleme
			System.out.println(e);// == numero d'erreur
			e.printStackTrace();//pour evoir les logs
		}
		return connect;
	}//Fin getConnection

}//Fin getConnect
