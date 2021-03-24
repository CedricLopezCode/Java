package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao implements IDAO<Produit>{

	Connection connect = GetConnect.getConnection();
	
	@Override
	public void create(Produit object) {
		try {
			PreparedStatement cPro = connect.prepareStatement("INSERT INTO produit"+"(nomP)"+"VALUES (?)");
			cPro.setString(1, object.getNomP());
			cPro.executeUpdate();
			System.out.println("\nCreate Produit :");
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("Create Produit KO");
		}
		
		
	}

	@Override
	public void afficher() {
		try {
			PreparedStatement rPro = connect.prepareStatement("SELECT * FROM produit");
			ResultSet rs = rPro.executeQuery();
			System.out.println("\nid\tNom Produit");
			while(rs.next()) {
				System.out.println(rs.getInt("id") +"\t"+ rs.getString("nomP"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("Read Produit KO");
		}
	}
	@Override
	public List<Produit> lister() {
		List<Produit> liste = new ArrayList<Produit>();
		try {
			PreparedStatement lPro = connect.prepareStatement("SELECT * FROM client");//pas besoin de ; a la fin de la requete
			ResultSet rs /*convention*/ = lPro.executeQuery();
			while(rs.next()) {
				Produit pro = new Produit(null);
				pro.setNomP(rs.getString("nomP"));
				liste.add(pro);
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Liste Produit KO");
		}
		return liste;
	}
	@Override
	public void update(int id, String nv_nom) {
		try {
			PreparedStatement uPro = connect.prepareStatement("UPDATE produit "+"SET nomP = ? " + "WHERE id= ?");
			uPro.setString(1, nv_nom);
			uPro.setInt(2, id);
			uPro.executeUpdate();
			System.out.println("\nUpdate produit:");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("Update Produit KO");
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement dPro = connect.prepareStatement("DELETE FROM produit "+"WHERE id= ?");
			dPro.setInt(1, id);
			dPro.executeUpdate();
			System.out.println("\nDelete produit:");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("Delete Produit KO");
		}		
	}

	@Override
	public void findBy(Produit object) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void vider_table(Produit object) {
		try {
			PreparedStatement vidPro = connect.prepareStatement("DELETE FROM produit");
			vidPro.executeUpdate();
			System.out.println("\nVider Table produit:");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Vider Table produit KO");
		}
	}

}
