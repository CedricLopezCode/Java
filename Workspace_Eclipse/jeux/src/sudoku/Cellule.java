package sudoku;

public class Cellule {
	private int chiffre;
	private int coord_ligne;
	private int coord_col;

	public Cellule() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		return "Cellule [chiffre=" + chiffre + "]";
	}
	
	
	
	
}
