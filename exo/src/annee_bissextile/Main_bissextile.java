package annee_bissextile;

public class Main_bissextile {

	public static void main(String[] args) {
		int annee_a_tester;
		annee_a_tester = 2021;
		//Analyse du num�ro de l'ann�e
		if((annee_a_tester % 4 == 0 && annee_a_tester % 100 != 0) || annee_a_tester % 400 == 0 ) {
			System.out.println("L'ann�e " + annee_a_tester + " est une ann�e bissextile");
		}else {
			System.out.println("L'ann�e " + annee_a_tester + " n'est pas une ann�e bissextile");
		}

	}
}
