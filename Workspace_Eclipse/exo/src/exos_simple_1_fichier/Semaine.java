package exos_simple_1_fichier;

import java.util.ArrayList;
import java.util.Arrays;

public class Semaine {

	public static void main(String[] args) {
		//Création
		//String[] semaine = {"lundi","mar","mercredi","jeudi","vendredi","samedi","dimanc"};
		ArrayList<String> semaine = new ArrayList<>(Arrays.asList("lundi","mar","mercredi","jeudi","vendredi","samedi","dimanc"));
		/*semaine.add("lundi");
		semaine.add("dimanc");
		semaine.add(1,"mar"); //index, ajout
		semaine.add(2,"mercredi");
		semaine.add(3,"jeudi");
		semaine.add(4,"vendredi");
		semaine.add(5,"samedi");*/
		System.out.println(semaine);
		semaine.remove(semaine.size()-1); System.out.println(semaine);
		semaine.add("dimanch"); System.out.println(semaine);
		semaine.set(semaine.indexOf("mar"),"mardi"); System.out.println(semaine);
		System.out.println(semaine.size());
		System.out.println(semaine.get(4));
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