package test9;

public class Test {

	public static void main(String[] args) {
		System.out.println("Bonjour");//Saute une ligne apres
		System.out.print("test "); //Ne saute pas de ligne
		System.out.println(30);
		System.out.println(3+2); //5
		System.out.println("3+2"); //3+2

		int nombre = 5;
		int x,y;
		x= 6;
		y= 7;
		final int CONSTANTE_EN_MAJUSCULE = 8;
		String stringg = "Salut ";
		
		
		System.out.println(nombre);
		System.out.println(stringg);
		nombre = 3;
		System.out.println(nombre);
		System.out.println("x+y vaut " + x + y);//67 error
		System.out.println("x+y vaut " + (x + y));//13 ok
		System.out.println(CONSTANTE_EN_MAJUSCULE);
		
		Personne cedric = new Personne();
		cedric.anniversaire();
		
		
	}

}
