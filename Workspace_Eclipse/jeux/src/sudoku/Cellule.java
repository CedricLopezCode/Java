package sudoku;

public class Cellule{
	//Attributs
	protected int coord_ligne;
	protected int coord_col;
	protected int chiffre;

	//Méthodes
	public int afficher_case() {
		return chiffre;
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
