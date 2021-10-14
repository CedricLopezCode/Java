package test_cartes;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
	
		//Attributs
	
	protected String nom;
	protected ArrayList<Carte> cartes_en_main;
	
		//Methodes
	public Carte jouer_carte() {
		Random random = new Random();
		int numero_carte = random.nextInt(cartes_en_main.size());
		Carte carte_jouee = cartes_en_main.get(numero_carte);
		cartes_en_main.remove(numero_carte);
		System.out.println(nom + " a joue" + carte_jouee.toString());
		return carte_jouee;
		
	}// fin jouer_carte
	
		//Constructeur
	
	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	
	public Joueur(String nom, ArrayList<Carte> cartes_en_main) {
		super();
		this.nom = nom;
		this.cartes_en_main = cartes_en_main;
	}
	
		//Accesseurs
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Carte> getMain() {
		return cartes_en_main;
	}
	
	public void setMain(ArrayList<Carte> cartes_en_main) {
		this.cartes_en_main = cartes_en_main;
	}

	@Override
	public String toString() {
		return "Joueur " + nom + " a en main : " + cartes_en_main;
	}
	

}
