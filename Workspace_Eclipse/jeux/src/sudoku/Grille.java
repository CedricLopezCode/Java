package sudoku;

import java.util.Arrays;

public class Grille {
	
	private Cellule [][] grille;

	public void afficher_grille( Cellule [][] grille) {
		for (int ligne = 0; ligne < Cellule[].length) {
			for (Cellule cellule : ligne) {
				System.out.print(cellule + " ");
			}
			System.out.println("");
		}
		
	}

	@Override
	public String toString() {
		return "Grille [grille=" + Arrays.toString(grille) + "]";
	}

	public Grille() {
		super();
		this.grille = int[9][9];
		// TODO Auto-generated constructor stub
	}
	
}
