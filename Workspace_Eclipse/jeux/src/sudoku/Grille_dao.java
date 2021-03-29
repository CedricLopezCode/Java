package sudoku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Grille_dao {
	
	Connection connect = GetDB.getConnection();
			
	public int choix_numero_grille() {
		Scanner scan = new Scanner(System.in);
		int choix_grille;
		do{
			System.out.println("Rentrer le numero de grille à remplir entre 1 et " + grille_max());
			choix_grille = scan.nextInt();
			if  (choix_grille < 1 || choix_grille > grille_max()) {
				System.out.println("Le numero de grille doit etre entre 1 et "+ grille_max());
			}
		}while (1 > choix_grille || choix_grille > grille_max());
		return choix_grille;
	}
	
	public int grille_max() {
		int max_grille = 0;
		try {
			PreparedStatement max = connect.prepareStatement("SELECT MAX(num_grille) FROM sudoku");
			ResultSet rs = max.executeQuery();
			while (rs.next()) {
				max_grille = rs.getInt(1);
				/*if(rs.getInt("num_grille") > max_grille) {
					max_grille = rs.getInt("num_grille");
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("grille max KO");
		}
		return max_grille;
	}
	public ArrayList<Cellule> recup_cell_connues(int num_grille) {
		ArrayList<Cellule> liste_cell_connues = new ArrayList<Cellule>();
		try {
			PreparedStatement lcc = connect.prepareStatement("SELECT * FROM sudoku "+"WHERE num_grille = ?");
			lcc.setInt(1, num_grille);
			ResultSet rs = lcc.executeQuery();
			while(rs.next()) {
				Cellule cell_temp = new Cellule();
				cell_temp.setCoord_ligne(rs.getInt("num_ligne"));
				cell_temp.setCoord_col(rs.getInt("num_col"));
				cell_temp.setChiffre(rs.getInt("chiffre"));
				liste_cell_connues.add(cell_temp);
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Liste cellule KO");
		}
		return liste_cell_connues;
	}
	
	public void ajout_nv_grille_ds_DB(int[][] tab_cell_connues) {
		try {
			int grille_max = grille_max()+1;
			PreparedStatement lcc;
			for(int[] cell:tab_cell_connues) {
				lcc = connect.prepareStatement("INSERT INTO sudoku "+"(num_grille, num_ligne,num_col,chiffre) "+ "VALUES (?,?,?,?)");
				lcc.setInt(1, grille_max);
				lcc.setInt(2, cell[0]);
				lcc.setInt(3, cell[1]);
				lcc.setInt(4, cell[2]);
				lcc.executeUpdate();
				System.out.println("Nouvelle Grille ajoutée");
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("ajout sudoku KO");
		}
	}
	
	public static void creer_DB() {
		Connection initConnection = GetDB.initConnection();
		try {
			PreparedStatement newDB = initConnection.prepareStatement("CREATE DATABASE IF NOT EXISTS ?");
			newDB.setString(1, "sudoku");
			System.out.println(newDB);
			newDB.executeUpdate();
			System.out.println("BD créee");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("creation DB KO");
		}
	}
	
	public void creer_table() {
		try {
			PreparedStatement newTable = connect.prepareStatement("CREATE TABLE IF NOT EXISTS sudoku " + "(?,?,?,?,?)");
			System.out.println(newTable);
			newTable.setString(1, "id_case INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
			System.out.println(newTable);
			newTable.setString(2, "num_grille INT");
			System.out.println(newTable);
			newTable.setString(3, "num_ligne INT");
			System.out.println(newTable);
			newTable.setString(4, "num_col INT");
			System.out.println(newTable);
			newTable.setString(5, "chiffre INT");
			System.out.println(newTable);
			newTable.execute();
			System.out.println("Table créee");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("creation table KO");
		}
	}
	
}//Fin Grille dao
