package dao;

public class Produit {
	
	protected static int id=1;
	protected String nomP;
	
	public Produit(String nomP) {
		super();
		this.nomP = nomP;
		id++;
	}

	public static int getId() {
		return id;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	
	
}
