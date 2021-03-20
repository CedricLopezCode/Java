package heritage_Mario_Kart;

import exos_simple_1_fichier.Nombre_premier;

public class Main {

	public static void main(String[] args) {
		System.out.println();
		
		Carapace carapace_1 = new Carapace();
		carapace_1.obtenir(carapace_1.getType(),carapace_1.getNom(),carapace_1.getDescription());
		carapace_1.utiliser(carapace_1.getType(),carapace_1.getNom(),carapace_1.getDescription());
		Carapace_Rouge carapace_2 = new Carapace_Rouge();
		carapace_2.obtenir(carapace_2.getType(),carapace_2.getNom(),carapace_2.getDescription());
		carapace_2.utiliser(carapace_2.getType(),carapace_2.getNom(),carapace_2.getDescription());
		
		System.out.println(carapace_1);
	}

}
