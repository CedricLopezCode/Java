package resume_Java;

import java.util.ArrayList;

public class A_main {

	public static void main(String[] args) {

					//Type
		
	int nombre = 5;
	float a_virgule = 5.5f; // Attention au f derriere // Ou sinon utiliser double
	String stringg = "Salut ";// Attention à la majuscule //Double obligatoirement
	char char_a = 'A'; //Simple obligatoirement
	int x,y;
	x= 6;
	y= 7;
	final int CONSTANTE_NOM_EN_MAJUSCULE = 8;

					//Tableaux  //Taille fixe
		//1D
	int [] tableau_de_nombre = {1, 2, 3, 4};
	String [] tableau_de_string = {"aaa", "bbb", "ccc", "ddd"};
	System.out.println(tableau_de_nombre[1]); //2
	
		//2D
	int [][] tableau_2D = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
	};

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
			{15, 6, 7, 8},
			{19, 10, 11, 12}
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
	
	ArrayList<String> collec = new ArrayList<>(); //ArrayList<Class>
	//necessite package //ajout automatique apres avoir ecrit: ctrl + maj + O
	collec.add("cedric");
	collec.add("moussa"); // obligé de répéter le add //Ne marche pas avec ,
	
	
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
	

					//Classes
	
	Personne cedric = new Personne(); // Créer objet 
	cedric.montrer_var(); //Utiliser méthodes de la classe
	System.out.println("");
	
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

}
