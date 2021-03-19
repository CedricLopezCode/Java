package serie_1_exo_1_Livre;

import java.util.Scanner;

public class Main_Livre {

	public static void main(String[] args) {
		int id_dernier_livre = 0;
		
		Livre livre_1 = saisie_info(id_dernier_livre);
		System.out.println(id_dernier_livre);
		System.out.println(livre_1);
		System.out.println(id_dernier_livre);
		Livre livre_2 = saisie_info(id_dernier_livre);
		System.out.println(livre_2);
	}//Fin Main
	
	public static Livre saisie_info(int id_dernier_livre) {
		id_dernier_livre++;
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
