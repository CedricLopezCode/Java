package resume_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A_00_main {

	public static void main(String[] args) {

		
					//Type
		
	int nombre = 5;
	float a_virgule = 5.5f; // Attention au f derriere
	double a_virgule_double = 6.6; // Ou sinon utiliser double
	String stringg = "Salut ";// Attention à la majuscule //Double obligatoirement
	char char_a = 'A'; //Simple obligatoirement
	boolean vrai_ou_faux = true;
	int x,y;
	x= 6;
	y= 7;
	final int CONSTANTE_NOM_EN_MAJUSCULE = 8;

	
					//Tableaux  //Taille fixe
		//1D
	int [] tableau_de_nombre = {1, 2, 3, 4}; 
	String [] tableau_de_string = {"aaa", "bbb", "ccc", "ddd"};
	System.out.println(tableau_de_nombre[1]); //2 car indice commence à 0
	
		//2D
	int [][] tableau_2D = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
	};
	System.out.println(tableau_2D[0][2]); //3
	for(int[] for_each1d:tableau_2D) {
		for(int for_each2d:for_each1d) {
			System.out.print(for_each2d + " ");
		}
		System.out.println("");
	}System.out.println("");
	
		//3D
	int [][][] tableau_3D = { //tres rare et difficile
		{
			{11, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
		},
		{
			{21, 2, 3, 4},
			{25, 6, 7, 8},
			{29, 10, 11, 12}
		},
		{
			{31, 2, 3, 4},
			{35, 6, 7, 8},
			{39, 10, 11, 12}
		}
	};
	
	for(int[][] for_each3d1:tableau_3D) {
		for(int[] for_each3d2:for_each3d1) {
			for(int for_each3d3:for_each3d2) {
				System.out.print(for_each3d3 + " ");
			}
		}
		System.out.println(""); 
	}System.out.println("");
	
	
					//Collections = Tableaux dynamiques
	
	ArrayList<Integer> collec = new ArrayList<Integer>(); //ArrayList<Class>
	//Class = Integer, Float(virgule obligatoire), Double(virgule obligatoire), etc...
	//necessite package java.util.ArrayList//ajout automatique apres avoir ecrit: ctrl + maj + O
	collec.add(2);//ajoute à la fin
	collec.add(3); // obligé de répéter le add //Ne marche pas avec ,
	collec.add(0, 11); //index, valeur
	collec.get(1);//retourne la valeur
	collec.set(0,1);//modifie la valeur //index, valeur
	collec.remove(1);//supprime l'élément indexé
	collec.size();//retourne la taille la collection //==.length
	collec.clear(); //vide la collection
	
		//Tri
	collec.add(2); collec.add(3); collec.add(1); collec.add(13); collec.add(7); collec.add(2);
	System.out.println(collec);
	Collections.sort(collec); //Tri la collection par ordre alphabetique ou numérique
	//necessite package java.util.Collections;//ajout automatique apres avoir ecrit: ctrl + maj + O
	System.out.println(collec); System.out.println();
	
	
	
					//Print
	
	System.out.print("Bonjour "); //attention aux espaces  // == inline
	System.out.println("Salut");//Saute une ligne apres  // == block
	System.out.println(30);
	System.out.println(3+2); //5
	System.out.println("3+2"); //3+2
	System.out.println("x+y vaut " + x + y); //67 error
	System.out.println("x+y vaut " + (x + y)); //13 ok
	System.out.println("\tTabulation");
	System.out.println("Saut ligne\n");
	
	
					//Scanner 
	//necessite le package java.util.scanner
	
	System.out.println("Rentrer valeur");
	Scanner scan = new Scanner(System.in);
	
		//depend des types:
	System.out.println("st");stringg = scan.next(); //String //Forme raccourci 
	//stringg = scan.nextLine(); //String  //Forme raccourci
	char_a = scan.next().charAt(0); //Char
	System.out.println("int");nombre = scan.nextInt(); 
	System.out.println("flo");a_virgule = scan.nextFloat(); //attention ici , 
	System.out.println("bool");vrai_ou_faux = scan.nextBoolean();
	
	
					//Classes
	
	Personne cedric = new Personne(); // Créer objet 
	cedric.montrer_var(); //Utiliser méthodes de la classe
	System.out.println("");
	
			//Héritage
	
	Lion simba = new Lion(); // Créer objet 
	System.out.println(simba.manger());
	System.out.println(simba.nommer());
	
			//Interface
	//On donne la méthode dans le fichier d'interface et on défini ensuite dans chaque Classe
	System.out.println(cedric.caresser());
	System.out.println(simba.caresser());

	
	
					//Boucles
	
	//For
	for(int index_for = 0; index_for < tableau_de_nombre.length; index_for++) {
		System.out.print(tableau_de_nombre[index_for] + " ");
	}System.out.println("For");
	
	//While
	int index = 0;
	while(index < tableau_de_nombre.length) {
		System.out.print(tableau_de_nombre[index] + " ");
		index++;
	}System.out.println("While");
	
	//Do While
	index = 0;
	do{
		System.out.print(tableau_de_nombre[index] + " ");
		index++;
	}while(index < tableau_de_nombre.length);		System.out.println("Do While");
	
	//For Each
	for(int for_each:tableau_de_nombre) {
		System.out.print(for_each + " ");
	} System.out.println("For Each\n");
	
	
					//Conditions
	
	if(nombre >= 18) {
		System.out.println("Vous etes majeur");
	}else{
		System.out.println("Vous etes mineur");
	}
			
	String majeur_ou_pas = nombre <= 18 ?  "mineur" : "majeur" ; //Affecter une valeur via ternaire
	System.out.println(majeur_ou_pas); //Afficher la valeur donnée par le ternaire
	System.out.println(nombre >= 18 ? "majeur" : "mineur");//Souvent ternaire dans Sysout

	
	switch (nombre) {
	case 1: 
		System.out.println("ca vaut 1");
		break; //optionnel
	case 2: 
		System.out.println("ca vaut 2");
	default:
		System.out.println("ca vaut autre chose");
	}
	
					//Affichage
	
	System.out.println("fin");//2
	
}
					//Fonctions, Méthodes
		
	public static void simple() {System.out.println("Générique");}
	//static car n'appartient pas à une classe //ne s'utilise que dans le fichier du main //en dehors du main mais dans le package
	//void car pas de return //autres types obligés d'avoir un return
	public static void avec_parametres(int a, int b) {System.out.println(a+b);}
	public static int avec_type() {return 10;} 
	
		//quand on ne sait pas combien il y aura de parametres
	public static int addition_infinie(int ...nombres) {//autant de parametre que je veux //Mais tous du meme type
		System.out.println(nombres);//affichage bizarre
		System.out.println(nombres[0]);//affichage le 1er parametre
		int somme = 0;
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
			somme += nombres[i];
		}
		return somme;
	}
}
