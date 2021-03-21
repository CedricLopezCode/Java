package sudoku;

import java.util.Arrays;

public class Grille {
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
	//== toString
	public void afficher() {
		System.out.println("__________________________________________________________");
		for(int ligne = 0; ligne < 9; ligne++) {
			System.out.print("| ");
			for(int col = 0; col < 9; col++) {
				//if(cellule.getChiffre() == null) {cellule.setChiffre();}
				System.out.print(/*grille[ligne][col].getChiffre() == 0 ? " ":*/ grille[ligne][col].getChiffre());
				System.out.println(" | ");
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
				System.out.print( col + " | ");
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
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre()) {
				if(lgn != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
					System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la ligne !");
					return true;
				}
			} 
		}
		return false;
	}	
	public boolean doublon_dans_colonne(Cellule en_cours){
		int col = en_cours.getCoord_col();
		for(int lgn = 0; lgn < 9; lgn++) {
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre()) {
				if(lgn != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
					System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la colonne !");
					return true;
				}
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
				if (grille[ligne][col].getChiffre() == en_cours.getChiffre()){
					if(ligne != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
						System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans le carré !");
						return true;
					}
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
	public boolean verifier_victoire(Cellule en_cours){
		if	(	
				grille_remplie() == true &&
				doublon_dans_ligne(en_cours) == false &&
				doublon_dans_colonne(en_cours) == false &&
				doublon_dans_carre(en_cours) == false
				)
		{
			return true;
		}
		/*System.out.println("grille " + grille_remplie(en_cours, grille));
	System.out.println("ligne " + doublon_dans_ligne(en_cours, grille));
	System.out.println("col " + doublon_dans_colonne(en_cours, grille));
	System.out.println("carre " + doublon_dans_carre(en_cours, grille));*/
		return false;
	}
}//Fin classe
