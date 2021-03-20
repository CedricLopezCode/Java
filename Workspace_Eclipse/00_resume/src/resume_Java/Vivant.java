package resume_Java;

abstract class Vivant { 
	
	//Attributs
	String nom;
	
	//Methodes
	abstract public String manger();//Obligation redéfinir la méthode dans les enfants
	public String nommer() {return nom +" est un ";}//Mais possibilité de définir des méthodes normales

	
}
