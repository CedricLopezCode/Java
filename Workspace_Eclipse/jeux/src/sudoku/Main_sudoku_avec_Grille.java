package sudoku;

import java.util.ArrayList;
import java.util.Scanner;



public class Main_sudoku_avec_Grille {

	public static void main(String[] args) {
				
				//Creation
		//par defaut
		Grille grille_classe = new Grille();
		
		//avec chaque celulle connues en param
		int[] cellule_connue_1 = {1,1,1};
		int[] cellule_connue_2 = {2,2,2};
		int[] cellule_connue_3 = {3,3,3};
		int[] cellule_connue_4 = {4,4,4};
		int[] cellule_connue_5 = {5,5,5};
		int[] cellule_connue_6 = {6,6,6};
		Grille grille_valeurs = new Grille(cellule_connue_1, cellule_connue_2, cellule_connue_3);
		
		//avec 1 tableau des cellules connues en param
		int[][] cellules_connues = {
			{1,1,1},
			{2,2,2},
			{3,3,3},
			{4,4,4},
			{5,5,5},
			{6,6,6},
			{7,7,7},
			{8,8,8}
		};
		Grille grille_tableau = new Grille(cellules_connues);
		
		//rempli sauf 9 9 8
		int[][] complet = {
				{1,2,3,4,5,6,7,8,9},
				{4,5,6,7,8,9,1,2,3},
				{7,8,9,1,2,3,4,5,6},
				{2,3,4,5,6,7,8,9,1},
				{5,6,7,8,9,1,2,3,4},
				{8,9,1,2,3,4,5,6,7},
				{3,4,5,6,7,8,9,1,2},
				{6,7,8,9,1,2,3,4,5},
				{9,1,2,3,4,5,6,7,8}
			};

			int[][] victoire = new int[81][3]; 
			for(int cellul = 0; cellul < 81; cellul++) {
				victoire[cellul][0] = Math.round((cellul)/ 9) + 1; 
				victoire[cellul][1] = (cellul % 9) + 1;
				victoire[cellul][2] = complet [Math.round((cellul)/ 9)][(cellul % 9)];
			}
		Grille grille_victoire = new Grille(victoire);
		grille_victoire.insertion_chiffre(new Cellule(8,8,0));
		
		//reel facile
		//avec 1 tableau des cellules connues en param
		int[][] cellules_reel = {
			{1,1,7},
			{1,3,3},
			{1,4,1},
			{1,7,9},
			{1,9,4},
			{2,4,4},
			{2,3,5},
			{2,8,7},
			{2,9,3},
			{3,2,2},
			{3,4,3},
			{3,6,4},
			{3,7,1},
			{3,9,5},
			{4,1,6},
			{4,2,7},
			{4,5,3},
			{4,2,8},
			{4,3,9},
			{5,2,3},
			{5,3,1},
			{5,4,6},
			{5,5,4},
			{5,8,5},
			{6,5,5},
			{6,8,4},
			{7,4,7},
			{7,7,5},
			{7,9,8},
			{8,3,6},
			{8,4,1},
			{8,6,8},
			{8,7,5},
			{9,3,4},
			{9,4,7},
			{9,5,5},
			{9,7,6},
			{9,8,9}
		};
		Grille grille_reel = new Grille(cellules_reel);
//--------------------------------------------------------------------------------------------
		//grille dao 
		Grille_dao dao_grille = new Grille_dao();
		int num_grille = dao_grille.choix_numero_grille();
		ArrayList<Cellule> liste_cell_connues = dao_grille.recup_cell_connues(num_grille);
		Grille grille_dao = new Grille(liste_cell_connues);
//--------------------------------------------------------------------------------------------
		
		
		//choix grille 
		Grille grille = grille_dao;

				//Preparation
		Cellule en_cours = new Cellule();
		int nombre_de_coup = 0;
		
				//Interaction Joueur
		do { 
			grille.afficher(); //grille.afficher_brut();  grille.afficher_morpion();
			System.out.println("Coup n° " + (nombre_de_coup + 1));
			en_cours = en_cours.choix_case();
			if(grille.case_occupee(en_cours) == false || validation_remplacement(en_cours, grille)){
				grille.insertion_chiffre(en_cours);
				nombre_de_coup ++;
				//Analyse grille
				System.out.println("analyse");
				grille.doublon_dans_ligne(en_cours); 
				grille.doublon_dans_colonne(en_cours);
				grille.doublon_dans_carre(en_cours);
			}
		} while (grille.victoire_acquise() == false);
		
				//Fin Partie
		grille.afficher();
		System.out.println("Bravo vous avez réussi ce sudoku en " + nombre_de_coup + " coups");

	}	//Fin main

	
	
	public static boolean validation_remplacement(Cellule en_cours, Grille grille) {
		Scanner scan = new Scanner(System.in);

		int choix_remplacement;
		do{
			System.out.println("Voulez-vous remplacer le "+ grille.getGrille()[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() +" par un "+ en_cours.getChiffre()+ " ?");
			System.out.println("5 pour oui,  0 pour non");
			choix_remplacement = scan.nextInt();
			if  ( choix_remplacement == 0 ) {return false;}
		}while (choix_remplacement != 5);
		return true;
	}

}//Fin Sudoku


/*
 public static TYPE_RETURN nom_methode(int 11111, int 11111, int 11111, Cellule[][] grille) {
		
	return true;
}
*/
