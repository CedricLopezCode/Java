package heritage_Mario_Kart;

abstract public class Objet {
	protected String nom;
	protected String description;
	protected String type;
	
	public void obtenir() {
		System.out.println(type +" "+ nom + " obtenu\n" + description); 
	}
	public void utiliser() {
		System.out.println(type +" "+ nom + " utilisé\n" + description); 
	}
}
