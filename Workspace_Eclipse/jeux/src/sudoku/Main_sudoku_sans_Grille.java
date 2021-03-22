package sudoku;


import java.util.Scanner;


public class Main_sudoku_sans_Grille {

	public static void main(String[] args) {
		//Creation et Affichage
	//Cellule [][] grille = new Cellule[9][9];
	Cellule [][] grille = creer_grille();
	Choisie cellule_Choisie = new Choisie();
	Cellule en_cours = new Cellule();
		//Interaction Joueur
	int nombre_de_coup = 0;

	
	do { //juste_1_coup();
		
		//Version Bourrin
		/*afficher(grille);
		afficher_morpion(grille);
		remplir_case(grille);
		afficher(grille);
		afficher_morpion(grille);*/
		
		//Version avec cellule de liaison
		afficher(grille); afficher_morpion(grille);
		afficher_brut(grille);
		en_cours = choix_case();
		if(case_occupee(en_cours, grille) && annulation_coup(en_cours, grille)){break;}
		grille = insertion_chiffre(en_cours, grille);
		//System.out.println(grille);
		//afficher(grille);
		//afficher_brut(grille);
		
		//Analyse grille
		doublon_dans_ligne(en_cours, grille);
		doublon_dans_colonne(en_cours, grille);
		doublon_dans_carre(en_cours, grille);
		if (nombre_de_coup > 40)  {verifier_victoire(en_cours, grille);}
		
		nombre_de_coup++;
	} while (verifier_victoire(en_cours, grille) == false);
	
	
	
	}//Fin main
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	//Creation et Affichage
	public static Cellule [][] creer_grille() {
		Cellule [][] grille = new Cellule[9][9];
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				grille[ligne][col] = new Cellule(ligne, col, 0);
			}
		}
		return grille;
	}
	public static void afficher(Cellule[][] grille) {
		System.out.println(" _____________________________________");
		for(int ligne = 0; ligne < 9; ligne++) {
			System.out.println("|   |   |   |   |   |   |   |   |   |");
			for(int col = 0; col < 9; col++) {
				//System.out.print(" ");System.out.print("| "); System.out.print(" ");
				if(grille[ligne][col].getChiffre() == 0) {
					System.out.print(0 + " |  ");
				}else {
					System.out.println(grille[ligne][col].getChiffre());
				}
				//System.out.print(grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() == 0 ? " ": cellule);
			}
			System.out.println();
			System.out.println(" |___|___|___|___|___|___|___|___|___|");
		}System.out.println("");
	}
	public static void afficher_morpion(Cellule[][] grille) {
		System.out.println("_____________________________________");
		for(Cellule[] ligne:grille) {
			System.out.print("| ");
			for(Cellule col:ligne) {
				System.out.print( 0 + " | ");
			}
			System.out.println();
			System.out.println("|___|___|___|___|___|___|___|___|___|");
		}System.out.println("");
	}
	public static void afficher_brut(Cellule[][] grille) {
		for(int ligne = 0; ligne < 9; ligne++) {
			for(int col = 0; col < 9; col++) {
				if(grille[ligne][col].getChiffre() == 0) {
					System.out.print(0 + " ");
				}else {
					System.out.print(grille[ligne][col].getChiffre() + " ");
				}

			}
			System.out.println();
		}System.out.println("");
	}
	public static void juste_1_coup(){}	
	public static int scan() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	public static boolean plage_valide(String a_tester, int valeur) {
		if(1 <= valeur && valeur <= 9){
			return true;
		}else{
			System.out.println(a_tester +" doit etre entre 1 et 9");
		}
			return false;
	}
	public static boolean victoire() {return false;}
	//***********************************************************************************		
			//Interaction Joueur
	//Version Bourrin
	public static void remplir_case(Cellule[][] grille) {
		int choix_ligne, choix_colonne, choix_chiffre;
		//Saisie valeur valide
		do {
			System.out.println("Choisir une ligne");
			choix_ligne = scan();
		} while( plage_valide("La ligne", choix_ligne) == false );
		do {
			System.out.println("Choisir une colonne");
			choix_colonne = scan();
		} while( plage_valide("La colonne", choix_colonne) == false );
		do {
			System.out.println("Choisir le chiffre à mettre");
			choix_chiffre = scan();
		} while( plage_valide("Le chiffre", choix_chiffre) == false );
	//------------------------------------------------------------------------------	
		//Case vide ou pas
		if(grille[choix_ligne-1][choix_colonne-1].getChiffre() != 0) {
			//remplacement_ou_pas(choix_ligne, choix_colonne, choix_chiffre, grille) ;
		}
		//return grille[choix_ligne][choix_colonne].getChiffre()choix_chiffre;
	//----------------------------------------------------------------------------	
		//Insertion chiffre
		grille[choix_ligne-1][choix_colonne-1].setChiffre(choix_chiffre);
	}
	
	//---------------------------------------------------------------------------
	
	//Version avec cellule intermediaire
	public static Cellule choix_case() {
		int choix_ligne, choix_colonne, choix_chiffre;
		//Saisie valeur valide
		do {
			System.out.println("Choisir une ligne");
			choix_ligne = scan();
		} while( plage_valide("La ligne", choix_ligne) == false );
		do {
			System.out.println("Choisir une colonne");
			choix_colonne = scan();
		} while( plage_valide("La colonne", choix_colonne) == false );
		do {
			System.out.println("Choisir le chiffre à mettre");
			choix_chiffre = scan();
		} while( plage_valide("Le chiffre", choix_chiffre) == false );
		Cellule en_cours = new Cellule(choix_ligne-1, choix_colonne-1, choix_chiffre);
		return en_cours;
	}
	
	public static boolean case_occupee(Cellule en_cours, Cellule[][] grille) {
		if(grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() != 0) {
			System.out.println("La case "+ (en_cours.getCoord_ligne()+1) +" "+(en_cours.getCoord_col()+1)+" est déjà prise !");
		}
		return true;
	}
	public static boolean annulation_coup(Cellule en_cours, Cellule[][] grille) {
		if(grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() != 0) {
			int choix_remplacement;
			do{
				System.out.println("Voulez-vous remplacer le "+ grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].getChiffre() +" par un "+ en_cours.getChiffre()+ " ?");
				System.out.println("5 pour oui,  0 pour non");
				choix_remplacement = scan();
				if  ( choix_remplacement == 0 ) {return true;}
			}while (choix_remplacement != 5);
		}
		return false;
	}
	public static Cellule[][] insertion_chiffre(Cellule en_cours, Cellule[][] grille) {
		grille[en_cours.getCoord_ligne()][en_cours.getCoord_col()].setChiffre(en_cours.getChiffre());
		return grille;
	}
	/*public static boolean remplacement_ou_pas(int lgn, int col, int chiff, Cellule[][] grille) {
		if(grille[lgn][col].getChiffre() != 0) {
			System.out.println("La case"+lgn+" "+col+" est déjà prise !");
			System.out.println("Voulez-vous remplacer la "+grille[lgn][col]+" par un "+chiff+" ?");
			int choix_remplacement;
			do{
				System.out.println("5 pour oui,  0 pour non");
				choix_remplacement = scan();
			}while (choix_remplacement !=5);
			
			//grille[choix_ligne][choix_colonne].setChiffre(choix_chiffre);
			return false;
		}
		return false;
	}*/
