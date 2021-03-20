package exos_simple_1_fichier;

import java.util.ArrayList;

public class Semaine {

	public static void main(String[] args) {
		//Création
		//String[] semaine = {"lundi","mar","mercredi","jeudi","vendredi","samedi","dimanc"};
		ArrayList<String> semaine = new ArrayList<String>();
		semaine.add("lundi");
		semaine.add("dimanc");
		semaine.add(1,"mar"); //index, ajout
		semaine.add(2,"mercredi");
		semaine.add(3,"jeudi");
		semaine.add(4,"vendredi");
		semaine.add(5,"samedi");
		System.out.println(semaine);
		
		//Modif
	}

}
//Soit le tableau suivant : Var semaine = [‘lundi’, ‘mar’, ‘mercredi’, ‘jeudi’, ‘vendredi’, ‘samedi’, ‘dimanc’] ;
 
//- Retirer la dernière valeur du tableau
//- Afficher les valeurs du tableau en utilisant la méthode document.write
//- Ajouter la valeur la valeur ‘dimanche’ à la fin du tableau
//- Remplacer le mar par mardi
//- Afficher le nombre de valeurs du tableau
//- Afficher la 5éme valeur*/