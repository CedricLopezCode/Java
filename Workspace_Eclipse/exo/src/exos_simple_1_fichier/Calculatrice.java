package exos_simple_1_fichier;

public class Calculatrice {

	public static void main(String[] args) {
		float nombre_1 = 5.5f;
		float nombre_2 = 5;
		
		affichage_operations(nombre_1, nombre_2);
	}
	
	//operation de base
	public static float addition(float a, float b) {return a + b;}
	public static float soustraction(float a, float b) {return a - b;}
	public static float multiplicatrion(float a, float b) {return a * b;}
	public static float division(float a, float b) {return a / b;}
	public static float modulo(float a, float b) {return a % b;}

	//affichage résultat
	public static void affichage_operations(float x, float y) {
		float resultat;
		resultat = addition(x, y);
		System.out.println(x + " + " + y + " = " + resultat);
		resultat = soustraction(x, y);
		System.out.println(x + " - " + y + " = " + resultat);
		resultat = multiplicatrion(x, y);
		System.out.println(x + " * " + y + " = " + resultat);
		resultat = division(x, y);
		System.out.println(x + " / " + y + " = " + resultat);
		resultat = modulo(x, y);
		System.out.println(x + " % " + y + " = " + resultat);
		
	}
}
