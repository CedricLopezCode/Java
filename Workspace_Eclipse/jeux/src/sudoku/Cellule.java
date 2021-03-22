package sudoku;

import java.util.Scanner;

public class Cellule{
			//Attributs
	protected int coord_ligne;
	protected int coord_col;
	protected int chiffre;

			//Méthodes
	public int afficher_case() {
		return chiffre;
	}
	public Cellule choix_case() { //pour avec Classe Grille
		Scanner scan = new Scanner(System.in);
		int choix_ligne, choix_colonne, choix_chiffre;
		//Saisie valeur valide
		do {
			System.out.println("Choisir une ligne");
			choix_ligne = scan.nextInt();
		} while( plage_valide("La ligne", choix_ligne) == false );
		do {
			System.out.println("Choisir une colonne");
			choix_colonne = scan.nextInt();
		} while( plage_valide("La colonne", choix_colonne) == false );
		do {
			System.out.println("Choisir le chiffre à mettre");
			choix_chiffre = scan.nextInt();
		} while( plage_valide("Le chiffre", choix_chiffre) == false );
		Cellule en_cours = new Cellule(choix_ligne-1, choix_colonne-1, choix_chiffre);
		scan.close();
		return en_cours;
	}
	public boolean plage_valide(String a_tester, int valeur) { //pour avec Classe Grille
		if(1 <= valeur && valeur <= 9){
			return true;
		}else{
			System.out.println(a_tester +" doit etre entre 1 et 9");
		}
			return false;
	}
	//Constructeur
	public Cellule() {
		super();
	}
	public Cellule(int chiffre) {
		super();
		this.chiffre = chiffre;
	}
	public Cellule(int coord_ligne, int coord_col) {
		super();
		this.coord_ligne = coord_ligne;
		this.coord_col = coord_col;
	}
	public Cellule(int coord_ligne, int coord_col, int chiffre) {
		super();
		this.chiffre = chiffre;
		this.coord_ligne = coord_ligne;
		this.coord_col = coord_col;
	}
	//Accesseurs
	public int getChiffre() {
		return chiffre;
	}

	public void setChiffre(int chiffre) {
		this.chiffre = chiffre;
	}
	
	public int getCoord_ligne() {
		return coord_ligne;
	}

	public void setCoord_ligne(int coord_ligne) {
		this.coord_ligne = coord_ligne;
	}

	public int getCoord_col() {
		return coord_col;
	}

	public void setCoord_col(int coord_col) {
		this.coord_col = coord_col;
	}

	@Override
	public String toString() {
		return "Case en " + (coord_ligne+1) +" , "+ (coord_col+1) +" contient le chiffre: " + chiffre;
	}
	
	
	
	
}
