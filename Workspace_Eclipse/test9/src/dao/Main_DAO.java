package dao;

import java.util.List;

public class Main_DAO {

	public static void main(String[] args) {
		
		//Connection testConnection = GetConnect.getConnection();
		
		//Preparation Client
		ClientDao dao_client = new ClientDao();
		
		//afficher via recup
		List<Client> liste_client = dao_client.lister();
		System.out.println("\nid"+ "\t" +"nom" +"\t"+ "prenom");
		for (Client client: dao_client.lister()) {
			System.out.println(client.getId() +"\t"+ client.getNom()+"\t"+ client.getPrenom());
		}
		
		//Creation Client
		dao_client.create(new Client("aa", "aaaa"));
		dao_client.create(new Client("bb", "bbbb"));
		dao_client.create(new Client("cc", "cccc"));
		dao_client.create(new Client("dd", "dddd"));
		dao_client.create(new Client("ee", "eeee"));
		dao_client.create(new Client("ff", "ffff"));
		dao_client.create(new Client("gg", "gggg"));
		
		//Read client
		dao_client.afficher();
		
		//Update Client
		dao_client.update(2, "Cedric");
		dao_client.afficher();
		
		//Delete Client
		dao_client.delete(15);
		dao_client.afficher();
		
		//Vider Table Client
		dao_client.vider_table(null);
		dao_client.afficher();
		
		//Preparation produit
		ProduitDao dao_produit = new ProduitDao();
		dao_produit.afficher();
		
		//Creation produit
		dao_produit.create(new Produit("atta"));
		dao_produit.create(new Produit("bbbbbb"));
		dao_produit.create(new Produit("cccccc"));
		dao_produit.create(new Produit("dddddd"));
		dao_produit.create(new Produit("eeeeee"));
		dao_produit.create(new Produit("ffffff"));
		dao_produit.create(new Produit("ggggg"));
		
		//Read produit
		dao_produit.afficher();
		
		//Update produit
		dao_produit.update( 2, "Cedric");
		dao_produit.afficher();
		
		//Delete produit
		dao_produit.delete( 5);
		dao_produit.afficher();
		
		//Vider Table produit
		//dao_produit.vider_table(null);
		dao_produit.afficher();
		
		
		
		
	}//Fin Main
	
	

}// Fin Classe
