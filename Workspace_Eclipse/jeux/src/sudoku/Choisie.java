package sudoku;

public class Choisie extends Cellule{
	protected int ligne_choisie;
	protected int colonne_choisie;
	protected int chiffre_choisi;
	
	//Constructeurs
	public Choisie() {
		super();
	}
	public Choisie(int coord_ligne, int coord_col, int chiffre) {
		super(coord_ligne, coord_col, chiffre);

	}
	public Choisie(int coord_ligne, int coord_col) {
		super(coord_ligne, coord_col);
	}
	public Choisie(int chiffre) {
		super(chiffre);
	}
	
	//getset
	public int getLigne_choisie() {
		return ligne_choisie;
	}
	public void setLigne_choisie(int ligne_choisie) {
		this.ligne_choisie = ligne_choisie;
	}
	public int getColonne_choisie() {
		return colonne_choisie;
	}
	public void setColonne_choisie(int colonne_choisie) {
		this.colonne_choisie = colonne_choisie;
	}
	public int getChiffre_choisi() {
		return chiffre_choisi;
	}
	public void setChiffre_choisi(int chiffre_choisi) {
		this.chiffre_choisi = chiffre_choisi;
	}
	
	@Override
	public String toString() {
		return "Cellule choisie:\nLigne: " + ligne_choisie + "\nColonne: " + colonne_choisie + "\nChiffre: "
				+ chiffre_choisi;
	}
	
}
