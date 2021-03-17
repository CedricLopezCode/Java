package exos_simple_1_fichier;

public class Nombre_premier {

	public static void main(String[] args) {
		int nombre_a_tester;
		nombre_a_tester = 20;
		
		int nombre_de_diviseur = 0;
		for(int index_for = 1; index_for < nombre_a_tester; index_for++) {
			if( nombre_a_tester % index_for == 0) {nombre_de_diviseur++;}
		}
		System.out.println(nombre_de_diviseur == 1 ? "for premier" : "for pas premier");
		
		int index_while = 2;
		while(nombre_a_tester % index_while != 0 && nombre_a_tester >= index_while) {
			index_while++;
		}
		System.out.println(nombre_a_tester == index_while ? "while premier" : "while pas premier");
		
		int index_do_while = 1;
		do {
			index_do_while++;
		} while(nombre_a_tester % index_do_while != 0 && nombre_a_tester >= index_do_while);
		System.out.println(nombre_a_tester == index_do_while ? "do while premier" : "do while pas premier");
	}

}
