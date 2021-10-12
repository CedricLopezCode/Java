package test_cartes;

public class Main {

	public static void main(String[] args) {
		//Question 1
		Carte[][] liste_cartes = generer_cartes();
		//Question 2
		afficher_cartes(liste_cartes);
		//Question 3
		comparaison_cartes(liste_cartes[0][2], liste_cartes[0][2]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[0][12]);
		comparaison_cartes(liste_cartes[0][5], liste_cartes[0][3]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[1][2]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[1][12]);
		comparaison_cartes(liste_cartes[0][5], liste_cartes[1][3]);
		//Question 4
		distribuer_cartes();
		//Question 5
		analyse_pli();
		//Question 6
		recup_cartes();
		
	}
	

	private static Carte[][] generer_cartes(){
		final String [] LISTE_FORME = {"Coeur", "Carreau", "Trèfle", "Pique"};
		Carte[][] liste_cartes = new Carte[4][13];
		for (int i = 0; i < LISTE_FORME.length; i++) {
			for (int j = 2; j < 15; j++) {
				Carte carte = new Carte(j, LISTE_FORME[i]);
				liste_cartes[i][j-2] = carte;
			}
		}
		return liste_cartes;
	}// fin generer_cartes

	private static void afficher_cartes(Carte[][] liste_cartes) {
		for(Carte[] liste_par_forme:liste_cartes) {
			for(Carte carte_actuelle:liste_par_forme) {
				System.out.print(carte_actuelle.toString() + " ");
			}
			System.out.println();
		}
	}// fin afficher_cartes
	
	private static void comparaison_cartes(Carte carte_1, Carte carte_2) {
		String gagnant = "";
		if (carte_1.getForce() == carte_2.getForce()) {
			gagnant = "egalite" ;
		} else if (carte_1.getForce() > carte_2.getForce()){
			gagnant = carte_1.toString();
		} else {
			gagnant = carte_2.toString();
		}
		System.out.println(carte_1.toString() + " VS " + carte_2.toString() + " : " + gagnant);
	}// fin comparaison_cartes

	private static void recup_cartes() {
		
		
	}// fin recup_cartes

	private static void analyse_pli() {
		
		
	}// fin analyse_pli

	private static void distribuer_cartes() {
		
		
	}// fin distribuer_cartes
}
