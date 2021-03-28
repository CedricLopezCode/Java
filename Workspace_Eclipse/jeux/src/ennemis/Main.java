package ennemis;

public class Main {

	public static void main(String[] args) {

		Element feu = new Feu();
		Element eau = new Eau();
		Element glace = new Glace();
		
		Dragon dragon_normal = new Dragon();
		Dragon dragon_de_feu = new Dragon(feu);
		
		dragon_normal.souffle();
		dragon_de_feu.souffle();

	}//Fin main

}//Fin class
