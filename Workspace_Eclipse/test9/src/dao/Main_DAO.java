package dao;

import java.sql.Connection;

public class Main_DAO {

	public static void main(String[] args) {
		
		Connection testConnection = getConnect.getConnection();
		
		//Preparation Client
		ClientDao dao_client = new ClientDao();
		dao_client.read();
		
		//Creation Client
		dao_client.create(new Client("aa", "aaaa"));
		dao_client.create(new Client("bb", "bbbb"));
		dao_client.create(new Client("cc", "cccc"));
		dao_client.create(new Client("dd", "dddd"));
		dao_client.create(new Client("ee", "eeee"));
		dao_client.create(new Client("ff", "ffff"));
		dao_client.create(new Client("gg", "gggg"));
		
		//Read client
		dao_client.read();
		
		//Update Client
		dao_client.update(null, 2, "Cedric");
		dao_client.read();
		
		//Delete Client
		dao_client.delete(null, 15);
		dao_client.read();
		
		//Vider Table Client
		dao_client.vider_table(null);
		dao_client.read();
		
		//Preparation produit
		ProduitDao dao_produit = new ProduitDao();
		dao_produit.read();
		
		//Creation produit
		dao_produit.create(new Produit("atta"));
		dao_produit.create(new Produit("bbbbbb"));
		dao_produit.create(new Produit("cccccc"));
		dao_produit.create(new Produit("dddddd"));
		dao_produit.create(new Produit("eeeeee"));
		dao_produit.create(new Produit("ffffff"));
		dao_produit.create(new Produit("ggggg"));
		
		//Read produit
		dao_produit.read();
		
		//Update produit
		dao_produit.update(null, 2, "Cedric");
		dao_produit.read();
		
		//Delete produit
		dao_produit.delete(null, 5);
		dao_produit.read();
		
		//Vider Table produit
		//dao_produit.vider_table(null);
		dao_produit.read();
		
		
		
		
	}//Fin Main
	
	

}// Fin Classe
