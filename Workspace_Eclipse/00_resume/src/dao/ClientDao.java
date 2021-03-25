package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IDAO<Client>{

	Connection connect = Connection_DB.seConnecter();
	
	@Override
	public void create(Client object) {
		try {
			PreparedStatement cCli = connect.prepareStatement("INSERT INTO client"+ "(nom,prenom) VALUES (?,?) ");
			//?,? pour sécurite et eviter injection sql des hackers
			cCli.setString(1, object.getNom()); //On remplace les ? dans la requete
			cCli.setString(2, object.getPrenom());
			cCli.executeUpdate(); //On exécute la requete
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void afficher() {
		try {
			PreparedStatement rCli = connect.prepareStatement("SELECT * FROM client");//pas besoin de ; a la fin de la requete
			ResultSet rs /*convention*/ = rCli.executeQuery(); //Query pour le SELECT //Retourne un tableau
			System.out.println("\nid"+ "\t" +"nom" +"\t"+ "prenom");
			while(rs.next()) {//0 faire même si seulement 1 élément
				System.out.println(rs.getInt("id")+ "\t" + rs.getString("nom") +"\t"+ rs.getString("prenom"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Client> lister() {
		List<Client> liste = new ArrayList<Client>();
		try {
			PreparedStatement lCli = connect.prepareStatement("SELECT * FROM client");//pas besoin de ; a la fin de la requete
			ResultSet rs /*convention*/ = lCli.executeQuery();
			while(rs.next()) {
				Client cli = new Client(null, null);
				cli.setId(rs.getInt("id"));
				cli.setNom(rs.getString("nom"));
				cli.setPrenom(rs.getString("prenom"));
				liste.add(cli);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	@Override
	public void update(int id, String nv_nom) {
		try {
			PreparedStatement uCli = connect.prepareStatement("UPDATE client " + "SET prenom = ? " +"WHERE id= ?");
			uCli.setString(1, nv_nom);
			uCli.setInt(2, id);
			uCli.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete( int id) {
		try {
			PreparedStatement dCli = connect.prepareStatement("DELETE FROM client "+"WHERE id= ?");
			dCli.setInt(1, id);
			dCli.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void findBy(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vider_table() {
		try {
			PreparedStatement vidCli = connect.prepareStatement("TRUNCATE TABLE client");
			vidCli.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
