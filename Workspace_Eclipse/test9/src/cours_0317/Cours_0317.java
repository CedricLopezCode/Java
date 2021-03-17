package cours_0317;

import java.util.Scanner;


public class Cours_0317 {

	public static void main(String[] args) {
		/*float nombre_1 = 5.5f;
		float nombre_2 = 5;
		
		affichage_operations(nombre_1, nombre_2);
		addition_infinie(1,2,3,4);
		System.out.println(addition_infinie(1,2,3,4));
		
		System.out.println("Choisir un nombre");
		Scanner scanner = new Scanner(System.in);
		String string =scanner.next();
		
		int choix = scanner.nextInt();
		System.out.println(string);
		*/
		
		//aprem
		Personne cedric = new Personne();
		Personne moussa = new Personne();
		Personne cedric_param = new Personne("cedric","lopez","mail",27);
		System.out.println(cedric_param);//necessite un toString dans la classe
		//System.out.println(cedric_param.prenom);//impossible car attributs en private
		System.out.println(cedric_param.getPrenom());// ok car getter
		cedric_param.setPrenom("Ced");
		System.out.println(cedric_param.getPrenom());
	}	
	
	
	//operation de base
	public static float addition_normale(float a, float b) {return a + b;}
	public static float addition_infinie(float ...nombres) {//autant de parametre que je veux
		System.out.println(nombres);//affichage bizarre
		System.out.println(nombres[0]);//affichage le 1er parametre
		float somme = 0;
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
			somme += nombres[i];
		}
		return somme;
	}
	

	//affichage résultat
	public static void affichage_operations(float x, float y) {
		float resultat;
		resultat = addition_normale(x, y);
		System.out.println(x + " + " + y + " = " + resultat);
		
	}

}