//***********************************************************************************
			//Analyse grille
	public static boolean doublon_dans_ligne(Cellule en_cours, Cellule[][] grille){
		int lgn = en_cours.getCoord_ligne(); 
		for(int col = 0; col < 9; col++) {
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre()) {
				if(lgn != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
					System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la ligne !");
					return true;
				}
			} 
		}
		return false;
	}	
	public static boolean doublon_dans_colonne(Cellule en_cours, Cellule[][] grille){
		int col = en_cours.getCoord_col();
		for(int lgn = 0; lgn < 9; lgn++) {
			if( grille[lgn][col].getChiffre() == en_cours.getChiffre()) {
				if(lgn != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
					System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans la colonne !");
					return true;
				}
			}
		}
		return false;
	}
	public static boolean doublon_dans_carre(Cellule en_cours, Cellule[][] grille){
		//Deduction Carre
		int nieme_carre_ligne = Math.round((en_cours.getCoord_ligne() )/ 3); 
		int nieme_carre_colonne = Math.round((en_cours.getCoord_col() )/ 3);
		int debut_carre_ligne = 3 * nieme_carre_ligne;
		int debut_carre_colonne = 3 * nieme_carre_colonne;
		//Creation Carre
		/*Cellule [][] carre = new Cellule[3][3];
		for(int ligne = debut_carre_ligne; ligne < debut_carre_ligne+3; ligne++) {
			for(int col = debut_carre_colonne; col < debut_carre_colonne+3; col++) {
				grille[ligne][col] = new Cellule(ligne, col, en_cours.getChiffre());
			}
		}*/
		//Comparaison dans carre
		for(int ligne = debut_carre_ligne; ligne < debut_carre_ligne+3; ligne++) {
			for(int col = debut_carre_colonne; col < debut_carre_colonne+3; col++) {
				if (grille[ligne][col].getChiffre() == en_cours.getChiffre()){
					if(ligne != en_cours.getCoord_ligne() || col != en_cours.getCoord_col()){
						System.out.println("Il y a déjà un "+ en_cours.getChiffre() + " dans le carré !");
						return true;
					}
				}
			}
		}
	return false;
	}
	public static boolean grille_remplie(Cellule en_cours, Cellule[][] grille){
			for(Cellule[] ligne:grille) {
				for(Cellule col:ligne) {
					if (col.getChiffre() == 0) {return false;}
				}
			}
		return true;
	}
	public static boolean verifier_victoire(Cellule en_cours, Cellule[][] grille){
		if	(	
				grille_remplie(en_cours, grille) == true &&
				doublon_dans_ligne(en_cours, grille) == false &&
				doublon_dans_colonne(en_cours, grille) == false &&
				doublon_dans_carre(en_cours, grille) == false
			)
			{
			return true;
			}
		/*System.out.println("grille " + grille_remplie(en_cours, grille));
		System.out.println("ligne " + doublon_dans_ligne(en_cours, grille));
		System.out.println("col " + doublon_dans_colonne(en_cours, grille));
		System.out.println("carre " + doublon_dans_carre(en_cours, grille));*/
		return false;
	}
}//Fin Sudoku

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 public static TYPE_RETURN nom_methode(int 11111, int 11111, int 11111, Cellule[][] grille) {
		
	return true;
}
*/
