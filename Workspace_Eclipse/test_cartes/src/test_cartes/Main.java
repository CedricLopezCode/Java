package test_cartes;

import java.util.ArrayList;
import java.util.Random;

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
		distribuer_cartes(liste_cartes);
			//Question 5
		analyse_pli();
			//Question 6
		recup_cartes();
		//Joueur joueur_1 = new Joueur(cm, )
		
	}//fin main
	

	private static Carte[][] generer_cartes(){
		final String [] LISTE_FORME = {"Coeur", "Carreau", "Trefle", "Pique"};
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

	private static void distribuer_cartes(Carte[][] liste_cartes) {
			//Liste Cartes à distribuer
		ArrayList<Carte> cartes_restantes = new ArrayList<Carte>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < liste_cartes[0].length; j++) {
				cartes_restantes.add(liste_cartes[i][j]);
			}
		}
		/* vérif
		for(Carte carte_actuelle : cartes_restantes)
			System.out.println(carte_actuelle.toString());
		*/
		
			//Création liste joueurs
		ArrayList<Joueur> liste_joueurs = new ArrayList<Joueur>();
		for (int i = 0; i < 4; i++) {
			//instanciation joueurs
			String nom_joueur = "Joueur " + i; 
			liste_joueurs.add(new Joueur(nom_joueur));
			System.out.println(liste_joueurs.get(i).toString()); //verif
		}
			//Création liste Carte
		ArrayList<Carte> liste_cartes_joueur = new ArrayList<Carte>();
		Random random = new Random();
		for (int i = 0; i < liste_joueurs.size(); i++) {
			for (int j = 0; j < liste_cartes[0].length; j++) {
				int numero_carte = random.nextInt(cartes_restantes.size());
				Carte carte_actuelle = cartes_restantes.get(numero_carte);
				liste_cartes_joueur.add(carte_actuelle);
				cartes_restantes.remove(numero_carte);
			}
			liste_joueurs.get(i).setMain(liste_cartes_joueur);
			liste_cartes_joueur.clear();
			System.out.println(liste_joueurs.get(i).toString()); //verif
		}
		
	}// fin distribuer_cartes
	
	private static void analyse_pli() {
		
		
	}// fin analyse_pli
	
	private static void recup_cartes() {
		
		
	}// fin recup_cartes
}
