package essai;

import java.util.Iterator;

public class Essais {

	public static void main(String[] args) {
		int debut_carre_ligne, nieme_carre_ligne;
		for (int xxx = 1; xxx <= 9; xxx++) {
			System.out.println("ligne "+ xxx);
			nieme_carre_ligne = Math.round((xxx-1 )/ 3);
			System.out.print(nieme_carre_ligne);
			System.out.println(" i�me carr�");
			debut_carre_ligne = 3 * nieme_carre_ligne;
			System.out.print("d�but carr� ligne ");
			System.out.println(debut_carre_ligne);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//Fin Main

}//Fin essai
