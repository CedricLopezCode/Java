package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao implements IDAO<Produit>{

	Connection connect = Connection_DB.seConnecter();
	
	@Override
	public void create(Produit object) {
		try {
			PreparedStatement cPro = connect.prepareStatement("INSERT INTO produit"+"(nomP)"+"VALUES (?)");
			cPro.setString(1, object.getNomP());
			cPro.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement dPro = connect.prepareStatement("DELETE FROM produit "+"WHERE id= ?");
			dPro.setInt(1, id);
			dPro.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void findBy(Produit object) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void vider_table() {
		try {
			PreparedStatement vidPro = connect.prepareStatement("DELETE FROM produit");
			vidPro.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
