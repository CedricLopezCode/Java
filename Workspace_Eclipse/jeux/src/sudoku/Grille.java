package sudoku;

import java.util.Arrays;

public class Grille {
	
	//Attributs
	protected Cellule [][] grille = new Cellule[9][9];
	
	//Constructeurs
	public Grille() {
		super();
		
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				grille[ligne][col] = new Cellule(ligne, col, 0);
			}
		}
	}
	public Grille(int[]...donnees) {
		//constructeur par defaut
		super();
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				grille[ligne][col] = new Cellule(ligne, col, 0);
			}
		}
		
		// + personnalisation suivant les données rentrées
		
		for (int[] cell_donnees : donnees) {
			grille[cell_donnees[0]-1][cell_donnees[1]-1].setChiffre(cell_donnees[2]);
		}
	}
	public Grille(int[][] tab_donnees) {
		//constructeur par defaut
		super();
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				grille[ligne][col] = new Cellule(ligne, col, 0);
			}
		}
		
		// + personnalisation suivant les données rentrées
		
		for (int[] cell_donnees : tab_donnees) {
			grille[cell_donnees[0]-1][cell_donnees[1]-1].setChiffre(cell_donnees[2]);
		}
	}
	//-------------------------------------------------------------------------
	//get set
	public Cellule[][] getGrille() {
		return grille;
	}
	public void setGrille(Cellule[][] grille) {
		this.grille = grille;
	}
	
	//== toString
	public void afficher() {
		System.out.println("_______________________________________________________");
		for(int ligne = 0; ligne < 9; ligne++) {
			System.out.println("|     |     |     |     |     |     |     |     |     |");
			System.out.print("|  ");
			for(int col = 0; col < 9; col++) {
				System.out.print(grille[ligne][col].getChiffre() == 0 ? " ": grille[ligne][col].getChiffre());
				System.out.print("  |  ");
			}
			System.out.println();
			System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
		}System.out.println("");
	}
	public void affichersauv() {
		System.out.println("__________________________________________________________");
		for(int ligne = 0; ligne < 9; ligne++) {
			System.out.print("| ");
			for(int col = 0; col < 9; col++) {
				//if(cellule.getChiffre() == null) {cellule.setChiffre();}
				System.out.print(grille[ligne][col].getChiffre() == 0 ? " ": grille[ligne][col].getChiffre());
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("|___|___|___|___|___|___|___|___|___|");
		}System.out.println("");
	}
	public void afficher_brut() {
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				if(grille[ligne][col].getChiffre() == 0) {
					System.out.print(0 + " ");
				}else {
					System.out.print(grille[ligne][col].getChiffre() + " ");
				}
			}
			System.out.println();
		}System.out.println("");
	}
	public void afficher_morpion() {
		System.out.println("_____________________________________");
		for(Cellule[] ligne:grille) {
			System.out.print("| ");
			for(Cellule col:ligne) {
				System.out.print( col.getChiffre() + " | ");
			}
			System.out.println();
			System.out.println("|___|___|___|___|___|___|___|___|___|");
		}System.out.println("");
	}
//-----------------------------------------------------------------------------------------
					// Méthode
	public void insertion_chiffre(Cellule en_cours) {
		grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].setChiffre(en_cours.getChiffre());
	}
	
		//Analyse grille
	
	public boolean case_occupee(Cellule en_cours) {
		if(grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() != 0) {
			System.out.println("La case "+ (en_cours.getCoord_ligne()+1) +" "+(en_cours.getCoord_col()+1)+" est déjà prise !");
		}
		return true;
	}
	public boolean doublon_dans_ligne(Cellule en_cours){
		int lgn = en_cours.getCoord_ligne(); 
		for(int col = 0; col < 9; col++) { 
			//System.out.println(en_cours);
			//System.out.print("chiffre tab "+grille[lgn][col].getChiffre());
			//System.out.println(" chiffre en cours "+en_cours.getChiffre());
			//System.out.print("col " +col);
			//System.out.println(" col en_cours "+en_cours.getCoord_col());
			
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre() && col != en_cours.getCoord_col()) {
				System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la ligne !");
				return true;
			} 
		}
		return false;
	}	
	public boolean doublon_dans_colonne(Cellule en_cours){
		int col = en_cours.getCoord_col();
		for(int lgn = 0; lgn < 9; lgn++) {
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre() && lgn != en_cours.getCoord_ligne()) {
				System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la colonne !");
				return true;
			}
		}
		return false;
	}
	public boolean doublon_dans_carre(Cellule en_cours){
		//Deduction Carre
		int nieme_carre_ligne = Math.round((en_cours.getCoord_ligne() )/ 3); 
		int nieme_carre_colonne = Math.round((en_cours.getCoord_col() )/ 3);
		int debut_carre_ligne = 3 * nieme_carre_ligne;
		int debut_carre_colonne = 3 * nieme_carre_colonne;
		//Comparaison dans carre
		for(int ligne = debut_carre_ligne; ligne < debut_carre_ligne+3; ligne++) {
			for(int col = debut_carre_colonne; col < debut_carre_colonne+3; col++) {
				if 	(grille[ligne][col].getChiffre() == en_cours.getChiffre() && 
					(ligne != en_cours.getCoord_ligne() || col != en_cours.getCoord_col())
					){
					System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans le carré !");
					return true;
				}
			}
		}
		return false;
	}
	public boolean grille_remplie(){
		for(Cellule[] ligne:grille) {
			for(Cellule col:ligne) {
				if (col.getChiffre() == 0) {return false;}
			}
		}
		return true;
	}
	public boolean doublon_for(){
		for(int lgn = 0; lgn < 9; lgn++) {
			for(int col = 0; col < 9; col++) {
				if(
					doublon_dans_ligne(grille[lgn][col]) ||
					doublon_dans_colonne(grille[lgn][col]) ||
					doublon_dans_carre(grille[lgn][col]) 
				) 
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean doublon_each(){
		for(Cellule[] ligne:grille) {
			for(Cellule cell:ligne) {
				if(
					doublon_dans_ligne(cell) ||
					doublon_dans_colonne(cell) ||
					doublon_dans_carre(cell) 
				) 
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean victoire_acquise(){
		if(grille_remplie()  && (doublon_each() == false) ) 
		{
			return true;
		}
		return false;
	}
}//Fin classe
