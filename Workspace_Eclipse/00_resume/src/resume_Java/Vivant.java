package resume_Java;

abstract class Vivant { 
	
	//Attributs
	String nom;
	
	//Methodes
	abstract public String manger();//Obligation red�finir la m�thode dans les enfants
	public String nommer() {return nom +" est un ";}//Mais possibilit� de d�finir des m�thodes normales

	
}
