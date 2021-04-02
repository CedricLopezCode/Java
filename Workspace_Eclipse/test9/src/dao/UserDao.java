package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import swing_dao.Dao_swing;

public class UserDao implements IDAO<User>{

	Connection connect = GetConnect.getConnection();
	
	@Override
	public void create(User object) {
		
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO user" + "(email, pwd) VALUES (?,?) ");
			
			req.setString(1, object.getEmail());
			req.setString(2, object.getPassword());
			System.out.println(object.getPassword());
			System.out.println(req);
			req.executeUpdate();
			System.out.println("Insertion OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
	}

	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> lister() {
		List<User> tableauUser = new ArrayList<User>();
		try {
			PreparedStatement listUser = connect.prepareStatement("SELECT * FROM user");
			ResultSet rs = listUser.executeQuery();
			while (rs.next()) {
				User userTempBoucle = new User(null, null);
				userTempBoucle.setId(rs.getInt("id"));
				userTempBoucle.setEmail(rs.getString("email"));
				userTempBoucle.setPassword(rs.getString("pwd"));
				tableauUser.add(userTempBoucle);
			}
		
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Select KO");
		}
		return tableauUser;
	}

	@Override
    public void update(User object) {

        try {
            PreparedStatement req = connect.prepareStatement("UPDATE user SET email = ? , pwd = ? WHERE id= ? ");
            req.setString(1, object.getEmail());
            req.setString(2, object.getPassword());
            req.setInt(3, object.getId());
            req.executeUpdate();
            System.out.println("Update ok");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Insertion KO - KO - KO");
        }

    }

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void vider_table(User object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findBy(User object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String email, String pwd) {
		List<User> tableauUser = new ArrayList<>();
		try {
			PreparedStatement listUser = connect.prepareStatement("SELECT * FROM user " +"WHERE email = ?"+" AND pwd = ?");
			listUser.setString(1, email);
			listUser.setString(2, pwd);
			System.out.println(listUser);
			ResultSet rs = listUser.executeQuery();
			while (rs.next()) {
				User userTempBoucle = new User(null, null);
				userTempBoucle.setId(rs.getInt("id"));
				userTempBoucle.setEmail(rs.getString("email"));
				userTempBoucle.setPassword(rs.getString("pwd"));
				tableauUser.add(userTempBoucle);
			}
			System.out.println(tableauUser.size());
			return tableauUser.size() == 1 ? true : false;
		} catch (Exception e3) {
			e3.printStackTrace();
			return false;
		}
	}
	
	public static DefaultTableModel liste() {
		String[] col = {"ID","Email","Pwd"};
		UserDao usDao = new UserDao();
		DefaultTableModel tab = new DefaultTableModel(null,col);
		List<User> listUser = new ArrayList<>();
		listUser.addAll(usDao.lister());
		for (int index = 0; index < listUser.size(); index++) {
			User us = listUser.get(index);
			Vector vect = new Vector(); //== ArrayList avec modif en direct sans rafraichir
			vect.add(us.getId());
			vect.add(us.getEmail());
			vect.add(us.getPassword());
			
			tab.addRow(vect);
		}
		return tab;
	}


}