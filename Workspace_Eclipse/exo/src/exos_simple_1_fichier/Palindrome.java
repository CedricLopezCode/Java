package exos_simple_1_fichier;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		String mot_a_tester;
		mot_a_tester = scan_chaine();
		affichage_resultat(mot_a_tester);
		
	}
	
	public static String scan_chaine() {
		System.out.println("Rentrer le mot à tester");
		Scanner scan_chaine = new Scanner(System.in);
		return scan_chaine.next(); 
	}
	
	public static boolean verification(String mot) { 
		for (int i = 0; i < mot.length(); i++) {
			//System.out.println(mot.charAt(i));
			//System.out.println(mot.charAt(mot.length() - 1 - i));
			if (mot.charAt(i) != mot.charAt(mot.length() - 1 - i)) {
				return false;
			};
		}
		return true; 
	}
	
	public static void affichage_resultat(String mot_a) {
		System.out.print(mot_a);
		System.out.println(verification(mot_a) ? " est un palindrome": " n'est pas un palindrome");
	}
	
	
	//ECHEC
	public static String inversion(String mot) {
		char[] mot_lettre = mot.toCharArray(); System.out.println(mot_lettre);
		//char[] inverse_lettre = mot_lettre.clone(); System.out.println(inverse_lettre);
		//ArrayList<char> inverse_lettre = new ArrayList<>();
		//inverse_lettre = mot_lettre.clone(); System.out.println(inverse_lettre);
		char[] inverse_lettre = new char[mot_lettre.length]; System.out.println(inverse_lettre);
		for (int i = 0; i < inverse_lettre.length; i++) {
			inverse_lettre[i] = mot_lettre[inverse_lettre.length - 1 - i];
		}
		System.out.println(mot_lettre);
		System.out.println( inverse_lettre);
		String mot_inversee = inverse_lettre.toString(); System.out.println( inverse_lettre);
		return mot_inversee; 
	}
	public static void affichage(String mot_a, String mot_b) {
		System.out.print(mot_a);
		System.out.println(mot_a == mot_b ? " est un palindrome": " n'est pas un palindrome");
		
	}
}
			//Javascript
/*
function test_palindrome(){

	var mot_rentre = $("#mot_rentre").val();
	console.log(mot_rentre);
	var mot_inverse = inversion(mot_rentre);
	comparaison(mot_rentre, mot_inverse);
	event.preventDefault();
}
function inversion(mot){
	var tab = mot.split(""); 
	var tab_inverse = tab.reverse(); 
	var mot_inverse = tab_inverse.join(""); 
	return mot_inverse
}
function comparaison(motun, motdeux){
	console.log(motun);
	motun == motdeux ? affichage_palindrome_oui() : affichage_palindrome_non();
}
function affichage_palindrome_oui(){
	console.log(mot_rentre);
	mot_rentre = $("#mot_rentre").val();
	console.log(mot_rentre);
	$("#reponse").html(mot_rentre + " est bien un palindrome");
	$("#reponse").css("background", "lime");
}

function affichage_palindrome_non(){
	
	mot_rentre = $("#mot_rentre").val();
	console.log(mot_rentre);
	$("#reponse").html(mot_rentre + " n'est pas un palindrome");
	$("#reponse").css("background", "red");
}*/