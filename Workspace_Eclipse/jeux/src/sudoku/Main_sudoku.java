package sudoku;

public class Main_sudoku {

	public static void main(String[] args) {
		Cellule [][] grille = creer_grille();
		System.out.println(grille);
	}
	public static Cellule [][] creer_grille() {
		Cellule [][] grille = new Cellule[9][9];
		return grille;
	}

}
