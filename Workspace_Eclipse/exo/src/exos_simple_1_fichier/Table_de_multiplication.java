package exos_simple_1_fichier;

import java.util.Scanner;

public class Table_de_multiplication {

	public static void main(String[] args) {
	int table_a_afficher;
	table_a_afficher = scanner_int();
	System.out.println(table_a_afficher);
	table(table_a_afficher);
	}
	public static int scanner_int() {
		System.out.println("Rentrer la table de multiplication à afficher");
		return new Scanner(System.in).nextInt();		
	}
	public static void table(int x) {
		for(int i = 1 ; i < 11; i++) {
			System.out.println(x + " x " + i + " = " + (x*i));
		}
	}

}
