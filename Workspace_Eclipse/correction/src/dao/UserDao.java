package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.Connect;
import model.User;

public class UserDao implements IDAO<User> {

	Connection connect = Connect.getConnection();
	
	public void ecrire(User object) {
		
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user (nom,prenom,email,password)"
					+ "VALUES (?,?,?,?)");
			
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getEmail());
			req.setString(4, object.getPassword());
			
			req.executeUpdate();
			
			System.out.println( object.getPrenom()+ "  " +object.getNom() +" a été bien ajouté en base");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		
	}
	
	//Verification email
	public boolean mailExist(String mail) {
		Boolean message = false;
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=?");
			
			req.setString(1, mail);
			
			ResultSet rs = req.executeQuery();
			
			if(!rs.next()) {
				System.out.println("Email existe déja");
				message = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return message;
		
	}
	
	//La connection 
	
	public boolean login(String mail, String pwd) {
		Boolean message = false;
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=?"
					+ " AND password=?");
			
			req.setString(1, mail);
			req.setString(2, pwd);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				message = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public boolean create(User object) {
		// TODO Auto-generated method stub
		return false;
	} 
}
