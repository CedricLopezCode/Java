package serie_1_exo_1_Livre;

import java.util.Scanner;

public class Main_Livre {

	public static void main(String[] args) {
		
		Livre livre_1 = saisie_info();
		System.out.println();
		System.out.println(livre_1);
		System.out.println();
		Livre livre_2 = saisie_info();
		System.out.println(livre_2);
	}//Fin Main
	
	public static Livre saisie_info() {
		Scanner scan = new Scanner(System.in);
		//Saisie
		System.out.println("Rentrer le titre du livre");
		String titre = scan.next();
		System.out.println("Rentrer le nom de l'auteur");
		String Auteur = scan.next();
		System.out.println("Rentrer le prix du livre");
		float prix = scan.nextFloat();
		//Création
		Livre nouveau_livre = new Livre(titre, Auteur, prix);
		return nouveau_livre;
	}

}
