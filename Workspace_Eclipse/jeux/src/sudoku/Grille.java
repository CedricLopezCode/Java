package sudoku;

import java.util.Arrays;

public class Grille {
	
	protected Cellule [][] grille;
	/*
	public Cellule [][] creer_grille() {
		Cellule [][] grille = new Cellule[9][9];
		
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				System.out.print(ligne);
				System.out.print(col);
				System.out.println(grille[ligne][col]);
				
				grille[ligne][col].setCoord_ligne(1);
				System.out.println(grille[ligne][col].getCoord_ligne());
				//grille[ligne][col].setCoord_col(1);
				//System.out.println(grille[ligne][col].getCoord_col());
			}
		}
		return grille;
	}
	*/
	public void afficher() {
		System.out.println("__________________________________________________________");
		for(int ligne = 0; ligne < 9; ligne++) {
			System.out.print("| ");
			for(int col = 0; col < 9; col++) {
				//if(cellule.getChiffre() == null) {cellule.setChiffre();}
				System.out.print(grille[ligne][col].getChiffre() == 0 ? " ": grille[ligne][col].getChiffre());
				System.out.println(" | ");
			}
			System.out.println();
			System.out.println("|___|___|___|___|___|___|___|___|___|");
		}System.out.println("");
	}
/*
	public Grille() {
		super();
		Cellule [][] grille = new Cellule[9][9];
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				grille[ligne][col] = new Cellule(ligne, col, 0);
			}
		}*/
	public Grille() {
		super(
				for(int ligne = 0; ligne < 9; ligne++) {
					for(int col = 0; col < 9; col++) {
						grille[ligne][col] = new Cellule(ligne, col, 0);
					}
				}
				);
		
	}
	@Override
	public String toString() {
		return "Grille [grille=" + Arrays.toString(grille) + "]";
	}
	
	
	
}
