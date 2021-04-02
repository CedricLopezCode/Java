package blog_article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;




public class ArticleDAO implements IDAO<Article>{

	Connection connect = SeConnecter.avoirConnection();
	
	@Override
	public void create(Article object) {
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO article (titre, resum, contenu, created_at, id_auteur) VALUES (?,?,?,now(),?)");
			req.setString(1, object.getTitre());
			req.setString(2, object.getResum());
			req.setString(3, object.getContenu());
			req.setInt(4, 1);
			System.out.println(req);
			req.executeUpdate();
			
			
			System.out.println("Create ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Create ERREUR !");
		}
	}

	@Override
	public List<Article> read() {
		List<Article> listeArticle = new ArrayList<>();
		Article tempArticle = new Article();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempArticle.setId_article(rs.getInt("id_Article"));
				tempArticle.setTitre(rs.getString("titre"));
				tempArticle.setResum(rs.getString("resum"));
				tempArticle.setContenu(rs.getString("contenu"));
				tempArticle.setCreated_at(rs.getString("created_at"));
				tempArticle.setAuteur(rs.getInt("id_auteur"));
				
				listeArticle.add(tempArticle);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}
		return listeArticle;
	}

	@Override
	public void delete(Article object) {
		
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM article WHERE id = ? ");
			req.setInt(1, object.getId_article());
			req.executeUpdate();
			
			System.out.println("Delete ok");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete ERREUR !");
		}
	}
	
	@Override
	public List<Article> lister() {
		/*List<Article> listeArticle = new ArrayList<>();
		Article tempArticle = new Article();
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				tempArticle.setId_article(rs.getInt("id_Article"));
				tempArticle.setNom(rs.getString("nom"));
				tempArticle.setPrenom(rs.getString("prenom"));
				tempArticle.setPrenom(rs.getString("email"));
				tempArticle.setPrenom(rs.getString("pwd"));
				
				listeArticle.add(tempArticle);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Read ERREUR !");
		}*/
		return null;
	}

	public static DefaultTableModel liste() {
		String[] col = {"ID","titre","Resum"};
		ArticleDAO artDao = new ArticleDAO();
		DefaultTableModel tab = new DefaultTableModel(null,col);
		List<Article> listArt = new ArrayList<>();
		listArt.addAll(artDao.read());
		for (int index = 0; index < listArt.size(); index++) {
			Article art = listArt.get(index);
			Vector vect = new Vector();
			vect.add(art.getId_article());
			vect.add(art.getTitre());
			vect.add(art.getResum());
			
			tab.addRow(vect);
		}
		return tab;
	}

	@Override
	public void update(Article object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findBy(Article object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vider_table(Article object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String email, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}
	

}