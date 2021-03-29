package resume_Java;

import java.util.ArrayList;

public class A_main {

	public static void main(String[] args) {

					//Type
		
	int nombre = 5;
	float a_virgule = 5.5f; // Attention au f derriere  Ou sinon utiliser double
	System.out.println(a_virgule);
	String stringg = "Salut ";
	char char_a = 'A';
	System.out.println(char_a);
	int x,y;
	x= 6;
	y= 7;
	final int CONSTANTE_NOM_EN_MAJUSCULE = 8;

					//Tableaux  //Taille fixe
	
	int [] tableau_de_nombre = {1, 2, 3, 4};
	System.out.println(tableau_de_nombre[1]);//2
	String [] tableau_de_string = {"aaa", "bbb", "ccc", "ccc"};
	int [][] tableau_2D = {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}
	};
	System.out.println("Boucle for each 2d");
	for(int[] for_each1d:tableau_2D) {
		for(int for_each2d:for_each1d) {
			System.out.print(for_each2d + " ");
		}
		System.out.println("");
	}
	System.out.println("");
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
	System.out.println("Boucle for each 3d");
	for(int[][] for_each3d1:tableau_3D) {
		for(int[] for_each3d2:for_each3d1) {
			for(int for_each3d3:for_each3d2) {
				System.out.print(for_each3d3 + " ");
			}
			System.out.println("");
		}
	}
	System.out.println("");
	
					//Collections = Tableaux dynamiques
	
	ArrayList<String> collec = new ArrayList<>(); //ArrayList<Personne>
	//necessite package //ajout automatique apres avoir ecrit ctrl + maj + O
	collec.add("cedric");
	collec.add("moussa"); // obligé de répéter le add //Ne marche pas avec ,
	System.out.println(collec);	
	
					//Print
	
	System.out.println("Bonjour");//Saute une ligne apres
	System.out.print("test "); //Ne saute pas de ligne //attention aux espaces //rarement utilisé
	System.out.println(30);
	System.out.println(3+2); //5
	System.out.println("3+2"); //3+2
	System.out.println("x+y vaut " + x + y); //67 error
	System.out.println("x+y vaut " + (x + y)); //13 ok
	

					//Classes
	
	Personne cedric = new Personne();
	cedric.montrer_var();
	cedric.anniversaire();
	cedric.montrer_var();

	
					//Boucles
	
	System.out.println("Boucle for");
	for(int index_for = 0; index_for < tableau_de_nombre.length; index_for++) {
		System.out.print(tableau_de_nombre[index_for] + " ");
	}
	System.out.println("");
	
	System.out.println("Boucle while");
	int index = 0;
	while(index < tableau_de_nombre.length) {
		System.out.print(tableau_de_nombre[index] + " ");
		index++;
	}
	System.out.println("");
	
	System.out.println("Boucle do while");
	index = 0;
	do{
		System.out.print(tableau_de_nombre[index] + " ");
		index++;
	}while(index < tableau_de_nombre.length);
	System.out.println("");
	
	System.out.println("Boucle for each");
	for(int for_each:tableau_de_nombre) {
		System.out.print(for_each + " ");
	}
	System.out.println("");
	
					//Conditions
	
	if(nombre >= 18) {
		System.out.println("Vous etes majeur");
	}else{
		System.out.println("Vous etes mineur");
	}
			
	String majeur_ou_pas = nombre <= 18 ?  "mineur" : "majeur" ; //pour affecter une valeur via ternaire
	System.out.println(majeur_ou_pas);
	System.out.println(nombre >= 18 ? "majeur" : "mineur");//ternaire forcément dans Sysout

	
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
