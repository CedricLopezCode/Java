package sudoku;

import java.util.Arrays;

public class Grille {
	
	//Attributs
	protected int taille = 9;
	protected Cellule [][] grille = new Cellule [9][9];
	
	//Méthodes
	public void creer_grille() {
		
	}
	//Constructeurs
	public Grille() {
		super();
	}
	public Grille(int taille) {
		super();
		this.taille = taille;
	}
	
	//Accesseurs
	public Cellule[][] getGrille() {
		return grille;
	}
	public void setGrille(Cellule[][] grille) {
		this.grille = grille;
	}
	
	@Override
	public String toString() {
		return "Grille [taille=" + taille + ", grille=" + Arrays.toString(grille) + "]";
	}
	
	

	

}
