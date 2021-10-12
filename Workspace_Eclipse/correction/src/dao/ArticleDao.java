package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connection.Connect;
import model.Article;

public class ArticleDao implements IDAO<Article>{

	Connection connect = Connect.getConnection();
	
	@Override
	public boolean create(Article object) {
		boolean message = false;
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO article"
					+ "(titre, resume, contenu, created_at, auteur) VALUES (?,?,?,now(),?) ");
			
			req.setString(1, object.getTitre());
			req.setString(2, object.getResume());
			req.setString(3, object.getContenu());
			req.setString(4, object.getAuteur());
			
			req.executeUpdate();
			message = true;
			System.out.println("Insertion OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
			
		}
		return message;
		
	}
	
	public List<Article> read() {
		List<Article> listearticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setResume(rs.getString("resume"));
				article.setContenu(rs.getString("contenu"));
				article.setCreated_at(rs.getString("created_at"));
				article.setAuteur(rs.getString("auteur"));
				
				listearticle.add(article);
			}
			System.out.println(listearticle);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listearticle;
	}
	
	public List<Article> findById(int id) {
		List<Article> listearticle = new ArrayList<>();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setResume(rs.getString("resume"));
				article.setContenu(rs.getString("contenu"));
				article.setCreated_at(rs.getString("created_at"));
				article.setAuteur(rs.getString("auteur"));
				
				listearticle.add(article);
			}
			System.out.println(listearticle);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listearticle;
	}

}
