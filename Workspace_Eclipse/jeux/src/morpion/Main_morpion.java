package morpion;

import java.util.Scanner;

public class Main_morpion {

	public static void main(String[] args) {
		char[][] grille = {
			{' ',' ',' '},
			{' ',' ',' '},
			{' ',' ',' '}
		};
		afficher_grille(grille);
		char signe = qui_commence();
		do {
			tour_joueur(signe, grille); 
			signe = signe == 'X' ? 'O': 'X';
		}while(fin_partie(signe, grille) == false);
		signe = signe == 'X' ? 'O': 'X';
		if (victoire(signe, grille)) {
			System.out.println("Bravo !\nLe joueur " + signe + " a gagné !");
		}else {
			System.out.println("Egalité !\nJouez encore pour vous départager !");
		}
	}//Fin Main
	
	public static int scan() {
		Scanner scanner = new Scanner(System.in);
		return scanner .nextInt();
	}
	public static char qui_commence(){
		System.out.println("Qui commence ? X ou O");
		Scanner scanne = new Scanner(System.in);
		char choix = scanne.next().charAt(0);
		if (choix == '0' || choix == 'o') {choix = 'O';}
		if (choix != 'O') {choix = 'X';}
		return choix;
	}
	public static void tour_joueur(char signe, char[][] grille){
		System.out.println("Tour Joueur " + signe);
		choix_case(signe, grille);
		afficher_grille(grille);
	}
	public static void choix_case(char signe, char[][] grille) {
		int choix_ligne, choix_colonne;
		
		do {
		System.out.println("Choisir une ligne");
		choix_ligne = scan();
		System.out.println("Choisir une colonne");
		choix_colonne = scan();
		} while( coup_valide(choix_ligne, choix_colonne, grille) == false );
		grille[choix_ligne-1][choix_colonne-1] = signe;
	}
	public static boolean coup_valide(int lgn, int col, char[][] grille) {
		switch (lgn) {
		case 1: break ;
		case 2: break ;
		case 3: break ;
		default:
			System.out.println("La ligne doit etre entre 1 et 3");
			return false;
		}
		switch (col) {
		case 1: break ;
		case 2: break ;
		case 3: break ;
		default:
			System.out.println("La colonne doit etre entre 1 et 3");
			return false;
		}
		if(grille[lgn-1][col-1] != ' ') {
			System.out.println("Cette case est déjà prise");
			return false;
		}
		return true;
	}
	public static void afficher_grille(char[][] grille) {
		System.out.println("_____________");
		for(char[] ligne:grille) {
			System.out.print("| ");
			for(char col:ligne) {
				System.out.print( col + " | ");
			}
			System.out.println();
			System.out.println("|___|___|___|");
		}System.out.println("");
	}
	public static boolean fin_partie(char signe, char[][] grille) {
		if(victoire(signe, grille) || match_nul(grille)) {return true;}
		return false;
	}
	public static boolean victoire(char signe, char[][] grille) {
		if(en_ligne(signe, grille) || en_colonne(signe, grille) || en_diag(signe, grille)) {
			return true;
		}else{
			return false;
		}
	}
	public static boolean match_nul(char[][] grille) {
		for(char[] ligne:grille) {
			for(char col:ligne) {
				if(col == ' ') {return false;}
			}
		}
		return true;
	}
	public static boolean en_ligne(char signe, char[][] grille) {
		for(int lgn = 0; lgn < 3; lgn++) {
			if(grille[lgn][0] == grille[lgn][1] && grille[lgn][0] == grille[lgn][2] && grille[lgn][0] != ' ') {
				return true;
			}
		}
		return false;
	}
	public static boolean en_colonne(char signe, char[][] grille) {
		for(int col = 0; col < 3; col++) {
			if(grille[0][col] == grille[1][col] && grille[0][col] == grille[2][col] && grille[0][col] != ' ') {
				return true;
			}
		}
		return false;
	}
	public static boolean en_diag(char signe, char[][] grille) {
		if(grille[0][0] == grille[1][1] && grille[0][0] == grille[2][2] && grille[1][1] != ' ') {
			return true;
		}
		if(grille[2][0] == grille[1][1] && grille[0][0] == grille[0][2] && grille[1][1] != ' ') {
			return true;
		}
		return false;
	}
	/*
	public static void changement_joueur(char signe) {
		//signe = signe == 'X' ? 'O': 'X';
		if( signe == 'X') {signe = 'O';}else {signe = 'X';}
	}*/
	
}
