package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDao implements IDAO<Client>{

	Connection connect = getConnect.getConnection();
	
	@Override
	public void create(Client object) {
		try {
			PreparedStatement cCli = connect.prepareStatement("INSERT INTO client"+ "(nom,prenom) VALUES (?,?) ");//?,? pour sécurite et eviter injection sql des hackers
			cCli.setString(1, object.getNom());
			cCli.setString(2, object.getPrenom());
			cCli.executeUpdate();
			System.out.println("\nCreation client ok");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Creation client KO");
		}
		
	}

	@Override
	public void read() {
		try {
			PreparedStatement rCli = connect.prepareStatement("SELECT * FROM client");//pas besoin de ; a la fin de la requete
			ResultSet rs /*convention*/ = rCli.executeQuery();
			System.out.println("\nid"+ "\t" +"nom" +"\t"+ "prenom");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+ "\t" + rs.getString("nom") +"\t"+ rs.getString("prenom"));
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Read client KO");
		}
	}

	
	@Override
	public void update(Client object, int id, String nv_nom) {
		try {
			PreparedStatement uCli = connect.prepareStatement("UPDATE client " + "SET prenom = ? " +"WHERE id= ?");
			uCli.setString(1, nv_nom);
			uCli.setInt(2, id);
			uCli.executeUpdate();
			System.out.println("\nUpdate client ok");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Update client KO");
		}
	}

	@Override
	public void delete(Client object, int id) {
		try {
			PreparedStatement dCli = connect.prepareStatement("DELETE FROM client "+"WHERE id= ?");
			dCli.setInt(1, id);
			dCli.executeUpdate();
			System.out.println("\nDelete client ok");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Delete client KO");
		}
		
	}

	@Override
	public void findBy(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vider_table(Client object) {
		try {
			PreparedStatement vidCli = connect.prepareStatement("TRUNCATE TABLE client");
			vidCli.executeUpdate();
			System.out.println("\nVider Table client ok");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Vider Table client KO");
		}
	}

}
