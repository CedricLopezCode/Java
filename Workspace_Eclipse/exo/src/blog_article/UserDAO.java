package blog_article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IDAO<User>{

	Connection connect = SeConnecter.avoirConnection();
	
	@Override
	public void create(User object) {
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO utilisateur " + "(nom, prenom, email, pwd)" + " VALUES (?,?,?,?) ");
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getEmail());
			req.setString(4, object.getPwd());
			req.executeUpdate();
			
			System.out.println("Create ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Create ERREUR !");
		}
	}

	@Override
	public List<User> read() {
		List<User> listeUser = new ArrayList<>();
		User tempUser = new User();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM utilisateur");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempUser.setId_user(rs.getInt("id_user"));
				tempUser.setNom(rs.getString("nom"));
				tempUser.setPrenom(rs.getString("prenom"));
				tempUser.setPrenom(rs.getString("email"));
				tempUser.setPrenom(rs.getString("pwd"));
				
				listeUser.add(tempUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeUser;
	}

	@Override
	public void update(User object) {

		try {
			PreparedStatement req = connect.prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ? WHERE id = ?");
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setInt(3, object.getId_user());
			req.executeUpdate();
			
			System.out.println("Update ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Update ERREUR !");
		}
	}

	@Override
	public void delete(User object) {
		
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM utilisateur WHERE id = ?");
			req.setInt(1, object.getId_user());
			req.executeUpdate();
			
			System.out.println("Delete ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete ERREUR !");
		}
	}
	
	@Override
	public List<User> lister() {
		List<User> listeUser = new ArrayList<>();
		User tempUser = new User();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM utilisateur");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempUser.setId_user(rs.getInt("id_user"));
				tempUser.setNom(rs.getString("nom"));
				tempUser.setPrenom(rs.getString("prenom"));
				tempUser.setPrenom(rs.getString("email"));
				tempUser.setPrenom(rs.getString("pwd"));
				
				listeUser.add(tempUser);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeUser;
	}
	@Override
	public boolean login(String email, String pwd) {
		List<User> tableauUser = new ArrayList<>();
		try {
			PreparedStatement listUser = connect.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND pwd = ?");
			listUser.setString(1, email);
			listUser.setString(2, pwd);
			System.out.println(listUser);
			ResultSet rs = listUser.executeQuery();
			
			while (rs.next()) {
				User userTempBoucle = new User();
				userTempBoucle.setId_user(rs.getInt("id_user"));
				userTempBoucle.setEmail(rs.getString("email"));
				userTempBoucle.setPwd(rs.getString("pwd"));
				tableauUser.add(userTempBoucle);
			}
			System.out.println(tableauUser.size());
			return tableauUser.size() == 1 ? true : false;
		} catch (Exception e3) {
			e3.printStackTrace();
			return false;
		}
	}

	@Override
	public void findBy(User object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vider_table(User object) {
		// TODO Auto-generated method stub
		
	}
	
	

}