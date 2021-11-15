package test_cartes;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
			//Question 1
		System.out.println("\tQuestion 1 & 2 : Génération Cartes et Affichage \n");
		Carte[][] liste_cartes = generer_cartes();
			//Question 2
		afficher_cartes(liste_cartes);
			//Question 3
		System.out.println("\n\tQuestion 3 : Comparaison Cartes \n");
		comparaison_cartes(liste_cartes[0][2], liste_cartes[0][2]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[0][12]);
		comparaison_cartes(liste_cartes[0][5], liste_cartes[0][3]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[1][2]);
		comparaison_cartes(liste_cartes[0][2], liste_cartes[1][12]);
		comparaison_cartes(liste_cartes[0][5], liste_cartes[1][3]);
			//Question 4
		System.out.println("\n\tQuestion 4 : Distribution Cartes \n");
		ArrayList<Joueur> liste_joueurs = new ArrayList<Joueur>();
		distribuer_cartes(liste_cartes, liste_joueurs);
			//Question 5 & 6
		System.out.println("\n\tQuestion 5 & 6 : Pli et Récupération\n");
		analyse_pli(liste_joueurs);
			
		
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
			System.out.println();// vérification
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

	private static void distribuer_cartes(Carte[][] liste_cartes,ArrayList<Joueur> liste_joueurs) {
			//Liste Cartes à distribuer
		ArrayList<Carte> cartes_restantes = new ArrayList<Carte>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < liste_cartes[0].length; j++) {
				cartes_restantes.add(liste_cartes[i][j]);
			}
		}
		/* vérif
		for(Carte carte_actuelle : cartes_restantes){
			System.out.println(carte_actuelle.toString());
		}
		*/
			//Création liste joueurs	
		for (int i = 0; i < 4; i++) {
			String nom_joueur = "Joueur " + i; 
			liste_joueurs.add(new Joueur(nom_joueur));
			//System.out.println(liste_joueurs.get(i).toString()); //verif
		}
			//Création liste Carte
		Random random = new Random();
		for (int i = 0; i < liste_joueurs.size(); i++) {
			ArrayList<Carte> liste_cartes_joueur = new ArrayList<Carte>();
			for (int j = 0; j < liste_cartes[0].length; j++) {
				int numero_carte = random.nextInt(cartes_restantes.size());
				Carte carte_actuelle = cartes_restantes.get(numero_carte); 
				liste_cartes_joueur.add(carte_actuelle); 
				cartes_restantes.remove(numero_carte);
			}
			liste_joueurs.get(i).setMain(liste_cartes_joueur);
			//System.out.println(liste_joueurs.get(i).toString()); //verif
		}
		System.out.println(liste_joueurs);
		
	}// fin distribuer_cartes
	
	private static void analyse_pli(ArrayList<Joueur> liste_joueurs) {
			//Remplissage pli
		ArrayList<Carte> pli = new ArrayList<Carte>();
		for (int i = 0; i < liste_joueurs.size(); i++) {
			Carte carte_jouee = liste_joueurs.get(i).jouer_carte();
			pli.add(carte_jouee);
		}
		System.out.println("pli = " + pli); //verif
			//Désignation gagnant
		int gagnant = 0;
		for(Carte carte_actuelle : pli){
			if (carte_actuelle.getForce() >= pli.get(gagnant).getForce()) {
				gagnant = pli.indexOf(carte_actuelle);
			}
		}
		System.out.println("index gagnant = " + gagnant + " , carte gagnante = " + pli.get(gagnant)); //verif
		
		
		liste_joueurs.get(gagnant).recup_carte(pli);
		System.out.println(liste_joueurs.toString()); //verif
	}// fin analyse_pli
	
	private static void recup_cartes() {
		
		
	}// fin recup_cartes
}
